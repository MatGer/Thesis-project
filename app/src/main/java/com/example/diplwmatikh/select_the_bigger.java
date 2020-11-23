package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class select_the_bigger extends universal {
    ImageButton first,second;
    Button next;
    int counter=0;
    int score=0;
    int selected=0;      //if 0, no selection made. if 1 first image selected. if 2 second image selected
    //activity name = select_the_bigger
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_the_bigger);
        runtime();

        TextView title = findViewById(R.id.title);
        title.setText("Επέλεξε την μεγαλύτερη εικόνα");
        title.setSelected(true);

        findViewById(R.id.check).setVisibility(View.INVISIBLE);

        first=findViewById(R.id.first_image);
        second=findViewById(R.id.second_image);
        next=findViewById(R.id.next_button);
        first.setImageDrawable(getDrawable(R.drawable.tomato));
        second.setImageDrawable(getDrawable(R.drawable.pizza));

        Button check = findViewById(R.id.check);
        check.setVisibility(View.INVISIBLE);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first.setBackground(getDrawable(R.color.teal_200));
                second.setBackground(getDrawable(R.color.white));
                selected=1;
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second.setBackground(getDrawable(R.color.teal_200));
                first.setBackground(getDrawable(R.color.white));
                selected=2;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected==0){
                    Toast.makeText(select_the_bigger.this, "Δεν επιλέχθηκε κάποια εικόνα",Toast.LENGTH_SHORT).show();
                }
                else if(selected==1){
                    if(counter==1 || counter==3){
                        score++;
                    }
                }else if (selected==2){
                    if(counter==0 || counter==2){
                        score++;
                    }
                }
                counter++;
                selected=0;
                second.setBackground(getDrawable(R.color.white));
                first.setBackground(getDrawable(R.color.white));
                switch(counter){
                    case 1:
                        first.setImageDrawable(getDrawable(R.drawable.basketball));
                        second.setImageDrawable(getDrawable(R.drawable.baseball));
                        break;

                    case 2:
                        first.setImageDrawable(getDrawable(R.drawable.plant));
                        second.setImageDrawable(getDrawable(R.drawable.tree));
                        break;

                    case 3:
                        first.setImageDrawable(getDrawable(R.drawable.elephant));
                        second.setImageDrawable(getDrawable(R.drawable.cat));
                        break;

                    case 4:
                        upload_score("select_the_bigger",score);
                        create_builder_finished_with_score(score);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + counter);
                }
            }
        });
    }
}