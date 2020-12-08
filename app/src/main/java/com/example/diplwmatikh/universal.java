 package com.example.diplwmatikh;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

import io.grpc.internal.SharedResourceHolder;

 public class universal extends AppCompatActivity {
    Intent intent;
    AlertDialog.Builder builderreset, builderback, builderfinished, builderfinished_score;
    View decorView;
    FirebaseAuth fAuth;
    String userID;
    MediaPlayer player;
    int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION        //options to hide nav bar, status bar and further functionality
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    public void runtime(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//screen always on
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        decorView.setSystemUiVisibility(uiOptions);

        //get user id
        fAuth=FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null){
            userID=fAuth.getCurrentUser().getUid();
        }


        builderback = new AlertDialog.Builder(universal.this);
        builderback.setCancelable(false);       //makes alert to close only if you press yes or no
        builderback.setMessage("Θέλετε να επιστρέψετε στο αρχικό μενού;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(universal.this, Mainmenu.class);
                        startActivity(intent);
                        intent=null;
                    }
                })
                .setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        decorView.setSystemUiVisibility(uiOptions);
                    }
                });

        builderreset = new AlertDialog.Builder(universal.this);
        builderreset.setCancelable(false);          //makes alert to close only if you press yes or no
        builderreset.setMessage("Θέλετε να ξανακάνετε την δραστηριότητα;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = getIntent();
                        finish();
                        startActivity(intent);
                        intent=null;
                    }
                })
                .setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        decorView.setSystemUiVisibility(uiOptions);
                    }
                });
    }

    void create_builder_finished_with_score(int score){
        builderfinished_score = new AlertDialog.Builder(universal.this);
        builderfinished_score.setTitle("Η δραστηριότητα ολοκληρώθηκε!");
        builderfinished_score.setMessage("Το σκορ ειναι : "+score+" .Θέλετε να ξανακάνετε την δραστηριότητα;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = getIntent();
                        finish();
                        startActivity(intent);
                        intent=null;
                    }
                })
                .setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(universal.this, Mainmenu.class);
                        startActivity(intent);
                        intent=null;
                    }
                }).create().show();
    }

    void create_builder_finished(int rating){
        builderfinished = new AlertDialog.Builder(universal.this);
        builderfinished.setTitle("Η δραστηριότητα ολοκληρώθηκε!");
        switch(rating){
            case 1:builderfinished.setMessage("Χρειάζεται περισσότερη προσπάθεια. Θελετε να ξαναπροσπαθήσετε;");
                   break;
            case 2:builderfinished.setMessage("Καλή δουλειά. Συνεχίστε έτσι. Θέλετε να ξαναξεκινήσετε;");
                   break;
            case 3:builderfinished.setMessage("Συγχαρητήρια! Πολύ καλή δουλειά. Θέλετε να ξαναξεκινήσετε;");
                   break;
        }
                builderfinished.setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = getIntent();
                        finish();
                        startActivity(intent);
                        intent=null;
                    }
                })
                .setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(universal.this, Mainmenu.class);
                        startActivity(intent);
                        intent=null;
                    }
                }).create().show();
    }

    public void upload_score(String activityname,int score){
        //bring previous score
        FirebaseFirestore fStore=FirebaseFirestore.getInstance();
        DocumentReference bring_old = fStore.collection("scores").document(userID);
        bring_old.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                Map<String, Object> data = new HashMap<>();
                //if field not exists
                if(value.getDouble(activityname)==null){
                    //fStore.collection("scores").document(userID);
                    data.put(activityname, score);
                    fStore.collection("scores").document(userID).update(data)
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("upload score method", "Error on uploading score document", e);
                                }
                            });
                }else{
                    //if field exists
                    double old_score=value.getDouble(activityname);
                    //if new score > old score then upload the new score else keep the old one
                    if(score > (int) old_score){
                        //fStore.collection("scores").document(userID);
                        data.put(activityname, score);
                        fStore.collection("scores").document(userID).update(data)
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w("upload score method", "Error on uploading score document", e);
                                    }
                                });
                    }
                }

            }
        });
    }

    public void get_score(String activityname,String uid,TextView field){
        FirebaseFirestore fStore=FirebaseFirestore.getInstance();
        DocumentReference fetch_test = fStore.collection("scores").document(uid);
        fetch_test.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                int output;
                double score=0;
                if(value.getDouble(activityname)==null || value.getDouble(activityname)==-1){
                    score=-1;
                    //if null or -1 (if user deleted data) we want to show different message
                }else{
                    score = value.getDouble(activityname);
                }
                if(score==-1){
                    field.setText("Η "+activityname+" δεν έχει ολοκληρωθεί ακόμα.");
                }else{
                    output=(int) score;
                    field.setText(activityname +": "+output);
                }
            }
        });
    }
     public void get_score_for_navbar(String activityname,String uid,TextView field,int max_activity_score){
         FirebaseFirestore fStore=FirebaseFirestore.getInstance();
         DocumentReference fetch_test = fStore.collection("scores").document(uid);
         fetch_test.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
             @Override
             public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                 int output;
                 double score=0;
                 if(value.getDouble(activityname)==null){
                     score=-1;
                     //if null we want to show different message
                 }else{
                     score = value.getDouble(activityname);
                 }
                 if(score==-1){
                     field.setText("--");
                 }else{
                     output=(int) score;
                     field.setText(output+"/"+max_activity_score);
                 }
             }
         });
     }

     View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View v) {
             ClipData data = ClipData.newPlainText("clipdata","text2");
             View.DragShadowBuilder myShadowBBuilder = new View.DragShadowBuilder(v);// Instantiates the drag shadow builder.
             v.startDragAndDrop(data, myShadowBBuilder, v, 0);
             return true;
         }
     };

    View.OnClickListener back_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
    //track is an integer... must be formatted as R.raw.filename
    public void play_sound(int track, ImageButton btn){
        player = MediaPlayer.create(this,track);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btn.setEnabled(true);
            }
        });
        btn.setEnabled(false);
        player.start();
    }

    public void play_sound(int track, ImageView btn){
        player = MediaPlayer.create(this,track);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btn.setEnabled(true);
            }
        });
        btn.setEnabled(false);
        player.start();
    }

    public void show_rating(int score, int max_activity_score){
        float rating = max_activity_score/3;
        if(score<=rating){
            //fair
            create_builder_finished(1);
            return;
        }else if(score<=2*rating){
            //good
            create_builder_finished(2);
            return;
        }else{
            //very good
            create_builder_finished(3);
            return;
        }
    }

     public void hide_labels(){
         findViewById(R.id.title).setVisibility(View.INVISIBLE);
         findViewById(R.id.prev_score).setVisibility(View.INVISIBLE);
         findViewById(R.id.score).setVisibility(View.INVISIBLE);
         findViewById(R.id.check).setVisibility(View.INVISIBLE);
     }

     public void reset_score(String activityname){
        //deletes the field
        //System.out.println(userID+"   00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
         FirebaseFirestore fStore=FirebaseFirestore.getInstance();
         DocumentReference reset = fStore.collection("scores").document(userID);
         reset.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
             @Override
             public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                 Map<String,Object> hashMap = new HashMap<>();
                 if(value.getDouble(activityname)==null){
                     //System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000         null found");
                 }else{
                     hashMap.put(activityname, FieldValue.delete());
                     reset.update(hashMap);
                     //System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000        field deleted");
                 }
             }
         });
     }

     public void onResume(){
         super.onResume();
         decorView.setSystemUiVisibility(uiOptions);
     }
}
