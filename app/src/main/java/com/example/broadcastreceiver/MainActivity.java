package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tvLevel,tvHealth,tvTemp;
BatteryReceiver batteryReceiver;
ImageView ivEmpty;
Button btnPush;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLevel=findViewById(R.id.tvLevel);
        btnPush=findViewById(R.id.btnPush);
        btnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
//        tvHealth=findViewById(R.id.tvHealth);
//        tvTemp=findViewById(R.id.tvTemp);
        ivEmpty=findViewById(R.id.ivEmpty);
        batteryReceiver=new BatteryReceiver();
        registerReceiver(batteryReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(batteryReceiver);
        super.onDestroy();
    }

    class BatteryReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);

//                int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
//                int temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
            tvLevel.setText(Integer.toString(level));
//                tvHealth.setText(Integer.toString(health));
//                tvTemp.setText(Integer.toString(temp)+"");
                if (level==100){
                    ivEmpty.setImageResource(R.drawable.batterypercentage);
                }else if (level<100 && level>80){
                    ivEmpty.setImageResource(R.drawable.batteryeighty);
                }else if (level<80 && level>60){
                    ivEmpty.setImageResource(R.drawable.imagessixty);
                }else if (level<60 && level>40){
                    ivEmpty.setImageResource(R.drawable.imahefourty);
                }else if (level<40 && level>20){
                    ivEmpty.setImageResource(R.drawable.batterythirty);
                }else if (level<20 && level>1)
                    ivEmpty.setImageResource(R.drawable.batteryutwenty);
                }else{
                ivEmpty.setImageResource(R.drawable.empty);

            }

        }
        }
}

