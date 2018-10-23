package trindade.univali.br.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CirculoResuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_resu);

        double resultado = getIntent().getExtras().getDouble("resultado");

        TextView tvResultado = (TextView) findViewById(R.id.tvResultadoCirculo);

        tvResultado.setText( "AREA: "+resultado+ "cm²." );
    }
    public void onClickInicioC(View v) {
        Intent Inicio = new Intent(this, MainActivity.class);
        Inicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(Inicio);
    }
}