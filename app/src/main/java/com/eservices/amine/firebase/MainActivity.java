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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private EditText editTextEmail,editTextPw;
    private TextView textViewSignIn;
    private ProgressDialog progressDialog;


    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

       // Si l'utilisateur est connecté, on accède à son profil
        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent
                (getApplicationContext(), ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        editTextEmail =  (EditText) findViewById(R.id.editTextEmail);
        editTextPw =  (EditText) findViewById(R.id.editTextPw);

        textViewSignIn =  (TextView) findViewById(R.id.textViewSignIn);

        buttonRegister.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);
    }


    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPw.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            //pas d'email
            Toast.makeText(this, "Veuillez entrer un email",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            //pas de mdp
            Toast.makeText(this, "Veuillez entrer un mot de passe",
                    Toast.LENGTH_SHORT).show();
            return;
        }

    progressDialog.setMessage("Enregistrement en cours ...");
    progressDialog.show();
    firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        //l'utilisateur s'est enregistré avec succès
                        //on va afficher l'activité du profil ici


                        finish();
                        startActivity(new Intent
                            (getApplicationContext(), ProfileActivity.class));
                    }
                    else {
                        Toast.makeText(MainActivity.this,
                            "Enregistrement échoué", Toast.LENGTH_SHORT).show();

                    }
                    progressDialog.dismiss();
                }
            });

    }


    @Override
    public void onClick(View v) {
        if(v==buttonRegister){
            registerUser();
        }

        if(v==textViewSignIn){
            // va ouvrir l'activité de connexion ici
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
