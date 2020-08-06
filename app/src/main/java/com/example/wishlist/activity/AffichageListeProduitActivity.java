package com.example.wishlist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.wishlist.R;
import com.example.wishlist.activity.adapter.ProduitAdapter;
import com.example.wishlist.bo.Produit;
import com.example.wishlist.view_model.ProduitViewModel;

import java.util.List;

public class AffichageListeProduitActivity extends AppCompatActivity {

    Context context = this;
    private ListView maListe = null;
    private List<Produit> produits = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_liste_produit);

        maListe = findViewById(R.id.listview_affichage_liste_produits);

        /**
         * affiche le détail d'un produit en cliquant dessus
         */
        maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //page de détail d'un produit
                Intent intent = new Intent(context, AffichageDetailProduitActivity.class);
                //envoyer l'objet sur lequel on vient de cliquer afin d'en afficher les détails
                intent.putExtra("produitAAfficher",produits.get(position));
                //y aller
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();

        ProduitViewModel vm = ViewModelProviders.of(this).get(ProduitViewModel.class);
        LiveData<List<Produit>> observateur = vm.getObservateur();

        observateur.observe(this, new Observer<List<Produit>>() {
            @Override
            public void onChanged(List<Produit> produits) {
                AffichageListeProduitActivity.this.produits = produits;
                maListe = findViewById(R.id.listview_affichage_liste_produits);
                ProduitAdapter adapter = new ProduitAdapter(context, R.layout.style_ligne_produit, produits);
                maListe.setAdapter(adapter);
            }
        });
    }

    public void onClicRetourAccueil(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}