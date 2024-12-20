package com.intrast.depi_s1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView    // declare "Global variable"
    lateinit var leftButton: Button
    lateinit var rigthButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView2)
        leftButton = findViewById(R.id.left_button)
        rigthButton = findViewById(R.id.right_button)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        leftButton.setOnClickListener {
            leftButtonClicked()
        }
        rigthButton.setOnClickListener{
            rightButtonClicked()
        }
    }

    fun rightButtonClicked(){
        textView.text = "Right Button Clicked"
        rigthButton.text = "clicked"
        leftButton.text = "Left"
    }

    fun leftButtonClicked(){
        textView.text = "Left Button Clicked"
        leftButton.text = "clicked"
        rigthButton.text = "Right"
    }

}