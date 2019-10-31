package com.xu.commonlib.di.module

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.xu.commonlib.base.BaseApplication
import com.xu.commonlib.constant.TableConstant
import com.xu.commonlib.db.dao.ISportDao
import com.xu.commonlib.db.AppDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author 言吾許
 */
@Module
abstract class AppModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideGson(): Gson {
            return GsonBuilder().create()
        }

        //提供room数据库
        @JvmStatic
        @Provides
        @Singleton
        fun provideRoom(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, TableConstant.DB_NAME)
                .build()

        }


    }


    @Binds
    abstract fun provideApplicationContext(application: BaseApplication): Context


}