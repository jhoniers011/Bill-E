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

    }


    public  void comprobar(){
        //Este metodo envia los datos de las cantidades de los productos al controlador.
        //seria un empleadoControlador.comprobarCantidades()
    }

    public void cantidadesVacio(){

        //Muestra un AlertDialog con un mensaje de error que hay algun campo cantidad vacio

    }

    public void cantidadesCorrecto(){
        //Muestra un mensaje en el que se dice que se envió la factura a la Dian y se le enviará a su correo electronico.
        //despues al darle ok al mensaje, vuelve al menu principal.
    }
}