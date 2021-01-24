package com.example.schlotter_romain_liste_personnalise_avec_recherche;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView monRecyclerView;
    private RecyclerView.Adapter monAdapter;
    private RecyclerView.LayoutManager monLayoutManager;
    private ArrayList<Patisserie> alPatisserie;
    private ArrayList<Patisserie> listePatisserie;
    private TextView tvRecherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alPatisserie = new ArrayList<Patisserie>();
        listePatisserie = new ArrayList<Patisserie>();
        initListe(alPatisserie);
        initListe(listePatisserie);

        monRecyclerView = (RecyclerView) findViewById(R.id.main_RecyclerView);
        monRecyclerView.setHasFixedSize(true); //Taille fixe des éléments de la liste.

        monLayoutManager = new LinearLayoutManager(this);
        monRecyclerView.setLayoutManager(monLayoutManager);

        monAdapter = new PatisserieAdapter(alPatisserie);
        monRecyclerView.setAdapter(monAdapter);

        monRecyclerView.addOnItemTouchListener(new PatisserieItemClickListener(getApplicationContext(),new PatisserieItemClickListener.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position)
            {
                if (listePatisserie.get(position).getNom()!=getResources().getString(R.string.erreur))
                {
                    //LA NAVIGATION !!!
                    final String EXTRA_PATISSERIE="patisserie";

                    //Préparation de la navigation.
                    Intent monIntent = new Intent(MainActivity.this,Detail.class);
                    Parcelable parcel = listePatisserie.get(position);
                    monIntent.putExtra(EXTRA_PATISSERIE,parcel);

                    //Navigation
                    startActivity(monIntent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Veuillez réitérer votre recherche.",Toast.LENGTH_SHORT).show();
                }
            }
        }));

        tvRecherche = (TextView) findViewById(R.id.recherche);
        tvRecherche.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrer();
            }
        });
    }

    public void filtrer()
    {
        //récupérer la chaîne saisie par l'utilisateur
        //créer une nouvelle liste qui va contenir le résultat à afficher
        listePatisserie = new ArrayList<Patisserie>();
        //Boucler sur la liste des noms, avec une itération
        for ( Patisserie patisserie:alPatisserie)
        {
            if (patisserie.getNom().toString().toUpperCase().startsWith(tvRecherche.getText().toString().toUpperCase()))
            {
                listePatisserie.add(patisserie);
            }
        }

        if (listePatisserie.size()==0)
        {
            Patisserie patisserie = new Patisserie();
            patisserie.setsNom(getResources().getString(R.string.erreur));
            patisserie.setsPrix("0.00");
            patisserie.setIdImage(R.drawable.erreur);
            listePatisserie.add(patisserie);
        }

        RecyclerView.Adapter monAdapter = new PatisserieAdapter(listePatisserie);
        monRecyclerView.setAdapter(null);
        monRecyclerView.setAdapter(monAdapter);
    }

    private void initListe(ArrayList<Patisserie> listePatisserie)
    {
        Patisserie patisserie = new Patisserie();
        patisserie.setsNom(getResources().getString(R.string.eclair));
        patisserie.setsPrix("1.00");
        patisserie.setIdImage(R.drawable.eclair);
        patisserie.setIdVideo(R.raw.eclair);
        patisserie.setDescription(getResources().getString(R.string.description_eclair));
        listePatisserie.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setsNom(getResources().getString(R.string.cremebrulee));
        patisserie.setsPrix("2.00");
        patisserie.setIdImage(R.drawable.creme_brulee);
        patisserie.setIdVideo(R.raw.creme_brulee);
        patisserie.setDescription(getResources().getString(R.string.description_cremebrulee));
        listePatisserie.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setsNom(getResources().getString(R.string.beignets));
        patisserie.setsPrix("1.00");
        patisserie.setIdImage(R.drawable.beignet);
        patisserie.setIdVideo(R.raw.beignet);
        patisserie.setDescription(getResources().getString(R.string.description_beignet));
        listePatisserie.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setsNom(getResources().getString(R.string.tartepoires));
        patisserie.setsPrix("10.90");
        patisserie.setIdImage(R.drawable.tarte_aux_poires);
        patisserie.setIdVideo(R.raw.tarte_amandine_aux_poires);
        patisserie.setDescription(getResources().getString(R.string.tartepoires));
        listePatisserie.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setsNom(getResources().getString(R.string.gateauchoco));
        patisserie.setsPrix("9.90");
        patisserie.setIdImage(R.drawable.gateau_au_chocolat);
        patisserie.setIdVideo(R.raw.gateau_au_chocolat);
        patisserie.setDescription(getResources().getString(R.string.description_gateau));
        listePatisserie.add(patisserie);
    }
}