package com.example.schlotter_romain_liste_personnalise_avec_recherche;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        final String EXTRA_PATISSERIE="patisserie";

        Intent monIntent = getIntent();
        Patisserie patisserie = monIntent.getParcelableExtra(EXTRA_PATISSERIE);

        ImageView imPatisserie = (ImageView) findViewById(R.id.imagepatisserie);
        TextView tvNom = (TextView) findViewById(R.id.nom);
        TextView tvDescription = (TextView) findViewById(R.id.description);

        imPatisserie.setImageResource(patisserie.getImage());
        tvNom.setText(patisserie.getNom());
        tvDescription.setText(patisserie.getDescription());

        Button btMenu = (Button) findViewById(R.id.menu);
        Button btRecette = (Button) findViewById(R.id.recette);

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LA NAVIGATION !!!

                //Préparation de la navigation.
                Intent monIntent = new Intent(Detail.this,MainActivity.class);

                //Navigation
                startActivity(monIntent);
            }
        });

        btRecette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(patisserie.getidVideo()>0)
                {
                    //LA NAVIGATION !!!
                    final String EXTRA_PATISSERIE="patisserie";

                    //Préparation de la navigation.
                    Intent monIntent = new Intent(Detail.this,Recette.class);
                    Parcelable parcel = patisserie;
                    monIntent.putExtra(EXTRA_PATISSERIE,parcel);

                    //Navigation
                    startActivity(monIntent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Vidéo non disponible pour l'instant.",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
