package com.example.dramaserial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class HomeActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    private Spinner spinner;
    private String[] countryNames;


    private AlertDialog.Builder alertdialogBuilder;
    private boolean isFirstSelection = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        viewFlipper = findViewById(R.id.imageFlipper);
        spinner = findViewById(R.id.spinner);

        countryNames = getResources().getStringArray(R.array.country_name);

        CustomAdapter adapter = new CustomAdapter(countryNames,this);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                if (isFirstSelection==true)
                {
                    isFirstSelection = false;
                }
                else
                {
                    String value = countryNames[position];

                    if(value.equalsIgnoreCase("Country Name"))
                    {
                        Toast.makeText(HomeActivity.this, "Please Select a Country Name", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        Toast.makeText(HomeActivity.this, value+"is selected", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });


        int images[] = {R.drawable.strongwoman,R.drawable.goblin,R.drawable.hq,R.drawable.living_poster};

        for (int image: images){
            flipperimages(image);

        }



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void flipperimages(int images){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(5000);//5 sec
        viewFlipper.setAutoStart(true);

        //animation


        viewFlipper.setOutAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setInAnimation(this, android.R.anim.slide_out_right);

    }


    @Override
    public void onBackPressed() {



        alertdialogBuilder = new AlertDialog.Builder(HomeActivity.this);

        alertdialogBuilder.setTitle("Exit Button");
        alertdialogBuilder.setMessage("Do you want to exit?");
        alertdialogBuilder.setIcon(R.drawable.ic_exit_to_app_black_24dp);
        alertdialogBuilder.setCancelable(false);
        alertdialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertdialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertdialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(HomeActivity.this, "Cancel Exit Button", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog  = alertdialogBuilder.create();
        alertDialog.show();





    }


}
