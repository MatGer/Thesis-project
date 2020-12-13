package com.example.diplwmatikh;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class complete_the_pattern extends universal {
    ImageView fill1_1,fill1_2,fill2_1,fill2_2,fill3_1,fill3_2;
    ImageView drag1,drag2,drag3,drag4,drag5,drag6;
    Button check;
    TextView text,prevscore;
    ImageButton restart,back;
    int[] answer = {1,4,3,0,5,2};
    int[] match_to_answer = {-1,-1,-1,-1,-1,-1};
    int current_object=-1;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compete_the_pattern);
        runtime();

        prevscore=findViewById(R.id.score);
        restart=findViewById(R.id.restart);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button_from_activity);

        TextView title = findViewById(R.id.title);
        title.setText("Σείρε τα σχήματα από την τελευταία σειρά, στα πράσινα κουτάκια για να ολοκληρώσεις τα μοτίβα.");
        title.setSelected(true);

        get_score_for_navbar("complete the pattern", prevscore, 6);

        fill1_1=findViewById(R.id.fill1_7);
        fill1_2=findViewById(R.id.fill1_8);
        fill2_1=findViewById(R.id.fill2_7);
        fill2_2=findViewById(R.id.fill2_8);
        fill3_1=findViewById(R.id.fill3_7);
        fill3_2=findViewById(R.id.fill3_8);

        drag1=findViewById(R.id.row4_1);
        drag2=findViewById(R.id.row4_2);
        drag3=findViewById(R.id.row4_3);
        drag4=findViewById(R.id.row4_4);
        drag5=findViewById(R.id.row4_5);
        drag6=findViewById(R.id.row4_6);

        check=findViewById(R.id.check);

        drag1.setOnLongClickListener(longClickListener);
        drag2.setOnLongClickListener(longClickListener);
        drag3.setOnLongClickListener(longClickListener);
        drag4.setOnLongClickListener(longClickListener);
        drag5.setOnLongClickListener(longClickListener);
        drag6.setOnLongClickListener(longClickListener);

        fill1_1.setOnDragListener(dragListener);
        fill1_2.setOnDragListener(dragListener);
        fill2_1.setOnDragListener(dragListener);
        fill2_2.setOnDragListener(dragListener);
        fill3_1.setOnDragListener(dragListener);
        fill3_2.setOnDragListener(dragListener);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<answer.length;i++){
                    if(answer[i]==match_to_answer[i]){
                        score++;
                    }
                }
                upload_score("complete the pattern",score);
                show_rating(score,6,complete_the_pattern.class,complete_the_shape.class,false);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(complete_the_pattern.this, complete_the_pattern.class);
                startActivity(intent);
                intent=null;
            }
        });
    }

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {        //view.getId()=id of dragging item
            int dragEvent = event.getAction();                  //v.getId()=id of target item
            final View view = (View) event.getLocalState(); //takes info of dragged item imports it into view item
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_STARTED:
                    switch (view.getId()){         //get dragged item id
                        case R.id.row4_1:
                            current_object=0;
                            break;
                        case R.id.row4_2:
                            current_object=1;
                            break;
                        case R.id.row4_3:
                            current_object=2;
                            break;
                        case R.id.row4_4:
                            current_object=3;
                            break;
                        case R.id.row4_5:
                            current_object=4;
                            break;
                        case R.id.row4_6:
                            current_object=5;
                            break;
                    }
                    break;
                case DragEvent.ACTION_DROP:
                        switch (v.getId()) {         //get target id
                            case R.id.fill1_7:
                                match_to_answer[0] = current_object;
                                break;
                            case R.id.fill1_8:
                                match_to_answer[1] = current_object;
                                break;
                            case R.id.fill2_7:
                                match_to_answer[2] = current_object;
                                break;
                            case R.id.fill2_8:
                                match_to_answer[3] = current_object;
                                break;
                            case R.id.fill3_7:
                                match_to_answer[4] = current_object;
                                break;
                            case R.id.fill3_8:
                                match_to_answer[5] = current_object;
                                break;
                        }
                    view.animate()
                            .x(v.getX())
                            .y(v.getY())
                            .setDuration(500)
                            .start();
                    break;
            }
            return true;
        }
    };
}
