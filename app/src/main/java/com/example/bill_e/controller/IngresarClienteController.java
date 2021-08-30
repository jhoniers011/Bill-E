package com.example.bill_e.controller;

import androidx.room.util.StringUtil;

import com.example.bill_e.model.LocalStorage;
import com.example.bill_e.model.dao.ClienteRoomDao;
import com.example.bill_e.model.pojo.Cliente;
import com.example.bill_e.view.IngresarClienteActivity;

import java.util.List;

public class IngresarClienteController {

    private ClienteRoomDao clienteRoomDao;

     public void comprobarCliente(IngresarClienteActivity activity, Cliente cliente,Boolean persona,Boolean empresa){

         if(!comprobarCamposVacios(cliente)){
             if (persona || empresa){
                 List<String> cedula;
                 try {
                     this.clienteRoomDao = LocalStorage.getLocalStorage(activity.getApplicationContext()).clienteRoomDao();
                     cedula = this.clienteRoomDao.findcedula(cliente.getDocumentoidentidad());
                 }catch (NullPointerException e){
                     cedula = null;
                 }

                 if (cedula.size() == 0){

                     this.clienteRoomDao = LocalStorage.getLocalStorage(activity.getApplicationContext()).clienteRoomDao();
                     this.clienteRoomDao.insertOne(cliente);

                     activity.exito();
                 }
                 else {
                    activity.documentoRepetido();
                 }

             }
             else {
                 activity.tipoClienteNoEspecificado();
             }
         }
         else {
             activity.campoVacio();
         }



    }


    private boolean comprobarCamposVacios(Cliente cliente){
         if (cliente.getDocumentoidentidad() != null && !cliente.getDocumentoidentidad().trim().isEmpty() && cliente.getTelefono() != null && !cliente.getTelefono().trim().isEmpty() && cliente.getDireccion() != null && !cliente.getDireccion().trim().isEmpty() && cliente.getPais() != null && !cliente.getPais().trim().isEmpty() && cliente.getDepartamento() != null && !cliente.getDepartamento().trim().isEmpty() && cliente.getMunicipio() != null && !cliente.getMunicipio().trim().isEmpty() && cliente.getCodigopostal() != null && !cliente.getCodigopostal().trim().isEmpty()){
             return false;
         }
         else {
             return true;
         }
    }
}
