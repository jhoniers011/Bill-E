package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bill_e.R;
import com.example.bill_e.adapter.CantidadProductoAdapter;
import com.example.bill_e.model.pojo.Producto;

import java.util.ArrayList;

public class CantidadProductosActivity extends AppCompatActivity {

    CantidadProductosFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantidad_productos);

        //cargando fragmento

        fragment = new CantidadProductosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.LayoutCantidadProducto,fragment).commit();

        //ArrayList<Producto> lista = (ArrayList<Producto>) getIntent().getExtras().getSerializable("productos");
    }
}