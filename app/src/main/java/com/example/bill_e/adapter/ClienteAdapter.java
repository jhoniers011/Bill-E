package com.example.bill_e.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bill_e.R;
import com.example.bill_e.model.pojo.Cliente;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.viewHolder>{

    private List<Cliente> listaClientes;
    private Context context;
    private int position = -1;

    public ClienteAdapter(List<Cliente> listaClientes, Context context) {
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

        if(listaClientes.get(position).getNombre().isEmpty()){
            holder.nombres.setText("Razón Social: "+listaClientes.get(position).getRazonsocial());
            holder.apellidos.setText( "Rut: " + listaClientes.get(position).getRut());
        }else {
            holder.nombres.setText("Nombres: " + listaClientes.get(position).getNombre());
            holder.apellidos.setText("Apellidos: " + listaClientes.get(position).getApellidos());
        }


        holder.cedula.setText(listaClientes.get(position).getDocumentoidentidad());
        if(listaClientes.get(position).getTipocliente().compareTo("Persona") == 0){
            holder.imagen.setImageResource(R.drawable.ic_baseline_person_24);
            holder.smallImage.setImageResource(R.drawable.ic_baseline_person_24);
            holder.tipoCliente.setText("Persona");
        }else {
            holder.imagen.setImageResource(R.drawable.ic_empresa);
            holder.smallImage.setImageResource(R.drawable.ic_empresa);
            holder.tipoCliente.setText("Empresa");
        }



        holder.bind();
    }
    public Cliente getSelected(){
        if (position != -1){
            return listaClientes.get(position);
        }
        return null;
    }

    public int getPosition(){return this.position;}


    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public   class  viewHolder extends RecyclerView.ViewHolder{

        private TextView nombres,apellidos,cedula,tipoCliente;
        private MaterialCardView cardView;
        private ImageView imagen,smallImage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombres = itemView.findViewById(R.id.NombreCantidadProductoTextView);
            apellidos = itemView.findViewById(R.id.CodigoCantidadProductoTextView);
            cedula = itemView.findViewById(R.id.PrecioCantidadProductoTextView);
            cardView = itemView.findViewById(R.id.TarjetaClienteCardView);
            imagen = itemView.findViewById(R.id.fotoproductocantidad);
            smallImage = itemView.findViewById(R.id.imageCliente);
            tipoCliente = itemView.findViewById(R.id.TipoClienteTextView);

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
