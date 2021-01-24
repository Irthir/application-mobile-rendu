package com.example.schlotter_romain_liste_personnalise_avec_recherche;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PatisserieAdapter extends RecyclerView.Adapter<PatisserieAdapter.ViewHolder> {
    private final ArrayList<Patisserie> alPatisserie; //Notre tableau de données.

    //Le viewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        //On y déclare les objets e la vue qui seront chargés.
        public TextView tvNom;
        public TextView tvPrix;
        public ImageView ivPatisserie;

        //Constructeur du holder : le view holder a une référence à tous les widgets de la liste
        public ViewHolder(View v)
        {
            super(v);
            tvNom = (TextView) v.findViewById(R.id.nom);
            tvPrix = (TextView) v.findViewById(R.id.prix);
            ivPatisserie = (ImageView) v.findViewById(R.id.imagepatisserie);
        }
    }

    //Constructeur de l'adapteur : initialisation de l'adapteur et des données.
    public PatisserieAdapter(ArrayList<Patisserie> listePatisserie) { alPatisserie = listePatisserie;}

    //Chargement du layout et initialisation du viewholder
    @NonNull
    @Override
    public PatisserieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_patisserie,parent,false);

        return new ViewHolder(v);
    }

    //Lien entre viewHolder et données
    @Override
    public void onBindViewHolder(ViewHolder holder, final int nPosition)
    {
        holder.tvNom.setText(alPatisserie.get(nPosition).getNom());
        String sPrix = String.format("%s€",alPatisserie.get(nPosition).getPrix());
        holder.tvPrix.setText(sPrix);
        holder.ivPatisserie.setImageResource(alPatisserie.get(nPosition).getImage());
    }

    //Nombre d'éléements de la liste
    @Override
    public int getItemCount() {return alPatisserie.size();}
}
