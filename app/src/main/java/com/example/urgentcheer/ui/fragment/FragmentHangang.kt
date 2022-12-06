package com.example.urgentcheer.ui.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.urgentcheer.databinding.FragmentHangangBinding
import com.example.urgentcheer.ui.activity.MainActivity

class FragmentHangang : Fragment() {

    private var _binding: FragmentHangangBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_main, container, false)
        _binding = FragmentHangangBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        arrayTemp = (activity as MainActivity).getHangangTemp()

        val temp = (activity as MainActivity).getHangang("temp")

        binding.hgTv2.text = temp + "ºC"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}