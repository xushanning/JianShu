package com.xu.commonlib.di.module


import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
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
        fun provideClient(builder: OkHttpClient.Builder): OkHttpClient {
            builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            builder.addInterceptor { chain ->
                val request = chain.request()
                //请求地址
                Logger.d("请求地址:" + request.url())
                chain.proceed(request)
            }

            builder.addInterceptor(HttpLoggingInterceptor { s ->
                if (s.isNotEmpty()) {
                    val begin = s.substring(0, 1)
                    if ("{" == begin) {
                        //只打印json
                        Logger.json(s)
                    }
                }

            })
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


        @JvmStatic
        @Provides
        @Singleton
        fun provideBuilder(client: OkHttpClient): Retrofit.Builder {
            return Retrofit.Builder()
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient.Builder {
            return OkHttpClient.Builder()
        }
    }
}