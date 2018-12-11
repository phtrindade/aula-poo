package trindade.univali.br.a05_controledeabastecimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class AbDao {

    private static ArrayList<Abastecimento> AL_CACHE = new ArrayList<>();

    public static boolean salvar(Context c, Abastecimento aSerSalvo)
    {
        BancoDados meuDb = new BancoDados(c);
        SQLiteDatabase db = meuDb.getWritableDatabase();

        ContentValues chaveValor = new ContentValues();
        chaveValor.put("km", aSerSalvo.getKm());
        chaveValor.put("litros", aSerSalvo.getLitros());
        chaveValor.put("lat", aSerSalvo.getLat());
        chaveValor.put("lng", aSerSalvo.getLng());
        chaveValor.put("data", aSerSalvo.getDataAbastecimento());
        chaveValor.put("posto", aSerSalvo.getPosto());
        long id = db.insert("abastecimento", null, chaveValor);
        aSerSalvo.setId(id);

        AL_CACHE.add(aSerSalvo);
        return true;
    }

    public static boolean excluir(Context c, Abastecimento aSerExcluido)
    {
        BancoDados meuDb = new BancoDados(c);
        SQLiteDatabase db = meuDb.getWritableDatabase();

        String[] whereId = {String.valueOf(aSerExcluido.getId())};
        db.delete("abastecimento", "id = ?", whereId);
        getLista(c);
        return true;
    }

    public static ArrayList<Abastecimento> getLista(Context c)
    {
        AL_CACHE = new ArrayList<>();

        BancoDados meuDb = new BancoDados(c);
        SQLiteDatabase db = meuDb.getReadableDatabase();

        String SQLBuscarAbastecimentos = "SELECT km, litros, lat, lng, data, posto, id FROM abastecimento";
        Cursor ponteiro = db.rawQuery(SQLBuscarAbastecimentos, null);

        while(ponteiro.moveToNext())
        {
            Abastecimento daVez = new Abastecimento();
            daVez.setKm(ponteiro.getDouble(0));
            daVez.setLitros(ponteiro.getDouble(1));
            daVez.setLat(ponteiro.getDouble(2));
            daVez.setLng(ponteiro.getDouble(3));
            daVez.setDataAbastecimento(ponteiro.getString(4));
            daVez.setPosto(ponteiro.getString(5));
            daVez.setId(ponteiro.getLong(6));
            AL_CACHE.add((daVez));
        }
        return AL_CACHE;
    }
}


