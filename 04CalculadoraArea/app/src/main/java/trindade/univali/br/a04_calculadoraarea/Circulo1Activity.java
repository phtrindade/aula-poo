package trindade.univali.br.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Circulo1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo1);
    }


    public void onClickAvancarCirculo(View v){
        EditText etRaioCirculo   = findViewById(R.id.etRaio);

        double resultado;

        double raio = Double.parseDouble(etRaioCirculo.getText().toString());


        resultado     = 3.142*((Double.parseDouble(etRaioCirculo.getText().toString()))*
                (Double.parseDouble(etRaioCirculo.getText().toString())));


        Intent intencaoAbrirTelaCirculoRes = new Intent(this.getApplicationContext(), CirculoResuActivity.class);
        intencaoAbrirTelaCirculoRes.putExtra("resultado", resultado);


        this.startActivity(intencaoAbrirTelaCirculoRes);
    }
}
