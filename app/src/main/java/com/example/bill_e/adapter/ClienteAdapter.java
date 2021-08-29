package com.example.bill_e.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bill_e.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.viewHolder>{

    private List<String> listaClientes; //por ahora de tipo string para pasar un dato, cuando se implemente la parte de model se cambio a tipo cliente.
    private Context context;
    private int position = -1;

    public ClienteAdapter(List<String> listaClientes, Context context) {
        this.listaClientes = listaClientes;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjetaclientes,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.nombres.setText(listaClientes.get(position));
        //holder.apellidos.setText("Nuevo Apellido");
        //holder.cedula.setText("123456");

        holder.bind();
    }

    public void comprobarPosicion(viewHolder holder){

        if (position != holder.getAdapterPosition()) {
            notifyItemChanged(position);
            position = holder.getAdapterPosition();
        }

    }



    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public   class  viewHolder extends RecyclerView.ViewHolder{

        private TextView nombres,apellidos,cedula;
        private MaterialCardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombres = itemView.findViewById(R.id.NombresListaClientesTextView);
            apellidos = itemView.findViewById(R.id.ApellidosListaClientesTextView);
            cedula = itemView.findViewById(R.id.CedulaListaClientesTextView);
            cardView = itemView.findViewById(R.id.TarjetaClienteCardView);

        }

        void bind(){
            if (position == -1){
                cardView.setChecked(false);
            }else {
                if (position == getAdapterPosition()){
                    cardView.setChecked(true);
                }else {
                    cardView.setChecked(false);
                }
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cardView.setChecked(true);

                    if (position != getAdapterPosition()){
                        notifyItemChanged(position);
                        position = getAdapterPosition();
                    }

                }
            });
        }
    }

}
