package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Contato;

public class DAOContato extends DAOGenerico<Contato, Integer> {

    public List<Contato> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select c from Contato c "
                    + " where (1 = 1) ";
//CODIGO
//E-MAIL
//TELEFONE
//CELULAR
            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and c.codigo = " + dado;
                }else if (opcao.equals("E-MAIL")) {
                    sql += " and c.email like '%" + dado + "%'";
                }else if (opcao.equals("TELEFONE")) {
                    sql += " and c.telefone like '%" + dado + "%'";
                }else if (opcao.equals("CELULAR")) {
                    sql += " and c.celular like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Contato.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}