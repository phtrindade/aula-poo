/*
Classe abstrata é uma classe não possuiu atributos necessários pra instanciar objeto tipo 
veiculo, moto, carro, avião, não possibilatando representar um objeto sendo classes Pais
veiculo pai de moto e carro, 
static atributo compartilhado por varios objetos
*/
package pkg01.geradorprova;

/**
 *
 * @author Trindade
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Prova x  = new Prova("POO");
        x.setData("28-08-2018"); //Utilizando encapsulamento
        x.setLocal("Lab-- 3 bloco B6");
        // x.local ="Lab-- 3 bloco B6";
        //x.data ="28-08-2018";
       
        
        // metodo didático
        String retornoDoMetodo = x.obtemDetalhes();
        System.out.println(retornoDoMetodo);
        //ou 
        System.out.println(x.obtemDetalhes());
        
        
        
        Objetiva o = new Objetiva();
        o.setPergunta("Qual a pergunta correta? ");
        o.setPeso(3);
        String[] opcoes =  new String[5];
        opcoes[0]= "Gre";
        opcoes[1]= "Corinthias";
        opcoes[2]= "Palmeiras";
        opcoes[3]= "Colorado";
        opcoes[4]= "Bahia";
        o.setOpcoes(opcoes);
        o.setRespostaCorreta(3);
        
        
    }
    
}
