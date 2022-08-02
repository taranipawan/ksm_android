package com.satnam.ksm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class JapJiSahib extends AppCompatActivity {

    PDFView JapJiSahibView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jap_ji_sahib);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("श्री जपुजी साहिब");
        getWindow().addFlags(128);

        JapJiSahibView = (PDFView) findViewById(R.id.pdfViewForJapJiSahib);

        JapJiSahibView.fromAsset("japjisahib.pdf").load();
    }
}