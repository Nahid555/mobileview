package com.example.mobiledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Thread thread;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            return;
        }

        progressBar=findViewById(R.id.progress);

        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                Display();
            }
        });
        thread.start();


    }
    public void doWork(){
        for(i=50;i<100;i=i+50){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    public void Display(){

        Intent intent=new Intent(getApplicationContext(),MyDisplay.class);
        startActivity(intent);
    }
}
