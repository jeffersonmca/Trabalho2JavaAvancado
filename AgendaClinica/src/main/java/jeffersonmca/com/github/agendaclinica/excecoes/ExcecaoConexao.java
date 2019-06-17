package jeffersonmca.com.github.agendaclinica.excecoes;

public class ExcecaoConexao extends Exception {
    
    public ExcecaoConexao() {
        super();
    }
    
    public ExcecaoConexao(String msg) {
        super(msg);
    }
}
