package com.example.wishlist.repository;

import androidx.lifecycle.LiveData;

import com.example.wishlist.bo.Produit;

import java.util.List;

/**
 * Interface permettant de mettre en place le design pattern DAO
 */
public interface IProduitRepository
{
    void insert(Produit produit);

    LiveData<List<Produit>> get();

    Produit get(int id);

    void update(Produit produit);

    void delete(Produit produit);

    void deleteAll();
}