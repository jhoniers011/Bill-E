package com.example.bill_e.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bill_e.model.dao.ClienteRoomDao;
import com.example.bill_e.model.dao.ProductoRoomDao;
import com.example.bill_e.model.pojo.Cliente;
import com.example.bill_e.model.pojo.Producto;


    @Database(entities = {Cliente.class, Producto.class}, version = 1)
    public abstract class LocalStorage extends RoomDatabase {

        private static LocalStorage localStorage;
        public abstract ClienteRoomDao clienteRoomDao();
        public abstract ProductoRoomDao productoRoomDao();

        public static LocalStorage getLocalStorage(final Context context){
            if (localStorage == null){

                localStorage = Room.databaseBuilder(context,
                        LocalStorage.class,
                        "Bill-e-db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
            return localStorage;
        }

        public LocalStorage(){

        }

}
