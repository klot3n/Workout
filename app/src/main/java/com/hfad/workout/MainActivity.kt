package com.hfad.workout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity(),WorkoutListFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun itemClicked(id:Long){
        val fragmentContainer = this.findViewById<FrameLayout>(R.id.fragment_container)
        if (fragmentContainer!=null){
            val details = WorkoutDetailFragment()
            details.setWorkout(id)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,details)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit()
        } else{
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("id",id)
            startActivity(i)
        }
    }

}

