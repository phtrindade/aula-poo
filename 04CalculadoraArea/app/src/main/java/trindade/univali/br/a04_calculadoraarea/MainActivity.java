package trindade.univali.br.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onPause(){
        super.onPause();
       // Log.d("CALLBACK_LCA", "Método onpause da mainactivity");
    }

    @Override
    protected void onResume(){
        super.onResume();
        //Log.d("CALLBACK_LCA", "Método onresume da mainactivity");
    }
    public void onClickAvancar(View v){

        Intent intencaoAbrirTelaQuadrado1  = new Intent(this.getApplicationContext(), Quadrado1Activity.class);
        Intent intencaoAbrirTelaCirculo1   = new Intent(this.getApplicationContext(), Circulo1Activity.class);
        Intent intencaoAbrirTelaTriangulo1 = new Intent(this.getApplicationContext(), Triangulo1Activity.class );

        try{
            //forma didática
            RadioButton rbQuadrado = findViewById(R.id.rbQuadrado);
            RadioButton rbCirculo = findViewById(R.id.rbCirculo);
            RadioButton rbTriangulo = findViewById(R.id.rbTriangulo);

            if(rbQuadrado.isChecked()){
                //objetoGCB.rbQuadrado( "Quadrado" );
                this.startActivity(intencaoAbrirTelaQuadrado1);
            }
            if(rbCirculo.isChecked()){
                this.startActivity(intencaoAbrirTelaCirculo1);
            }
            if(rbTriangulo.isChecked()) {
                this.startActivity(intencaoAbrirTelaTriangulo1);
            }
                // intencaoAbrirGCBResultado.putExtra("objeto", objetoGCB);



        }catch (Exception e){
            Toast.makeText(this.getApplicationContext(), "Erro na EXECUSÃO", Toast.LENGTH_LONG).show();
        }


    }

}
