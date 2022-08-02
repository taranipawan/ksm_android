package com.satnam.ksm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.github.barteksc.pdfviewer.PDFView;

public class SukhmaniSahib extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    PDFView SukhmaniView;
    Spinner SaloksList;
    Button Next, Previous;
    String[] Saloks = { "1 - आदि गुरए नमह",
            "2 - दीन दरद दुख भंजना",
            "3 - बहु सासत्र बहु सिम्रिती",
            "4 - निरगुनीआर इआनिआ",
            "5 - देनहारु प्रभ छोडि कै",
            "6 - काम क्रोध अरु लोभ मोह",
            "7 - अगम अगाधि पारब्रहमु सोइ",
            "8 - मनि साचा मुखि साचा सोइ",
            "9 - उरि धारै जो अंतरि नामु",
            "10 - उसतति करहि अनेक जन",
            "11 - करण कारण प्रभु एकु है",
            "12 - सुखी बसै मसकीनीआ",
            "13 - संत सरनि जो जनु परै",
            "14 - तजहु सिआनप सुरि जनहु",
            "15 - सरब कला भरपूर प्रभ",
            "16 - रूप न रेख न रंगु किछु",
            "17 - आदि सचु जुगादि सचु",
            "18 - सति पुरखु जिनि जानिआ",
            "19 - साथि न चालै बिनु भजन",
            "20 - फिरत फिरत प्रभ आइआ",
            "21 - सरगुन निरगुन निरंकार",
            "22 - जीअ जंत के ठाकुरा",
            "23 - गिआनु अंजनु गुरि दिआ",
            "24 - पूरा प्रभु आराधिआ" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sukhmani_sahib);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("श्री सुखमनी साहिब");
        getWindow().addFlags(128);

        SukhmaniView = (PDFView) findViewById(R.id.pdfViewForSukhmaniSahib);
        SaloksList = (Spinner) findViewById(R.id.spinnerSaloks);
        Next = (Button) findViewById(R.id.btnNextSalok);
        Previous = (Button) findViewById(R.id.btnPrevSalok);

        SaloksList.setOnItemSelectedListener(this);

        SukhmaniView.fromAsset("sukhmaniSahib/Salok 1.pdf").load();

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Saloks);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        SaloksList.setAdapter(aa);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaloksList.setSelection(SaloksList.getSelectedItemPosition() + 1);
            }
        });

        Previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaloksList.setSelection(SaloksList.getSelectedItemPosition() - 1);
            }
        });
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        SukhmaniView.fromAsset("sukhmaniSahib/Salok " + (position+1) + ".pdf").load();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}