package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    TextView TotalPrecioProductos;
    ArrayList<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantidad_productos);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TotalPrecioProductos = findViewById(R.id.TotalPrecioProductosTextView);


        productos = (ArrayList<Producto>) getIntent().getExtras().getSerializable("productos");
        Bundle bundle = new Bundle();
        bundle.putSerializable("productos",productos);


        //cargando fragmento

        fragment = new CantidadProductosFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.LayoutCantidadProducto,fragment).commit();

        generarFacturaButton = findViewById(R.id.GenerarFacturaFinalButton);
        empleadoController = new EmpleadoController();

        //empleadoController.calcularTotal(productos);
        TotalPrecioProductos.setText(String.valueOf(empleadoController.calcularTotal(productos)));
        generarFacturaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar();
            }
        });

    }


    private   void comprobar(){
        cantidadProductoAdapter = fragment.getAdapter();
        empleadoController.comprobarCantidadesVacio(this,cantidadProductoAdapter);

    }

    public void cantidadesVacio(){

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Error")
                .setMessage("Algún campo de cantidad está vacio o negativo, por favor ingrese un valor válido para el campo correspondiente")
                //.setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();

    }

    public void sinExistenciasSuficientes(){

    }

    public void cantidadesCorrecto(){

        if (empleadoController.comprobarCantidadesDisponibles(this,cantidadProductoAdapter,productos)){
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
            builder.setTitle("Error")
                    .setMessage("No hay existencias suficientes para algún producto, por favor verifique las cantidades")
                    //.setCancelable(false)
                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }


                    })
                    .show();
        }
        else {
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
            builder.setTitle("Compra Realizada")
                    .setMessage("Su compra ha sido realizada, la factura se enviará a su correo electrónico")
                    //.setCancelable(false)
                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            volverMenuPrincipal();
                        }


                    })
                    .show();
        }





    }

     void volverMenuPrincipal(){
        Intent newActivity = new Intent(this, EmpleadoActivity.class);
        startActivity(newActivity);
        finish();
    }
}