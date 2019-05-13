package dao;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
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
    public void salvar(I instancia) {
        
        try {

            em.getTransaction().begin();
            em.merge(instancia);
            em.getTransaction().commit();

        } catch (Exception e) {
            
        }
    }

    @Override
    public I remover(ID codigo) {
        
        try {
            I aux = buscarPorCodigo(codigo);

            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();

            return aux;
            
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public I buscarPorCodigo(ID codigo) {

        try {
            return em.find(entidade, codigo);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<I> buscarTodos() {
        
        try {
            String sql = "select i from " + entidade.getName() + " i ";
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
        }
        return null;
    }   
}