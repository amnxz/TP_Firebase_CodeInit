package com.eservices.amine.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

//    private TextView textViewUserEmail;
//    private Button buttonLogout;
//    private FirebaseAuth firebaseAuth;


    //------------------------------//
//    EditText editTextName;
//    Button buttonAddArtist;
//    Spinner spinnerGenres;
//
//    DatabaseReference databaseArtists;
//    ListView listViewArtists;
//
//    //une liste pour récupérer tous les artistes de la base firebase
//    List<Artiste> artists;
    //------------------------------//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        firebaseAuth = FirebaseAuth.getInstance();
//        if(firebaseAuth.getCurrentUser()==null){
//            finish();
//            startActivity(new Intent(this, LoginActivity.class));
//        }
//
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//
//        textViewUserEmail = (TextView) findViewById(R.id.textUserEmail);
//        buttonLogout = (Button) findViewById(R.id.buttonLogout);
//
//
//        textViewUserEmail.setText("Bonjour "+user.getEmail());
//
//        buttonLogout.setOnClickListener(this);



        //------------------------------//
//        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");
//
//        editTextName = (EditText) findViewById(R.id.editTextName);
//        buttonAddArtist = (Button) findViewById(R.id.buttonAddArtist);
//        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);
//        listViewArtists = (ListView) findViewById(R.id.listViewArtists);
//
//
//        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addArtist();
//            }
//        });
        //------------------------------//


        // Artist list init //
       // artists = new ArrayList<>();
        //-------- //

    }

    @Override
    public void onClick(View v) {
//        if(v==buttonLogout){
//            firebaseAuth.signOut();
//            finish();
//            startActivity(new Intent(this, LoginActivity.class));
//
//        }

    }


    //-----------------------------------//
//    private void addArtist(){
//        String name = editTextName.getText().toString().trim();
//    String genre = spinnerGenres.getSelectedItem().toString();
//
//        if(!TextUtils.isEmpty(name)){
//        //generer un id unique pour chaque artist
//        //la racine c'est "artists"
//        // => creer à chaque fois un noeud
//        // et on va sauvegarder les infos relatives à un artiste
//        String id = databaseArtists.push().getKey();
//        Artiste artist = new Artiste(id,name,genre);
//        databaseArtists.child(id).setValue(artist);
//
//        Toast.makeText(this, "Artiste ajouté",
//                Toast.LENGTH_LONG).show();
//
//    }
//        else {
//        Toast.makeText(this, "Vous devez entrez un nom",
//                Toast.LENGTH_LONG).show();
//    }
//}
    //-----------------------------------//



    // --------------------------------------- Liste d'artistes -------------------------------  //
//    @Override
//    protected void onStart() {
//        super.onStart();
//        //attacher une valeur au listener
//        databaseArtists.addValueEventListener(new ValueEventListener() {
//            @Override // elle s'execute à chaque changement en bdd
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                //s'assurer que la liste est vide
//                artists.clear();
//                //extraire les donnes de notre base et iterer sur tous les noeuds
//
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    //récupération de l'artiste
//                    Artiste artist = postSnapshot.getValue(Artiste.class);
//                    //Ajout de l'artiste sur la liste
//                    artists.add(artist);
//                }
//
//                //Créer un adaptateur
//                ArtistList artistAdapter = new ArtistList(ProfileActivity.this, artists);
//                //Attacher l'adapteur à listView
//                listViewArtists.setAdapter(artistAdapter);
//            }
//
//            @Override // elle s'excecute en cas d'erreur
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }

    // --------------------------------------- Liste d'artistes -------------------------------  //

}
