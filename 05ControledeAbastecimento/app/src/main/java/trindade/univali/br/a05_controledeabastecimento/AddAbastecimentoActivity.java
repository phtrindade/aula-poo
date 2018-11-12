package trindade.univali.br.a05_controledeabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddAbastecimentoActivity extends AppCompatActivity {
    //Checa um editText para caso esteja vazio, mostra uma msg de erro caso sim
    public boolean isEmpty(EditText et)
    {
        String validation = et.getText().toString();
        if(TextUtils.isEmpty(validation))
        {
            et.setError(getString(R.string.erro_vazio));
            return true;
        }

        return false;
    }

    public void onClickSalvar(View v)
    {
        EditText etKmAtual = findViewById(R.id.etKmAtual);
        EditText etLitros = findViewById(R.id.etLitros);
        EditText etData = findViewById(R.id.etData);
        Spinner spPosto = findViewById(R.id.spPosto);

        //Verifica se os editTexts estao vazios
        boolean erro = false;
        if(isEmpty(etKmAtual))
            erro = true;
        if(isEmpty(etLitros))
            erro = true;
        if(isEmpty(etData))
            erro = true;

        //Verifica se o Km inserido eh menor que o anterior
        if(!erro)
        {
            double ultimoKm = this.getIntent().getDoubleExtra("ultimoKm", -1);
            double kmDigitado = Double.parseDouble(etKmAtual.getText().toString());
            if (kmDigitado <= ultimoKm)
            {
                erro = true;
                etKmAtual.setError(getString(R.string.erro_km));
            }
        }

        if(!erro)
        {
            Abastecimento abastecimento = new Abastecimento();

            abastecimento.setKm(Double.parseDouble(etKmAtual.getText().toString()));
            abastecimento.setLitros(Double.parseDouble(etLitros.getText().toString()));
            abastecimento.setDataAbastecimento(etData.getText().toString());
            abastecimento.setPosto(spPosto.getSelectedItem().toString());

            boolean salvar = AbDao.salvar(this.getApplicationContext(), abastecimento);

            if (salvar)
            {
                setResult(1);
                finish();
            }
            else
            {
                Toast.makeText(this.getApplicationContext(), getString(R.string.erro_salvar), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_abastecimento);

        //Foca o primeiro editText
        EditText etKmAtual = findViewById(R.id.etKmAtual);
        etKmAtual.requestFocus();

        //Coloca de hint o ultimo km inserido
        double ultimoKm = this.getIntent().getDoubleExtra("ultimoKm", -1);
        if(ultimoKm >= 0)
            etKmAtual.setHint(Double.toString(ultimoKm));

        //Populando spinner
        Spinner spinner = findViewById(R.id.spPosto);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getApplicationContext(), R.array.postos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}