package com.a.randomsquare.second

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.databinding.FragmentSecondBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SecondFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: SecondViewModel
    private lateinit var binding: FragmentSecondBinding
    private lateinit var rootView: View

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        binding.generateSecondButton.setOnClickListener {
            viewModel.generateRandomColor()
        }
        viewModel.colorCodeLiveData.observe(viewLifecycleOwner, Observer {
            binding.secondSquare.setBackgroundColor(viewModel.colorCodeLiveData.value!!)
        })

        return rootView
    }

    private fun init() {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        rootView = binding.root
        viewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)
    }
}