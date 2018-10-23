package com.magnani.aula.a03_listas;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AvaliacaoViewHolder extends RecyclerView.ViewHolder {

    //esta classe representa cada gaveta que será apresentada na lista

    private TextView tvData;
    private TextView tvConteudo;
    private TextView tvMedia;
    private TextView tvDisciplina;

    public AvaliacaoViewHolder(View itemView) {
        super(itemView);
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), tvConteudo.getText().toString(), Toast.LENGTH_LONG).show();
//            }
//        });

        this.tvData = itemView.findViewById(R.id.tvData);
        this.tvConteudo = itemView.findViewById(R.id.tvConteudo);
        this.tvMedia = itemView.findViewById(R.id.tvMedia);
        this.tvDisciplina = itemView.findViewById(R.id.tvDisciplina);
    }

    public void atualizaGaveta(Avaliacao objetoAvaliacao){
        this.tvData.setText( objetoAvaliacao.getData() );
        this.tvConteudo.setText( objetoAvaliacao.getConteudo() );
        this.tvDisciplina.setText( objetoAvaliacao.getDisciplina() );
        this.tvMedia.setText( objetoAvaliacao.getMedia() );

        if(objetoAvaliacao.getMedia().equals("M1")){
            this.tvMedia.setTextColor(Color.BLUE);
        }else{
            this.tvMedia.setTextColor(Color.GRAY);
        }
    }

}
