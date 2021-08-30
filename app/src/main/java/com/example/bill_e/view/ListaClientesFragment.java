package com.example.bill_e.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bill_e.R;
import com.example.bill_e.adapter.ClienteAdapter;
import com.example.bill_e.controller.EmpleadoController;
import com.example.bill_e.model.pojo.Cliente;

import java.util.ArrayList;
import java.util.List;


public class ListaClientesFragment extends Fragment {


    private RecyclerView recyclerListaClientes;
    private ClienteAdapter adapterCliente;
    private EmpleadoController empleadoController;



    public ListaClientesFragment() {
        // Required empty public constructor
    }



    public static ListaClientesFragment newInstance(String param1, String param2) {
        ListaClientesFragment fragment = new ListaClientesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_lista_clientes, container, false);
        recyclerListaClientes = vista.findViewById(R.id.recyclerListaClientes);
        recyclerListaClientes.setLayoutManager(new LinearLayoutManager(getContext()));
        empleadoController = new EmpleadoController();


        List<Cliente> ListaClientes = new ArrayList<>();
        ListaClientes =  empleadoController.listarClientes(getContext());


        adapterCliente = new ClienteAdapter(ListaClientes,getContext());
        recyclerListaClientes.setAdapter(adapterCliente);

        return vista;
    }

    public ClienteAdapter getAdapterCliente() {
        return adapterCliente;
    }
}