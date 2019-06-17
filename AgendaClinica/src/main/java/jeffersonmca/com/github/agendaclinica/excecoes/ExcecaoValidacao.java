package jeffersonmca.com.github.agendaclinica.excecoes;

public class ExcecaoValidacao extends Exception {

    public ExcecaoValidacao() {
        super();
    }
    
    public ExcecaoValidacao(String msg) {
        super(msg);
    }
}