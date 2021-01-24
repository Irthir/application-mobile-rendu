package com.example.schlotter_romain_liste_personnalise_avec_recherche;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Recette extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recette);

        final String EXTRA_PATISSERIE="patisserie";

        Intent monIntent = getIntent();
        Patisserie patisserie = monIntent.getParcelableExtra(EXTRA_PATISSERIE);

        TextView tvNom = (TextView) findViewById(R.id.nom);
        tvNom.setText(patisserie.getNom());

        //Gestion de la vidéo
        VideoView vRecette = (VideoView) findViewById(R.id.videoView);
        String videoPath = "android.resource://"+getPackageName() + "/"+patisserie.getidVideo();
        Uri uri = Uri.parse(videoPath);
        vRecette.setVideoURI(uri);

        //Gestion du media controller
        MediaController mediaController = new MediaController(this);
        vRecette.setMediaController(mediaController);
        mediaController.setAnchorView(vRecette);

        //Les boutons !!!
        Button btMenu = (Button) findViewById(R.id.menu);
        Button btDetail = (Button) findViewById(R.id.detail);

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LA NAVIGATION !!!

                //Préparation de la navigation.
                Intent monIntent = new Intent(Recette.this,MainActivity.class);

                //Navigation
                startActivity(monIntent);
            }
        });

        btDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LA NAVIGATION !!!
                final String EXTRA_PATISSERIE="patisserie";

                //Préparation de la navigation.
                Intent monIntent = new Intent(Recette.this,Detail.class);
                Parcelable parcel = patisserie;
                monIntent.putExtra(EXTRA_PATISSERIE,parcel);

                //Navigation
                startActivity(monIntent);
            }
        });
    }
}