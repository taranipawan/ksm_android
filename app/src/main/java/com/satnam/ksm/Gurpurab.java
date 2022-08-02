package com.satnam.ksm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Gurpurab extends AppCompatActivity {

    private static final String JSON_URL = "https://ksmdarbarnagpur.000webhostapp.com/fetch_gurpurab_info.php";
    RecyclerView gurpurabList;
    List<GurpurabModal> gurpurabDataList;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gurpurab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("गुरपूरब तिथियां");

        gurpurabList = (RecyclerView) findViewById(R.id.recyclerViewGurpurab);
        spinner = (ProgressBar) findViewById(R.id.progressBarGurpurab);

        gurpurabList.setHasFixedSize(true);
        gurpurabList.setLayoutManager(new LinearLayoutManager(this));
        gurpurabDataList = new ArrayList<>();

        if(isInternetOn() != true) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Gurpurab.this);
            builder.setTitle((CharSequence) "Enable mobile data");
            builder.setMessage((CharSequence) "KSM require mobile data connection to be ON.").setCancelable(false).setPositiveButton((CharSequence) "Ok", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.create().show();
            spinner.setVisibility(View.GONE);
            return;
        }

        loadGurpurabList();
    }

    private void loadGurpurabList() {

        spinner.setVisibility(View.VISIBLE);
        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //getting the whole json object from the response
                            JSONArray gurpurabListArray = new JSONArray(response);

                            //now looping through all the elements of the json array
                            for (int i = 0; i < gurpurabListArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject gurpurabObject = gurpurabListArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object
                                GurpurabModal satsang = new GurpurabModal(gurpurabObject.getString("sno"),
                                        gurpurabObject.getString("description"));

                                //adding the hero to herolist
                                gurpurabDataList.add(satsang);
                            }

                            //creating custom adapter object
                            GurpurabListAdapter adapter = new GurpurabListAdapter(getApplicationContext(), gurpurabDataList);

                            //adding the adapter to listview
                            gurpurabList.setAdapter(adapter);

                            spinner.setVisibility(View.GONE);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        spinner.setVisibility(View.GONE);
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }

    private boolean isInternetOn() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}