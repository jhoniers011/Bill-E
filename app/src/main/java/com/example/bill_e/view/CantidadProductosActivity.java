package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bill_e.R;

public class CantidadProductosActivity extends AppCompatActivity {

    ListaProductosFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantidad_productos);

        //cargando fragmento

        fragment = new ListaProductosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layoutfragmentRealizarVenta,fragment).commit();
    }
}