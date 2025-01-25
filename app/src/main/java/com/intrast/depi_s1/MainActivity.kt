package com.intrast.depi_s1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        button.setOnClickListener {
//            val text = editText.text.toString()
//            editText.text.clear();
//
//
//            val intent = Intent(Intent.ACTION_VIEW)
//            if (intent.resolveActivity(packageManager) != null) {
//                startActivity(intent)
//            }
//            else{
//                Toast.makeText(this, "Error While launching activity", Toast.LENGTH_SHORT).show()
//            }
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", editText.text.toString())
            startActivity(intent)
        }

    }
}