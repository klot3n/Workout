package com.hfad.workout


import android.content.Context
import android.net.sip.SipSession
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class WorkoutListFragment : ListFragment() {

    interface Listener{
        fun itemClicked(id:Long){}
    }
    var listener: Listener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val names:  MutableList<String> = mutableListOf <String>()
        for (i in Workout.workouts.indices) names.add(Workout.workouts[i].name)
        val adapter = ArrayAdapter<String>(inflater.context, android.R.layout.simple_list_item_1, names)
            setListAdapter(adapter)
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.listener=context as Listener
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        if(listener!=null) listener!!.itemClicked(id)
    }


}
