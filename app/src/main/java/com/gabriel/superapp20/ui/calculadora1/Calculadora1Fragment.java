package com.gabriel.superapp20.ui.calculadora1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gabriel.superapp20.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Calculadora1Fragment extends Fragment {

    private EditText editPrimeiroValor, editSegundoValor;
    private Button buttonSomar;
    private TextView textResultado;

    public Calculadora1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculadora1, container, false);

        editPrimeiroValor = view.findViewById(R.id.editPrimeiroValor);
        editSegundoValor = view.findViewById(R.id.editSegundoValor);
        buttonSomar = view.findViewById(R.id.buttonSomar);
        textResultado = view.findViewById(R.id.textResultado);

        textResultado.setVisibility(View.INVISIBLE);

        somar();

        return view;
    }

    public void somar() {

        buttonSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                textResultado.setVisibility(View.INVISIBLE);

                //Verificar se os valores são válidos
                String valor1String = editPrimeiroValor.getText().toString();
                String valor2String = editSegundoValor.getText().toString();

                if (valor1String.equals("") || valor1String == null || valor1String.equals(".")) {
                    Toast.makeText(getActivity(), "Primeiro valor INVÁLIDO!", Toast.LENGTH_SHORT).show();
                } else if (valor2String.equals("") || valor2String == null || valor2String.equals(".")) {
                    Toast.makeText(getActivity(), "Segundo valor INVÁLIDO!", Toast.LENGTH_SHORT).show();
                } else {
                    double valor1 = Double.parseDouble(valor1String);
                    double valor2 = Double.parseDouble(valor2String);

                    double soma = valor1 + valor2;

                    textResultado.setVisibility(View.VISIBLE);
                    textResultado.setText(String.format("%.2f", soma));
                }
            }
        });
    }
}
