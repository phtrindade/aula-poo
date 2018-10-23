package com.magnani.aula.a02_navegacao_atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GCBResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcbresultado);

        GastoCaloricoBasal objetoGCB = (GastoCaloricoBasal) this.getIntent().getParcelableExtra("objeto");

        TextView tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setText( "" + objetoGCB.getResultado() );

    }
}
