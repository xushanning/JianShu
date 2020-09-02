package com.xu.commonlib.di


import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseApplication
import com.xu.commonlib.constant.TableConstant
import com.xu.commonlib.db.AppDatabase
import com.xu.easyload.EasyLoad
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

        builder.addInterceptor { chain ->
            val builder1 = chain.request().newBuilder()
            chain.proceed(builder1.build())
        }
        builder.addInterceptor { chain ->
            val builder1 = chain.request().newBuilder()
            builder1.addHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.108 Safari/537.36 2345Explorer/8.0.0.13547"
            )
            builder1.addHeader("Cache-Control", "max-age=0")
            builder1.addHeader("Upgrade-Insecure-Requests", "1")
            builder1.addHeader("X-Requested-With", "XMLHttpRequest")
            builder1.addHeader(
                "Cookie",
                "uuid=\"w:f2e0e469165542f8a3960f67cb354026\"; __tasessionId=4p6q77g6q1479458262778; csrftoken=7de2dd812d513441f85cf8272f015ce5; tt_webid=36385357187"
            )
            chain.proceed(builder1.build())
        }
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
    fun provideOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }


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

    @Provides
    @Singleton
    fun provideEasyLoadBuilder(): EasyLoad.LocalBuilder {
        return EasyLoad.initLocal()
    }


}