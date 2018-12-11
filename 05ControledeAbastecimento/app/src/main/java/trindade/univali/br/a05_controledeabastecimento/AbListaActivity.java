package trindade.univali.br.a05_controledeabastecimento;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class AbListaActivity extends AppCompatActivity
{
    private AbAdapter adaptador;

    public static final int RC_ADICIONAR_ABASTECIMENTO = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ab_lista);

        RecyclerView rvListaAbastecimento = findViewById(R.id.rvListaAbastecimento);

        this.adaptador = new AbAdapter();

        this.adaptador.listaAbastecimento = AbDao.getLista(this.getApplicationContext());

        rvListaAbastecimento.setAdapter(this.adaptador);

        rvListaAbastecimento.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }

    public void atualizaDatasetLista()
    {
        this.adaptador.listaAbastecimento = AbDao.getLista(this.getApplicationContext());
        this.adaptador.notifyDataSetChanged();
    }

    public void onClickFAB(View v)
    {
        Intent intencaoAbrirTelaAdicionar = new Intent(this.getApplicationContext(), AddAbastecimentoActivity.class);

        double ultimoKm;
        if(this.adaptador.listaAbastecimento.size() == 0)
            ultimoKm = -1;
        else
            ultimoKm = this.adaptador.listaAbastecimento.get(this.adaptador.listaAbastecimento.size() - 1).getKm();
        intencaoAbrirTelaAdicionar.putExtra("ultimoKm", ultimoKm);


        startActivityForResult(intencaoAbrirTelaAdicionar, RC_ADICIONAR_ABASTECIMENTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_ADICIONAR_ABASTECIMENTO)
        {
            if(resultCode == 1)
            {
                Toast.makeText(this.getApplicationContext(), getString(R.string.toast_salvar), Toast.LENGTH_SHORT).show();
                this.adaptador.notifyDataSetChanged();
            }
        }
    }
}
