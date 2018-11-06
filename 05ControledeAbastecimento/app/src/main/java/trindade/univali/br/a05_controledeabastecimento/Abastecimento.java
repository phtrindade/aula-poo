package trindade.univali.br.a05_controledeabastecimento;

import java.io.Serializable;

import io.realm.RealmObject;

public class Abastecimento extends RealmObject implements Serializable {

    private double quilometragem;
    private double litro;
    private String nomePosto;
    private String data;

    public Abastecimento(){}

    public Abastecimento(double kilometragem, double litros, String dataA, String posto){
        this.quilometragem = kilometragem;
        this.litro = litros;
        this.data = dataA;
        this.nomePosto = posto;
    }
    public double getQuilometragem() {return quilometragem;}

    public void setQuilometragem(double quilometragem) {this.quilometragem = quilometragem;}

    public double getLitro() {return litro;}

    public void setLitro(double litro) {this.litro = litro;}

    public String getNomePosto() {return nomePosto;}

    public void setNomePosto(String nomePosto) {this.nomePosto = nomePosto;}

    public String getData() {return data;}

    public void setData(String data) {this.data = data;}
}
