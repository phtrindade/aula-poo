package trindade.univali.br.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Quadrado1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadrado1);
    }

    public void onClickAvancarQuadrado(View v){

        EditText etBaseQuadrado   = findViewById(R.id.etBaseQuadrado);
        EditText etAlturaQuadrado = findViewById(R.id.etAlturaQuadrado);
        double resultado;

        double altura = Double.parseDouble(etAlturaQuadrado.getText().toString());
        double base   = Double.parseDouble(etBaseQuadrado.getText().toString());

        resultado     = ((Double.parseDouble(etAlturaQuadrado.getText().toString()))*
                        (Double.parseDouble(etBaseQuadrado.getText().toString())));


        Intent intencaoAbrirTelaQuadradoRes = new Intent(this.getApplicationContext(), QuadradoResuActivity.class);
        intencaoAbrirTelaQuadradoRes.putExtra("resultado", resultado);


        this.startActivity(intencaoAbrirTelaQuadradoRes);
    }
}
