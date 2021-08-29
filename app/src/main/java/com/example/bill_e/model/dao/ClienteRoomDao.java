package com.example.bill_e.model.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bill_e.model.pojo.Cliente;

import java.util.List;

@Dao
public interface ClienteRoomDao {

    @Query("SELECT * FROM Cliente")
    List<Cliente> getAll();


    @Insert
    void insertOne(Cliente cliente);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateOne(Cliente cliente);

    //Ejemplo para eliminar-actualizar varios.
    @Update
    void updateList(List<Cliente> clientes);


    @Delete
    void deleteOne(Cliente cliente);


}
