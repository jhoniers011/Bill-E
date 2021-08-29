package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bill_e.R;

public class SeleccionarClienteActivity extends AppCompatActivity {

    Button botonsiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_cliente);

        //cargando fragmento

        Fragment fragment = new ListaClientesFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layoutfragment,fragment).commit();


        botonsiguiente = findViewById(R.id.SiguienteSeleccionarClienteButton);
        botonsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComprobarAlgo();
            }
        });
    }


    private void ComprobarAlgo(){
        Intent newActivity = new Intent(this, RealizarVentaActivity.class);
        startActivity(newActivity);
        finish();
    }


}