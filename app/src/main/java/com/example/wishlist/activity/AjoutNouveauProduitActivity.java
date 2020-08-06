package com.example.wishlist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.wishlist.R;
import com.example.wishlist.bo.Produit;
import com.example.wishlist.repository.IProduitRepository;
import com.example.wishlist.repository.ProduitBddRepository;

public class AjoutNouveauProduitActivity extends AppCompatActivity {

    Context context = this;
    private ListView maListe = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_nouveau_produit);
    }

    /**
     * Pour enregistrer le produit en bdd
     * @param view
     */
    public void onClickEnregistrerAjouterProduit(View view) {

        EditText etNom = findViewById(R.id.et_ajouter_nom_produit);
        String nom = etNom.getText().toString();

        EditText etPrix = findViewById(R.id.et_ajouter_prix_produit);
        Float prix = Float.valueOf(etPrix.getText().toString());

        EditText etDescription = findViewById(R.id.et_ajouter_description_produit);
        String description = etDescription.getText().toString();

        EditText etWebSite = findViewById(R.id.et_ajouter_website_produit);
        String website = etWebSite.getText().toString();

        RatingBar rbNote = findViewById(R.id.rb_detail_note_produit);
        int note = (int) rbNote.getRating();

        ToggleButton tgDejaAchete = findViewById(R.id.tgbt_ajouter_dejaAchete_produit);
        Boolean dejaAchete = tgDejaAchete.isChecked();

        //l'objet Produit a été hydraté avec les données récupérées dans les EditText
        Produit produitAAjouter = new Produit(0,nom,prix,description,note,website,dejaAchete);

        //enregistrement en bdd
        IProduitRepository repoProduit = new ProduitBddRepository(this);
        repoProduit.insert(produitAAjouter);


        //affiche un msg si le produit est bien enregistré
        Toast.makeText(context,"Produit enregistré !",Toast.LENGTH_LONG).show();
        //retour à la page de liste (le msg est transmis malgré le changement de page)
        Intent intent = new Intent(context, AffichageListeProduitActivity.class);
        startActivity(intent);

    }
}