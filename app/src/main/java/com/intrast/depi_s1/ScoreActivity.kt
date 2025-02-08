package com.intrast.depi_s1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.intrast.depi_s1.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    lateinit var binding: ActivityScoreBinding
    lateinit var viewModel: ScoreViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        binding.viewModel = viewModel

        binding.addTeamAScoreButton.setOnClickListener {
           viewModel.incrementScore(true)
            binding.teamAScore.text = viewModel.teamAScore.toString()
        }
        binding.addTeamBScoreButton.setOnClickListener {
            viewModel.incrementScore(false)
            binding.teamBScore.text = viewModel.teamBScore.toString()
        }
        binding.resetButton.setOnClickListener {
            viewModel.resetScore()
            binding.teamAScore.text = 0.toString()
            binding.teamBScore.text = 0.toString()
        }
    }
}