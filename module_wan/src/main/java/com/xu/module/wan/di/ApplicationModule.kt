package com.xu.module.wan.di

import android.content.Context
import androidx.room.Room

import com.xu.module.wan.api.WanService
import com.xu.module.wan.constant.AppConstant
import com.xu.module.wan.constant.DbConstant
import com.xu.module.wan.db.AppDatabase
import com.xu.module.wan.db.dao.IHistoryDao
import com.xu.module.wan.db.dao.IUserDao
import com.xu.module.wan.viewmodel.WanLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class ApplicationModule {

    /**
     * provide api
     */
    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): WanService {
        return builder
            .baseUrl(AppConstant.BASE_URL)
            .build()
            .create(WanService::class.java)
    }

    /**
     * 提供room数据库
     */
    @Provides
    @Singleton
    fun provideRoom(context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, DbConstant.DB_NAME)
            .build()

    }

    /**
     * 提供UserDao
     */
    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): IUserDao {
        return database.userDao()
    }

    /**
     * 提供浏览历史Dao
     */
    @Provides
    @Singleton
    fun provideHistoryDao(database: AppDatabase): IHistoryDao {
        return database.historyDao()
    }

    /**
     * 提供全局LiveData
     */
    @Provides
    @Singleton
    fun provideModuleLiveData(): WanLiveData {
        return WanLiveData.INSTANCE
    }


}