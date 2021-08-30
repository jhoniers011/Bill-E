package com.example.bill_e.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bill_e.R;
import com.example.bill_e.model.pojo.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CantidadProductoAdapter extends RecyclerView.Adapter<CantidadProductoAdapter.viewHolder> {

    private List<Producto> listaProductos;
    private ArrayList<Integer> cantidades;

    public CantidadProductoAdapter(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        cantidades = new ArrayList<Integer>(Collections.nCopies(listaProductos.size(),0));
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjetaproductoscantidad,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.nombre.setText(listaProductos.get(position).getNombre());
        holder.cantidad.setText(Integer.toString(listaProductos.get(position).getCantidad()));
        holder.precio.setText(Integer.toString(listaProductos.get(position).getPrecio()));
        holder.codigo.setText(Integer.toString(listaProductos.get(position).getPid()));

    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public   class  viewHolder extends RecyclerView.ViewHolder{

        private TextView nombre, precio,codigo;
        private CardView cardView;
        private EditText cantidad;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.NombreCantidadProductoTextView);
            precio = itemView.findViewById(R.id.PrecioCantidadProductoTextView);
            codigo = itemView.findViewById(R.id.CodigoCantidadProductoTextView);
            cardView = itemView.findViewById(R.id.recyclercantidadProductos);
            cantidad = itemView.findViewById(R.id.CantidadeditTextNumber);

            cantidad.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String aux = cantidad.getText().toString();
                    if (aux.compareTo("") == 0){
                        cantidades.set(getAdapterPosition(),null);
                    }else {
                        cantidades.set(getAdapterPosition(),Integer.parseInt(cantidad.getText().toString()));
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }

}
