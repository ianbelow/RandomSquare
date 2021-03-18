package com.a.randomsquare.di.component

import android.app.Application
import com.a.randomsquare.MyApp
import com.a.randomsquare.di.module.FragmentModule
import com.a.randomsquare.di.module.ColorsGeneratorModule
import com.a.randomsquare.di.module.ContextModule
import com.a.randomsquare.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ColorsGeneratorModule::class, FragmentModule::class,
        AndroidSupportInjectionModule::class, ContextModule::class, ViewModelModule::class]
)
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(myApp: MyApp)
}