package com.example.schlotter_romain_liste_personnalise_avec_recherche;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Splash extends Activity {
    //Duration of Splash
    private final int DUREE_SPLASH = 5000; //Oui c'est long 5 secondes, mais au moins on voit l'animation.

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash);

        ImageView img = (ImageView) findViewById(R.id.anim_patisserie);
        img.setBackgroundResource(R.drawable.patisserie_animation);
        AnimationDrawable monAnim = (AnimationDrawable) img.getBackground();
        monAnim.start();

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, DUREE_SPLASH);
    }
}
