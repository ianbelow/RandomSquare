package com.a.randomsquare

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.a.randomsquare.di.ContextModule
import com.a.randomsquare.di.DaggerAppComponent
import javax.inject.Inject


class MainFragment : Fragment() {

    @Inject
    lateinit var colorsGenerator: ColorsGenerator
    lateinit var generateButton: Button
    lateinit var square: View

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        init(view)
        generateButton.setOnClickListener {
            square.setBackgroundColor(colorsGenerator.getColor((1..5).random()))
        }
        return view
    }

    private fun init(view: View) {
        generateButton = view.findViewById(R.id.generateButton)
        square = view.findViewById(R.id.square)
        square.setBackgroundColor(colorsGenerator.getCurrentColor())
    }

}