
package geradorprova;
 class Discursiva extends Questao {    
    private String criterioCorrecao;
    public String getCriterioCorrecao() {
        return criterioCorrecao;
    }
    public void setCriterioCorrecao(String criterioCorrecao) {
        this.criterioCorrecao = criterioCorrecao;
    }

    @Override
    public String retornaQuestao() {
        String retornaDiscursiva="";
        retornaDiscursiva+=this.getPergunta()+"\nCritério de Correção: "+this.getCriterioCorrecao();
        return retornaDiscursiva;
    }
    
}