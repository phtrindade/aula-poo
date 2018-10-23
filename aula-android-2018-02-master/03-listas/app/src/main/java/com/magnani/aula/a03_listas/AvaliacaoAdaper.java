package com.magnani.aula.a03_listas;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AvaliacaoAdaper extends RecyclerView.Adapter {

    public ArrayList<Avaliacao> listaAvaliacoes;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflando o XML
        View elementoPaiDoXML =
                LayoutInflater.from(
                        parent.getContext()
                ).inflate(
                        R.layout.avaliacao_item_lista,
                        parent,
                        false
                );

        AvaliacaoViewHolder minhaGaveta = new AvaliacaoViewHolder(elementoPaiDoXML);
        return minhaGaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //método que deve vestir a gaveta
        AvaliacaoViewHolder minhaGaveta = (AvaliacaoViewHolder) holder;
        Avaliacao daVez = listaAvaliacoes.get(position);
        minhaGaveta.atualizaGaveta( daVez );
    }

    @Override
    public int getItemCount() {
        //retornar o total de itens da lista
        return listaAvaliacoes.size();
    }
}
