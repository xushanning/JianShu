package com.xu.commonlib.utlis.extention

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.permissionx.guolindev.PermissionX

/**
 * Activity 权限
 */
fun FragmentActivity.permission(
    vararg permissions: String?,
    res: (allGranted: Boolean) -> Unit
) {
    PermissionX.init(this)
        .permissions(*permissions)
        //给用户解释原因
        .onExplainRequestReason { scope, deniedList ->
            scope.showRequestReasonDialog(deniedList, "需要这些权限，给一下呗", "OK", "Cancel")
        }
        //引导用户去设置页面
        .onForwardToSettings { scope, deniedList ->
            scope.showForwardToSettingsDialog(
                deniedList,
                "大兄弟，权限啊",
                "OK",
                "Cancel"
            )
        }
        .request { allGranted, _, _ ->
            res.invoke(allGranted)
        }
}

/**
 * Fragment 权限
 */
fun Fragment.permission(vararg permissions: String?) {
    PermissionX.init(this)
        .permissions(*permissions)
        .onExplainRequestReason { scope, deniedList ->

        }
        .onForwardToSettings { scope, deniedList ->

        }
        .request { allGranted, grantedList, deniedList ->

        }
}