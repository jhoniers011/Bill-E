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
import com.example.bill_e.adapter.ProductoAdapter;
import com.example.bill_e.controller.EmpleadoController;
import com.example.bill_e.model.pojo.Cliente;
import com.example.bill_e.model.pojo.Producto;

import java.util.ArrayList;
import java.util.List;


public class ListaProductosFragment extends Fragment {


    private RecyclerView recyclerListaProductos;
    private ProductoAdapter adapterProducto;
    private EmpleadoController empleadoController;

    public ListaProductosFragment() {
        // Required empty public constructor
    }

    public static ListaProductosFragment newInstance(String param1, String param2) {
        ListaProductosFragment fragment = new ListaProductosFragment();

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
        View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);
        recyclerListaProductos = view.findViewById(R.id.recyclerListaProductos);
        recyclerListaProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        empleadoController = new EmpleadoController();

        ArrayList<Producto> ListaProducto = new ArrayList<>();
        ListaProducto = (ArrayList<Producto>) empleadoController.listarProductos(getContext());

        adapterProducto = new ProductoAdapter(ListaProducto,getContext());
        recyclerListaProductos.setAdapter(adapterProducto);

        return view;
    }

    public ProductoAdapter getAdapterProducto(){
        return adapterProducto;
    }
}