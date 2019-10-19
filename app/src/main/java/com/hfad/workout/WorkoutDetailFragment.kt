package com.hfad.workout

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class WorkoutDetailFragment :Fragment() {

    var workoutId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState==null) {
            val stopwatch = StopWatchFragment()
            val fr = childFragmentManager.beginTransaction()
                .add(R.id.stopwatch_container, stopwatch).addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        } else{
            workoutId=savedInstanceState.getLong("workoutId")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false)
    }

    override fun onStart(){
        super.onStart()
        val view=view
        if (view!=null){
            val workout = Workout.workouts[workoutId!!.toInt()]
            val title = view.findViewById<TextView>(R.id.textTitle)
            title.setText(workout.name)
            val description = view.findViewById<TextView>(R.id.textDescription)
            description.setText(workout.description)

        }

    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {savedInstanceState
        savedInstanceState.putLong("workoutId", workoutId!!.toLong())
    }

    fun setWorkout (id :Long){
        this.workoutId=id
    }

}