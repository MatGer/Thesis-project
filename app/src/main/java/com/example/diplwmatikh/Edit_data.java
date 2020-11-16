package com.example.diplwmatikh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class Edit_data extends universal {
    EditText username,email,pass,pass2;
    FirebaseAuth fAuth;
    String userID;
    FirebaseFirestore fStore;
    Button cancel,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        runtime();
        username=findViewById(R.id.showusername);
        email=findViewById(R.id.showemail);
        pass=findViewById(R.id.showpassword);
        pass2=findViewById(R.id.showpassword2);
        cancel=findViewById(R.id.showcancel);
        update=findViewById(R.id.showupdate);
        //FirebaseUser user = fAuth.getCurrentUser();

        fAuth=FirebaseAuth.getInstance();
        userID=fAuth.getCurrentUser().getUid();
        fStore=FirebaseFirestore.getInstance();

        DocumentReference fetch_test = fStore.collection("users").document(userID);
        fetch_test.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                username.setText(value.getString("Username"));
                email.setText(value.getString("Email"));
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Edit_data.this, Mainmenu.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> data = new HashMap<>();
                data.put("Username", username.getText().toString().trim());
                data.put("Email", email.getText().toString().trim());

                fStore.collection("users").document(userID).update(data)
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("upload data class", "Error on updating data", e);
                            }
                        });
                decorView.setSystemUiVisibility(uiOptions);//to dissapear nav bar
                /*
                String newpass=pass2.getText().toString().trim();
                user.updatePassword(newpass)
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("upload data class", "Error on updating password", e);
                            }
                        });

                 */
            }
        });
    }
}