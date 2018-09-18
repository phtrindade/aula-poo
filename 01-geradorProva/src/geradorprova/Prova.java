package geradorprova;
import java.util.ArrayList;

public class Prova {
    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private ArrayList<Questao> listaQuestoesO;
    private ArrayList<Questao> listaQuestoesD;
    
    
    public Prova(String nome){
        this.peso=10;
        this.nomeDisciplina=nome;
        this.listaQuestoesO=new ArrayList();
        this.listaQuestoesD=new ArrayList();
    }
       public String obtemDetalhes(){
       System.out.println("=============================================================");
       String retorno = "               Universidade do vale do Itajaí         \n";
       retorno += "=============================================================\n";
       retorno+= "Nome:________________________________   Peso: "+this.getPeso();
       retorno+= "\nDisciplina: "+this.getNomeDisciplina();
       retorno+= "\nLocal: "+this.getLocal()+"  Data: "+this.getData()+"\n";
       retorno += "=============================================================\n";
       return retorno;
   }
    
     public String obtemProvaImpressao(){
      String retorno = "";
      String questao = "";
      String questao2 = "";
      int i, j;
      for(i=0;i<this.getListaQuestoesD().size();i++){
          questao += ((i+1)+".) "+"(Peso "+this.getListaQuestoesD().get(i).getPeso()+") - ");
          questao += (this.getListaQuestoesD().get(i).retornaQuestao()+"\n");
          questao += "__________________________________________________________\n";
          questao += "__________________________________________________________\n";
          questao += "__________________________________________________________\n";
        }
      retorno += questao;
      for(j=0;j< this.getListaQuestoesO().size();j++){
          questao2 += "_________________________________________________________\n";
          questao2 += ((i+1+j)+".) "+"(Peso "+this.getListaQuestoesO().get(j).getPeso()+") - ");
          questao2 += (this.getListaQuestoesO().get(j).retornaQuestao()+"");
      }
      retorno += questao2;
     
      return retorno;
     }
    
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the listaQuestoesO
     */
    public ArrayList<Questao> getListaQuestoesO() {
        return listaQuestoesO;
    }

    /**
     * @param listaQuestoesO the listaQuestoesO to set
     */
    public void setListaQuestoesO(ArrayList<Questao> listaQuestoesO) {
        this.listaQuestoesO = listaQuestoesO;
    }

    /**
     * @return the listaQuestoesD
     */
    public ArrayList<Questao> getListaQuestoesD() {
        return listaQuestoesD;
    }

    /**
     * @param listaQuestoesD the listaQuestoesD to set
     */
    public void setListaQuestoesD(ArrayList<Questao> listaQuestoesD) {
        this.listaQuestoesD = listaQuestoesD;
    }

}

    
    
    
    
