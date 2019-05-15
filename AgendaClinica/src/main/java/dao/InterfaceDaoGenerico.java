package dao;

import excecao.ExcecaoDao;
import java.io.Serializable;
import java.util.List;



public interface InterfaceDaoGenerico <I, ID extends Serializable> {
    
    public void salvar(I instancia) throws ExcecaoDao;
    public List<I> buscarTodos() throws ExcecaoDao;
    public I buscarPorCodigo(ID codigo) throws ExcecaoDao;
    public I remover(ID codigo) throws ExcecaoDao;
}




