package com.intrast.depi_s1

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.intrast.depi_s1.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    lateinit var binding: ActivityThirdBinding
    val TAG = "ThirdActivity"

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate called: ")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.container1, TopFragment()).commit()

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            supportFragmentManager.beginTransaction().replace(R.id.container2, BottomFragment()).commit()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume called: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause called: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop called: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy called: ")
    }

    fun getText(name:String){
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            val bottomFragment = BottomFragment()
            val bundle = Bundle()
            bundle.putString("name",name)
            bottomFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.container1,bottomFragment).commit()
        }
        else{
            val bottomFragment = supportFragmentManager.findFragmentById(R.id.container2) as BottomFragment
            bottomFragment.setText(name)
        }

    }
}