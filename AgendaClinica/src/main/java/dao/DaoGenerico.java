package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import excecao.ExcecaoDao;
import util.Conexao;

public abstract class DaoGenerico<I, ID extends Serializable> implements InterfaceDaoGenerico<I, ID> {

    protected EntityManager em;
    private Class<I> entidade;
    
    public DaoGenerico() {
        
      em = Conexao.getConexao();
      
      entidade = (Class<I>)((ParameterizedType)getClass()
              .getGenericSuperclass())
              .getActualTypeArguments()[0];
    }
    
    @Override
    public void salvar(I instancia) throws ExcecaoDao {
        
        try {

            em.getTransaction().begin();
            em.merge(instancia);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new ExcecaoDao("Houve erro ao salvar o registro!");
        }
    }

    @Override
    public I remover(ID codigo) throws ExcecaoDao {
        
        try {
            I aux = buscarPorCodigo(codigo);

            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();

            return aux;
            
        } catch (Exception e) {
            throw new ExcecaoDao("Houve erro ao remover o registro!");
        }
    }

    @Override
    public I buscarPorCodigo(ID codigo) throws ExcecaoDao {

        try {
            return em.find(entidade, codigo);
        } catch (Exception e) {
            throw new ExcecaoDao("Houve erro ao pegar um registro!");
        }
    }

    @Override
    public List<I> buscarTodos() throws ExcecaoDao {
        
        try {
            String sql = "select i from " + entidade.getName() + " i ";
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            throw new ExcecaoDao("Houve erro ao pegar todos os registros!");
        }
    }   
}