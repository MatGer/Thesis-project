 package com.example.diplwmatikh;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.HashMap;
import java.util.Map;

 public class universal extends AppCompatActivity {
    Intent intent;
    AlertDialog.Builder builderback, builderfinished, builderfinished2,builderexit, builderinfo;
    View decorView;
    FirebaseAuth fAuth;
    String userID;
    MediaPlayer player;
     //options to hide nav bar, status bar and further functionality
     // DO NOT TOUCH THE LINE BELOW
    int uiOptions=View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

    public void runtime(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//screen always on
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        decorView = getWindow().getDecorView();
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher
        onResume();

        //get user id
        fAuth=FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null){
            userID=fAuth.getCurrentUser().getUid();
        }
    }
    /*
    public void pop_up_3rd_activity(int scoreA,int scoreB,int maxA,int maxB, Class calling_class, Class next_class){
         float percentage_A=scoreA/maxA;
         float percentage_B=scoreB/maxB;
         if(percentage_A<0.5 && percentage_B<0.5){
             create_builder_for_3rd_activity(next_class);
         }else {
             show_rating(scoreB, maxB,calling_class,next_class);
         }
     }

     */
    //adjust text and call builder
    public void show_rating(int score, int max_activity_score,Class calling_class, Class next_class, boolean select_builder){
        float rating = (float) score/max_activity_score;                                                        //false=text optimised for 1st activity
        String text="";                                                                             //true=text optimised for 2nd activity
        if(next_class==null){                                                           //if next_class==null -> no next activity -> different builder
            if(rating<=0.33){
                //fair
                text="Χρειάζεται περισσότερη προσπάθεια.Η βαθμολογία σου είναι "+score +" από τα "+max_activity_score+". Θέλεις να σπιστρέψεις στο αρχικό μενού;";
            }else if(rating<=0.66){
                //good
                text="Καλή δουλειά. Συνέχισε έτσι. Η βαθμολογία σου είναι "+score +" από τα "+max_activity_score+". Θέλεις να σπιστρέψεις στο αρχικό μενού;";
            }else{
                //very good
                text="Συγχαρητήρια! Πολύ καλή δουλειά. Η βαθμολογία σου είναι "+score +" από τα "+max_activity_score+". Θέλεις να σπιστρέψεις στο αρχικό μενού;";
            }
            create_builder_for_3rd_activity(calling_class, text);
        }else{
            if(!select_builder){
                if(rating<=0.33){
                    //fair
                    text="Χρειάζεται περισσότερη προσπάθεια. Η βαθμολογία σου είναι "+score +" από τα "+max_activity_score+". Θέλεις να πας στην επόμενη δραστηριότητα;";
                }else if(rating<=0.66){
                    //good
                    text="Καλή δουλειά. Συνέχισε έτσι. Η βαθμολογία σου είναι "+score +" από τα "+max_activity_score+". Θέλεις να πας στην επόμενη δραστηριότητα;";
                }else{
                    //very good
                    text="Συγχαρητήρια! Πολύ καλή δουλειά. Η βαθμολογία σου είναι "+score +" από τα "+max_activity_score+". Θέλεις να πας στην επόμενη δραστηριότητα;";
                }
                create_builder_finished(calling_class,next_class,text);
            }else{
                if(rating<=0.33){
                    //fair
                    text="Χρειάζεται περισσότερη προσπάθεια. Η βαθμολογία σου είναι "+score +" από τα "+max_activity_score+". Θέλεις να δοκιμάσεις μια άλλη δραστηριότητα;";
                }else if(rating<=0.66){
                    //good
                    text="Καλή δουλειά. Συνέχισε έτσι. Η βαθμολογία σου είναι "+score +" από τα "+max_activity_score+". Θέλεις να δοκιμάσεις μια άλλη δραστηριότητα;";
                }else{
                    //very good
                    text="Συγχαρητήρια! Πολύ καλή δουλειά. Η βαθμολογία σου είναι "+score +" από τα "+max_activity_score+". Θέλεις να δοκιμάσεις μια άλλη δραστηριότητα;";
                }
                create_builder_finished(calling_class,next_class,text);
            }
        }
     }
    //show message at the end of the activity
    public void create_builder_finished(Class calling_class, Class next_class, String txt){
        builderfinished = new AlertDialog.Builder(universal.this);
        builderfinished.setTitle("Η δραστηριότητα ολοκληρώθηκε!");
        builderfinished.setMessage(txt);
        builderfinished.setCancelable(false);
                builderfinished.setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(universal.this, next_class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(universal.this, Mainmenu.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNeutralButton("Θα ξαναπροσπαθήσω", new DialogInterface.OnClickListener() {
                    @Override
                     public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(universal.this, calling_class);
                        startActivity(intent);
                        finish();
                     }
                  }).create().show();
    }
    //builder for 3rd activity
     public void create_builder_for_3rd_activity(Class calling_class, String txt){
         builderfinished2 = new AlertDialog.Builder(universal.this);
         builderfinished2.setTitle("Η δραστηριότητα ολοκληρώθηκε!");
         builderfinished2.setMessage(txt);
         builderfinished2.setCancelable(false);
         builderfinished2.setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 intent = new Intent(universal.this, Mainmenu.class);
                 startActivity(intent);
                 finish();
             }
         })
                 .setNegativeButton("Θα ξαναπροσπαθήσω", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         intent = new Intent(universal.this, calling_class);
                         startActivity(intent);
                         finish();
                     }
                 }).create().show();
     }
     public void create_exit_builder(){
         builderexit = new AlertDialog.Builder(universal.this);
         builderexit.setTitle("Έξοδος από την δραστηριότητα.");
         builderexit.setMessage("Θέλεις σίγουρα να φύγεις;");
         builderexit.setCancelable(false);
         builderexit.setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 finish();
             }
         });
         builderexit.setNegativeButton("Οχι", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         onResume();
                     }
                 }).create().show();
     }
     public void return_to_home_builder(){
         builderexit = new AlertDialog.Builder(universal.this);
         builderexit.setTitle("Μετάβαση στο αρχικό μενού!");
         builderexit.setMessage("Θέλεις σίγουρα να επιστρέψεις στο αρχικό μενού;");
         builderexit.setCancelable(false);
         builderexit.setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 intent = new Intent(universal.this, Mainmenu.class);
                 startActivity(intent);
                 finish();
             }
         });
         builderexit.setNegativeButton("Οχι", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 onResume();
             }
         }).create().show();
     }

     //to upload score
     public void upload_score(String activityname,int score, int max_score){
        //bring previous score
        FirebaseFirestore fStore=FirebaseFirestore.getInstance();
        DocumentReference bring_old = fStore.collection("scores").document(userID);
        bring_old.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                float rating = (float) score/max_score; //split max score in three parts for the button colours
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
                    if(rating<=0.33){
                        upload_color(activityname, "red");
                    }else if(rating<=0.66){
                        upload_color(activityname, "yellow");
                    }else{
                        upload_color(activityname, "green");
                    }
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
                        if(rating<=0.33){
                            upload_color(activityname, "red");
                        }else if(rating<=0.66){
                            upload_color(activityname, "yellow");
                        }else{
                            upload_color(activityname, "green");
                        }
                    }
                }
            }
        });
    }
    //to set button color
     public void upload_color(String activityname, String color){
         FirebaseFirestore fStore=FirebaseFirestore.getInstance();
         DocumentReference bring = fStore.collection("buttons").document(userID);
         bring.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
             @Override
             public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                 Map<String, Object> data = new HashMap<>();
                 //if field not exists
                 //no need ot check if field exists. this check happens on upload score method
                     data.put(activityname, color);
                     fStore.collection("buttons").document(userID).update(data)
                             .addOnFailureListener(new OnFailureListener() {
                                 @Override
                                 public void onFailure(@NonNull Exception e) {
                                     Log.w("upload colors method", "Error on uploading colors document", e);
                                 }
                             });
             }
         });
     }

     //to get the button's colour for score tab
     public void get_color(String activityname, Button btn){
         FirebaseFirestore fStore=FirebaseFirestore.getInstance();
         DocumentReference fetch_test = fStore.collection("buttons").document(userID);
         fetch_test.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
             @Override
             public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                 if (value.getString(activityname) != null) {
                     btn.setVisibility(View.VISIBLE);// if button is hidden, show it
                     switch (value.getString(activityname)) {
                         case "red":
                             btn.setBackground(getDrawable(R.drawable.start_menu_button_red));
                             break;
                         case "yellow":
                             btn.setBackground(getDrawable(R.drawable.start_menu_button_yellow));
                             break;
                         case "green":
                             btn.setBackground(getDrawable(R.drawable.start_menu_button_green));
                             break;
                     }
                 }
             }
         });
     }
    //to get the scores for score tab
    public void get_score(String activityname,int max_score, String scientific_name,TextView field){
        FirebaseFirestore fStore=FirebaseFirestore.getInstance();
        DocumentReference fetch_test = fStore.collection("scores").document(userID);
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
                    field.setText(scientific_name+" : Δεν έχει ολοκληρωθεί ακόμα.");
                }else{
                    output=(int) score;
                    field.setText(scientific_name +" : "+output+" από τα "+max_score);
                }
            }
        });
    }
    //get score for navigation bar
     public void get_score_for_navbar(String activityname,TextView field,int max_activity_score){
         FirebaseFirestore fStore=FirebaseFirestore.getInstance();
         DocumentReference fetch_test = fStore.collection("scores").document(userID);
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
     //home button listener
     View.OnClickListener home_button_listener = new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             return_to_home_builder();
         }
     };

     //long click listener
     View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
         @Override
        public boolean onLongClick(View v) {
             ClipData data = ClipData.newPlainText("clipdata","text2");
             View.DragShadowBuilder myShadowBBuilder = new View.DragShadowBuilder(v);// Instantiates the drag shadow builder.
             v.startDragAndDrop(data, myShadowBBuilder, v, 0);
             return true;
         }
     };
    //go back
    View.OnClickListener back_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
    View.OnClickListener back_button_from_activity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            create_exit_builder();
        }
    };
    //to play the sounds
    //track is an integer... must be formatted as R.raw.filename
    public void play_sound(int track, ImageView btn){
        player = MediaPlayer.create(this,track);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btn.setEnabled(true);
                btn.setImageDrawable(getDrawable(R.drawable.play_button));
            }
        });
        btn.setEnabled(false);
        btn.setImageDrawable(getDrawable(R.drawable.play_button_grey));
        player.start();
    }
     //to reset score. deletes a field at a time
     public void reset_score(String activityname,String category){
        //deletes the field
         FirebaseFirestore fStore=FirebaseFirestore.getInstance();
         DocumentReference reset;
         if(category=="scores"){
             reset = fStore.collection("scores").document(userID);
         }else{
             reset = fStore.collection("buttons").document(userID);
         }
         reset.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
             @Override
             public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                 Map<String,Object> hashMap = new HashMap<>();
                 if(value.get(activityname)==null){
                     //System.out.println("0000000000000000000000000000000000000000000000000000000000         null found");
                 }else{
                     hashMap.put(activityname, FieldValue.delete());
                     reset.update(hashMap);
                     //System.out.println("0000000000000000000000000000000000000000000000000000000000        field deleted");
                 }
             }
         });
     }
    //show information on menus
     View.OnClickListener info_button = new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             builderinfo = new AlertDialog.Builder(universal.this);
             builderinfo.setTitle("Πληροφορίες.");
             builderinfo.setMessage("Αν το κουμπί της δραστηριότητας είναι μπλε, τότε δεν έχει ολοκληρωθεί ακόμα.\n" +
                     "Αν το κουμπί της δραστηριότητας είναι κόκκινο, σημαίνει ότι ολοκληρώθηκε αλλά χρειάζεται κι άλλη προσπάθεια.\n" +
                     "Αν το κουμπί της δραστηριότητας είναι κίτρινο, σημαίνει ότι ολοκληρώθηκε με καλή βαθμολογία.\n" +
                     "Αν το κουμπί της δραστηριότητας είναι πράσινο, σημαίνει ότι ολοκληρώθηκε με πολύ καλή βαθμολογία.");
             builderinfo.setPositiveButton("Κλείσιμο", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     onResume();
                 }
             }).create().show();
         }
     };
     public void onResume(){
         super.onResume();
             decorView.setSystemUiVisibility(uiOptions);
     }
}
