package com.satnam.ksm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Nitnem extends AppCompatActivity implements View.OnClickListener {

    public static int tempid;
    CardView Stuti, JaapuSahib, RahraasSahib, KirtanSohila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nitnem);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("नितनेम");

        Stuti = (CardView) findViewById(R.id.cardViewStuti);
        JaapuSahib = (CardView) findViewById(R.id.cardViewJaapuSahib);
        RahraasSahib = (CardView) findViewById(R.id.cardViewRahiraasSahib);
        KirtanSohila = (CardView) findViewById(R.id.cardViewKirtanSohilaSahib);

        Stuti.setOnClickListener(this);

        JaapuSahib.setOnClickListener(this);

        RahraasSahib.setOnClickListener(this);

        KirtanSohila.setOnClickListener(this);
    }

    public void onClick(View view) {
        tempid = view.getId();
        if ((view.getId() == R.id.cardViewStuti) || (view.getId() == R.id.cardViewJaapuSahib) ||
                (view.getId() == R.id.cardViewRahiraasSahib) || (view.getId() == R.id.cardViewKirtanSohilaSahib)) {
            startActivity(new Intent(getApplicationContext(), LoadPDFFile.class));
        }
    }
}