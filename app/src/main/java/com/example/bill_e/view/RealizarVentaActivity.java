package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bill_e.R;

public class RealizarVentaActivity extends AppCompatActivity {

    Button BotonSiguienteRealizarVenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_venta);

        //cargando fragmento

        Fragment fragment = new ListaProductosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layoutfragmentRealizarVenta,fragment).commit();


        BotonSiguienteRealizarVenta = findViewById(R.id.RealizarVentasiguienteButton);

        BotonSiguienteRealizarVenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Comprobar();

            }
        });

    }

    public void Comprobar(){
        Intent newActivity = new Intent(this, CantidadProductosActivity.class);
        startActivity(newActivity);
        finish();
    }


}