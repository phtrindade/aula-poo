package trindade.univali.br.a05_controledeabastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

class MainActivity extends AppCompatActivity {

    ArrayList<Abastecimento>lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        setContentView(R.layout.activity_main);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Abastecimento> results = realm.where(Abastecimento.class).findAll();
        for (Abastecimento atual : results) {
            lista.add(atual);
        }

        if(!lista.isEmpty()) {
            // CALCULA A AUTONOMIA
            double litros = 0;
            double kilometragem = lista.get(lista.size()-1).getQuilometragem();
            for (int i = 0; i < lista.size(); i++) {
                litros += lista.get(i).getQuilometragem();
            }

            kilometragem /= litros;
            TextView autonomia = (TextView) findViewById(R.id.tvAutonomia);
            autonomia.setText(String.format("%.2f", kilometragem));
        }
    }

    public void clicouAdicionar(View quemClicou){
        Intent intencao = new Intent(this, add_Abastecimento.class);

        if(!lista.isEmpty()) {
            intencao.putExtra("kilometragem", lista.get(lista.size() - 1).getQuilometragem());
        }else
            intencao.putExtra("kilometragem", 0);
        startActivityForResult(intencao, 1);
    }

    public void clicouVisualizar(View quemClicou){
        Intent intencao = new Intent(this, visualizarAbastecimentos.class);
        startActivity(intencao);
    }
}
