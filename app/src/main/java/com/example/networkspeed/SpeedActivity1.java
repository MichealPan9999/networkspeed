package com.example.networkspeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SpeedActivity1 extends AppCompatActivity {

    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed1);
        textView = findViewById(R.id.showspeed);
        new NetWorkSpeedUtils(this,mHnadler).startShowNetSpeed();
    }

    private Handler mHnadler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    textView.append("当前网速： " +System.currentTimeMillis()+" : "+ msg.obj.toString()+"\n");
                    Log.d("SpeedActivity1", +System.currentTimeMillis()+" : "+ msg.obj.toString());
                    break;
            }
            super.handleMessage(msg);
        }
    };

}
