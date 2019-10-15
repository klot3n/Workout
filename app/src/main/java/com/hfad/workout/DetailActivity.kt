package com.hfad.workout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hfad.workout.R.id.detail_frag

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag = WorkoutDetailFragment()
        val workoutId:Long = intent.getLongExtra("id",213)
        frag.setWorkout(workoutId)
        supportFragmentManager.beginTransaction().replace(R.id.detail_frag,frag).commit()

    }
}