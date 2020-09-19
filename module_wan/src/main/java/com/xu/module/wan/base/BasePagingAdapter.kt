package com.xu.module.wan.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.LinearLayout
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger
import com.xu.module.wan.utils.ext.createDiff
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Modifier
import java.lang.reflect.ParameterizedType
import java.util.*

abstract class BasePagingAdapter<T : Any, VH : BaseViewHolder>(@LayoutRes private val layoutResId: Int, itemsTheSame: (oldItem: T, newItem: T) -> Boolean, contentsTheSame: (oldItem: T, newItem: T) -> Boolean) :
    PagingDataAdapter<T, VH>(createDiff(itemsTheSame, contentsTheSame)) {

    companion object {
        const val HEADER_VIEW = 0x10000111
    }

    /**
     * item监听
     */
    private var onItemClickListener: ((item: T, position: Int) -> Unit)? = null

    /**
     * child view监听
     */
    private var onItemChildClickListener: ((item: T, position: Int, viewId: Int) -> Unit)? =
        null

    private val childClickViewIds = LinkedHashSet<Int>()

    private lateinit var mHeaderLayout: LinearLayout

    val headerLayoutCount: Int
        get() {
            return if (hasHeaderLayout()) {
                1
            } else {
                0
            }
        }


    override fun onBindViewHolder(holder: VH, position: Int) {
        when (holder.itemViewType) {
            HEADER_VIEW -> return
            else -> convert(holder, getItem(position - headerLayoutCount)!!)
        }
    }

    protected abstract fun convert(holder: VH, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val baseViewHolder: VH
        when (viewType) {
            HEADER_VIEW -> {
                val headerLayoutVp: ViewParent? = mHeaderLayout.parent
                if (headerLayoutVp is ViewGroup) {
                    headerLayoutVp.removeView(mHeaderLayout)
                }
                baseViewHolder = createBaseViewHolder(mHeaderLayout)
            }
            else -> {
                val viewHolder = onCreateDefViewHolder(parent, viewType)
                bindViewClickListener(viewHolder)
                baseViewHolder = viewHolder
            }
        }
        return baseViewHolder
    }

    protected open fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createBaseViewHolder(parent, layoutResId)
    }

    fun createBaseViewHolder(parent: ViewGroup, @LayoutRes layoutResId: Int): VH {
        return createBaseViewHolder(
            LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        )
    }

    private fun bindViewClickListener(viewHolder: VH) {

        onItemClickListener?.let {
            viewHolder.itemView.setOnClickListener { _ ->
                var position = viewHolder.absoluteAdapterPosition
                if (position == RecyclerView.NO_POSITION) {
                    return@setOnClickListener
                }
                position -= headerLayoutCount
                it.invoke(getItem(position)!!, position)
            }
        }
        onItemChildClickListener?.let {
            childClickViewIds.forEach { id ->
                viewHolder.itemView.findViewById<View>(id).setOnClickListener { view ->
                    var position = viewHolder.absoluteAdapterPosition
                    if (position == RecyclerView.NO_POSITION) {
                        return@setOnClickListener
                    }
                    position -= headerLayoutCount
                    it.invoke(getItem(position)!!, position, view.id)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val hasHeader = hasHeaderLayout()
        if (hasHeader && position == 0) {
            return HEADER_VIEW
        } else {
            val adjPosition = if (hasHeader) {
                position - 1
            } else {
                position
            }
            return getDefItemViewType(adjPosition)
        }
    }

    protected open fun getDefItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun addChildClickViewIds(@IdRes vararg viewIds: Int) {
        for (viewId in viewIds) {
            childClickViewIds.add(viewId)
        }
    }

    /**
     * 添加header
     */
    fun addHeaderView(view: View, index: Int = -1, orientation: Int = LinearLayout.VERTICAL): Int {
        if (!this::mHeaderLayout.isInitialized) {
            mHeaderLayout = LinearLayout(view.context)
            mHeaderLayout.orientation = orientation
            mHeaderLayout.layoutParams = if (orientation == LinearLayout.VERTICAL) {
                RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            } else {
                RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }

        val childCount = mHeaderLayout.childCount
        var mIndex = index
        if (index < 0 || index > childCount) {
            mIndex = childCount
        }
        mHeaderLayout.addView(view, mIndex)
        if (mHeaderLayout.childCount == 1) {
            notifyItemInserted(0)
        }
        return mIndex
    }

    fun removeHeaderView(header: View) {
        if (!hasHeaderLayout()) return

        mHeaderLayout.removeView(header)
        if (mHeaderLayout.childCount == 0) {
            notifyItemRemoved(0)
        }
    }

    fun removeAllHeaderView() {
        if (!hasHeaderLayout()) return
        mHeaderLayout.removeAllViews()
        notifyItemRemoved(0)
    }

    fun hasHeaderLayout(): Boolean {
        if (this::mHeaderLayout.isInitialized && mHeaderLayout.childCount > 0) {
            return true
        }
        return false
    }


    private fun createBaseViewHolder(view: View): VH {
        var temp: Class<*>? = javaClass
        var z: Class<*>? = null
        while (z == null && null != temp) {
            z = getInstancedGenericKClass(temp)
            temp = temp.superclass
        }
        // 泛型擦除会导致z为null
        val vh: VH? = if (z == null) {
            BaseViewHolder(view) as VH
        } else {
            createBaseGenericKInstance(z, view)
        }
        return vh ?: BaseViewHolder(view) as VH
    }

    private fun getInstancedGenericKClass(z: Class<*>): Class<*>? {
        try {
            val type = z.genericSuperclass
            if (type is ParameterizedType) {
                val types = type.actualTypeArguments
                for (temp in types) {
                    if (temp is Class<*>) {
                        if (BaseViewHolder::class.java.isAssignableFrom(temp)) {
                            return temp
                        }
                    } else if (temp is ParameterizedType) {
                        val rawType = temp.rawType
                        if (rawType is Class<*> && BaseViewHolder::class.java.isAssignableFrom(
                                rawType
                            )
                        ) {
                            return rawType
                        }
                    }
                }
            }
        } catch (e: java.lang.reflect.GenericSignatureFormatError) {
            e.printStackTrace()
        } catch (e: TypeNotPresentException) {
            e.printStackTrace()
        } catch (e: java.lang.reflect.MalformedParameterizedTypeException) {
            e.printStackTrace()
        }
        return null
    }

    private fun createBaseGenericKInstance(z: Class<*>, view: View): VH? {
        try {
            val constructor: Constructor<*>

            return if (z.isMemberClass && !Modifier.isStatic(z.modifiers)) {
                constructor = z.getDeclaredConstructor(javaClass, View::class.java)
                constructor.isAccessible = true
                constructor.newInstance(this, view) as VH
            } else {
                constructor = z.getDeclaredConstructor(View::class.java)
                constructor.isAccessible = true
                constructor.newInstance(view) as VH
            }
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

        return null
    }

    /**
     * item点击
     */
    fun setOnItemClickListener(onItemClickListener: ((item: T, position: Int) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }

    /**
     * item child点击
     */
    fun setOnItemChildClickListener(onItemChildClickListener: ((item: T, position: Int, viewId: Int) -> Unit)?) {
        this.onItemChildClickListener = onItemChildClickListener
    }

}