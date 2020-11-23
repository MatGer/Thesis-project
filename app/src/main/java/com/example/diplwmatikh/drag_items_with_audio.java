package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class drag_items_with_audio extends universal{
    ImageView circle,rectangle,square,triangle;
    ImageView ice_cream,cake,cookie,candy;
    int x,y,score;
    Button check;
    int current_object=-1;
    int [] answer = {2,3,0,1};
    int[] match_to_answer={-1,-1,-1,-1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_items_with_audio);

        runtime();

        TextView title = findViewById(R.id.title);
        title.setText("Σείρε τις εικόνες μέσα στα σχήματα με βάση τις οδηγίες. Πάτησε στο ηχειάκι για να ακούσεις την εκφώνηση");
        title.setSelected(true);

        circle=findViewById(R.id.target1);
        rectangle=findViewById(R.id.target2);
        triangle=findViewById(R.id.target3);
        square=findViewById(R.id.target4);

        ice_cream=findViewById(R.id.drag1);
        cookie=findViewById(R.id.drag2);
        candy=findViewById(R.id.drag3);
        cake=findViewById(R.id.drag4);

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
                upload_score("drag items with audio", score);
                create_builder_finished_with_score(score);
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
                    x=x+v.getWidth()/2 - view.getWidth()/2;
                    y=y+v.getHeight()/2 - view.getHeight()/2;
                    //gia na min ginetai overlap sta borders tou trigwnou
                    if(view.getId()==R.id.drag1 && v.getId()==R.id.target3){
                        y=y+30;
                    }else{
                        y=y+70;
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
}