package com.magnani.aula.a02_navegacao_atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IMCPasso1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcpasso1);
    }

    public void onClickAvancar(View v){
        EditText etAltura = findViewById(R.id.etAltura);
        EditText etPeso = findViewById(R.id.etPeso);

        double altura = Double.parseDouble(etAltura.getText().toString());
        double peso = Double.parseDouble(etPeso.getText().toString());


        Intent intencaoAbrirIMCResultado = new Intent(this.getApplicationContext(), IMCResultadoActivity.class);

        intencaoAbrirIMCResultado.putExtra("altura", altura);
        intencaoAbrirIMCResultado.putExtra("peso", peso);

        this.startActivity(intencaoAbrirIMCResultado);

    }
}
