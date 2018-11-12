package trindade.univali.br.a05_controledeabastecimento;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AbAdapter extends RecyclerView.Adapter
{
    public ArrayList<Abastecimento> listaAbastecimento;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View elementoPaiXml = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.abastecimento_item_lista, parent, false);
        AbViewHolder minhaGaveta = new AbViewHolder(elementoPaiXml);
        return minhaGaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        AbViewHolder minhaGaveta = (AbViewHolder) holder;
        Abastecimento atual = listaAbastecimento.get(position);
        minhaGaveta.atualizaGaveta(atual);
    }

    @Override
    public int getItemCount()
    {
        return listaAbastecimento.size();
    }
}