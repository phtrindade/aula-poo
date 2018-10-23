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


    public void fazerAParadaAcontecer(View elementoClicado){
        EditText altura = findViewById(R.id.etAltura);
        EditText peso = findViewById(R.id.etPeso);
        TextView imc = findViewById(R.id.tvImc);

        String alturaDigitada = altura.getText().toString();
        String pesoDigitado = peso.getText().toString();

        if(alturaDigitada.equals("")  || pesoDigitado.equals("")){
            altura.setError("Informe a altura");
            peso.setError("Informe o peso");
            return;
        }

        try{
            double alturaEmDouble = Double.parseDouble(alturaDigitada);
            double pesoEmDouble = Double.parseDouble(pesoDigitado);

            double resultadoImc = pesoEmDouble/(alturaEmDouble*alturaEmDouble);

            imc.setText( "IMC: "+resultadoImc );

            imc.setVisibility(View.VISIBLE);
        }catch (Exception e){
            Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu", Toast.LENGTH_LONG);
            mensagemErro.show();
        }



    }


}
