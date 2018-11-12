package trindade.univali.br.a05_controledeabastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //Calcula e e coloca a autonomia no textView
    public void calculaAutonomia()
    {
        ArrayList<Abastecimento> listaAbastecimentos;
        listaAbastecimentos = AbastecimentoDao.getLista(this.getApplicationContext());

        TextView tvAutonomia = findViewById(R.id.tvAutonomia);
        if(listaAbastecimentos.size() > 1)
        {
            double autonomia;
            double km;
            double litros = 0;

            km = listaAbastecimentos.get(listaAbastecimentos.size() - 1).getQuilometragem() - listaAbastecimentos.get(0).getQuilometragem();

            for (int i = 0; i < listaAbastecimentos.size() - 1; i++)
            {
                litros += listaAbastecimentos.get(i).getLitro();
            }

            autonomia = km / litros;

            NumberFormat nf = DecimalFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            tvAutonomia.setText(nf.format(autonomia));
        }
        else
        {
            tvAutonomia.setText("--");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculaAutonomia();
    }

    @Override
    public void onResume()
    {
        super.onResume();

        calculaAutonomia();
    }

    public void onClickAdd(View v)
    {
        Intent intentAbrirListaAbastecimento = new Intent(this.getApplicationContext(), ListaActivity.class);
        this.startActivity(intentAbrirListaAbastecimento);
    }

    public void onClickLista(View view) {
        Intent intentAbrirListaAbastecimentoHolder = new Intent(this.getApplicationContext(), AbastecimentoHolder.class);
        this.startActivity(intentAbrirListaAbastecimentoHolder);
    }
}
