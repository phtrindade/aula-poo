
package geradorprova;

/**
 *
 * @author paulo
 */
public class Discursiva extends Questao {    
    private String criterioCorrecao;

    /**
     * @return the criterioCorrecao
     */
    public String getCriterioCorrecao() {
        return criterioCorrecao;
    }

    /**
     * @param criterioCorrecao the criterioCorrecao to set
     */
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