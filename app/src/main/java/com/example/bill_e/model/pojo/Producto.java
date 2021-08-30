package com.example.bill_e.model.pojo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Producto implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int pid;
    private int codigo_barras;
    private String nombre;
    private int precio;
    private int costo;
    private int  cantidad;
    private int iva;
    private String marca;
    private  String descripcion;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(int codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int     costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
