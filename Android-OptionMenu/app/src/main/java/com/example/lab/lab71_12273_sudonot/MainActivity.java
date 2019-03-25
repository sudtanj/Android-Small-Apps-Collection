package com.example.lab.lab71_12273_sudonot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_NEW_GAME=Menu.FIRST;
    private static final int MENU_QUIT=Menu.FIRST+1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,MENU_NEW_GAME,0,"New Game");
        menu.add(0,MENU_QUIT,0,"Quit").setIcon(R.drawable.ic_quit);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case MENU_NEW_GAME:
                newGame();
                return true;
            case MENU_QUIT:
                quit();
                return true;
        }
        return false;
    }

    public void newGame(){

    }
    public void quit(){

    }
}
