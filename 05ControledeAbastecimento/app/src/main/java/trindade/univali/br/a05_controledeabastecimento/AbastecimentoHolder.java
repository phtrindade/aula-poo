package trindade.univali.br.a05_controledeabastecimento;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public  class AbastecimentoHolder extends RecyclerView.ViewHolder {
    private TextView  tvKm;
    private TextView  tvLitrosAbastecidos;
    private TextView  tvDataAbastecimento;
    private ImageView ivPosto;

    private Abastecimento objetoSendoExibido;

    public AbastecimentoHolder(View itemView){
        super(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(final View view)
            {
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                new AlertDialog.Builder(view.getContext())
                        .setTitle(R.string.excluir)
                        .setMessage(R.string.aviso)
                        //Exclui
                        .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                AbastecimentoDao.excluir(view.getContext(), objetoSendoExibido);
                                ((ListaActivity) view.getContext()).atualizaDatasetLista();
                            }
                        })
                        //Nao exclui
                        .setNegativeButton(R.string.nao, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                //Nao faz nada
                            }
                        })
                        .show();
                return false;
            }
        });

        this.tvKm = itemView.findViewById(R.id.tvKilometros);
        this.tvLitrosAbastecidos = itemView.findViewById(R.id.tvLitros);
        this.tvDataAbastecimento = itemView.findViewById(R.id.tvData);
        this.ivPosto = itemView.findViewById(R.id.ivLogo);
    }

    public void atualizaGaveta(Abastecimento objetoAbastecimento) {
        this.objetoSendoExibido = objetoAbastecimento;

        this.tvKm.setText("Km: " + Double.toString(objetoAbastecimento.getQuilometragem()));
        this.tvLitrosAbastecidos.setText(Double.toString(objetoAbastecimento.getLitro()) + "L");
        this.tvDataAbastecimento.setText(objetoAbastecimento.getData());

        if (objetoAbastecimento.getNomePosto().equals("Texaco")) {
            ivPosto.setImageResource(R.drawable.texaco);
        } else if (objetoAbastecimento.getNomePosto().equals("Shell")) {
            ivPosto.setImageResource(R.drawable.shell);
        } else if (objetoAbastecimento.getNomePosto().equals("Petrobras")) {
            ivPosto.setImageResource(R.drawable.petrobras);
        } else if (objetoAbastecimento.getNomePosto().equals("Ipiranga")) {
            ivPosto.setImageResource(R.drawable.ipiranga);
        }else
            ivPosto.setImageResource(R.drawable.outro);

    }
}
