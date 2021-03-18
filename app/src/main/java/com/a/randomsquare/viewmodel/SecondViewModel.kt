package com.a.randomsquare.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.heavyobjects.HeavyObject
import javax.inject.Inject
import javax.inject.Provider

class SecondViewModel @Inject constructor(private var generator: IColorsGenerator, private var heavyObject: Provider<HeavyObject>): ViewModel() {

    var colorCode : MutableLiveData<Int> = MutableLiveData()

    fun generateNewColor(code: Int){
        colorCode.value = generator.getColor(code)
    }

    fun instanceCount():Int = HeavyObject.instantiationCount

    fun callObject(){
        heavyObject.get()
    }

}