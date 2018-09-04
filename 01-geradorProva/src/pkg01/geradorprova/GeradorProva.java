
/*
Classe abstrata é uma classe não possuiu atributos necessários pra instanciar objeto tipo 
veiculo, moto, carro, avião, não possibilatando representar um objeto sendo classes Pais
veiculo pai de moto e carro, 
static atributo compartilhado por varios objetos
*/

package pkg01.geradorprova;
import java.util.Scanner;
public class GeradorProva {

    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
         
        //Scanner recebe = new Scanner(System.in);
        System.out.print("Nome da Disciplina --> "); 
        Prova p1 = new Prova(recebe.nextLine());
        //p1.setNome(recebe.nextLine());
        System.out.print("Local --> ");
        p1.setLocal(recebe.nextLine());
        System.out.print("Data --> ");
        p1.setData(recebe.nextLine());
        System.out.print("Peso --> ");
        p1.setPeso(recebe.nextInt());
        
        String aux = new String();
        int qtdD;
        do{
            System.out.print("Numero de questões discursivas --> ");
            qtdD = recebe.nextInt();
            System.out.println("______________________________________________\n");
            if(qtdD<0){
                System.out.println("VALOR NECESSITA SER MAIOR QUE 'ZERO'");
            }
        }while(qtdD<0);
        
        
        Discursiva qDisc [] = new Discursiva[qtdD]; // qDisc ->  questões discursivas
        
        for(int i=0;i<qtdD;i++){
           qDisc[i] = new Discursiva();
            System.out.print("Digite a Questão "+(i+1)+" -> ");
            p1.recebe.nextLine();
            //aux = recebe.nextLine();
            //aux = recebe.nextLine();
            qDisc[i].setPergunta(aux);   
            System.out.print("Critério de Avaliação --> ");
            aux = recebe.nextLine();
            qDisc[i].setCriteriosCorrecao(aux);
            System.out.print("Peso da questão --> ") ;
            qDisc[i].setPeso(recebe.nextDouble());
            System.out.println("______________________________________________");
        }
        p1.setDiscursiva(qDisc);
        
        
        int qtdO;
        do{
            System.out.print("Numero de questões objetivas --> ");
            qtdO = recebe.nextInt();
            if(qtdO<0){
                System.out.println("VALOR NECESSITA SER MAIOR QUE 'ZERO'");
            }
        }while(qtdO<0);
        Objetiva qObj [] = new Objetiva[qtdO];
        String [] c = new String[5];
        for(int i=0;i<qtdO;i++){
            qObj[i]= new Objetiva();
            System.out.print("Digite a Questão "+(i+1)+" -> ");
            aux = recebe.nextLine();
            aux = recebe.nextLine();
            qObj[i].setPergunta(aux); 
            System.out.print("Peso --> ");
            qObj[i].setPeso(recebe.nextDouble());
            System.out.println("Entre com as Alternativas ");
            for(int j=0;j<5;j++){
                System.out.print((j+1)+".) alternativa: ");
                aux = recebe.nextLine();
                //calaux = recebe.nextLine();
                c[j]=aux;
            }
            qObj[i].setOpcoes(c);
            int alternativa;
            do{
                System.out.print("Alternativa correta é? ");
                alternativa = recebe.nextInt();
            }while(alternativa<0 || alternativa>6);
            qObj[i].setRespostaCorreta(alternativa-1);                 
        }
        p1.setObjetiva(qObj);
        

        
        System.out.println(p1.obtemDetalhes());
        
        /*Prova x = new Prova("POO");
        x.setLocal("Lab 3 - Bloco B6");
        x.setData("2018-08-28");
        
        //forma resumida
        System.out.println(x.obtemDetalhes());
        
        Discursiva d = new Discursiva();
        d.setPergunta("Qual seu nome?");
        d.setPeso(0);
        d.setCriteriosCorrecao("Saber o próprio nome");
        
        Objetiva o = new Objetiva();
        o.setPergunta("Qual o melhor time do Brasil?");
        o.setPeso(2);
        String[] opcoes = new String[5];
        opcoes[0] = "Gremio";
        opcoes[1] = "Inter";
        opcoes[2] = "Flamento";
        opcoes[3] = "Corinthians";
        opcoes[4] = "Sao Paulo";
        o.setOpcoes(opcoes);
        o.setRespostaCorreta(3);
        
                
                
        
        // metodo didático
       // String retornoDoMetodo = x.obtemDetalhes();
       // System.out.println(retornoDoMetodo);
        //ou 
       // System.out.println(x.obtemDetalhes());
        
        */
      
        
    }
    
}
