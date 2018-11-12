package trindade.univali.br.a05_controledeabastecimento;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AbDao {

    private static ArrayList<Abastecimento> AL_CACHE = new ArrayList<>();

    private static final String NOME_ARQUIVO = "abastecimentos.txt";

    public static boolean salvar(Context c, Abastecimento aSerSalva)
    {
        aSerSalva.setId(AL_CACHE.size());
        AL_CACHE.add(aSerSalva);

        String abastecimentoEmString = "";
        abastecimentoEmString += aSerSalva.getDataAbastecimento() + ";";
        abastecimentoEmString += aSerSalva.getKm() + ";";
        abastecimentoEmString += aSerSalva.getLitros() + ";";
        abastecimentoEmString += aSerSalva.getPosto() + '\n';

        File arquivo = new File(c.getFilesDir().getPath() + NOME_ARQUIVO);
        try
        {
            FileWriter escritor = new FileWriter(arquivo, true);
            escritor.write(abastecimentoEmString);
            escritor.close();
            return true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean excluir(Context c, Abastecimento aSerExcluida)
    {
        File arquivo = new File(c.getFilesDir().getPath() + NOME_ARQUIVO);

        try
        {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaAbastecimento = null;
            String conteudoNovo = "";

            int numeroLinha = 0;
            while((linhaAbastecimento = leitorDeLinha.readLine()) != null)
            {
                if(aSerExcluida.getId() != numeroLinha)
                {
                    conteudoNovo += linhaAbastecimento + '\n';
                }
                numeroLinha++;
            }
            leitor.close();

            FileWriter escritor = new FileWriter(arquivo, false);
            escritor.write(conteudoNovo);
            escritor.close();

            getLista(c);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static ArrayList<Abastecimento> getLista(Context c)
    {
        AL_CACHE = new ArrayList<>();

        File arquivo = new File(c.getFilesDir().getPath() + NOME_ARQUIVO);
        try
        {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaAbastecimento = null;

            int numeroLinha = 0;
            while((linhaAbastecimento = leitorDeLinha.readLine()) != null)
            {
                String[] partesDaLinha = linhaAbastecimento.split(";");
                Abastecimento atual = new Abastecimento();
                atual.setId(numeroLinha);
                atual.setDataAbastecimento(partesDaLinha[0]);
                atual.setKm(Double.parseDouble(partesDaLinha[1]));
                atual.setLitros(Double.parseDouble(partesDaLinha[2]));
                atual.setPosto(partesDaLinha[3]);
                AL_CACHE.add(atual);
                numeroLinha++;
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return AL_CACHE;
    }
}


