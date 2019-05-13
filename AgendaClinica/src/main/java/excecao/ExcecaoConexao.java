package excecao;

public class ExcecaoConexao extends Exception {
    
    public ExcecaoConexao() {
        super();
    }
    
    public ExcecaoConexao(String msg) {
        super(msg);
    }
}