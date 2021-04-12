package com.xu.module.video.di

import com.xu.commonlib.db.AppDatabase
import com.xu.commonlib.db.dao.ISportDao
import com.xu.commonlib.db.dao.IVideoDao
import com.xu.module.video.http.VideoApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author 言吾許
 */
//@Module
class VideoModule {

//    @Module
    companion object {
        /**
         * 提供videoApi
         */
//        @JvmStatic
//        @Provides
//        @Singleton
        fun provideVideoApi(builder: Retrofit.Builder): VideoApi {
            return builder.baseUrl(VideoApi.BASE_URL).build().create(VideoApi::class.java)
        }

//        //提供运动dao
//        @JvmStatic
//        @Provides
//        @Singleton
//        fun provideVideoDao(database: AppDatabase): IVideoDao {
//            return database.videoDao()
//        }
    }
}