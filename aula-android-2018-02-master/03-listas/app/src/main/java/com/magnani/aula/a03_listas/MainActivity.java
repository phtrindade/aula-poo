package com.magnani.aula.a03_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Avaliacao> listaAvaliacao;
    private AvaliacaoAdaper adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvListaAvaliacoes = findViewById(R.id.rvListaAvaliacoes);

        this.listaAvaliacao = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            Avaliacao av = new Avaliacao();
            av.setConteudo("Conteúdo "+i);
            av.setData(((i%30)+1)+"/10/2018");
            av.setDisciplina("Disciplina "+i);
            av.setMedia("M"+((i%3)+1));
            this.listaAvaliacao.add(av);
        }


        this.adaptador = new AvaliacaoAdaper();

        this.adaptador.listaAvaliacoes = this.listaAvaliacao;


        rvListaAvaliacoes.setAdapter(this.adaptador);

        rvListaAvaliacoes.setLayoutManager( new LinearLayoutManager(this.getApplicationContext()));
    }

    public void onClickFAB(View v){
        Toast.makeText(this.getApplicationContext(), "Ola", Toast.LENGTH_SHORT).show();
        Avaliacao av = new Avaliacao();
        int i = (int) (Math.random()*10);
        av.setConteudo("Conteúdo AA"+i);
        av.setData(((i%30)+1)+"/10/2018");
        av.setDisciplina("Disciplina "+i);
        av.setMedia("M"+((i%3)+1));
        this.listaAvaliacao.add(av);
        this.adaptador.notifyDataSetChanged();
    }
}
