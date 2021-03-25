package com.a.randomsquare.third

import androidx.lifecycle.ViewModel
import com.a.randomsquare.common.ViewModelKey
import com.a.randomsquare.generator.namegenerator.INameGenerator
import com.a.randomsquare.generator.namegenerator.MyNameGeneratorImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ThirdFragmentModule {

    @Binds
    abstract fun provideNameGenerator(generator: MyNameGeneratorImpl): INameGenerator

    @Binds
    @IntoMap
    @ViewModelKey(ThirdViewModel::class)
    internal abstract fun secondViewModel(viewModel: ThirdViewModel): ViewModel
}