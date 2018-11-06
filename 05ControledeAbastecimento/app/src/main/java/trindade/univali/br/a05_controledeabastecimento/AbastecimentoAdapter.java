package trindade.univali.br.a05_controledeabastecimento;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class AbastecimentoAdapter extends RecyclerView.Adapter {

    private ArrayList<Abastecimento> lista;

    public void setLista(ArrayList<Abastecimento> lista) {
        this.lista = lista;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_itens, parent, false);
        AbastecimentoHolder gaveta = new AbastecimentoHolder(layoutView);
        Log.d("RV", "Criando a gaveta " + gaveta.toString());
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AbastecimentoHolder gaveta = (AbastecimentoHolder) holder;
        Abastecimento atual = this.lista.get(position);
        gaveta.atualizaObjeto(atual);
        Log.d("RV", "Atualizando a gaveta " + gaveta.toString() + " com o objteto " + position);
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }
}