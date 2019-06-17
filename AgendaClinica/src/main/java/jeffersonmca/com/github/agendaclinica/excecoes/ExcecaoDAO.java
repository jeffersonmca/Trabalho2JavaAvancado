package jeffersonmca.com.github.agendaclinica.excecoes;

public class ExcecaoDAO extends Exception {

    public ExcecaoDAO() {
        super();
    }
    
    public ExcecaoDAO(String msg) {
        super(msg);
    }
}