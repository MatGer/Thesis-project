package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.CoreComponentFactory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Correct_wrong extends universal{
    AlertDialog.Builder builderfinished;
    String title = "Σωστό - Λάθος";
    TextView header,question;
    ImageButton restart,back;
    Button correct, wrong, next;
    int counter,getquestions,score=0;
    int selected_question=0;
    String[] questions={"Ερώτηση 1","Ερώτηση 2","Ερώτηση 3","Ερώτηση 4","Ερώτηση 5","Ερώτηση 6","Ερώτηση 7","Ερώτηση 8","Ερώτηση 9","Ερώτηση 10"};
    boolean[] answers={true,false,true,false,true,false,true,false,true,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runtime();
        setContentView(R.layout.activity_correct_wrong);
        next=findViewById(R.id.nextquestionbutton);
        correct=findViewById(R.id.correntbutton);
        wrong=findViewById(R.id.wrongbutton);
        question=findViewById(R.id.question);
//----------------------for random and unique questions-------------
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        selected_question=list.get(getquestions);
        question.setText(questions[selected_question]);
        getquestions++;

        //---------------Toolbar functionality------------------//
        back=findViewById(R.id.backbutton);
        restart=findViewById(R.id.restartbutton);
        header = findViewById(R.id.title);
        header.setText(title);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = builderback.create();
                alert.show();
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = builderreset.create();
                alert.show();
            }
        });

        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_answer(true);
            }
        });

        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_answer(false);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                selected_question=list.get(getquestions);
                question.setText(questions[selected_question]);
                getquestions++;
                next.setVisibility(View.INVISIBLE);
                correct.setEnabled(true);
                wrong.setEnabled(true);
                if(counter==4){
                    create_builder_finished(score);
                    AlertDialog alert = builderfinished.create();
                    alert.show();
                }
                counter++;
            }
        });
    }
    void check_answer(boolean answer){
        next.setVisibility(View.VISIBLE);
        correct.setEnabled(false);
        wrong.setEnabled(false);
        if(answer==answers[selected_question]){
            Toast.makeText(getApplicationContext(), "Απαντήσατε Σωστά!!! :D", Toast.LENGTH_SHORT).show();
            score++;
        }else{
            Toast.makeText(getApplicationContext(), "Απαντήσατε Λάθος!!! :(", Toast.LENGTH_SHORT).show();
            score--;
        }
    }

    void create_builder_finished(int a){
        builderfinished = new AlertDialog.Builder(Correct_wrong.this);
        builderfinished.setTitle("Η δραστηριότητα ολοκληρώθηκε!");
        builderfinished.setMessage("Το σκορ ειναι : "+a+" .Θέλετε να ξανακάνετε την δραστηριότητα;")
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
                        intent = new Intent(Correct_wrong.this, Mainmenu.class);
                        startActivity(intent);
                        intent=null;
                    }
                });
    }
}