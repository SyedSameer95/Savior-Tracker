package com.savior.syedsameerulhasan.savior_tracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SaviorSettings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText contact1;
    EditText contact2;
    EditText contact3;
    EditText intervaltext;
    TextView printcontacts;
    DBHandlerContacts dbHandler;
    DBHandlerInterval dbHandlerInterval;
    private Spinner spinner;
    private static final String[]paths = {"Choose Interval (mins)","1", "2", "3","4","5","10"};
    Interval interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savior_settings);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SaviorSettings.this,android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        String st = spinner.toString();

        contact1 = (EditText) findViewById(R.id.contact1);
        contact2 = (EditText) findViewById(R.id.contact2);
        contact3 = (EditText) findViewById(R.id.contact3);
        //intervaltext = (EditText) findViewById(R.id.intervaltext);
        printcontacts = (TextView) findViewById(R.id.printcontacts);
        dbHandlerInterval =new DBHandlerInterval(this);
        dbHandler = new DBHandlerContacts(this);
        printDatabase();
        Log.i("ST",st);
    }

    public void addButtonClicked(View view){
        Contacts contact = new Contacts();
        if(contact1.getText().toString().length() > 9) {
            contact = new Contacts(contact1.getText().toString());
            dbHandler.addContact(contact);}
        if(contact2.getText().toString().length() > 9) {
            contact = new Contacts(contact2.getText().toString());
            dbHandler.addContact(contact);}
        if(contact3.getText().toString().length() > 9) {
            contact = new Contacts(contact3.getText().toString());
            dbHandler.addContact(contact);}
/*        Interval interval = new Interval();
        if(intervaltext.getText().toString().length() > 0) {
            interval = new Interval(intervaltext.getText().toString());
            String text = spinner.getSelectedItem().toString();
            dbHandlerInterval.addInterval(text);
        }*/

        printDatabase();
    }

    public void deleteButtonClicked (View view){
        dbHandler.delContact();
        dbHandlerInterval.delInterval();
        printDatabase();
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        String dbStringinterval = dbHandlerInterval.databaseToString();
        printcontacts.setText(dbString+"\n"+dbStringinterval);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        interval = new Interval();
        String intervalt;
        switch (position) {
            case 0:

                break;
            case 1:
                intervalt=parent.getItemAtPosition(position).toString();
                interval = new Interval(intervalt);
                dbHandlerInterval.addInterval(interval);
                break;
            case 2:
                intervalt=parent.getItemAtPosition(position).toString();
                interval = new Interval(intervalt);
                dbHandlerInterval.addInterval(interval);
                break;
            case 3:
                intervalt=parent.getItemAtPosition(position).toString();
                interval = new Interval(intervalt);
                dbHandlerInterval.addInterval(interval);
                break;
            case 4:
                intervalt=parent.getItemAtPosition(position).toString();
                interval = new Interval(intervalt);
                dbHandlerInterval.addInterval(interval);
                break;
            case 5:
                intervalt=parent.getItemAtPosition(position).toString();
                interval = new Interval(intervalt);
                dbHandlerInterval.addInterval(interval);
                break;
            case 6:
                intervalt=parent.getItemAtPosition(position).toString();
                interval = new Interval(intervalt);
                dbHandlerInterval.addInterval(interval);
                break;
            case 7:
                intervalt=parent.getItemAtPosition(position).toString();
                interval = new Interval(intervalt);
                dbHandlerInterval.addInterval(interval);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
