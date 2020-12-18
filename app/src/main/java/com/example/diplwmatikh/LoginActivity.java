package com.example.diplwmatikh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends universal {
    EditText login_email, login_password;
    Button login_button;
    TextView create_new_account_text_button,forget_password_button;
    FirebaseAuth fAuth;
    ProgressBar prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        runtime();

        login_email=findViewById(R.id.edloginemail);
        login_password=findViewById(R.id.edloginpassword);
        login_button=findViewById(R.id.loginbutton);
        create_new_account_text_button=findViewById(R.id.create_new_account_text);
        prog=findViewById(R.id.progressbar_login);
        fAuth=FirebaseAuth.getInstance();
        forget_password_button=findViewById(R.id.forget_password_button);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);   //keyboard stay hidden

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(), Mainmenu.class));
            finish();
        }

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lgemail=login_email.getText().toString().trim();
                String lgpass=login_password.getText().toString().trim();

                if(TextUtils.isEmpty(lgemail)){
                    login_email.setError("Πρέπει να προσθέσετε Όνομα χρήστη");
                    return;
                }
                if(TextUtils.isEmpty(lgpass)){
                    login_password.setError("Πρέπει να προσθέσετε ένα E-mail");
                    return;
                }
                //close keyboard on button press
                InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                prog.setVisibility(View.VISIBLE);
                fAuth.signInWithEmailAndPassword(lgemail, lgpass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Συνδεθήκατε με επιτυχία", Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = fAuth.getCurrentUser();
                                    startActivity(new Intent(getApplicationContext(),Mainmenu.class));
                                }else{
                                    Toast.makeText(LoginActivity.this, "Error: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        //if something goes wrong
                        .addOnFailureListener(LoginActivity.this, new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                prog.setVisibility(View.INVISIBLE);
                            }
                        });
            }
        });

        create_new_account_text_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });

        forget_password_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText ps = new EditText(v.getContext());
                AlertDialog.Builder password_reset= new AlertDialog.Builder(v.getContext());
                System.out.println("-------------------------------------------------------------------------");
                password_reset.setTitle("Επαναφορά κωδικού");
                password_reset.setMessage("Πληκρολόγησε το E-mail σου");
                password_reset.setCancelable(false);
                password_reset.setView(ps);
                password_reset.setPositiveButton("Οκ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);   //keyboard stay hidden
                        fAuth.sendPasswordResetEmail(ps.getText().toString().trim())
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        //System.out.println("-------------------------------------------------------------------------done");
                                        Toast.makeText(LoginActivity.this, "Στάλθηκε e-mail στη διεύθυνση που πληκτρολογήσατε", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        //System.out.println("-------------------------------------------------------------------------not done");
                                        Toast.makeText(LoginActivity.this, "Κάτι πήγε στραβά. Ξαναπροσπάθησε.", Toast.LENGTH_SHORT).show();
                                        System.out.println("Error"+ e.getMessage());
                                    }
                                });

                    }
                })
                  .setNegativeButton("Ακυρο", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                            onResume();
                      }
                  });
                password_reset.create().show();
            }
        });
    }
}