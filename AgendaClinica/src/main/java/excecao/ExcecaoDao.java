package excecao;

public class ExcecaoDao extends Exception {

    public ExcecaoDao() {
        super();
    }
    
    public ExcecaoDao(String msg) {
        super(msg);
    }
}