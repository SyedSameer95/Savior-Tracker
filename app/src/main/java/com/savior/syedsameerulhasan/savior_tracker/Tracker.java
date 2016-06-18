package com.savior.syedsameerulhasan.savior_tracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;

public class Tracker extends AppCompatActivity {

    TextView printpoints;
    DBHandlerPoints dbHandler;
    private BroadcastReceiver mIntentReceiver;
    SharedPreferences preferences;
    public String FirstNumber;
    public String SecondNumber;
    public String ThirdNumber;

    MapsActivity MA = new MapsActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        MA.getppoints().size();


        Button First = (Button) findViewById(R.id.First);
        final Button Second = (Button) findViewById(R.id.Second);
        Button Third = (Button) findViewById(R.id.Third);

        DBHandlerContacts dbHandler = new DBHandlerContacts(this);

        FirstNumber = dbHandler.GetFirstPhoneNumber(0);
        SecondNumber = dbHandler.GetFirstPhoneNumber(1);
        ThirdNumber = dbHandler.GetFirstPhoneNumber(2);


        First.setText(FirstNumber);
        Second.setText(SecondNumber);
        Third.setText(ThirdNumber);


        final SharedPreferences preferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String InputString = preferences.getString("string_id","");
        Log.i("SP","InputString: "+InputString);
        Log.i("Number", "K"+InputString+ "K" +FirstNumber+"K");
        if (InputString.length()>1){


            if (InputString.equals(FirstNumber)){

                First.setBackgroundResource(R.drawable.plusbuttongreen);
            }
            if (InputString.equals(SecondNumber)){
                Second.setBackgroundResource(R.drawable.plusbuttongreen);
            }
            if (InputString.equals(ThirdNumber)){
                Third.setBackgroundResource(R.drawable.plusbuttongreen);
            }
        }


        First.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirstNumber.toString().length()>2){
                    if (MA.getppoints().size()<=1)
                    {
                        Toast.makeText(Tracker.this,"Not enough points",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        PlotButton(v.findViewById(R.id.First), FirstNumber);
                        preferences.edit().remove("string_id").commit();

                    }
                }
                else{
                    Toast.makeText(Tracker.this,"1st Savior Number not entered",Toast.LENGTH_SHORT).show();
                }

            }
        });

        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SecondNumber.toString().length()>2){
                    if (MA.getppoints().size()<=1) {
                        Toast.makeText(Tracker.this,"Not enough points",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        PlotButton(v.findViewById(R.id.Second),SecondNumber);
                        preferences.edit().remove("string_id").commit();

                    }
                }
                else{
                    Toast.makeText(Tracker.this, "2nd Savior Number not entered", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ThirdNumber.toString().length()>2){
                    if (MA.getppoints().size()<=1) {
                        Toast.makeText(Tracker.this,"Not enough points",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        PlotButton(v.findViewById(R.id.Third),ThirdNumber);
                        preferences.edit().remove("string_id").commit();

                    }
                }
                else{
                    Toast.makeText(Tracker.this,"3rd Savior Number not entered",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void PlotButton(View view, String PhoneNumber){
        Intent i = new Intent(this,MapsActivity.class);
        i.putExtra("PhoneNumber",PhoneNumber);
        startActivity(i);
    }
}
