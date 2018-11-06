package trindade.univali.br.a05_controledeabastecimento;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public  class AbastecimentoHolder extends RecyclerView.ViewHolder {

    private TextView tvData;
    private TextView tvLitros;
    private TextView tvKilometros;
    private ImageView ivFoto;

    public AbastecimentoHolder(View itemView) {
        super(itemView);

        this.tvData = itemView.findViewById(R.id.tvData);
        this.tvLitros = itemView.findViewById(R.id.tvLitros);
        this.tvKilometros = itemView.findViewById(R.id.tvKilometros);
        this.ivFoto = itemView.findViewById(R.id.ivFoto);
    }

    public void atualizaObjeto(Abastecimento abastecimento){
        tvData.setText( abastecimento.getData() );
        tvLitros.setText( Double.toString( abastecimento.getLitro() ));
        String s = ""+abastecimento.getQuilometragem();
        tvKilometros.setText(s);

        if(abastecimento.getNomePosto().equals("Petrobras")){
            ivFoto.setImageResource(R.drawable.petrobras);
        }else if (abastecimento.getNomePosto().equals("Ipiranga")){
            ivFoto.setImageResource(R.drawable.ipiranga);
        }else if (abastecimento.getNomePosto().equals("Shell")){
            ivFoto.setImageResource(R.drawable.shell);
        }else if (abastecimento.getNomePosto().equals("Texaco")){
            ivFoto.setImageResource(R.drawable.texaco);
        }else{
            ivFoto.setImageResource(R.drawable.outro);
        }


    }
}