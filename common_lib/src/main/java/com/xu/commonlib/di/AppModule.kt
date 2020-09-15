package com.xu.commonlib.di


import android.content.Context
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.orhanobut.logger.Logger
import com.squareup.moshi.Moshi
import com.xu.commonlib.base.BaseApplication
import com.xu.easyload.EasyLoad
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * @author 言吾許
 * 提供一些第三方库的实例
 */
@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    /**
     * 超时时间
     */
    private val TIME_OUT = 10L

    @Provides
    @Singleton
    fun provideClient(builder: OkHttpClient.Builder): OkHttpClient {
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        builder.addInterceptor { chain ->
            val request = chain.request()
            //请求地址
            Logger.d("请求地址:" + request.url())
            chain.proceed(request)
        }
        val resInterceptor = HttpLoggingInterceptor { s ->

            if (s.length > 1) {
                val begin: String = s.substring(0, 1)
                if ("{" == begin) {
                    Logger.d(s)
                }
            }
        }
        resInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(resInterceptor)

        return builder.build()
    }


    @Provides
    @Singleton
    fun provideBuilder(client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient.Builder {
        val cookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(context))
        return OkHttpClient
            .Builder()
            .cookieJar(cookieJar)
    }


    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return BaseApplication.appContext.applicationContext
    }

    @Provides
    @Singleton
    fun provideEasyLoadBuilder(): EasyLoad.LocalBuilder {
        return EasyLoad.initLocal()
    }

    @Provides
    @Singleton
    fun provideMoShi(): Moshi {
        return Moshi.Builder().build()
    }


}