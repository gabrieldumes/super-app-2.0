package com.gabriel.superapp20.ui.cardview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gabriel.superapp20.R;
import com.gabriel.superapp20.adapter.AdapterPostagem;
import com.gabriel.superapp20.model.Postagem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Postagem> listaPostagens = new ArrayList<>();

    public CardViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_view, container, false);

        recyclerView = view.findViewById(R.id.recyclerPostagem);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        criarPostagens();

        AdapterPostagem adapter = new AdapterPostagem(listaPostagens);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void criarPostagens() {

        Postagem postagem = new Postagem("Julie Mak", "Como não amar? #countryside", R.drawable.countryside);
        listaPostagens.add(postagem);

        postagem = new Postagem("Concessionária Litoral", "Agende seu testdrive!", R.drawable.car);
        listaPostagens.add(postagem);

        postagem = new Postagem("Peter Higgs", "Tá aí a foto do bóson que vocês pediram #cern", R.drawable.boson);
        listaPostagens.add(postagem);

        postagem = new Postagem("Ana Luíza Astrofotografia", "O céu estava lindo hoje <3", R.drawable.stars);
        listaPostagens.add(postagem);

        postagem = new Postagem("Xavier Porto", "#arquitetura", R.drawable.arch);
        listaPostagens.add(postagem);
    }
}
