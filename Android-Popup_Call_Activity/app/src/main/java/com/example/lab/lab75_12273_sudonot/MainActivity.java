package com.example.lab.lab75_12273_sudonot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup=new PopupMenu(MainActivity.this,button1);
                popup.getMenuInflater().inflate(R.menu.popup_menu,popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().equals("Call Activity One")){
                            Intent myIntent = new Intent(getApplicationContext(), ActivityOne.class);
                            startActivity(myIntent);

                        }
                        if(item.getTitle().equals("Call Activity Two")){
                            Intent myIntent = new Intent(getApplicationContext(), ActivityTwo.class);
                            startActivity(myIntent);

                        }
                        if(item.getTitle().equals("Call Activity Three")){
                            Intent myIntent = new Intent(getApplicationContext(), ActivityThree.class);
                            startActivity(myIntent);

                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }
}

