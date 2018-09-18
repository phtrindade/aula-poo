package geradorprova;

public class Objetiva extends Questao {
    private String[] opcoes=new String[5];
    private int respostaCorreta;

    public String[] getOpcoes() {
        return opcoes;
    }
    
    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }
   
    public int getRespostaCorreta() { 
        return respostaCorreta;
    }
  
    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    @Override
    public String retornaQuestao() {
        String retornaObjetiva="";
         String[] opcoes=new String[5];
         String[] caracteres={"(a","(b","(c","(d","(e"};
         retornaObjetiva+=this.getPergunta()+"\nAlternativas:\n";    
             
             opcoes=this.getOpcoes();
             for (int j = 0; j < 5; j++) {
                 retornaObjetiva+=caracteres[j]+") "+opcoes[j]+"\n";        
         }
        
        return retornaObjetiva;
    }
}