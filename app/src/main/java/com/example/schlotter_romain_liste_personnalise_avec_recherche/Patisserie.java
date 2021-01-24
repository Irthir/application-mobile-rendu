package com.example.schlotter_romain_liste_personnalise_avec_recherche;

import android.os.Parcel;
import android.os.Parcelable;

public class Patisserie implements Parcelable {
    private int idImage;
    private int idVideo;
    private String sNom;
    private String sPrix;
    private String sDescription;

    public Patisserie() {
    }

    protected Patisserie(Parcel in) {
        idImage = in.readInt();
        idVideo = in.readInt();
        sNom = in.readString();
        sPrix = in.readString();
        sDescription = in.readString();
    }

    public static final Creator<Patisserie> CREATOR = new Creator<Patisserie>() {
        @Override
        public Patisserie createFromParcel(Parcel in) {
            return new Patisserie(in);
        }

        @Override
        public Patisserie[] newArray(int size) {
            return new Patisserie[size];
        }
    };

    //Les Assesseurs
    public String getPrix(){ return sPrix;}

    public String getNom(){ return sNom;}

    public int getImage(){ return idImage;}

    public int getidVideo() { return idVideo;}


    //Les Mutateurs

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public void setsNom(String sNom) {
        this.sNom = sNom;
    }

    public void setsPrix(String sPrix)
    {
        this.sPrix = sPrix;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idImage);
        dest.writeInt(idVideo);
        dest.writeString(sNom);
        dest.writeString(sPrix);
        dest.writeString(sDescription);
    }

    public String getDescription() {
        return sDescription;
    }

    public void setDescription(String sDescription) {
        this.sDescription = sDescription;
    }
}
