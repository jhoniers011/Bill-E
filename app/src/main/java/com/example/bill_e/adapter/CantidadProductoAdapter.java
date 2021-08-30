package com.example.bill_e.adapter;

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

import java.util.List;

public class CantidadProductoAdapter extends RecyclerView.Adapter<CantidadProductoAdapter.viewHolder> {

    List<Producto> listaProductos;

    public CantidadProductoAdapter(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
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
        }
    }

}