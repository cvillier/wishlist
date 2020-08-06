package com.example.wishlist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wishlist.R;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    /**
     * Première fonction appelée dans le cycle de vie de l'activité.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        //charge l'IHM
        setContentView(R.layout.activity_main);
    }

    public void onClickLienVersListe(View view) {
        Intent intent = new Intent(this,AffichageListeProduitActivity.class);
        startActivity(intent);
    }

    public void onClickLienVersAjoutProduit(View view) {
        Intent intent = new Intent(this,AjoutNouveauProduitActivity.class);
        startActivity(intent);
    }
}