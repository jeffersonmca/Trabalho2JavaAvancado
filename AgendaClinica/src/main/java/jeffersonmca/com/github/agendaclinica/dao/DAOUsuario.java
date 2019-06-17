package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario, Integer> {

    public List<Usuario> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select u from Usuario u "
                    + " where (1 = 1) ";
//CODIGO
//AUTENTICADOR

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and u.codigo = " + dado;
                }else if (opcao.equals("AUTENTICADOR")) {
                    sql += " and u.autenticador like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Usuario.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}