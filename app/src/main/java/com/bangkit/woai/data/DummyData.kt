package com.bangkit.woai.data

import com.bangkit.woai.R

object DummyData {
    val workoutTrainings = listOf(
        WorkoutTraining(1, "1 Minute Push-Up", R.drawable.get_started, "Description 1", 60, 100),
        WorkoutTraining(2, "2 Minute Push-Up", R.drawable.get_started_2, "Description 2", 120, 200),
        WorkoutTraining(3, "3 Minute Push-Up", R.drawable.get_started_3, "Description 3", 180, 300),
        WorkoutTraining(4, "Custom Push-Up", R.drawable.get_started, "Custom Description", 90, 150),
    )

    val historyTrainings = listOf(
        HistoryTraining("No Data", "-- : --"),
    )
}