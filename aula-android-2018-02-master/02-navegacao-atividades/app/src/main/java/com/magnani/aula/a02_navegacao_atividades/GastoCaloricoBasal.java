package com.magnani.aula.a02_navegacao_atividades;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class GastoCaloricoBasal implements Parcelable {

    private double altura;
    private double peso;
    private int idade;
    private char sexo;

    public double getResultado(){
        double resultado = 0;
        if(this.sexo == 'F'){
            resultado = 655 + (9.6 * this.peso) + (1.8 * this.altura) - (4.7 * this.idade);
        }else{
            resultado = 66 + (13.7 * this.peso) + (5 * this.altura) - (6.8 * this.idade);
        }
        return  resultado;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }





    public static final Creator<GastoCaloricoBasal> CREATOR = new Creator<GastoCaloricoBasal>() {
        @Override
        public GastoCaloricoBasal createFromParcel(Parcel in) {
            GastoCaloricoBasal objetoDecodificado = new GastoCaloricoBasal();
            objetoDecodificado.setIdade(in.readInt());
            objetoDecodificado.setPeso(in.readDouble());
            objetoDecodificado.setAltura(in.readDouble());
            objetoDecodificado.setSexo((char) in.readInt());
            return objetoDecodificado;

        }

        @Override
        public GastoCaloricoBasal[] newArray(int size) {
            return new GastoCaloricoBasal[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.idade);
        parcel.writeDouble(this.peso);
        parcel.writeDouble(this.altura);
        parcel.writeInt(this.sexo);
    }


    @Override
    public int describeContents() {
        return 0;
    }


}
