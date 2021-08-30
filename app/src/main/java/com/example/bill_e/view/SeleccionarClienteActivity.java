package com.example.bill_e.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.bill_e.R;
import com.example.bill_e.adapter.ClienteAdapter;
import com.example.bill_e.controller.EmpleadoController;
import com.example.bill_e.model.pojo.Cliente;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class SeleccionarClienteActivity extends AppCompatActivity {

    Button botonsiguiente,botonseleccionarcliente;
    EmpleadoController empleadoController;
    RecyclerView recyclerViewSeleccionarCliente;
    ClienteAdapter clienteAdapter;
    ListaClientesFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_cliente);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //cargando fragmento

        fragment = new ListaClientesFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layoutfragment,fragment).commit();


        botonsiguiente = findViewById(R.id.SiguienteSeleccionarClienteButton);
        botonseleccionarcliente = findViewById(R.id.IngresarClienteSeleccionarClienteButton);
        empleadoController = new EmpleadoController();
        botonsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Comprobar();

            }
        });

        botonseleccionarcliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirActivityIngresarCliente();
            }
        });
    }

    public void clienteNoSeleccionado(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Error")
                .setMessage("No se ha seleccionado ningún cliente, por favor seleccione uno para continuar")
                //.setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    public void correctoSiguiente(){
        Intent newActivity = new Intent(this, RealizarVentaActivity.class);
        newActivity.putExtra("cliente",  fragment.getAdapterCliente().getSelected());
        startActivity(newActivity);
        //finish();
    }


    private void Comprobar( ){
        SeleccionarClienteActivity activity1 = this;
        clienteAdapter = fragment.getAdapterCliente();
        empleadoController.comprobarSeleccionarCliente(activity1, clienteAdapter);

    }

    private void AbrirActivityIngresarCliente(){
        Intent newActivity = new Intent(this, IngresarClienteActivity.class);
        startActivity(newActivity);
        finish();
    }


}