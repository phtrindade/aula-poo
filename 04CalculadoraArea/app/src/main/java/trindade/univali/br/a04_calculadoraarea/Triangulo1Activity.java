package trindade.univali.br.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Triangulo1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo1);
    }
    public void onClickAvancarTriangulo(View v){

        EditText etBaseTriangulo   = findViewById(R.id.etBaseTriangulo);
        EditText etAlturaTriangulo = findViewById(R.id.etAlturaTriangulo);
        double resultado;

        double altura = Double.parseDouble(etAlturaTriangulo.getText().toString());
        double base   = Double.parseDouble(etBaseTriangulo.getText().toString());

        resultado     = ((Double.parseDouble(etAlturaTriangulo.getText().toString()))*
                (Double.parseDouble(etBaseTriangulo.getText().toString())))/2;


        Intent intencaoAbrirTelaTrianguloRes = new Intent(this.getApplicationContext(), TrianguloResuActivity.class);
        intencaoAbrirTelaTrianguloRes.putExtra("resultado", resultado);


        this.startActivity(intencaoAbrirTelaTrianguloRes);
    }
}


