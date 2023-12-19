package com.bangkit.woai.views.training_summary

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bangkit.woai.data.preferences.Constant
import com.bangkit.woai.data.preferences.PreferenceHelper
import com.bangkit.woai.data.repository.UserRepository
import com.bangkit.woai.data.retrofit.ApiConfig
import com.bangkit.woai.databinding.ActivityTrainningSummaryBinding

class TrainingSummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrainningSummaryBinding
    private lateinit var viewModel: TrainingSummaryViewModel
    private lateinit var sharedPref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainningSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideSystemUI()

        sharedPref = PreferenceHelper(this)

        val historyTrainingId = intent.getIntExtra("historyTrainingId", 0)
        Log.d("historyId", "$historyTrainingId")

        val userRepository = UserRepository.getInstance(ApiConfig().getApiService(this))
        viewModel = ViewModelProvider(this, TrainingSummaryViewModelFactory(userRepository))
            .get(TrainingSummaryViewModel::class.java)

        val prefToken = sharedPref.getString(Constant.PREF_TOKEN)
        val id = historyTrainingId

        if (prefToken != null) {
            viewModel.getSpecificActivity(id, prefToken)
        }
        viewModel.specificActivity.observe(this, Observer { specificActivityResponse ->
            Log.d("TrainingSummaryActivity", "Specific Activity Response: $specificActivityResponse")
        })
    }

    private fun hideSystemUI() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

}