package com.example.bill_e.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bill_e.R;
import com.example.bill_e.model.pojo.Cliente;
import com.example.bill_e.model.pojo.Producto;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.viewHolder>{


    private List<Producto> listaproductos;
    private Context context;


    public ProductoAdapter(List<Producto> Listaproductos,Context context) {
        this.listaproductos = Listaproductos;
        this.context = context;
    }

    public void setProducto(List<Producto> productos){
            this.listaproductos = new ArrayList<>();
            this.listaproductos = productos;
            notifyDataSetChanged();
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjetaproductos,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.nombre.setText(listaproductos.get(position).getNombre());
        holder.codigo.setText(Integer.toString(listaproductos.get(position).getCodigo_barras()));
        holder.cantidad.setText("Cantiodad: "+ Integer.toString(listaproductos.get(position).getCantidad()));

    }


    @Override
    public int getItemCount() {
        return listaproductos.size();
    }

    public   class  viewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,cantidad,codigo;
        private MaterialCardView cardView;




        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.NombreListaProductosTextView);
            cantidad = itemView.findViewById(R.id.CantidadDisponibleTextView);
            codigo = itemView.findViewById(R.id.CodigoListaProductosTextView);
            cardView = itemView.findViewById(R.id.TarjetaProductoCardView);

        }




    }


}
