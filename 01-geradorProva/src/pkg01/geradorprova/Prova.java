package pkg01.geradorprova;
public class Prova {

    private String nome;
    private int peso;
    private String local;
    private String data;
    private Objetiva[] Objetiva;
    private Discursiva[] Discursiva;
    
    public String obtemDetalhes() {
        String retorno = "UNIVALI - Universidade do Vale do Itajaí\n";
         retorno += "Nome: "  + this.getNome()  + "\n";
         retorno += "Local: " + this.getLocal() + "\n";
         retorno += "Data: "  + this.getData()  + "\n";
         retorno += "Peso: "  + this.getPeso()  + "\n";
        return retorno;
    }
    /*public String obtemProvaImpressao(){
         String provaImpressao="Nome da Disciplina: "+this.getNome()+
                 "\nPeso da Prova: "+this.getPeso()+
                 "\nLocal da Prova: "+this.getLocal()+
                 "\nData da Prova: "+this.getData()+
                 "\n\n\t====Perguntas Discursivas=====\n";
         
         
         //for (int i = 0; i < this..size(); i++) {
         //    provaImpressao+="Questão "+(i+1)+") "+this...get(i).retornaQuestao();
         //}

         //return provaImpressao;
     //}*/
    public Prova(String nome) {
        this.nome = nome;
        this.peso = 10;
        
//this.local = local;
        //this.data = data;     
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the Objetiva
     */
    public Objetiva[] getObjetiva() {
        return Objetiva;
    }

    /**
     * @param Objetiva the Objetiva to set
     */
    public void setObjetiva(Objetiva[] Objetiva) {
        this.Objetiva = Objetiva;
    }

    /**
     * @return the Discursiva
     */
    public Discursiva[] getDiscursiva() {
        return Discursiva;
    }

    /**
     * @param Discursiva the Discursiva to set
     */
    public void setDiscursiva(Discursiva[] Discursiva) {
        this.Discursiva = Discursiva;
    }

}
