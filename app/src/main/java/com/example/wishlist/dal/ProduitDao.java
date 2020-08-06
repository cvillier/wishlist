package com.example.wishlist.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wishlist.bo.Produit;

import java.util.List;

/**
 * Une classe pour donner les consignes nécessaires à ROOM pour qu'il puisse créer la DAO pour la table Produit
 */
@Dao
public interface ProduitDao {

    @Insert
    void insert(Produit produit);

    @Query("SELECT * FROM Produit")
    LiveData<List<Produit>> get();

    @Query("SELECT * FROM Produit WHERE id = :id")
    Produit get(int id);

    @Update
    void update(Produit produit);

    @Delete
    void delete(Produit produit);

    @Query("DELETE FROM Produit")
    void deleteAll();

}
