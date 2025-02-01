package com.intrast.depi_s1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.intrast.depi_s1.databinding.FragmentTopBinding


class TopFragment : Fragment() {
    lateinit var binding: FragmentTopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TopFragment","onCreateView called: ")
        // Inflate the layout for this fragment
        binding = FragmentTopBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("TopFragment","onViewCreated called: ")
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            val name = binding.editText.text.toString()
            binding.editText.text.clear()

            if (activity is SecondActivity) {
               val activity = activity as SecondActivity
                activity.getText(name)
            }else if (activity is ThirdActivity){
                val activity = activity as ThirdActivity
                activity.getText(name)
            }
            else if (activity is NavActivity){

            val direction= TopFragmentDirections.actionTopFragment2ToBottomFragment2(name)
                findNavController().navigate(direction)
            }
            else{
                Toast.makeText(context,"Not in the Second Activity",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("TopFragment","onStop called: ")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TopFragment","onDestroy called: ")
    }

}