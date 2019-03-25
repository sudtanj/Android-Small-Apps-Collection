package com.example.user.lab41_12273sudonot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spin1;
    Spinner spin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1=(Spinner) findViewById(R.id.spinner);
        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length() > 0 && !countries.contains(country)) {
                countries.add(country);
            }
        }

        Collections.sort(countries);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countries);

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the your spinner
        spin1.setAdapter(countryAdapter);

        spin2=(Spinner)findViewById(R.id.spinner2);
        ArrayList<String> ethnic = new ArrayList<String>();

        ethnic.add("Ambon");
        ethnic.add("Malays");

        ArrayAdapter<String> ethnicAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ethnic);
        spin2.setAdapter(ethnicAdapter);

        Button play=(Button) findViewById(R.id.button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append(String.format("Spinner 1: %s", spin1.getSelectedItem()));
                result.append(String.format("Spinner 2: %s", spin2.getSelectedItem()));
                Toast.makeText(getApplicationContext(),"hasil pilihan"+result.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
