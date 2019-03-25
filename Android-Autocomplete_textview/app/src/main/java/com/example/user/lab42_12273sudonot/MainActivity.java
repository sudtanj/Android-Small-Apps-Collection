package com.example.user.lab42_12273sudonot;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView AutoComp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> kota =new ArrayList<String>();
        kota.add("Bogor");
        kota.add("Bandung");
        ArrayAdapter<String> aa = new ArrayAdapter <String> (this, android.R.layout.select_dialog_item, kota);
        AutoComp = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        AutoComp.setThreshold(1);
        AutoComp.setAdapter(aa);
        AutoComp.setTextColor(Color.BLUE);

    }
}
