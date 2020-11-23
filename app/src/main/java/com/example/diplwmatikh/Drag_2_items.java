package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Drag_2_items extends universal {
    Button check;
    View target;
    ImageView drag1,drag2,drag3,drag4,drag5,drag6;
    int counter,score=0;
    int itemX,itemY=0; //thesi pou tha boun ta items
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_2_items);
        runtime();

        check=findViewById(R.id.check);
        target=findViewById(R.id.target);
        drag1=findViewById(R.id.drag1);
        drag2=findViewById(R.id.drag2);
        drag3=findViewById(R.id.drag3);
        drag4=findViewById(R.id.drag4);
        drag5=findViewById(R.id.drag5);
        drag6=findViewById(R.id.drag6);

        drag1.setOnLongClickListener(longClickListener);
        drag2.setOnLongClickListener(longClickListener);
        drag3.setOnLongClickListener(longClickListener);
        drag4.setOnLongClickListener(longClickListener);
        drag5.setOnLongClickListener(longClickListener);
        drag6.setOnLongClickListener(longClickListener);

        target.setOnDragListener(dragListener);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload_score("drag 2 items", score);
                create_builder_finished_with_score(score);
            }
        });
    }

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {        //view.getId()=id of dragging item
            int dragEvent = event.getAction();                  //v.getId()=id of target item
            final View view = (View) event.getLocalState(); //takes info of dragged item imports it into view item
                if(dragEvent==DragEvent.ACTION_DROP){
                    switch(counter){
                        case 0:
                            itemX=(int) v.getX() +30;
                            itemY=(int) v.getY() + v.getHeight()/5;
                            counter++;
                            break;
                        case 1:
                            itemX=itemX+v.getWidth()/3;
                            counter++;
                            score=1;
                        break;
                        case 2:
                            itemX=itemX+v.getWidth()/3;
                            counter++;
                            score=2;
                            break;
                        case 3:
                            itemX=(int) v.getX() +10;
                            itemY = (int) v.getY() + 3*v.getHeight()/5;
                            counter++;
                            score=1;
                            break;
                        case 4:
                            itemX=itemX+v.getWidth()/3;
                            counter++;
                            score=1;
                            break;
                        case 5:
                            itemX=itemX+v.getWidth()/3;
                            counter++;
                            score=1;
                            break;
                    }
                    view.animate()
                            .x(itemX)
                            .y(itemY)
                            .setDuration(500)
                            .start();
                }

            return true;
        }
    };
}