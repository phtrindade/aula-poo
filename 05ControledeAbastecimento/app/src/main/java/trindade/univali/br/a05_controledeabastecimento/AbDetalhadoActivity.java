package trindade.univali.br.a05_controledeabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AbDetalhadoActivity extends AppCompatActivity
{
    private Abastecimento abastecimentoApresentadoNoFormulario;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ab_detalhado);

        this.abastecimentoApresentadoNoFormulario = (Abastecimento)getIntent().getSerializableExtra("abastecimento");
        if(this.abastecimentoApresentadoNoFormulario != null)
        {
            ImageView ivPosto = findViewById(R.id.ivImagemPostoDetalhado);
            TextView tvPosto = findViewById(R.id.tvPostoDetalhado);
            TextView tvData = findViewById(R.id.tvDataDetalhado);
            TextView tvQuilometragem = findViewById(R.id.tvQuilometragemMostradaDetalhado);
            TextView tvLitros = findViewById(R.id.tvLitrosAbastecidosDetalhado);
            TextView tvLatitude = findViewById(R.id.tvLatitudeDetalhado);
            TextView tvLongitude = findViewById(R.id.tvLongitudeDetalhado);

            tvQuilometragem.setText(Double.toString(this.abastecimentoApresentadoNoFormulario.getKm()));
            tvLitros.setText(Double.toString(this.abastecimentoApresentadoNoFormulario.getLitros()));
            tvData.setText(this.abastecimentoApresentadoNoFormulario.getDataAbastecimento());
            tvLatitude.setText(Double.toString(this.abastecimentoApresentadoNoFormulario.getLat()));
            tvLongitude.setText(Double.toString(this.abastecimentoApresentadoNoFormulario.getLng()));

            if(this.abastecimentoApresentadoNoFormulario.getPosto().equals("Texaco"))
                tvPosto.setText("Texaco");
            else if(this.abastecimentoApresentadoNoFormulario.getPosto().equals("Shell"))
                tvPosto.setText("Shell");
            else if(this.abastecimentoApresentadoNoFormulario.getPosto().equals("Petrobras"))
                tvPosto.setText("Petrobras");
            else
                tvPosto.setText("Ipiranga");

            if(this.abastecimentoApresentadoNoFormulario.getPosto().equals("Texaco"))
            {
                ivPosto.setImageResource(R.drawable.texaco);
            }
            else if(this.abastecimentoApresentadoNoFormulario.getPosto().equals("Shell"))
            {
                ivPosto.setImageResource(R.drawable.shell);
            }
            else if(this.abastecimentoApresentadoNoFormulario.getPosto().equals("Petrobras"))
            {
                ivPosto.setImageResource(R.drawable.petrobras);
            }
            else
            {
                ivPosto.setImageResource(R.drawable.ipiranga);
            }
        }
    }
}