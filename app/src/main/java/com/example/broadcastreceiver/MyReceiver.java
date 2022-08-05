package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String state=intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
            Toast.makeText(context, "Phone state is idle", Toast.LENGTH_SHORT).show();
        }else if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            Toast.makeText(context, "Ringing", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Off Hook", Toast.LENGTH_SHORT).show();
        }
}
}