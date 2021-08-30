package com.example.bill_e.controller;

import android.app.Activity;
import android.content.Context;

import com.example.bill_e.model.LocalStorage;
import com.example.bill_e.model.dao.ProductoRoomDao;
import com.example.bill_e.model.pojo.Producto;
import com.example.bill_e.view.IngresarProductoActivity;

public class IngresarProductoController {

    private ProductoRoomDao productoRoomDao;


    public void comprobarIngresarProducto(IngresarProductoActivity activity, String nombre, String precio, String costo, String cantidad, String iva, String marca, String descripcion){

        if (nombre.compareTo("") == 0 || precio.compareTo("") == 0 || costo.compareTo("") == 0 || cantidad.compareTo("") == 0 || iva.compareTo("") == 0 || marca.compareTo("") == 0 || descripcion.compareTo("") == 0){
            activity.vacio();
            return;
        }


        this.productoRoomDao = LocalStorage.getLocalStorage(activity.getApplicationContext()).productoRoomDao();
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setIva(Integer.parseInt(iva));
        producto.setPrecio(Integer.parseInt(precio));
        producto.setCosto(Integer.parseInt(costo));
        producto.setCantidad(Integer.parseInt(cantidad));
        producto.setMarca(marca);
        producto.setDescripcion(descripcion);

        this.productoRoomDao.insertOne(producto);

        activity.correcto();


    }

}
