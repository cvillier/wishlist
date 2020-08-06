package com.example.wishlist.dal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.wishlist.bo.Produit;

@Database(entities = {Produit.class}, exportSchema = false, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase INSTANCE;

    /**
     * Permet de fournir une instance de la DAO Utilisateur aux couches supérieures.
     * @return
     */
    public abstract ProduitDao getProduitDao();

    public static AppDataBase getINSTANCE(Context context)
    {
        //SINGLETON POUR LA CONNEXION
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context, AppDataBase.class, "wishlist_DB.db").build();
        }
        return INSTANCE;
    }
}
