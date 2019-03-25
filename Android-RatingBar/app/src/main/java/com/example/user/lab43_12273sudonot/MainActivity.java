package com.example.user.lab43_12273sudonot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RatingBar rating;
    TextView percent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percent=(TextView) findViewById(R.id.textView);
        rating=(RatingBar) findViewById(R.id.ratingBar);
        rating.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String sRatingBar = String.valueOf(rating.getRating());
                percent.setText(sRatingBar);
                return false;
            }
        });
    }
}
