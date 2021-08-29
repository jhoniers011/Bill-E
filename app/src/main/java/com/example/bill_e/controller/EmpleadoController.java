package com.example.bill_e.controller;

import android.content.Context;

import com.example.bill_e.model.LocalStorage;
import com.example.bill_e.model.dao.ClienteRoomDao;
import com.example.bill_e.model.dao.ProductoRoomDao;
import com.example.bill_e.model.pojo.Cliente;
import com.example.bill_e.view.EmpleadoActivity;

import java.util.List;

public class EmpleadoController {

    private ClienteRoomDao clienteRoomDao;
    private ProductoRoomDao productoRoomDao;


    public void comprobarConexion(EmpleadoActivity EmpleadoActivity){
        // Si hay conexión
        EmpleadoActivity.conexionCorrecta();

        // Si no hay conexión


    }

    //Inserta a la base de datos si está vacía una lista de productos y clientes por defecto
    public void llenarProductosyClientes(Context context){
        this.clienteRoomDao = LocalStorage.getLocalStorage(context).clienteRoomDao();
        List<Cliente> listaclientes = this.clienteRoomDao.getAll();

        if (listaclientes.size() <= 0){

            Cliente cliente1 = new Cliente();
            cliente1.setTipodocumento("C.C");
            cliente1.setDocumentoidentidad(1025897416);
            cliente1.setTelefono(4836574);
            cliente1.setEmail("alberto98@gmail.com");
            cliente1.setDireccion("Cra 38 # 26-78");
            cliente1.setPais("Colombia");
        }

    }


}
