package com.xu.module.sport.di.component

import com.xu.commonlib.di.component.AppComponent
import com.xu.commonlib.di.scope.ActivityScope
import com.xu.module.sport.di.module.MainModule
import com.xu.module.sport.ui.activity.main.MainActivity
import dagger.Component

/**
 * @author 言吾許
 */
@ActivityScope
@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
interface MainComponent {
    fun inject(main: MainActivity)
}