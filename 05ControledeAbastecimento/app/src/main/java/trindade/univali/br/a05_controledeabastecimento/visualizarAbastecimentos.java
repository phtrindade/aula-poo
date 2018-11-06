package trindade.univali.br.a05_controledeabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class visualizarAbastecimentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_abastecimentos);

        ArrayList<Abastecimento> lista = new ArrayList<>();
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Abastecimento> results = realm.where(Abastecimento.class).findAll();
        for (Abastecimento atual : results) {
            lista.add(atual);
        }

        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);

        AbastecimentoAdapter adapter = new AbastecimentoAdapter();
        adapter.setLista(lista);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setAdapter(adapter);
    }
}
