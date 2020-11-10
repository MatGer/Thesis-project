package com.example.diplwmatikh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends universal {
    EditText username,email,password,confirm_password;
    Button register_button;
    FirebaseAuth fAuth;
    ProgressBar progressbar;
    FirebaseFirestore fStore;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        runtime();

        username=findViewById(R.id.edgetusername);
        email=findViewById(R.id.edgetemail);
        password=findViewById(R.id.edgetpassword);
        confirm_password=findViewById(R.id.edconfirmpassword);
        register_button=findViewById(R.id.registerbutton);
        progressbar=findViewById(R.id.progressbar_reg);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username=username.getText().toString().trim();
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                String ConfirmPassword=confirm_password.getText().toString().trim();

                if(TextUtils.isEmpty(Username)){
                    username.setError("Πρέπει να προσθέσετε Όνομα χρήστη");
                    return;
                }
                if(TextUtils.isEmpty(Email)){
                    email.setError("Πρέπει να προσθέσετε ένα E-mail");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    password.setError("Πρέπει να προσθέσετε κωδικό");
                    return;
                }
                if(Password.length()<6){
                    password.setError("Ο κωδικός πρέπει να είναι από 6 χαρακτήρες και πάνω");
                }
                if(!TextUtils.equals(Password, ConfirmPassword)){
                    confirm_password.setError("Οι κωδικοί δεν είναι ίδιοι");
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Επιτυχής δημιουργία χρήστη", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference dR = fStore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("Username", Username);
                            user.put("Email", Email);
                            dR.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("Register Activity", "Το προφίλ του χρήστη" + userID + "δημιουργήθηκε");
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),Mainmenu.class));
                        }else{
                            Toast.makeText(RegisterActivity.this, "Error: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                        //if something goes wrong
                .addOnFailureListener(RegisterActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressbar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
    }
}