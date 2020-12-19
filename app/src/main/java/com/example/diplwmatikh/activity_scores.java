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
    TextView ac1,ac2,ac3,ac4,ac5,ac6,ac7,ac8,ac9,ac10,ac11,ac12,ac13,ac14,ac15,ac16,ac17,ac18;
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
        get_score("choose those who match", 8,"Σημασιολογία",findViewById(R.id.ac1));
        get_score("choose description",4 ,"Κατηγοριοποίηση/ταξινόμηση",findViewById(R.id.ac2));
        get_score("choose arrows",12 ,"Χωρικός Προσανατολισμός",findViewById(R.id.ac3));
        get_score("choose", 2,"Προσληπτικό λεξιλόγιο",findViewById(R.id.ac4));
        get_score("drag items with audio", 4,"Οδηγίες",findViewById(R.id.ac5));
        get_score("which one is different", 3,"Κατηγοριοποίηση",findViewById(R.id.ac6));

        get_score("find the path", 10,"Σχήματα",findViewById(R.id.ac7));
        get_score("select the bigger",4 ,"Σύγκριση",findViewById(R.id.ac8));
        get_score("complete the pattern", 6,"Ακολουθίες",findViewById(R.id.ac9));
        get_score("complete the shape", 6,"Καθρεπτισμός",findViewById(R.id.ac10));

        get_score("write height", 5,"Μετρήσεις",findViewById(R.id.ac11));
        get_score("add animals",4 ,"Αριθμητικές πράξεις",findViewById(R.id.ac12));
        get_score("next number",3 ,"Αριθμητικές ακολουθίες 2",findViewById(R.id.ac13));
        get_score("drag and drop numbers", 3,"Ποσότητες",findViewById(R.id.ac14));
        get_score("path with numbers", 11,"Αριθμητικές ακολουθίες",findViewById(R.id.ac15));
        get_score("drag 2 items", 2,"Ποσότητες 2",findViewById(R.id.ac16));
        get_score("choose the bigger number", 4,"Συγκρίσεις",findViewById(R.id.ac17));
        get_score("how many", 3,"Ποσότητες 3",findViewById(R.id.ac18));

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
        ac13=findViewById(R.id.ac13);
        ac14=findViewById(R.id.ac14);
        ac15=findViewById(R.id.ac15);
        ac16=findViewById(R.id.ac16);
        ac17=findViewById(R.id.ac17);
        ac18=findViewById(R.id.ac18);

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
        ac13.setOnClickListener(cl);
        ac14.setOnClickListener(cl);
        ac15.setOnClickListener(cl);
        ac16.setOnClickListener(cl);
        ac17.setOnClickListener(cl);
        ac18.setOnClickListener(cl);
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
                case R.id.ac3: intent = new Intent(activity_scores.this, choose_arrows.class);
                    ac="Επίλεξε τα βελάκια";
                    break;
                case R.id.ac4: intent = new Intent(activity_scores.this, choose.class);
                    ac="Επίλεξε την εικόνα";
                    break;
                case R.id.ac5: intent = new Intent(activity_scores.this, drag_items_with_audio.class);
                    ac="Σείρε τις εικόνες";
                    break;
                case R.id.ac6: intent = new Intent(activity_scores.this, which_one_is_different.class);
                    ac="Βρες το διαφορετικό";
                    break;
                case R.id.ac7: intent = new Intent(activity_scores.this, find_the_path.class);
                    ac="Βρες το μονοπάτι";
                    break;
                case R.id.ac8: intent = new Intent(activity_scores.this, select_the_bigger.class);
                    ac="Επίλεξε το μεγαλύτερο";
                    break;
                case R.id.ac9: intent = new Intent(activity_scores.this, complete_the_pattern.class);
                    ac="Ολοκλήρωσε το μοτίβο";
                    break;
                case R.id.ac10: intent = new Intent(activity_scores.this, complete_the_shape.class);
                    ac="Ολοκλήρωσε το σχήμα";
                    break;
                case R.id.ac11: intent = new Intent(activity_scores.this, write_height.class);
                    ac="Γράψε το ύψος";
                    break;
                case R.id.ac12: intent = new Intent(activity_scores.this, add_animals.class);
                    ac="Πρόσθεσε τα ζωάκια";
                    break;
                case R.id.ac13: intent = new Intent(activity_scores.this, next_number.class);
                    ac="Βρες τον επόμενο αριθμό";
                    break;
                case R.id.ac14: intent = new Intent(activity_scores.this, drag_and_drop_numbers.class);
                    ac="Σείρε τους αριθμούς";
                    break;
                case R.id.ac15: intent = new Intent(activity_scores.this, path_with_numbers.class);
                    ac="Βρες το μονοπάτι με τους αριθμούς";
                    break;
                case R.id.ac16: intent = new Intent(activity_scores.this, drag_2_items.class);
                    ac="Σείρε δύο εικόνες";
                    break;
                case R.id.ac17: intent = new Intent(activity_scores.this, choose_the_bigger_number.class);
                    ac="Επίλεξε τον μεγαλύτερο αριθμό";
                    break;
                case R.id.ac18: intent = new Intent(activity_scores.this, how_many.class);
                    ac="Πόσα ζωάκια υπάρχουν";
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