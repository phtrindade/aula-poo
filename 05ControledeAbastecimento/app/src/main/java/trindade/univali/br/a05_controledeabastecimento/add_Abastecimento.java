package trindade.univali.br.a05_controledeabastecimento;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import io.realm.Realm;

    public class add_Abastecimento extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add__abastecimento);

            Spinner postos = (Spinner) findViewById(R.id.spPostos);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.PostosGasolina, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            postos.setAdapter(adapter);

        }

        public void clicouEscolher(View quemClicou){
            Intent intencao = new Intent(this, datePick.class);
            startActivityForResult(intencao, 2);
        }

        protected void onActivityResult(int requestCode, int resultCode, Intent dados) {

            if (requestCode == 2) {
                if (resultCode == Activity.RESULT_OK) {
                    String data = dados.getStringExtra("data");
                    EditText editText = (EditText) findViewById(R.id.etData);
                    editText.setText(data);
                }
            }
        }

        public void clicouSalvar(View quemClicou){

            EditText kilometragem = (EditText) findViewById(R.id.etKilometragem);
            EditText litros = (EditText) findViewById(R.id.etLitros);
            EditText data = (EditText) findViewById(R.id.etData);
            Spinner posto = (Spinner) findViewById(R.id.spPostos);
            try {
                double km = Double.parseDouble(kilometragem.getText().toString());
                Bundle mochila = getIntent().getExtras();
                double kmAntiga = mochila.getDouble("kilometragem");
                if(km<kmAntiga){
                    Toast.makeText(getApplicationContext(), "ERRO! A quilometragem atual não pode ser menor que a anterior!", Toast.LENGTH_SHORT).show();
                    return;
                }


                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();

                Abastecimento a = realm.createObject(Abastecimento.class);
                a.setQuilometragem(km);
                a.setLitro(Double.parseDouble(litros.getText().toString()));
                a.setData(data.getText().toString());
                a.setData(posto.getSelectedItem().toString());

                realm.copyFromRealm(a);
                realm.commitTransaction();

                Intent intencao = new Intent(this, MainActivity.class);
                intencao.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intencao);
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "ERRO! Campo vazio!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }