package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bill_e.R;
import com.example.bill_e.controller.IngresarProductoController;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class IngresarProductoActivity extends AppCompatActivity {

    EditText nombre, precio,costo,cantidad,iva,marca,descripcion;
    Button ingresarProducto;
    IngresarProductoController ingresarProductoController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_producto);

        nombre = findViewById(R.id.NombreEditTextView);
        precio = findViewById(R.id.PrecioEditTextView);
        costo = findViewById(R.id.CostoEditTextView);
        cantidad = findViewById(R.id.CantidadEditTextView);
        iva = findViewById(R.id.IvaEditTextView);
        marca = findViewById(R.id.MarcaEditTextView);
        descripcion = findViewById(R.id.DescripcionEditTextView);
        ingresarProducto = findViewById(R.id.IngresarProductoFinalButton);
        ingresarProductoController = new IngresarProductoController();

        ingresarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar();
            }
        });


    }


    public void comprobar(){

        ingresarProductoController.comprobarIngresarProducto(this,nombre.getText().toString(),precio.getText().toString(),costo.getText().toString(),cantidad.getText().toString(),iva.getText().toString(),marca.getText().toString(),descripcion.getText().toString());
    }

    public void vacio(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Error")
                .setMessage("Hay algún campo  vacio, por favor verifica")
                //.setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    public void correcto(){

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Correcto")
                .setMessage("El producto se ingresó correctamente")
                //.setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();

        Intent newActivity = new Intent(this, EmpleadoActivity.class);
        startActivity(newActivity);
        finish();

    }
}