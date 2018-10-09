package com.magnani.aula.a01_interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void fazerAParadaAcontecer(View elementoClicado) {

        EditText Massa = findViewById(R.id.etA);
        EditText Gravidade = findViewById(R.id.etB);
        EditText Altura = findViewById(R.id.etC);

        TextView Resultado = findViewById(R.id.tvResultado);

        String Massa_Digitada = Massa.getText().toString();
        String Altura_Digitada = Gravidade.getText().toString();
        String Gravidade_Digitada = Altura.getText().toString();

            if ((Massa_Digitada.equals("")) || (Altura_Digitada.equals("")) || (Gravidade_Digitada.equals(""))){ // faz validação imprimindo

                Massa.setError("Informe a altura");
                Gravidade.setError("Informe o peso");
                Altura.setError("Informe Altura correta");
                return;
            }

        //}
        try{
            double MassaEmDouble = Double.parseDouble(Massa_Digitada);
            double AlturaEmDouble = Double.parseDouble(Altura_Digitada);
            double GravidadeEmDouble = Double.parseDouble(Gravidade_Digitada);

            double resultado = MassaEmDouble*AlturaEmDouble*GravidadeEmDouble;

            Resultado.setText("Força do impacto é de "+String.format("%s Newtons", resultado));

            Resultado.setVisibility(View.VISIBLE);
        }catch (Exception e){
            Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu", Toast.LENGTH_LONG);
            mensagemErro.show();
        }

    }

}
