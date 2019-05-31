package com.xu.commonlib.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.xu.commonlib.base.BaseApplication
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
    }


    @Binds
    abstract fun provideApplicationContext(application: BaseApplication): Context


}