package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Consulta;

public class DAOConsulta extends DAOGenerico<Consulta, Integer> {

    public List<Consulta> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select c from Consulta c "
                    + " where (1 = 1) ";
            
            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and c.codigo = " + dado;
                }else if (opcao.equals("PRONTUARIO")) {
                    sql += " and c.prontuario like '%" + dado + "%'";
                }else if (opcao.equals("HORARIO INICIO")) {
                    sql += " and c.horarioInicio like '%" + dado + "%'";
                }else if (opcao.equals("HORARIO FIM")) {
                    sql += " and c.horarioFim like '%" + dado + "%'";
                }else if (opcao.equals("DATA")) {
                    sql += " and c.data like '%" + dado + "%'";
                }else if (opcao.equals("ID MEDICO")) {
                    sql += " and c.medico.codigo = " + dado;
                }else if (opcao.equals("ID PACIENTE")) {
                    sql += " and c.paciente.codigo = " + dado;
                }else if (opcao.equals("VALOR")) {
                    sql += " and c.valor = " + dado;
                }
            }
            
            return em.createQuery(sql, Consulta.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}