package com.gabriel.superapp20.ui.calculadora2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gabriel.superapp20.R;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class Calculadora2Fragment extends Fragment {

    private TextInputEditText editPrimeiroValor, editSegundoValor;
    private RadioGroup radioGroup;
    private RadioButton radioSomar, radioSubtrair, radioMultiplicar, radioDividir, radioCalcularMedia;
    private Button buttonCalcular;
    private TextView textResultado, textOperacao;

    public Calculadora2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculadora2, container, false);

        editPrimeiroValor = view.findViewById(R.id.editPrimeiroValor);
        editSegundoValor = view.findViewById(R.id.editSegundoValor);

        radioGroup = view.findViewById(R.id.radioGroup);
        radioSomar = view.findViewById(R.id.radioSomar);
        radioSubtrair = view.findViewById(R.id.radioSubtrair);
        radioMultiplicar = view.findViewById(R.id.radioMultiplicar);
        radioDividir = view.findViewById(R.id.radioDividir);
        radioCalcularMedia = view.findViewById(R.id.radioCalcularMedia);

        buttonCalcular = view.findViewById(R.id.buttonCalcular);

        textResultado = view.findViewById(R.id.textResultado2);
        textOperacao = view.findViewById(R.id.textOperacao);

        textResultado.setVisibility(View.INVISIBLE);

        buttonCalcular();

        return view;
    }

    public void buttonCalcular() {

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textResultado.setVisibility(View.INVISIBLE);
                textOperacao.setTextColor(getResources().getColor(R.color.corTextViewPadrao));

                String valor1String = editPrimeiroValor.getText().toString();
                String valor2String = editSegundoValor.getText().toString();

                if (valor1String.equals("") || valor1String.equals(".") || valor1String == null) {
                    Toast.makeText(getActivity(), "Primeiro valor INVÁLIDO!", Toast.LENGTH_SHORT).show();

                } else if (valor2String.equals("") || valor2String.equals(".") || valor2String == null) {
                    Toast.makeText(getActivity(), "Segundo valor INVÁLIDO!", Toast.LENGTH_SHORT).show();

                } else {
                    double valor1 = Double.parseDouble(valor1String);
                    double valor2 = Double.parseDouble(valor2String);
                    Double resultado = null;

                    switch (radioGroup.getCheckedRadioButtonId()) {
                        case R.id.radioSomar:
                            resultado = valor1 + valor2;
                            break;
                        case R.id.radioSubtrair:
                            resultado = valor1 - valor2;
                            break;
                        case R.id.radioMultiplicar:
                            resultado = valor1 * valor2;
                            break;
                        case R.id.radioDividir:
                            resultado = valor1 / valor2;
                            break;
                        case R.id.radioCalcularMedia:
                            resultado = (valor1 + valor2) / 2;
                            break;
                        default:
                            textOperacao.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                            Toast.makeText(getActivity(), "Selecione a OPERAÇÃO!", Toast.LENGTH_SHORT).show();
                    }

                    if (resultado != null) {
                        textResultado.setVisibility(View.VISIBLE);
                        textResultado.setText(String.format("%.2f", resultado));
                    }
                }
            }
        });
    }
}
