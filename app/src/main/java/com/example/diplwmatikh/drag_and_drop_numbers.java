package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class drag_and_drop_numbers extends universal {
    TextView txt1,txt2,txt3,prevscore;
    ImageView img1,img2,img3;
    Button check;
    ImageButton restart,back,home;
    int[] answers={0,1,2};
    int[] match_to_answer = {-1,-1,-1};
    int score=0;
    int current_object=-1;
    int x,y=0; //for placing the numbers in pictures
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop_numbers);
        runtime();

        restart=findViewById(R.id.restart);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button_from_activity);
        home=findViewById(R.id.homebutton);
        home.setOnClickListener(home_button_listener);
        prevscore=findViewById(R.id.score);
        get_score_for_navbar("drag and drop numbers", prevscore, 3);
        TextView title = findViewById(R.id.title);
        title.setText("Σείρε τους αριθμούς μέσα στις στις εικόνες");
        title.setSelected(true);

        img1=findViewById(R.id.pencil);
        img2=findViewById(R.id.balls);
        img3=findViewById(R.id.eggs);
        
        txt1=findViewById(R.id.number1);
        txt2=findViewById(R.id.number2);
        txt3=findViewById(R.id.number3);

        txt1.setOnLongClickListener(longClickListener);
        txt2.setOnLongClickListener(longClickListener);
        txt3.setOnLongClickListener(longClickListener);

        check=findViewById(R.id.check);

        img1.setOnDragListener(dragListener);
        img2.setOnDragListener(dragListener);
        img3.setOnDragListener(dragListener);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<3;i++){
                    if(answers[i]==match_to_answer[i]){
                        score++;
                    }
                    upload_score("drag and drop numbers", score,3);
                    show_rating(score, 3,drag_and_drop_numbers.class,path_with_numbers.class,false);
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(drag_and_drop_numbers.this, drag_and_drop_numbers.class);
                startActivity(intent);
                intent=null;
                finish();
            }
        });

    }
    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {        //view.getId()=id of dragging item
            int dragEvent = event.getAction();                  //v.getId()=id of target item
            final View view = (View) event.getLocalState(); //takes info of dragged item imports it into view item
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    switch (view.getId()){
                        case R.id.number1: current_object=0; break;
                        case R.id.number2: current_object=1; break;
                        case R.id.number3: current_object=2; break;
                    }
                    switch (v.getId()){
                        case R.id.pencil: match_to_answer[0]=current_object; break;
                        case R.id.balls: match_to_answer[1]=current_object; break;
                        case R.id.eggs: match_to_answer[2]=current_object; break;
                    }
                    x = (int) (v.getX()+v.getWidth()/2-view.getWidth()/2);
                    y = (int) (v.getY() +v.getHeight());
                    view.animate()
                            .x(x)
                            .y(y)
                            .setDuration(500)
                            .start();
                    break;
            }
            return true;
        }
    };
}