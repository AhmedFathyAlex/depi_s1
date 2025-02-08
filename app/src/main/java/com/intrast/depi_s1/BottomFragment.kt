package com.intrast.depi_s1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intrast.depi_s1.databinding.FragmentBottomBinding


class BottomFragment : Fragment() {
    lateinit var binding : FragmentBottomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBottomBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val name = arguments?.getString("name").toString()
        val name = BottomFragmentArgs.fromBundle(requireArguments()).name
        setText(name)
    }

    fun setText(name:String){
        binding.textView.text = name

    }
}