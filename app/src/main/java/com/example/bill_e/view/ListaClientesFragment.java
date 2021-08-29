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

import java.util.ArrayList;
import java.util.List;


public class ListaClientesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerListaClientes;
    private ClienteAdapter adapterCliente;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaClientesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaClientesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaClientesFragment newInstance(String param1, String param2) {
        ListaClientesFragment fragment = new ListaClientesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_lista_clientes, container, false);
        recyclerListaClientes = vista.findViewById(R.id.recyclerListaClientes);
        recyclerListaClientes.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> listaElementos = new ArrayList<>();

        for(int i = 0; i<10;i++){
            listaElementos.add("Hola"+i);
        }

        adapterCliente = new ClienteAdapter(listaElementos,getContext());
        recyclerListaClientes.setAdapter(adapterCliente);

        return vista;
    }
}