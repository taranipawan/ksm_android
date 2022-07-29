package com.satnam.ksm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button SukhmaniSahib, SatsangList, Nitnem, Gurpurab, JapjiSahib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SatsangList = (Button) findViewById(R.id.btnSatsangList);
        Nitnem = (Button) findViewById(R.id.btnNitnem);
        Gurpurab = (Button) findViewById(R.id.btnGurpurab);
        JapjiSahib = (Button) findViewById(R.id.btnJapjiSahib);
        SukhmaniSahib = (Button) findViewById(R.id.btnSukhmaniSahib);

        SatsangList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.satnam.ksm.SukhmaniSahib.class));
            }
        });

        Nitnem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.satnam.ksm.SukhmaniSahib.class));
            }
        });

        Gurpurab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.satnam.ksm.SukhmaniSahib.class));
            }
        });

        JapjiSahib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.satnam.ksm.SukhmaniSahib.class));
            }
        });

        SukhmaniSahib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.satnam.ksm.SukhmaniSahib.class));
            }
        });
    }
}