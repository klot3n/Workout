package com.hfad.workout

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class WorkoutDetailFragment :Fragment() {

    var workoutId: Long? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        val view=view
        if (view!=null){
            val workout = /*workoutId.toString()*/Workout.workouts[workoutId!!.toInt()]    //Если [2] -> "5 Pull-ups...
            val title = view.findViewById<TextView>(R.id.textTitle)
            title.setText(workout.name)
            val description = view.findViewById<TextView>(R.id.textDescription)
            description.setText(workout.description)

        }

    }

    fun setWorkout (id :Long){
        this.workoutId=id
    }

}