package com.example.bill_e.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bill_e.model.pojo.Cliente;
import com.example.bill_e.model.pojo.Producto;

import java.util.List;

@Dao
public interface ProductoRoomDao {

    @Query("SELECT * FROM Producto")
    List<Producto> getAll();


    @Insert
    void insertOne(Producto producto);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateOne(Producto producto);

    //Ejemplo para eliminar-actualizar varios.
    @Update
    void updateList(List<Producto> productos);


    @Delete
    void deleteOne(Producto producto);

}
