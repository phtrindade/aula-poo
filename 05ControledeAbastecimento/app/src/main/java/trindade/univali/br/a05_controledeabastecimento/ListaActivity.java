package trindade.univali.br.a05_controledeabastecimento;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity
{
    private AbastecimentoAdapter adaptador;

    private final int RC_ADICIONAR_AVALIACAO = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_itens);

        RecyclerView rvListaAbastecimento = findViewById(R.id.rvListaAbastecimento);

        this.adaptador = new AbastecimentoAdapter();

        this.adaptador.lista = AbastecimentoDao.getLista(this.getApplicationContext());

        rvListaAbastecimento.setAdapter(this.adaptador);

        rvListaAbastecimento.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }

    public void onClickLista(View v)
    {
        Intent intentAbrirListaAbastecimento = new Intent(this.getApplicationContext(), ListaActivity.class);
        this.startActivity(intentAbrirListaAbastecimento);
    }
    public void atualizaDatasetLista()
    {
        this.adaptador.lista = AbastecimentoDao.getLista(this.getApplicationContext());
        this.adaptador.notifyDataSetChanged();
    }

    public void onClickAdd(View v)
    {
        Intent intencaoAbrirTelaAdicionar = new Intent(this.getApplicationContext(), addAbastecimentoActivity.class);

        double ultimoKm;
        if(this.adaptador.lista.size() == 0)
            ultimoKm = -1;
        else
            ultimoKm = this.adaptador.lista.get(this.adaptador.lista.size() - 1).getQuilometragem();
        intencaoAbrirTelaAdicionar.putExtra("ultimoKm", ultimoKm);


        startActivityForResult(intencaoAbrirTelaAdicionar, RC_ADICIONAR_AVALIACAO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_ADICIONAR_AVALIACAO)
        {
            if(resultCode == 1)
            {
                Toast.makeText(this.getApplicationContext(), getString(R.string.toast_salvar), Toast.LENGTH_SHORT).show();
                this.adaptador.notifyDataSetChanged();
            }
        }
    }
}
