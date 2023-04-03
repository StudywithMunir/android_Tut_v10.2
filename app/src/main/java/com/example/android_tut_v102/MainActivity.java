package com.example.android_tut_v102;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button serious, fun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();

        //calling those button onClickListner that defined in switch
        serious.setOnClickListener(this);
        fun.setOnClickListener(this);


    }

    public void initializer() {
        serious = (Button) findViewById(R.id.b1);
        fun = (Button) findViewById(R.id.b2);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.b1:

                serious.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new AlertDialog.Builder(MainActivity.this)
                                .setIcon(R.drawable.baseline_warning_24)
                                .setTitle("Do you want to Quit?")

                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                })

                                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                })

                                .setNeutralButton("cancel(sleep)", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Thread timer = new Thread() {

                                            public void run() {
                                                try {
                                                    sleep(5000);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                } finally {
                                                    Intent ourIntent = new Intent("com.example.android_tut_v102.MainActivity");
                                                    startActivity(ourIntent);
                                                }
                                            }

                                        };
                                        timer.start();

                                    }
                                })
                                .show();

                    }
                });

                break;

            case R.id.b2:

                fun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        new AlertDialog.Builder(MainActivity.this)
                                .setIcon(R.drawable.baseline_accessibility_new_24)
                                .setTitle("Do you want to Quit?")

                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();

                                    }
                                })

                                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                })

                                .setNeutralButton("cancel(sleep)", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        Thread timer = new Thread() {

                                            public void run() {
                                                try {
                                                    sleep(5000);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                } finally {
                                                    Intent ourIntent = new Intent("com.example.android_tut_v102.MainActivity");
                                                    startActivity(ourIntent);
                                                }
                                            }

                                        };
                                        timer.start();


                                    }
                                })
                                .show();


                    }
                });


        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}