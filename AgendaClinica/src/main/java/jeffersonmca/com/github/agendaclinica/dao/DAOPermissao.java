package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Permissao;

public class DAOPermissao extends DAOGenerico<Permissao, Integer> {

    public List<Permissao> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select p from Permissao p "
                    + " where (1 = 1) ";
//CODIGO
//DESCRICAO

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and p.codigo = " + dado;
                }else if (opcao.equals("DESCRICAO")) {
                    sql += " and p.descricao like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Permissao.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}