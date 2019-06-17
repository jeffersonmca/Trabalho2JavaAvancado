package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Medico;

public class DAOMedico extends DAOGenerico<Medico, Integer> {

    public List<Medico> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select m from Medico m "
                    + " where (1 = 1) ";
//CODIGO
//PERIODO TRABALHO

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and m.codigo = " + dado;
                }else if (opcao.equals("PERIODO TRABALHO")) {
                    sql += " and m.periodoTrabalho like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Medico.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}