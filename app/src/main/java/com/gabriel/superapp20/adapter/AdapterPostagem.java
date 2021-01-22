package com.gabriel.superapp20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gabriel.superapp20.R;
import com.gabriel.superapp20.model.Postagem;

import java.util.List;

public class AdapterPostagem extends RecyclerView.Adapter<AdapterPostagem.MyViewHolder> {

    private List<Postagem> listaPostagens;

    public AdapterPostagem(List<Postagem> listaPostagens) {
        this.listaPostagens = listaPostagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_cardview, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Postagem postagem = listaPostagens.get(position);

        holder.textNome.setText(postagem.getNome());
        holder.textLegenda.setText(postagem.getLegenda());
        holder.imagePostagem.setImageResource(postagem.getImagem());
    }

    @Override
    public int getItemCount() {
        return listaPostagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textNome, textLegenda;
        private ImageView imagePostagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textNome = itemView.findViewById(R.id.textNome);
            textLegenda = itemView.findViewById(R.id.textLegenda);
            imagePostagem = itemView.findViewById(R.id.imagePostagem);
        }
    }
}
