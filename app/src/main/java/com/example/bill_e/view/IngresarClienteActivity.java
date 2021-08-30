package com.example.bill_e.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bill_e.R;
import com.example.bill_e.controller.IngresarClienteController;
import com.example.bill_e.model.pojo.Cliente;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class IngresarClienteActivity extends AppCompatActivity {

    EditText documento, telefono, direccion, pais, departamento,municipio, codigoPostal, nombre, apellidos, razónSocial, Rut;
    Spinner TipoDocumento;
    CheckBox persona, empresa;
    Button ingresarCliente;
    IngresarClienteController ingresarClienteController;
    String tipodocumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_cliente);
        telefono = findViewById(R.id.TelefonoTextNumber);
        direccion = findViewById(R.id.DireccionTextNumber);
        pais = findViewById(R.id.PaisTextNumber);
        departamento = findViewById(R.id.DepartamentoTextNumber);
        municipio = findViewById(R.id.MunicipioTextNumber);
        codigoPostal = findViewById(R.id.CodigoPostalTextNumber);
        nombre = findViewById(R.id.NombreTextNumber);
        apellidos = findViewById(R.id.ApellidosTextNumber);
        razónSocial = findViewById(R.id.RazonSocialTextNumber);
        Rut = findViewById(R.id.RutTextNumber);
        documento = findViewById(R.id.DocumentoTextNumber);
        TipoDocumento = findViewById(R.id.spinner2);
        persona = findViewById(R.id.PersonacheckBox);
        empresa = findViewById(R.id.EmpresacheckBox);
        ingresarCliente = findViewById(R.id.IngresarClientefinalButton);
        ingresarClienteController = new IngresarClienteController();

        String[] valores = {"C.C","T.I"};
        TipoDocumento.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        TipoDocumento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               tipodocumento = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),tipodocumento,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });


        ingresarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar();
            }
        });



    }

    void comprobar(){

        String documentoT =  documento.getText().toString();
        String telefonoT =  telefono.getText().toString();
        String direccionT =  direccion.getText().toString();
        String paisT =  pais.getText().toString();
        String departamentoT =  departamento.getText().toString();
        String municipioT =  municipio.getText().toString();
        String codigoT =  codigoPostal.getText().toString();
        String NombreT =  nombre.getText().toString();
        String ApellidosT =  apellidos.getText().toString();
        String RazonT =  razónSocial.getText().toString();
        String Rutt =  Rut.getText().toString();
        Cliente cliente = new Cliente();
        cliente.setRut(Rutt);
        cliente.setRazonsocial(RazonT);
        cliente.setApellidos(ApellidosT);
        cliente.setNombre(NombreT);
        cliente.setDocumentoidentidad(documentoT);
        cliente.setTelefono(telefonoT);
        cliente.setDireccion(direccionT);
        cliente.setPais(paisT);
        cliente.setDepartamento(departamentoT);
        cliente.setMunicipio(municipioT);
        cliente.setCodigopostal(codigoT);
        cliente.setTipodocumento(tipodocumento);

        ingresarClienteController.comprobarCliente(this,cliente);

    }

    public void exito(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Correcto")
                .setMessage("Cliente creado correctamente")
                //.setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        menuprincipal();
                    }
                })
                .show();




    }

    public void menuprincipal(){
        Intent newActivity = new Intent(this, EmpleadoActivity.class);
        startActivity(newActivity);
        finish();
    }

}


