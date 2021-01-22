package com.gabriel.superapp20.ui.noticias;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gabriel.superapp20.R;
import com.gabriel.superapp20.model.Artigo;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends Fragment {

    private ImageView imagem;
    private TextView textTitulo, textData, textArtigo, textAutor;
    private Button botaoAnterior, botaoProximo;
    private List<Artigo> listaArtigos = new ArrayList<>();
    private int numeroArtigo;

    public NoticiasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_noticias, container, false);

        imagem = view.findViewById(R.id.imageArtigo);

        textTitulo = view.findViewById(R.id.textTitulo);
        textData = view.findViewById(R.id.textData);
        textArtigo = view.findViewById(R.id.textArtigo);
        textAutor = view.findViewById(R.id.textAutor);

        botaoAnterior = view.findViewById(R.id.buttonAnterior);
        botaoProximo = view.findViewById(R.id.buttonProximo);

        configuraBotaoProximo();
        configuraBotaoAnterior();

        criarArtigos();

        definirArtigo(0);

        return view;
    }

    public void configuraBotaoAnterior() {

        botaoAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numeroArtigo == 0) {
                    Toast.makeText(getContext(), "Este é o primeiro artigo", Toast.LENGTH_SHORT).show();
                } else {
                    definirArtigo(numeroArtigo - 1);
                }
            }
        });
    }

    public void configuraBotaoProximo() {

        botaoProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numeroArtigo == listaArtigos.size() - 1) {
                    Toast.makeText(getContext(), "Este é o último artigo", Toast.LENGTH_SHORT).show();
                } else {
                    definirArtigo(numeroArtigo + 1);
                }
            }
        });
    }

    public void criarArtigos() {

        Artigo artigo = new Artigo("Artigo 1: Stars", "17/05/2020", "", "Matthew Olsen", R.drawable.stars);
        artigo.setArtigo(getResources().getString(R.string.artigo_stars));
        listaArtigos.add(artigo);

        artigo = new Artigo("Artigo 2: Bóson", "08/09/2016", "", "Lauren Bunch", R.drawable.boson);
        artigo.setArtigo(getResources().getString(R.string.artigo_boson));
        listaArtigos.add(artigo);

        artigo = new Artigo("Artigo 3: Arquitetura", "30/03/2021", "", "Mark Miller", R.drawable.arch);
        artigo.setArtigo(getResources().getString(R.string.artigo_arch));
        listaArtigos.add(artigo);

        artigo = new Artigo("Artigo 4: Carro", "25/06/2015", "", "Corie Thompson", R.drawable.car);
        artigo.setArtigo(getResources().getString(R.string.artigo_car));
        listaArtigos.add(artigo);

        artigo = new Artigo("Artigo 5: Countryside", "07/01/2017", "", "Phoebe Hendricks", R.drawable.countryside);
        artigo.setArtigo(getResources().getString(R.string.artigo_countryside));
        listaArtigos.add(artigo);
    }

    public void definirArtigo(int numeroArtigo) {

        Artigo artigo = listaArtigos.get(numeroArtigo);
        this.numeroArtigo = numeroArtigo;

        imagem.setImageResource(artigo.getImagem());
        textTitulo.setText(artigo.getTitulo());
        textData.setText(artigo.getData());
        textArtigo.setText(artigo.getArtigo());
        textAutor.setText(artigo.getAutor());
    }
}
