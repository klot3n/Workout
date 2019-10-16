package com.hfad.workout

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_stopwatch.*
import java.util.*
//import java.util.logging.Handler

class StopWatchFragment : Fragment() {
    var seconds = 0
    var running = false
    var wasRunning = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_stopwatch, container, false)//.apply {
//            start_button.setOnClickListener { running = true }
//        stop_button.setOnClickListener { running = false }
//        reset_button.setOnClickListener { running = false; seconds = 0 }
//        }
        runTimer(layout)
        return layout
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) running = true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }

    private fun onClickStart() {
        running = true
    }

    private fun onClickStop() {
        running = false
    }

    private fun onClickReset() {
        running = false
        seconds = 0
    }
    private fun runTimer (view :View){
        val timeView = view.findViewById<TextView>(R.id.time_view)

        lateinit var handler:Handler
        handler.post( object : Runnable {
            override fun run() {
                val hours = seconds/3600
                val minutes = (seconds%3600)/60
                val secs=seconds%60
                val time=String.format(Locale.getDefault(),"%d:02d:%02d", hours,minutes,secs)
                timeView.setText(time)
                if(running){
                    seconds++
                }
                handler.postDelayed(this,1000)
            }
        })
    }
//    override fun onClick (v:View){

}