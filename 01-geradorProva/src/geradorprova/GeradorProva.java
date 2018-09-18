package geradorprova;

import java.awt.Desktop;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;            

    public class GeradorProva{
    /**
     * @param args the command line arguments
     */
        public static void main(String[] args){
            Scanner s=new Scanner(System.in);

            
            System.out.print("Disciplina da Prova: ");
            Prova p= new Prova(s.nextLine());
            
            System.out.print("Data da prova: ");
            p.setData(s.nextLine());
            System.out.print("Sala da prova: ");
            p.setLocal(s.nextLine());
            
            do{
                try{
                    System.out.print("Peso da prova: ");
                    p.setPeso(s.nextInt());
                    s.nextLine();
                    break;
                    }catch(Exception e){
                        System.out.println("Valor invalido, repita!!!");
                }
            }while(false);
            
        
            while(true){
                System.out.print("Digite 'O' para questões Objetivas, 'D' para Discursiva e 'X'  para SAIR.");
                String decisao=s.nextLine();
                if(decisao.equalsIgnoreCase("x")){
                    break;
                }else if(decisao.equalsIgnoreCase("o")){
                    
                    Objetiva objetivas=new Objetiva();
                    String[] troca=new String[5];

                    System.out.print("Entre com a pergunta da questão: ");
                    objetivas.setPergunta(s.nextLine());

                    for (int j = 0; j < 5; j++) {
                         System.out.print("Entre com a "+(j+1)+"ª alternativa da questão: ");
                         troca[j]=s.nextLine();
                    }
                    objetivas.setOpcoes(troca);
                    System.out.print("Alternativa correta da questão: ");
                    objetivas.setRespostaCorreta(s.nextInt()-1);
                    s.nextLine();
                    System.out.print("Peso da questão: ");
                    objetivas.setPeso(s.nextInt());
                    s.nextLine();
                    p.getListaQuestoesO().add(objetivas);
                    
                }else if(decisao.equalsIgnoreCase("d")){
                    
                    // criar discursiva
                    Discursiva disc;
                     disc=new Discursiva();
                    System.out.print("Digite a pergunta da questão: ");
                    disc.setPergunta(s.nextLine());
                    System.out.print("Digite o peso da questão: ");
                    disc.setPeso(s.nextDouble());
                    s.nextLine();
                    System.out.print("Digite o critério de avaliação da questão: ");
                    disc.setCriterioCorrecao(s.nextLine());
                    p.getListaQuestoesD().add(disc);
                   
                }else{
                    System.out.println("***--->> Opção inválida! <<--***");
                }
            }

           String prova=p.obtemProvaImpressao();
           System.out.println(p.obtemDetalhes());
           

            System.out.println(prova);
            System.out.print("Salvar em arquivo?(Sim/Nao)");
            String resposta=s.next();
           
            if(resposta.equalsIgnoreCase("sim")){ //if(decisao.equalsIgnoreCase("d"))
                try{
                    System.out.print("Nome do arquivo.txt ");
                    String arquivoAbrir=s.next();
                    File aqrv=new File(arquivoAbrir);
                    try (FileWriter out = new FileWriter(aqrv)) {
                        out.write(prova);
                        Desktop.getDesktop().open(aqrv);
                    }
	  	}catch(IOException e){}
            }
           JOptionPane.showMessageDialog(null, prova);       
        } 
       
    }
    