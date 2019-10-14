package com.hfad.workout


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class WorkoutListFragment : ListFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        var names:  MutableList<String> = mutableListOf <String>()
        for (i in Workout.workouts.indices) names.add(Workout.workouts[i].name)
        var adapter = ArrayAdapter<String>(inflater.context, android.R.layout.simple_list_item_1, names)
            setListAdapter(adapter)
        return super.onCreateView(inflater, container, savedInstanceState)

    }


}
