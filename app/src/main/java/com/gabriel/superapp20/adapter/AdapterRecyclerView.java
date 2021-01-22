package com.gabriel.superapp20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gabriel.superapp20.R;
import com.gabriel.superapp20.model.Filme;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder> {

    private List<Filme> listaFilmes;

    public AdapterRecyclerView(List<Filme> listaFilmes) {

        this.listaFilmes = listaFilmes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_adapter_recyclerview, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = listaFilmes.get(position);

        holder.textTitulo.setText(filme.getTitulo());
        holder.textAno.setText(filme.getAno());
        holder.textGenero.setText(filme.getGenero());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textTitulo, textAno, textGenero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitulo = itemView.findViewById(R.id.textTitulo);
            textAno = itemView.findViewById(R.id.textAno);
            textGenero = itemView.findViewById(R.id.textGenero);
        }
    }

}
