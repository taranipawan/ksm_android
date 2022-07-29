package com.satnam.ksm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class SukhmaniSahib extends AppCompatActivity {

    PDFView SukhmaniView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sukhmani_sahib);

        SukhmaniView = (PDFView) findViewById(R.id.pdfViewForSukhmaniSahib);
        SukhmaniView.fromAsset("Salok1.pdf");
    }
}