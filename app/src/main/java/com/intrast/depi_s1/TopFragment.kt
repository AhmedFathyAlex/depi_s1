package com.intrast.depi_s1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.intrast.depi_s1.databinding.FragmentTopBinding


class TopFragment : Fragment() {
    lateinit var binding: FragmentTopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTopBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            val name = binding.editText.text.toString()
            binding.editText.text.clear()

            if (activity is SecondActivity) {
               val activity = activity as SecondActivity
                activity.getText(name)
            }else{
                Toast.makeText(context,"Not in the Second Activity",Toast.LENGTH_SHORT).show()
            }


        }


    }

}