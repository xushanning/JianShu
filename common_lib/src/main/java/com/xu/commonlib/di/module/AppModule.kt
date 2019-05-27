package com.xu.commonlib.di.module

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author 言吾許
 */
@Module
class AppModule(application: Application) {
    private var mApplication: Application = application


    @Provides
    fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    fun provideContext(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}