package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bill_e.R;
import com.example.bill_e.controller.EmpleadoController;
import com.example.bill_e.model.LocalStorage;
import com.example.bill_e.model.dao.ClienteRoomDao;

public class EmpleadoActivity extends AppCompatActivity {

    private Button GenerarFacturaButton,IngresarProductoButton, IngresarClienteButton;
    private EmpleadoController ControllerEmpleado;
    private ClienteRoomDao clienteRoomDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GenerarFacturaButton = findViewById(R.id.GenerarFacturaButton);
        IngresarProductoButton = findViewById(R.id.IngresarProductoButton);
        IngresarClienteButton = findViewById(R.id.IngresarClienteButton);
        ControllerEmpleado = new EmpleadoController();

        ControllerEmpleado.llenarProductosyClientes(getApplicationContext());


        GenerarFacturaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexion();

            }
        });

        IngresarProductoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarIngresarProducto();
            }
        });

        IngresarClienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarIngresarCliente();
            }
        });

        //this.clienteRoomDao = LocalStorage.getLocalStorage(this.getApplicationContext()).clienteRoomDao();
        //this.clienteRoomDao.deleteAll();


    }

    private void conexion(){
        ControllerEmpleado.comprobarConexion(this);
    }

    public void conexionCorrecta(){
        Intent newActivity = new Intent(this, SeleccionarClienteActivity.class);
        startActivity(newActivity);
        //finish();
    }

    private void iniciarIngresarProducto(){
        Intent newActivity = new Intent(this, IngresarProductoActivity.class);
        startActivity(newActivity);
        //finish();
    }

    private  void iniciarIngresarCliente(){
        Intent newActivity = new Intent(this, IngresarClienteActivity.class);
        startActivity(newActivity);
        //finish();
    }


}