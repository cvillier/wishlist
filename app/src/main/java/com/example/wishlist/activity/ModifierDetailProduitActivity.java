package com.example.wishlist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.wishlist.R;
import com.example.wishlist.bo.Produit;
import com.example.wishlist.repository.IProduitRepository;
import com.example.wishlist.repository.ProduitBddRepository;

public class ModifierDetailProduitActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_detail_produit);

        final Produit produitRecupere = getIntent().getParcelableExtra("produitAModifier");

        EditText etNomProduit = findViewById(R.id.et_modifier_nom_produit);
        etNomProduit.setText(produitRecupere.getNom());

        EditText etModifPrix = findViewById(R.id.et_modifier_prix_produit);
        etModifPrix.setText(Float.toString(produitRecupere.getPrix()));

        EditText etModifDescription = findViewById(R.id.et_modifier_description_produit);
        etModifDescription.setText(produitRecupere.getDescription());

        EditText etModifWebSite = findViewById(R.id.et_modifier_website_produit);
        etModifWebSite.setText(produitRecupere.getWebsite());


    }

    /**
     * Enregistrement des modification apportées au profil
     * @param view
     */
    public void onClickEnregistrerModifierProduit(View view) {

        //on récupère le produit à modifier
        final Produit produitAModifier = getIntent().getParcelableExtra("produitAModifier");

        //on récupère les données
        EditText etNom = findViewById(R.id.et_modifier_nom_produit);
        String nom = etNom.getText().toString();
        produitAModifier.setNom(nom);

        EditText etPrix = findViewById(R.id.et_modifier_prix_produit);
        Float prix = Float.valueOf(etPrix.getText().toString());
        produitAModifier.setPrix(prix);

        EditText etDescription = findViewById(R.id.et_modifier_description_produit);
        String description = etDescription.getText().toString();
        produitAModifier.setDescription(description);

        EditText etWebSite = findViewById(R.id.et_modifier_website_produit);
        String website = etWebSite.getText().toString();
        produitAModifier.setWebsite(website);

        RatingBar rbNote = findViewById(R.id.rb_modifier_note_produit);
        int note = (int) rbNote.getRating();
        produitAModifier.setNote(note);

        ToggleButton tgDejaAchete = findViewById(R.id.tgbt_modifier_dejaAchete_produit);
        Boolean dejaAchete = tgDejaAchete.isChecked();
        produitAModifier.setDejaAchete(dejaAchete);

        //MAJ de la bdd
        IProduitRepository repoProduit = new ProduitBddRepository(this);
        repoProduit.update(produitAModifier);

        //affiche un msg pour prévenir que le produit est bien enregistré
        Toast.makeText(context,"Produit enregistré !",Toast.LENGTH_LONG).show();
        //retour à la page principale (le msg est transmis malgré le changement de page)
        Intent intent = new Intent(context, AffichageListeProduitActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);

    }
}