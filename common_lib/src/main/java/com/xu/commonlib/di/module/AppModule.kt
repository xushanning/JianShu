package com.xu.commonlib.di.module

import android.content.Context
import androidx.room.Room
import com.xu.commonlib.base.BaseApplication
import com.xu.commonlib.constant.TableConstant
import com.xu.commonlib.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @author 言吾許
 */
@Module
@InstallIn(ApplicationComponent::class)
class AppModule {


    //提供room数据库
    @Provides
    @Singleton
    fun provideRoom(context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, TableConstant.DB_NAME)
            .build()

    }


    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return BaseApplication.appContext.applicationContext
    }


}