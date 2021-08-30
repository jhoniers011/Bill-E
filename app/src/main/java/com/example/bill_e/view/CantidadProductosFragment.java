package com.example.bill_e.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bill_e.R;
import com.example.bill_e.adapter.CantidadProductoAdapter;
import com.example.bill_e.adapter.ProductoAdapter;
import com.example.bill_e.controller.EmpleadoController;
import com.example.bill_e.model.pojo.Producto;

import java.util.ArrayList;
import java.util.List;


public class CantidadProductosFragment extends Fragment {

    private RecyclerView recyclerCantidadProductos;
    private CantidadProductoAdapter adapterCantidadProducto;
    private EmpleadoController empleadoController;

    public CantidadProductosFragment() {
        // Required empty public constructor
    }


    public static CantidadProductosFragment newInstance(String param1, String param2) {
        CantidadProductosFragment fragment = new CantidadProductosFragment();

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
        View view = inflater.inflate(R.layout.fragment_cantidad_productos, container, false);

        recyclerCantidadProductos = view.findViewById(R.id.recyclercantidadProductos);
        recyclerCantidadProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        empleadoController = new EmpleadoController();

        ArrayList<Producto> ListaProducto = (ArrayList<Producto>) getArguments().getSerializable("productos");
        adapterCantidadProducto = new CantidadProductoAdapter(ListaProducto);
        recyclerCantidadProductos.setAdapter(adapterCantidadProducto);

        return view;
    }

    public CantidadProductoAdapter getAdapter(){
        return adapterCantidadProducto;
    }
}