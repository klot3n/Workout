//package com.hfad.workout;
//
//import android.support.v4.app.Fragment;
//import android.view.View;
//import android.widget.TextView;
//
//import java.util.Locale;
//import java.util.logging.Handler;
//import java.util.logging.LogRecord;
//import java.lang.Runnable;
//
//public class ri extends Fragment {
//    private void runTimer2 (View view){
//        final TextView timeView = (TextView) view.findViewById(R.id.time_view);
//
//                final Handler handler = new Handler() {
//                    @Override                    public void publish(LogRecord record) {                    }
//
//                    @Override                    public void flush() {                    }
//
//                    @Override                    public void close() throws SecurityException {                    }
//                };
//        handler.post( new Runnable() {
//                @Override
//                public void run(){
//                    int hours = seconds/3600;
//                    int minutes = (seconds%3600)/60;
//                    int secs=seconds%60;
//                    String time=String.format(Locale.getDefault(),"%d:02d:%02d", hours,minutes,secs);
//                timeView.setText(time);
//                if(running){
//                    seconds++;
//                }
//                handler.postDelayed(this,1000);
//            }
//        });
//    }
//}
