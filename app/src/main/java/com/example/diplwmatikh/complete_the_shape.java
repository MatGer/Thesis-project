package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class complete_the_shape extends universal {
    ImageView drag1, drag2, drag3, drag4, drag5, drag6;
    ImageView fill1, fill2, fill3, fill4, fill5, fill6;
    int current_object = -1;
    int[] answer = {5,3,2,0,1,4};
    int[] match_to_answer = {-1, -1, -1, -1, -1, -1};
    Button check;
    TextView text;
    int score = 0;
    FirebaseAuth fAuth;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_the_shape);
        runtime();

        text = findViewById(R.id.info);
        check = findViewById(R.id.complete_check);

        drag1 = findViewById(R.id.drag1_complete);
        drag2 = findViewById(R.id.drag2_complete);
        drag3 = findViewById(R.id.drag3_complete);
        drag4 = findViewById(R.id.drag1_complete2);
        drag5 = findViewById(R.id.drag2_complete2);
        drag6 = findViewById(R.id.drag3_complete2);

        fill1 = findViewById(R.id.second_complete);
        fill2 = findViewById(R.id.fourth_complete);
        fill3 = findViewById(R.id.sixth_complete);
        fill4 = findViewById(R.id.second_complete2);
        fill5 = findViewById(R.id.fourth_complete2);
        fill6 = findViewById(R.id.sixth_complete2);

        drag1.setOnLongClickListener(longClickListener);
        drag2.setOnLongClickListener(longClickListener);
        drag3.setOnLongClickListener(longClickListener);
        drag4.setOnLongClickListener(longClickListener);
        drag5.setOnLongClickListener(longClickListener);
        drag6.setOnLongClickListener(longClickListener);

        fill1.setOnDragListener(dragListener);
        fill2.setOnDragListener(dragListener);
        fill3.setOnDragListener(dragListener);
        fill4.setOnDragListener(dragListener);
        fill5.setOnDragListener(dragListener);
        fill6.setOnDragListener(dragListener);

        fAuth=FirebaseAuth.getInstance();
        userID=fAuth.getCurrentUser().getUid();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<answer.length;i++){
                    if(answer[i]==match_to_answer[i]){
                        score++;
                    }
                }
                upload_score("complete the shape",userID,score);
                create_builder_finished_with_score(score);
            }
        });
    }

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {        //view.getId()=id of dragging item
            int dragEvent = event.getAction();                  //v.getId()=id of target item
            final View view = (View) event.getLocalState(); //takes info of dragged item imports it into view item
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_STARTED:
                    switch (view.getId()) {         //get dragged item id
                        case R.id.drag1_complete:
                            current_object = 0;
                            break;
                        case R.id.drag2_complete:
                            current_object = 1;
                            break;
                        case R.id.drag3_complete:
                            current_object = 2;
                            break;
                        case R.id.drag1_complete2:
                            current_object = 3;
                            break;
                        case R.id.drag2_complete2:
                            current_object = 4;
                            break;
                        case R.id.drag3_complete2:
                            current_object = 5;
                            break;
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    text.setText("target= " + v.getId() + " , source: " + view.getId() + "\n" + "target X " + v.getX() + " Y " + v.getY() + " , source: X " + view.getX() + " Y " + view.getY());
                    break;
                case DragEvent.ACTION_DROP:
                    switch (v.getId()) {         //get target id
                        case R.id.second_complete:
                            match_to_answer[0] = current_object;
                            break;
                        case R.id.fourth_complete:
                            match_to_answer[1] = current_object;
                            break;
                        case R.id.sixth_complete:
                            match_to_answer[2] = current_object;
                            break;
                        case R.id.second_complete2:
                            match_to_answer[3] = current_object;
                            break;
                        case R.id.fourth_complete2:
                            match_to_answer[4] = current_object;
                            break;
                        case R.id.sixth_complete2:
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