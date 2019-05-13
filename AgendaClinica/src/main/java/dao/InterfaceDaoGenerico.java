package dao;

import java.io.Serializable;
import java.util.List;



public interface InterfaceDaoGenerico <I, ID extends Serializable> {
    
    public void salvar(I instancia);
    public List<I> buscarTodos();
    public I buscarPorCodigo(ID codigo);
    public I remover(ID codigo);
}




