package com.hfad.workout

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

class TempActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
        if (savedInstanceState==null){
            val stopwatch =StopWatchFragment()
            val fr = supportFragmentManager.beginTransaction()
                .add(R.id.stopwatch_container,stopwatch).addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }
    }

}