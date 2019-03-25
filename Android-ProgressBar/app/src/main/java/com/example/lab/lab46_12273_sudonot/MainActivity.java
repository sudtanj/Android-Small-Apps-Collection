package com.example.lab.lab46_12273_sudonot;

import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStartProgress;
    Button btnStartBar;
    ProgressDialog progressBar;
    TextView textDownload;
    ProgressBar progress;
    private int progressBarStatus =0;
    private Handler progressBarHandler = new Handler();
    private Handler progressHandler= new Handler();
    private long fileSize=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick() {
        btnStartProgress=(Button)findViewById(R.id.button);
        btnStartBar=(Button)findViewById(R.id.button2);
        textDownload=(TextView) findViewById(R.id.textView2);
        btnStartBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress=(ProgressBar) findViewById(R.id.progressBar);
                progress.setProgress(0);
                progress.setMax(100);
                progress.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
                textDownload.setText("0%");
                progressBarStatus=0;
                fileSize=0;
                Thread one=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressBarStatus<100){
                            progressBarStatus=doOperation();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            progressHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progress.setProgress(progressBarStatus);
                                    textDownload.setText(String.valueOf(progressBarStatus)+"%");
                                }
                            });
                        }
                        if(progressBarStatus>=100){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                one.start();
            }
        });
        btnStartProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar=new ProgressDialog(v.getContext());
                progressBar.setCancelable(true);
                progressBar.setMessage("File downloading ...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();

                progressBarStatus=0;
                fileSize=0;

                Thread one=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressBarStatus<100){
                            progressBarStatus=doOperation();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            progressBarHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressBarStatus);
                                }
                            });
                        }
                        if(progressBarStatus>=100){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            progressBar.dismiss();
                        }
                    }
                });
                one.start();
            }
        });
    }

    public int doOperation(){
            fileSize+=1;
        return (int)fileSize;
    }
}
