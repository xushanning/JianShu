package com.xu.commonlib.di.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author 言吾許
 * 提供一些第三方库的实例
 */
@Module
abstract class ClientModule {


    @Module
    companion object {
        /**
         * 超时时间
         */
        private const val TIME_OUT = 10L

        @JvmStatic
        @Provides
        @Singleton
        fun provideRetrofit(builder: Retrofit.Builder, client: OkHttpClient, gson: Gson): Retrofit {
            builder.baseUrl("")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))

            return builder.build()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideClient(builder: OkHttpClient.Builder): OkHttpClient {
            builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            return builder.build()
        }


        @JvmStatic
        @Provides
        @Singleton
        fun provideBuilder(): Retrofit.Builder {
            return Retrofit.Builder()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient.Builder {
            return OkHttpClient.Builder()
        }
    }
}