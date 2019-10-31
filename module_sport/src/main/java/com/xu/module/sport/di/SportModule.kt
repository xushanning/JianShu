package com.xu.module.sport.di

import com.xu.commonlib.db.AppDatabase
import com.xu.commonlib.db.dao.ISportDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author 言吾許
 */
@Module
class SportModule {
    @Module
    companion object {
        //提供运动dao
        @JvmStatic
        @Provides
        @Singleton
        fun provideSportDao(database: AppDatabase): ISportDao {
            return database.sportDao()
        }
    }
}