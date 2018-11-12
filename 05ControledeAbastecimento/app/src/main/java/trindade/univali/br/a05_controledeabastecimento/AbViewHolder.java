package trindade.univali.br.a05_controledeabastecimento;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AbViewHolder extends RecyclerView.ViewHolder{
    private TextView tvKm;
    private TextView tvLitrosAbastecidos;
    private TextView tvDataAbastecimento;
    private ImageView ivPosto;

    private Abastecimento objetoSendoExibido;

    public AbViewHolder(View itemView)
    {
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
                                AbDao.excluir(view.getContext(), objetoSendoExibido);
                                ((AbListaActivity) view.getContext()).atualizaDatasetLista();
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

        this.tvKm = itemView.findViewById(R.id.tvKM);
        this.tvLitrosAbastecidos = itemView.findViewById(R.id.tvLitros);
        this.tvDataAbastecimento = itemView.findViewById(R.id.tvData);
        this.ivPosto = itemView.findViewById(R.id.ivImagemPosto);
    }

    public void atualizaGaveta(Abastecimento objetoAbastecimento)
    {
        this.objetoSendoExibido = objetoAbastecimento;

        this.tvKm.setText("Km: " + Double.toString(objetoAbastecimento.getKm()));
        this.tvLitrosAbastecidos.setText(Double.toString(objetoAbastecimento.getLitros()) + "L");
        this.tvDataAbastecimento.setText(objetoAbastecimento.getDataAbastecimento());

        if(objetoAbastecimento.getPosto().equals("Texaco"))
        {
            ivPosto.setImageResource(R.drawable.texaco);
        }
        else if(objetoAbastecimento.getPosto().equals("Shell"))
        {
            ivPosto.setImageResource(R.drawable.shell);
        }
        else if(objetoAbastecimento.getPosto().equals("Petrobras"))
        {
            ivPosto.setImageResource(R.drawable.petrobras);
        }
        else
        {
            ivPosto.setImageResource(R.drawable.ipiranga);
        }
    }
}

