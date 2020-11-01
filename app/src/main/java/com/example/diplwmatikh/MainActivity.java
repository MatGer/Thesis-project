package com.example.diplwmatikh;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends universal{
    ImageView img1, img2, selected;
    TextView txt,header;
    View target, target2;
    ImageButton restart,back;
    int x_cord, y_cord;
    int identification; // to recognize the target for each item
    int counter = 0; // counter = counter to align the dropped items on target
    String title = "Αντιστοίχηση";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runtime();
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        img1 = (ImageView) findViewById(R.id.dragme);
        img2 = (ImageView) findViewById(R.id.dragme2);
        target = (View) findViewById(R.id.drophere);
        target2 = (View) findViewById(R.id.drophere2);


        img1.setOnLongClickListener(longClickListener);
        img2.setOnLongClickListener(longClickListener);

        target.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        //---------------Toolbar functionality------------------//
        back=findViewById(R.id.backbutton);
        restart=findViewById(R.id.restartbutton);
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
                switch(dragEvent){
                    case DragEvent.ACTION_DRAG_ENTERED:

                       if(view.getId()==R.id.dragme){
                           txt.setText("object 1 dragged");
                       }else{
                           txt.setText("object 2 dragged");
                       }
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        if(view.getId()==R.id.dragme){
                            txt.setText("object 1 exitted");
                        }else if(view.getId()==R.id.dragme2){
                            txt.setText("object 2 exitted");
                        }
                        break;
                    case DragEvent.ACTION_DROP:
                        //detect which item is dragged

                        if(view.getId()==R.id.dragme){
                            txt.setText("object 1 dropped");
                            selected=img1;
                        }else if(view.getId()==R.id.dragme2){
                            txt.setText("object 2 dropped");
                            selected=img2;
                        }
                        identification=v.getId();
                        if (identification == R.id.drophere && view.getId()==R.id.dragme2){
                            txt.setText("cant dropped here");
                        }
                        else {
                            //center the item on target
                            x_cord = (int) target.getX();
                            y_cord = (int) target.getY();
                            x_cord = x_cord + target.getWidth() / 2 - selected.getWidth() / 2;
                            y_cord = y_cord + target.getHeight() / 2 - selected.getHeight() / 2;

                            View view2 = (View) event.getLocalState();
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view2);
                            LinearLayout container = (LinearLayout) v;
                            container.addView(view2);
                            view.setVisibility(View.VISIBLE);

                            selected.setX(x_cord);
                            selected.setY(y_cord);

                            ObjectAnimator animationX = ObjectAnimator.ofFloat(view2, "translationX", (target.getWidth() / 2 - selected.getWidth() / 2));
                            animationX.setDuration(1);
                            animationX.start();
                            ObjectAnimator animationY = ObjectAnimator.ofFloat(view2, "translationY", (target.getY()));
                        /*switch(counter){
                            case 0:
                                animationY = ObjectAnimator.ofFloat(view2, "translationY", (target.getY()));
                                counter++;
                                break;
                            case 1:
                                animationY = ObjectAnimator.ofFloat(view2, "translationY", (target.getY() + selected.getHeight()));
                                counter++;
                                break;
                            default:
                                break;
                        }*/
                            animationY.setDuration(500);
                            animationY.start();
                            selected.setOnLongClickListener(null);
                        }
                        break;
                }
                return true;
            }
        };
}