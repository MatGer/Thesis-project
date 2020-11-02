 package com.example.diplwmatikh;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class universal extends AppCompatActivity {
    Intent intent;
    AlertDialog.Builder builderreset, builderback, builderfinished, builderfinished_score;
    public void runtime(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//screen always on
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION        //options to hide nav bar, status bar and further functionality
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        builderback = new AlertDialog.Builder(universal.this);
        builderback.setCancelable(false);       //makes alert to close only if you press yes or no
        builderback.setMessage("Θέλετε να επιστρέψετε στο αρχικό μενού;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(universal.this, Mainmenu.class);
                        startActivity(intent);
                        intent=null;
                    }
                })
                .setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        decorView.setSystemUiVisibility(uiOptions);
                    }
                });

        builderreset = new AlertDialog.Builder(universal.this);
        builderreset.setCancelable(false);          //makes alert to close only if you press yes or no
        builderreset.setMessage("Θέλετε να ξανακάνετε την δραστηριότητα;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = getIntent();
                        finish();
                        startActivity(intent);
                        intent=null;
                    }
                })
                .setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        decorView.setSystemUiVisibility(uiOptions);
                    }
                });


    }

    void create_builder_finished_with_score(int a){
        builderfinished_score = new AlertDialog.Builder(universal.this);
        builderfinished_score.setTitle("Η δραστηριότητα ολοκληρώθηκε!");
        builderfinished_score.setMessage("Το σκορ ειναι : "+a+" .Θέλετε να ξανακάνετε την δραστηριότητα;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = getIntent();
                        finish();
                        startActivity(intent);
                        intent=null;
                    }
                })
                .setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(universal.this, Mainmenu.class);
                        startActivity(intent);
                        intent=null;
                    }
                });
    }

    void create_builder_finished(){
        builderfinished = new AlertDialog.Builder(universal.this);
        builderfinished.setTitle("Η δραστηριότητα ολοκληρώθηκε!");
        builderfinished.setMessage("Συγχαρητήρια! Ολοκληρώσατε την δραστηριότητα. Θέλετε να ξαναξεκινήσετε;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = getIntent();
                        finish();
                        startActivity(intent);
                        intent=null;
                    }
                })
                .setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(universal.this, Mainmenu.class);
                        startActivity(intent);
                        intent=null;
                    }
                });
    }
}
