package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class activity_scores extends universal {
    ImageButton back;
    Button gotomenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        runtime();

        back=findViewById(R.id.backbutton);
        gotomenu=findViewById(R.id.gotomenu);
        /*----------------------------------------names from first row == names from 2nd row--------------------------------------------
        String[][] activity_names={{"choose those who match","choose description","find the path","choose arrows","drag and drop numbers","path with numbers",
                "select the bigger","write height","add animals","next number","complete the pattern","complete the shape"},
                {"επίλεξε αυτά που ταιριάζουν","επίλεξε περιγραφή","βρες το μονοπάτι","επίλεξε τα βελάκια","σείρε τους αριθμούς","βρες το μονοπάτι με τους αριθμούς",
                        "επίλεξε το μεγαλύτερο","γράψε το ύψος","πρόσθεσε τα ζωάκια","βρες τον επόμενο αριθμό","ολοκλήρωσε το μοτίβο","ολοκλήρωσε το σχήμα"}
        };
        //------------------------------------------------------------------------------------------------------------------------
         */
        get_score("choose those who match", "Eπίλεξε αυτά που ταιριάζουν",findViewById(R.id.ac1));
        get_score("choose description", "Επίλεξε περιγραφή",findViewById(R.id.ac2));
        get_score("find the path", "Βρες το μονοπάτι",findViewById(R.id.ac3));
        get_score("choose arrows", "Επίλεξε τα βελάκια",findViewById(R.id.ac4));
        get_score("drag and drop numbers", "Σείρε τους αριθμούς",findViewById(R.id.ac5));
        get_score("path with numbers", "Βρες το μονοπάτι με τους αριθμούς",findViewById(R.id.ac6));
        get_score("select the bigger", "Επίλεξε το μεγαλύτερο",findViewById(R.id.ac7));
        get_score("write height", "Γράψε το ύψος",findViewById(R.id.ac8));
        get_score("add animals", "Πρόσθεσε τα ζωάκια",findViewById(R.id.ac9));
        get_score("next number", "Βρες τον επόμενο αριθμό",findViewById(R.id.ac10));
        get_score("complete the pattern", "Ολοκλήρωσε το μοτίβο",findViewById(R.id.ac11));
        get_score("complete the shape", "Ολοκλήρωσε το σχήμα",findViewById(R.id.ac12));

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

        back.setOnClickListener(back_button);

        gotomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_scores.this, Mainmenu.class));
                finish();
            }
        });
    }
}