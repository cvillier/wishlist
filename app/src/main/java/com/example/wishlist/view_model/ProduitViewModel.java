package com.example.wishlist.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wishlist.bo.Produit;
import com.example.wishlist.repository.IProduitRepository;
import com.example.wishlist.repository.ProduitBddRepository;

import java.util.List;

public class ProduitViewModel extends AndroidViewModel {

    IProduitRepository repo;

    /**
     * Permet de n'avoir qu'un seul observateur pour toute l'application
     */
    LiveData<List<Produit>> observateur = null;


    public ProduitViewModel(@NonNull Application application) {
        super(application);
        repo = new ProduitBddRepository(application);
        observateur =  repo.get();
    }

    public LiveData<List<Produit>> getObservateur()
    {
        return observateur;
    }

    void insert(Produit produit)
    {
        repo.insert(produit);
    }

    void update(Produit produit)
    {
        repo.update(produit);
    }

    void delete(Produit produit)
    {
        repo.delete(produit);
    }

    void deleteAll()
    {
        repo.deleteAll();
    }

}
