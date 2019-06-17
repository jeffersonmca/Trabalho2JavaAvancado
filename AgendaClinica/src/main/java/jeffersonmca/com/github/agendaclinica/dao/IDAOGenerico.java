package jeffersonmca.com.github.agendaclinica.dao;

import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import java.io.Serializable;
import java.util.List;

public interface IDAOGenerico <I, ID extends Serializable> {
    
    public void salvar(I instancia) throws ExcecaoDAO;
    public List<I> buscarTodos() throws ExcecaoDAO;
    public I buscarPorCodigo(ID codigo) throws ExcecaoDAO;
    public I remover(ID codigo) throws ExcecaoDAO;
}




