package com.example.wishlist.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Classe représantant un produit sur l'application
 */
@Entity
public class Produit implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private float prix;
    private String description;
    private int note;
    private String website;
    private boolean dejaAchete;


    //CONSTRUCTEUR
    public Produit(int id, String nom, float prix, String description, int note, String website, boolean dejaAchete) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.note = note;
        this.website = website;
        this.dejaAchete = dejaAchete;
    }


    protected Produit(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        prix = in.readFloat();
        description = in.readString();
        note = in.readInt();
        website = in.readString();
        dejaAchete = in.readByte() != 0;
    }

    public static final Creator<Produit> CREATOR = new Creator<Produit>() {
        @Override
        public Produit createFromParcel(Parcel in) {
            return new Produit(in);
        }

        @Override
        public Produit[] newArray(int size) {
            return new Produit[size];
        }
    };

    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isDejaAchete() {
        return dejaAchete;
    }

    public void setDejaAchete(boolean dejaAchete) {
        this.dejaAchete = dejaAchete;
    }


    //toSTRING
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", note=" + note +
                ", website='" + website + '\'' +
                ", dejaAchete=" + dejaAchete +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nom);
        parcel.writeFloat(prix);
        parcel.writeString(description);
        parcel.writeInt(note);
        parcel.writeString(website);
        parcel.writeByte((byte) (dejaAchete ? 1 : 0));
    }
}
