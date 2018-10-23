package com.magnani.aula.a02_navegacao_atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class IMCResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresultado);

        double altura = this.getIntent().getDoubleExtra("altura", -1);
        double peso = this.getIntent().getDoubleExtra("peso", -1);
        double imc = peso / Math.pow(altura, 2);

        TextView tvResultado = findViewById(R.id.tvResultado);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        tvResultado.setText(nf.format(imc));



    }
}
