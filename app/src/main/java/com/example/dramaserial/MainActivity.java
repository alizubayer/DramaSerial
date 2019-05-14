package com.example.dramaserial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int p;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar)findViewById(R.id.progress);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                dowork();
                start();

            }
        });
        thread.start();

    }

    private void start() {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
    private void dowork() {

        for (p=10;p<=50;p=p+10)
        {
            try
            {
                Thread.sleep(1000);
                progress.setProgress(p);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


}
