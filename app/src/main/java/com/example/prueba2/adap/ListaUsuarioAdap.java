package com.example.prueba2.adap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba2.R;
import com.example.prueba2.entidades.Usuario;

import java.util.ArrayList;

public class ListaUsuarioAdap extends RecyclerView.Adapter<ListaUsuarioAdap.UsuarioViewHolder> {

    ArrayList<Usuario> listaUsuarios;

    public ListaUsuarioAdap(ArrayList<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_usuarios, null, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {

        holder.viewNom.setText(listaUsuarios.get(position).getNombre());
        holder.viewPass.setText(listaUsuarios.get(position).getContra());

    }

    @Override
    public int getItemCount() {
       return listaUsuarios.size();

    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder {

        TextView viewNom, viewPass;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNom = itemView.findViewById(R.id.viewNom);
            viewPass = itemView.findViewById(R.id.viewPass);


        }
    }
}
