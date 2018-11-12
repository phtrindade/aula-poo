package trindade.univali.br.a05_controledeabastecimento;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
//Paulo Henrique Trindade
public class AbastecimentoAdapter extends RecyclerView.Adapter {

    public ArrayList<Abastecimento> lista;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View elementoPaiXml = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.lista_itens, parent, false);
        AbastecimentoHolder minhaGaveta = new AbastecimentoHolder(elementoPaiXml);
        return minhaGaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        AbastecimentoHolder minhaGaveta = (AbastecimentoHolder) holder;
        Abastecimento atual = lista.get(position);
        minhaGaveta.atualizaGaveta(atual);
    }

    @Override
    public int getItemCount()
    {
        return lista.size();
    }
}