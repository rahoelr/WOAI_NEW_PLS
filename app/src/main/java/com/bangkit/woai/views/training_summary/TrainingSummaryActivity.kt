package com.bangkit.woai.views.training_summary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.woai.databinding.ActivityTrainningSummaryBinding

class TrainingSummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrainningSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainningSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val historyTrainingId = intent.getIntExtra("historyTrainingId", 0)
        Log.d("historyId", "$historyTrainingId")
    }

}