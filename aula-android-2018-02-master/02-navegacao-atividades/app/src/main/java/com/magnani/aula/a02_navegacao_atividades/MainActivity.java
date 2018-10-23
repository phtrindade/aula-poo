package com.magnani.aula.a02_navegacao_atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("CALLBACK_LCA", "Método onpause da mainactivity");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("CALLBACK_LCA", "Método onresume da mainactivity");
    }

    public void onClickIMC(View v){
        Intent intencaoAbrirTelaIMC = new Intent(this.getApplicationContext(), IMCPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaIMC);
    }

    public void onClickGCB(View v){


        Intent intencaoAbrirTelaGCB = new Intent(this.getApplicationContext(), GCBPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaGCB);

    }
}
