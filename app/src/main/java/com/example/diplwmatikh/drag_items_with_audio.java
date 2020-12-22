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

public class drag_items_with_audio extends universal{
    ImageView circle,rectangle,square,triangle;
    ImageView ice_cream,cake,cookie,candy;
    ImageView play1,play2,play3,play4;
    int x,y,score;
    Button check;
    ImageButton back,restart,home;
    TextView prevscore;
    int current_object=-1;
    int [] answer = {2,3,0,1};
    int[] match_to_answer={-1,-1,-1,-1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_items_with_audio);

        runtime();

        restart=findViewById(R.id.restart);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button_from_activity);
        home=findViewById(R.id.homebutton);
        home.setOnClickListener(home_button_listener);
        prevscore=findViewById(R.id.score);
        get_score_for_navbar("drag items with audio", prevscore, 4);

        TextView title = findViewById(R.id.title);
        title.setText("Σύρε τις εικόνες μέσα στα σχήματα με βάση τις οδηγίες. Πάτησε στο ηχειάκι για να ακούσεις την εκφώνηση");
        title.setSelected(true);

        circle=findViewById(R.id.target1);
        rectangle=findViewById(R.id.target2);
        triangle=findViewById(R.id.target3);
        square=findViewById(R.id.target4);

        ice_cream=findViewById(R.id.drag1);
        cookie=findViewById(R.id.drag2);
        candy=findViewById(R.id.drag3);
        cake=findViewById(R.id.drag4);

        play1=findViewById(R.id.play1);
        play2=findViewById(R.id.play2);
        play3=findViewById(R.id.play3);
        play4=findViewById(R.id.play4);

        ice_cream.setOnLongClickListener(longClickListener);
        cake.setOnLongClickListener(longClickListener);
        candy.setOnLongClickListener(longClickListener);
        cookie.setOnLongClickListener(longClickListener);

        circle.setOnDragListener(dragListener);
        rectangle.setOnDragListener(dragListener);
        triangle.setOnDragListener(dragListener);
        square.setOnDragListener(dragListener);

        check=findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<4;i++){
                    if(match_to_answer[i]==answer[i]){
                        score++;
                    }
                }
                upload_score("drag items with audio", score,4);
                show_rating(score,4,drag_items_with_audio.class,null,true);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(drag_items_with_audio.this, drag_items_with_audio.class);
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
                        case R.id.drag1: current_object=0; break;
                        case R.id.drag2: current_object=1; break;
                        case R.id.drag3: current_object=2; break;
                        case R.id.drag4: current_object=3; break;
                    }

                    switch (v.getId()){
                        case R.id.target1:
                            match_to_answer[0]=current_object;
                            break;
                        case R.id.target2:
                            match_to_answer[1]=current_object;
                            break;
                        case R.id.target3:
                            match_to_answer[2]=current_object;
                            break;
                        case R.id.target4:
                            match_to_answer[3]=current_object;
                            break;
                    }

                    x=(int) v.getX();
                    y=(int) v.getY();
                    x+=v.getWidth()/2 - view.getWidth()/2;
                    y+=v.getHeight()/2 - view.getHeight()/2;
                    //gia na min ginetai overlap sta borders tou trigwnou
                    if(v.getId()==R.id.target3){
                        y=y+60;
                    }
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

    View.OnClickListener play = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.play1: play_sound(R.raw.pagwto_trigwno, play1); break;
                case R.id.play2: play_sound(R.raw.biskoto_tetragwno, play2); break;
                case R.id.play3: play_sound(R.raw.karamela_kyklos, play3); break;
                case R.id.play4: play_sound(R.raw.tourta_orthogwnio, play4); break;
            }
        }
    };
}