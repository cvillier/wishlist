package com.example.wishlist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.wishlist.R;
import com.example.wishlist.bo.Produit;
import com.example.wishlist.repository.IProduitRepository;
import com.example.wishlist.repository.ProduitBddRepository;


public class AffichageDetailProduitActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("coco", "arrivée onCreate de AffichageDetail");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_detail_produit);

        final Produit produitRecupere = getIntent().getParcelableExtra("produitAAfficher");


        TextView tvNomProduit = findViewById(R.id.tv_detail_ligne_nom_produit);
        tvNomProduit.setText(produitRecupere.getNom());

        TextView tvPrix = findViewById(R.id.tv_detail_prix_produit);
        tvPrix.setText(String.valueOf(produitRecupere.getPrix())+" €");


        TextView tvDescription = findViewById(R.id.tv_detail_description_produit);
        tvDescription.setText(produitRecupere.getDescription());

        RatingBar rbNote = findViewById(R.id.rb_detail_note_produit);
        rbNote.setNumStars(produitRecupere.getNote());

        TextView tvDejaAchete = findViewById(R.id.tv_detail_dejaAchete_produit);
        if (produitRecupere.isDejaAchete()) {
            tvDejaAchete.setText("DEJA ACHETE");
        } else {
            tvDejaAchete.setText("JAMAIS ACHETE");
        }


        // lien vers le site internet dans le détail d'un produit
        Button button = (Button)findViewById(R.id.btn_detail_website_produit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(produitRecupere.getWebsite()));
                startActivity(viewIntent);
            }
        });
    }

    /**
     * Mise à jour des données du produit sur lequel on clic
     * @param view
     */
    public void onClickModifierProduit(View view) {
        final Produit produitRecupere = getIntent().getParcelableExtra("produitAAfficher");
        Intent intent = new Intent(context, ModifierDetailProduitActivity.class);
        intent.putExtra("produitAModifier", produitRecupere);
        startActivity(intent);
    }

    /**
     * Suppression du produit sur lequel on clic
     * @param view
     */
    public void onClickSupprimerProduit(View view) {
        IProduitRepository repoProduit = new ProduitBddRepository(this);
        final Produit produitRecupere = getIntent().getParcelableExtra("produitAAfficher");

        repoProduit.delete(produitRecupere);
        Toast.makeText(this, "Produit supprimé !", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, AffichageListeProduitActivity.class);
        startActivity(intent);
    }

    /**
     * Retour à l'écran de liste
     * @param view
     */
    public void onClicRetourListe(View view) {
        Intent intent = new Intent(this, AffichageListeProduitActivity.class);
        startActivity(intent);
    }

    /**
     * Retour à l'écran d'accueil depuis le détail d'un produit
     * @param view
     */
    public void onClicRetourAccueil(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}