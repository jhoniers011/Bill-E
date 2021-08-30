package com.example.bill_e.controller;

import com.example.bill_e.model.LocalStorage;
import com.example.bill_e.model.dao.ClienteRoomDao;
import com.example.bill_e.model.pojo.Cliente;
import com.example.bill_e.view.IngresarClienteActivity;

public class IngresarClienteController {

    private ClienteRoomDao clienteRoomDao;

     public void comprobarCliente(IngresarClienteActivity activity, Cliente cliente){
         this.clienteRoomDao = LocalStorage.getLocalStorage(activity.getApplicationContext()).clienteRoomDao();
         this.clienteRoomDao.insertOne(cliente);

         activity.exito();

    }
}
