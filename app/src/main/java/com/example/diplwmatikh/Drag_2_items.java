package com.example.diplwmatikh;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class drag_2_items extends universal {
    Button check;
    View target;
    ImageView drag1,drag2,drag3,drag4,drag5,drag6;
    ImageView restart,back,home;
    TextView prevscore;
    int counter,score=0;
    int itemX,itemY=0; //thesi pou tha boun ta items
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_2_items);
        runtime();

        check=findViewById(R.id.check);
        restart=findViewById(R.id.restart);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button_from_activity);
        home=findViewById(R.id.homebutton);
        home.setOnClickListener(home_button_listener);
        prevscore=findViewById(R.id.score);
        get_score_for_navbar("drag 2 items", prevscore, 2);

        TextView title = findViewById(R.id.title);
        title.setText("Σύρε δύο εικόνες στο μαύρο πλαίσιο.");
        title.setSelected(true);

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
                upload_score("drag 2 items", score,2);
                show_rating(score,2, drag_2_items.class,null,true);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(drag_2_items.this, drag_2_items.class);
                startActivity(intent);
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
                            score=1;
                            break;
                        case 1:
                            itemX=itemX+v.getWidth()/3;
                            counter++;
                            score=2;
                            break;
                        case 2:
                            itemX=itemX+v.getWidth()/3;
                            counter++;
                            score=1;
                            break;
                        case 3:
                            itemX=(int) v.getX() +30;
                            itemY = (int) v.getY() + 3*v.getHeight()/5;
                            counter++;
                            score=0;
                            break;
                        case 4:
                        case 5:
                            itemX=itemX+v.getWidth()/3;
                            counter++;
                            score=0;
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