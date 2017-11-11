package com.eservices.amine.firebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSignIn;
    private EditText editTextEmail, editTextPassword;
    private TextView textViewsignUp;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Si l'utilisateur est déjà connecté, on accède à son profil
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));

        }



        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPw);
        buttonSignIn = (Button) findViewById(R.id.buttonConnexion);
        textViewsignUp = (TextView) findViewById(R.id.textViewSignUp);

        progressDialog = new ProgressDialog(this);

        buttonSignIn.setOnClickListener(this);
        textViewsignUp.setOnClickListener(this);


    }

    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String pw = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            //pas d'email
            Toast.makeText(this, "Veuillez entrez un email",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pw)){
            //pas de mdp
            Toast.makeText(this, "Veuillez entrer un mot de passe",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Authentification en cours ...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, pw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            //lancer l'acitivité du profil utilisateur
                            finish();
                            startActivity(new Intent
                                (getApplicationContext(), ProfileActivity.class)
                                         );

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {

        if (v==buttonSignIn){
            userLogin();
        }

        if(v==textViewsignUp){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

    }

}
