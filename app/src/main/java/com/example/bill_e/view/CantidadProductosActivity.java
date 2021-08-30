package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bill_e.R;
import com.example.bill_e.adapter.CantidadProductoAdapter;
import com.example.bill_e.controller.EmpleadoController;
import com.example.bill_e.model.pojo.Producto;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class CantidadProductosActivity extends AppCompatActivity {

    CantidadProductosFragment fragment;
    Button generarFacturaButton;
    EmpleadoController empleadoController;
    CantidadProductoAdapter cantidadProductoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantidad_productos);


        ArrayList<Producto> productos = (ArrayList<Producto>) getIntent().getExtras().getSerializable("productos");
        Bundle bundle = new Bundle();
        bundle.putSerializable("productos",productos);


        //cargando fragmento

        fragment = new CantidadProductosFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.LayoutCantidadProducto,fragment).commit();

        generarFacturaButton = findViewById(R.id.GenerarFacturaFinalButton);
        empleadoController = new EmpleadoController();

        generarFacturaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar();
            }
        });

    }


    private   void comprobar(){
        cantidadProductoAdapter = fragment.getAdapter();
        empleadoController.comprobarCantidades(this,cantidadProductoAdapter);

    }

    public void cantidadesVacio(){

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Error")
                .setMessage("Hay algún campo cantidad vacio, por favor llenalo")
                //.setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();

    }

    public void cantidadesCorrecto(){

            String texto = "";
            ArrayList<Integer> cantidades = cantidadProductoAdapter.getCantidades();
            for (int i=0; i<cantidades.size();i++){
                texto = texto + cantidades.get(i).toString();
            }
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Error")
                .setMessage(texto)
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