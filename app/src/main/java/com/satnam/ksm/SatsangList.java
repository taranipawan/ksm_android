package com.satnam.ksm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.format.DateFormat;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SatsangList extends AppCompatActivity {

    private static final String JSON_URL = "https://ksmdarbarnagpur.000webhostapp.com/fetch_satsang_list.php";
    RecyclerView satsangList;
    List<SatsangListModal> satsangDataList;
    private ProgressBar spinner;
    Date server_date, sysdate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat newdateFormat = new SimpleDateFormat("dd MMMM yyyy EEEE", Locale.ENGLISH);
    String sysdate_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satsang_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("सत्संग लिस्ट");

        sysdate_string = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
        try {
            sysdate = dateFormat.parse(this.sysdate_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        satsangList = (RecyclerView) findViewById(R.id.recyclerViewSatsangList);
        spinner = (ProgressBar) findViewById(R.id.progressBarSatsangList);

        satsangList.setLayoutManager(new LinearLayoutManager(this));
        satsangDataList = new ArrayList<>();

        if(isInternetOn() != true) {
            AlertDialog.Builder builder = new AlertDialog.Builder(SatsangList.this);
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

        loadSatsangList();
    }

    private void loadSatsangList() {
        spinner.setVisibility(View.VISIBLE);
        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //getting the whole json object from the response
                            JSONArray satsangListArray = new JSONArray(response);

                            //now looping through all the elements of the json array
                            for (int i = 0; i < satsangListArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject satsangObject = satsangListArray.getJSONObject(i);

                                server_date = dateFormat.parse(satsangObject.getString("date"));

                                if (server_date.equals(sysdate) || server_date.after(sysdate)) {

                                    //creating a hero object and giving them the values from json object
                                    SatsangListModal satsang = new SatsangListModal(newdateFormat.format(server_date).toString(),
                                            satsangObject.getString("time"),
                                            satsangObject.getString("place"),
                                            satsangObject.getString("organizer"),
                                            satsangObject.getString("kirtankar"));

                                    //adding the hero to herolist
                                    satsangDataList.add(satsang);
                                }
                            }

                            //creating custom adapter object
                            SatsangListAdapter adapter = new SatsangListAdapter(getApplicationContext(), satsangDataList);

                            //adding the adapter to listview
                            satsangList.setAdapter(adapter);

                            spinner.setVisibility(View.GONE);

                        } catch (JSONException | ParseException e) {
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