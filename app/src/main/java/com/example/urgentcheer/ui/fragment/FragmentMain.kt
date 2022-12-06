package com.example.urgentcheer.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.urgentcheer.databinding.FragmentMainBinding
import com.example.urgentcheer.ui.activity.MainActivity
import org.json.JSONArray
import java.util.*

class FragmentMain : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var jsonQuote : JSONArray = (activity as MainActivity).getQuote()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val num = Random().nextInt(jsonQuote.length())


        binding.tvQuote.text = jsonQuote.getJSONObject(num).getString("quote")
        binding.tvQuote.append("\n - " + jsonQuote.getJSONObject(num).getString("speaker"))

    }

}