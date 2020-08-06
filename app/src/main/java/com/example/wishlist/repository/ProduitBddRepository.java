package com.example.wishlist.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.wishlist.bo.Produit;
import com.example.wishlist.dal.AppDataBase;
import com.example.wishlist.dal.ProduitDao;

import java.util.List;

public class ProduitBddRepository implements IProduitRepository {

    private ProduitDao produitDao;

    List<Produit> resultat = null;

    public ProduitBddRepository(Context context)
    {
        //instance de la bdd
        AppDataBase maBaseDeDonnees = AppDataBase.getINSTANCE(context);

        //instance de la dao
        produitDao = maBaseDeDonnees.getProduitDao();
    }


    @SuppressWarnings("deprecation")
    @Override
    public void insert(Produit produit) {
        //création new thread
        new AsyncTask<Produit, Void,Void>(){
            //on lui dit quoi faire
            @Override
            protected Void doInBackground(Produit... produits) {
                produitDao.insert(produits[0]);
                return null;
            }//on lui dit de le faire
        }.execute(produit);

    }

    @Override
    public LiveData<List<Produit>> get() {
        return produitDao.get();
    }

    @Override
    public Produit get(final int id) {
        return produitDao.get(id);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void update(Produit produit) {

        new AsyncTask<Produit, Void, Produit>() {
            @Override
            protected Produit doInBackground(Produit... produits) {
                produitDao.update(produits[0]);
                return null;
            }
        }.execute(produit);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void delete(final Produit produit) {

        new AsyncTask<Produit, Void,Void >() {

            @Override
            protected Void doInBackground(Produit... produits) {
                produitDao.delete(produit);
                return null;
            }
        }.execute(produit);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void deleteAll() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                produitDao.deleteAll();
                return null;
            }
        }.execute();

    }
}
