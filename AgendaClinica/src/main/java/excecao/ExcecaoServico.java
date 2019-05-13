package excecao;

public class ExcecaoServico extends Exception {

    public ExcecaoServico() {
        super();
    }
    
    public ExcecaoServico(String msg) {
        super(msg);
    }
}