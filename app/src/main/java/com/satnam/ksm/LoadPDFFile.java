package com.satnam.ksm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class LoadPDFFile extends AppCompatActivity {

    PDFView GranthView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_pdffile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(128);

        GranthView = (PDFView) findViewById(R.id.pdfViewForGranth);

        if (Nitnem.tempid == R.id.cardViewStuti) {
            GranthView.fromAsset("stuti.pdf").load();
        } else if (Nitnem.tempid == R.id.cardViewJaapuSahib) {
            GranthView.fromAsset("appjaapusahib.pdf").load();
        } else if (Nitnem.tempid == R.id.cardViewRahiraasSahib) {
            GranthView.fromAsset("rahiraassahib.pdf").load();
        } else if (Nitnem.tempid == R.id.cardViewKirtanSohilaSahib) {
            GranthView.fromAsset("kirtansohila.pdf").load();
        }
    }
}