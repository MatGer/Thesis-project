package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class activity_scores extends universal {
    ImageButton back;
    TextView ac1,ac2,ac3,ac4,ac5,ac6,ac7,ac8,ac9,ac10,ac11,ac12;
    AlertDialog.Builder goto_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        runtime();

        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);

        /*----------------------------------------names from first row == names from 2nd row--------------------------------------------
        String[][] activity_names={{"choose those who match","choose description","find the path","choose arrows","drag and drop numbers","path with numbers",
                "select the bigger","write height","add animals","next number","complete the pattern","complete the shape"},
                {"επίλεξε αυτά που ταιριάζουν","επίλεξε περιγραφή","βρες το μονοπάτι","επίλεξε τα βελάκια","σείρε τους αριθμούς","βρες το μονοπάτι με τους αριθμούς",
                        "επίλεξε το μεγαλύτερο","γράψε το ύψος","πρόσθεσε τα ζωάκια","βρες τον επόμενο αριθμό","ολοκλήρωσε το μοτίβο","ολοκλήρωσε το σχήμα"}
        };
        //------------------------------------------------------------------------------------------------------------------------
         */
        get_score("choose those who match", 8,"Eπίλεξε αυτά που ταιριάζουν",findViewById(R.id.ac1));
        get_score("choose description",4 ,"Επίλεξε περιγραφή",findViewById(R.id.ac2));
        get_score("find the path", 10,"Βρες το μονοπάτι",findViewById(R.id.ac3));
        get_score("choose arrows",12 ,"Επίλεξε τα βελάκια",findViewById(R.id.ac4));
        get_score("drag and drop numbers", 3,"Σείρε τους αριθμούς",findViewById(R.id.ac5));
        get_score("path with numbers", 11,"Βρες το μονοπάτι με τους αριθμούς",findViewById(R.id.ac6));
        get_score("select the bigger",4 ,"Επίλεξε το μεγαλύτερο",findViewById(R.id.ac7));
        get_score("write height", 5,"Γράψε το ύψος",findViewById(R.id.ac8));
        get_score("add animals",4 ,"Πρόσθεσε τα ζωάκια",findViewById(R.id.ac9));
        get_score("next number",3 ,"Βρες τον επόμενο αριθμό",findViewById(R.id.ac10));
        get_score("complete the pattern", 6,"Ολοκλήρωσε το μοτίβο",findViewById(R.id.ac11));
        get_score("complete the shape", 6,"Ολοκλήρωσε το σχήμα",findViewById(R.id.ac12));

        /*

        //implement names and add all activities

        get_score("add animals", userID,findViewById(R.id.ac5));
        get_score("choose arrows", userID,findViewById(R.id.ac6));
        get_score("complete the pattern", userID,findViewById(R.id.ac7));
        get_score("path_of_numbers2", userID,findViewById(R.id.ac8));
        get_score("add animals", userID,findViewById(R.id.ac9));
        get_score("choose arrows", userID,findViewById(R.id.ac10));
        get_score("complete the pattern", userID,findViewById(R.id.ac11));
        get_score("path_of_numbers2", userID,findViewById(R.id.ac12));

         */
        ac1=findViewById(R.id.ac1);
        ac2=findViewById(R.id.ac2);
        ac3=findViewById(R.id.ac3);
        ac4=findViewById(R.id.ac4);
        ac5=findViewById(R.id.ac5);
        ac6=findViewById(R.id.ac6);
        ac7=findViewById(R.id.ac7);
        ac8=findViewById(R.id.ac8);
        ac9=findViewById(R.id.ac9);
        ac10=findViewById(R.id.ac10);
        ac11=findViewById(R.id.ac11);
        ac12=findViewById(R.id.ac12);

        ac1.setOnClickListener(cl);
        ac2.setOnClickListener(cl);
        ac3.setOnClickListener(cl);
        ac4.setOnClickListener(cl);
        ac5.setOnClickListener(cl);
        ac6.setOnClickListener(cl);
        ac7.setOnClickListener(cl);
        ac8.setOnClickListener(cl);
        ac9.setOnClickListener(cl);
        ac10.setOnClickListener(cl);
        ac11.setOnClickListener(cl);
        ac12.setOnClickListener(cl);
    }

    View.OnClickListener cl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String ac="";
            switch (v.getId()){
                case R.id.ac1: intent = new Intent(activity_scores.this, choose_those_who_match.class);
                    ac="Eπίλεξε αυτά που ταιριάζουν";
                    break;
                case R.id.ac2: intent = new Intent(activity_scores.this, choose_description.class);
                    ac="Επίλεξε περιγραφή";
                    break;
                case R.id.ac3: intent = new Intent(activity_scores.this, find_the_path.class);
                    ac="Βρες το μονοπάτι";
                    break;
                case R.id.ac4: intent = new Intent(activity_scores.this, choose_arrows.class);
                    ac="Επίλεξε τα βελάκια";
                    break;
                case R.id.ac5: intent = new Intent(activity_scores.this, drag_and_drop_numbers.class);
                    ac="Σείρε τους αριθμούς";
                    break;
                case R.id.ac6: intent = new Intent(activity_scores.this, path_with_numbers.class);
                    ac="Βρες το μονοπάτι με τους αριθμούς";
                    break;
                case R.id.ac7: intent = new Intent(activity_scores.this, select_the_bigger.class);
                    ac="Επίλεξε το μεγαλύτερο";
                    break;
                case R.id.ac8: intent = new Intent(activity_scores.this, write_height.class);
                    ac="Γράψε το ύψος";
                    break;
                case R.id.ac9: intent = new Intent(activity_scores.this, add_animals.class);
                    ac="Πρόσθεσε τα ζωάκια";
                    break;
                case R.id.ac10: intent = new Intent(activity_scores.this, next_number.class);
                    ac="Βρες τον επόμενο αριθμό";
                    break;
                case R.id.ac11: intent = new Intent(activity_scores.this, complete_the_pattern.class);
                    ac="Ολοκλήρωσε το μοτίβο";
                    break;
                case R.id.ac12: intent = new Intent(activity_scores.this, complete_the_shape.class);
                    ac="Ολοκλήρωσε το σχήμα";
                    break;

            }
            goto_activity = new AlertDialog.Builder(activity_scores.this);
            goto_activity.setTitle("Μετάβαση!");
            goto_activity.setMessage("Θέλεις να μεταβείς στην δραστηριότητα: "+ ac +";");
            goto_activity.setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(intent);
                    finish();
                }
            })
                    .setNegativeButton("Οχι", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            onResume();
                        }
                    }).create().show();
        }
    };
}