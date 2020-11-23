package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class place_in_order extends universal {
    TextView header;
    ImageButton restart,back;
    String title="Δημιούργησε μία ιστορία...";
    View target1,target2,target3,target4;
    ImageView drag1,drag2,drag3,drag4;
    Button check;
    String score;
    int activity_finished=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runtime();
        setContentView(R.layout.activity_place_in_order);

        target1=findViewById(R.id.targ1);
        target2=findViewById(R.id.targ2);
        target3=findViewById(R.id.targ3);
        target4=findViewById(R.id.targ4);

        drag1=findViewById(R.id.drag1);
        drag2=findViewById(R.id.drag2);
        drag3=findViewById(R.id.drag3);
        drag4=findViewById(R.id.drag4);

        check=findViewById(R.id.check);
        userID=FirebaseAuth.getInstance().getUid();
        //---------------Toolbar functionality------------------//
        back=findViewById(R.id.backbutton);
        header = findViewById(R.id.title);
        header.setText(title);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alert = builderback.create();
                alert.show();

            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = builderreset.create();
                alert.show();
            }
        });

        drag1.setOnLongClickListener(longClickListener);
        drag2.setOnLongClickListener(longClickListener);
        drag3.setOnLongClickListener(longClickListener);
        drag4.setOnLongClickListener(longClickListener);

        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload_score("place in order",1);
            }
        });
    }
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBBuilder = new View.DragShadowBuilder(v);// Instantiates the drag shadow builder.
            v.startDragAndDrop(data, myShadowBBuilder, v, 0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState(); //takes info of dragged item imports it into view item
            if(dragEvent==DragEvent.ACTION_DROP){
                    if(view.getId()==R.id.drag1 && v.getId()==R.id.targ1){
                        animate_movement(drag1, target1, view);
                    }else if(view.getId()==R.id.drag2 && v.getId()==R.id.targ2){
                        animate_movement(drag2, target2, view);
                    }else if(view.getId()==R.id.drag3 && v.getId()==R.id.targ3){
                        animate_movement(drag3, target3, view);
                    }else if(view.getId()==R.id.drag4 && v.getId()==R.id.targ4){
                        animate_movement(drag4, target4, view);
                    }else{
                        Toast.makeText(getApplicationContext(), "Αυτό το κομμάτι δεν ταιριάζει εδω. Προσπάθησε ξανα...", Toast.LENGTH_SHORT).show();
                    }
            }
            if(activity_finished==4){
                create_builder_finished();
                AlertDialog alert = builderfinished.create();
                alert.show();
                activity_finished=0;
            }
            return true;
        }
    };

    void animate_movement(View Source, View destination, View v1){
        v1.animate()
                .x(destination.getX())
                .y(destination.getY())
                .setDuration(500)
                .start();
        activity_finished++;
        Source.setOnLongClickListener(null);
    }
}