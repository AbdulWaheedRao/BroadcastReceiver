package com.example.broadcastreceiver;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        ActivityResultLauncher<String> requestPermissionLauncher=registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                Toast.makeText(MainActivity2.this, "thanks", Toast.LENGTH_SHORT).show();
            }
        });
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)== PackageManager.PERMISSION_DENIED){
            requestPermissionLauncher.launch(Manifest.permission.READ_PHONE_STATE);
        }
    }
}