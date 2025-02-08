package com.intrast.depi_s1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.intrast.depi_s1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menue, menu)
        super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.notification -> {
                val intent = Intent(this, ThirdActivity::class.java)
                startActivity(intent)
            }

            R.id.profile -> {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
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