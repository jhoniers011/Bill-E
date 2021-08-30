package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bill_e.R;
import com.example.bill_e.adapter.ProductoAdapter;
import com.example.bill_e.controller.EmpleadoController;
import com.example.bill_e.model.pojo.Cliente;
import com.example.bill_e.model.pojo.Producto;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RealizarVentaActivity extends AppCompatActivity {

    Button BotonSiguienteRealizarVenta;
    EmpleadoController empleadoController;
    ListaProductosFragment fragment;
    ProductoAdapter productoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_venta);

        //cargando fragmento

        fragment = new ListaProductosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layoutfragmentRealizarVenta,fragment).commit();


        BotonSiguienteRealizarVenta = findViewById(R.id.RealizarVentasiguienteButton);
        empleadoController = new EmpleadoController();

        BotonSiguienteRealizarVenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Comprobar();

            }
        });

    }

    public void Comprobar(){

        productoAdapter = fragment.getAdapterProducto();
        empleadoController.comprobarSeleccionarProducto(this,productoAdapter);
    }

    public void ComprobadoExito(){
        Intent newActivity = new Intent(this, CantidadProductosActivity.class);
        Bundle datosafragment = new Bundle();
        Cliente cliente = (Cliente) getIntent().getExtras().getSerializable("cliente");
        newActivity.putExtra("clienteproductos",cliente);
        ArrayList<Producto> lista = productoAdapter.getSelectedItems();
        datosafragment.putSerializable("productos",lista);
        //newActivity.putExtra("productos", (Serializable) lista);
        startActivity(newActivity);
        finish();
    }

    public void noSeleccionado(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Error")
                .setMessage("Debes seleccionar por lo menos un producto")
                //.setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();

    }



}