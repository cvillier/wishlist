package com.example.wishlist.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wishlist.R;
import com.example.wishlist.bo.Produit;

import java.util.List;

public class ProduitAdapter extends ArrayAdapter<Produit>
{

    public ProduitAdapter(@NonNull Context context, int resource, @NonNull List<Produit> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //décompression du fichier style_ligne_produit.xml
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View nouvelleLigne = li.inflate(R.layout.style_ligne_produit, parent, false);

        //on met les données en ligne

        TextView tvNomProduit = nouvelleLigne.findViewById(R.id.tv_detail_ligne_nom_produit);
        tvNomProduit.setText(getItem(position).getNom());

        TextView tvPrix = nouvelleLigne.findViewById(R.id.tv_ligne_prix_produit);
        tvPrix.setText(Float.toString(getItem(position).getPrix())+" €");

        TextView tvDescription = nouvelleLigne.findViewById(R.id.tv_ligne_description_produit);
        tvDescription.setText(getItem(position).getDescription());

        RatingBar rbNote = nouvelleLigne.findViewById(R.id.rb_detail_note_produit);
        rbNote.setNumStars((int) getItem(position).getNote());

        return nouvelleLigne;
    }
}
