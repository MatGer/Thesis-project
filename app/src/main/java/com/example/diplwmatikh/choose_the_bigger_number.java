package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class choose_the_bigger_number extends universal {
    TextView n1,n2,n3,n4,n5,n6,n7,n8;
    Button check;
    ImageButton back;
    TextView prevscore;
    int[] answers={0,0,0,0}; //0=start value, 1=left tile correct, 2=right tile correct
    int[] correct_answers={2,1,2,1};
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_the_bigger_number);
        runtime();

        prevscore=findViewById(R.id.score);
        check=findViewById(R.id.check);
        TextView title = findViewById(R.id.title);
        title.setText("Επίλεξε τον μεγαλύτερο αριθμό.");
        title.setSelected(true);
        get_score_for_navbar("choose the bigger number", prevscore, 4);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button_from_activity);

        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
        n4=findViewById(R.id.n4);
        n5=findViewById(R.id.n5);
        n6=findViewById(R.id.n6);
        n7=findViewById(R.id.n7);
        n8=findViewById(R.id.n8);

        n1.setOnClickListener(select);
        n2.setOnClickListener(select);
        n3.setOnClickListener(select);
        n4.setOnClickListener(select);
        n5.setOnClickListener(select);
        n6.setOnClickListener(select);
        n7.setOnClickListener(select);
        n8.setOnClickListener(select);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<4;i++){
                    if(correct_answers[i]==answers[i]){
                        score++;
                    }
                }
                upload_score("choose the bigger number", score,4);
                show_rating(score,4,choose_the_bigger_number.class,null,true);
            }
        });
    }

    View.OnClickListener select = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.n1:
                    n1.setBackground(getDrawable(R.drawable.start_menu_button));
                    n2.setBackground(getDrawable(R.drawable.unselected_menu_button));
                    answers[0]=1;
                    break;
                case R.id.n2:
                    n2.setBackground(getDrawable(R.drawable.start_menu_button));
                    n1.setBackground(getDrawable(R.drawable.unselected_menu_button));
                    answers[0]=2;
                    break;
                case R.id.n3:
                    n3.setBackground(getDrawable(R.drawable.start_menu_button));
                    n4.setBackground(getDrawable(R.drawable.unselected_menu_button));
                    answers[1]=1;
                    break;
                case R.id.n4:
                    n4.setBackground(getDrawable(R.drawable.start_menu_button));
                    n3.setBackground(getDrawable(R.drawable.unselected_menu_button));
                    answers[1]=2;
                    break;
                case R.id.n5:
                    n5.setBackground(getDrawable(R.drawable.start_menu_button));
                    n6.setBackground(getDrawable(R.drawable.unselected_menu_button));
                    answers[2]=1;
                    break;
                case R.id.n6:
                    n6.setBackground(getDrawable(R.drawable.start_menu_button));
                    n5.setBackground(getDrawable(R.drawable.unselected_menu_button));
                    answers[2]=2;
                    break;
                case R.id.n7:
                    n7.setBackground(getDrawable(R.drawable.start_menu_button));
                    n8.setBackground(getDrawable(R.drawable.unselected_menu_button));
                    answers[3]=1;
                    break;
                case R.id.n8:
                    n8.setBackground(getDrawable(R.drawable.start_menu_button));
                    n7.setBackground(getDrawable(R.drawable.unselected_menu_button));
                    answers[3]=2;
                    break;
            }
        }
    };
}