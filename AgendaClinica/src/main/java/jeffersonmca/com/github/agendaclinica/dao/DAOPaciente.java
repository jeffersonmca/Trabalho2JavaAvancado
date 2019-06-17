package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Paciente;

public class DAOPaciente extends DAOGenerico<Paciente, Integer> {

    public List<Paciente> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select p from Paciente p "
                    + " where (1 = 1) ";
//CODIGO
//CONVENIO

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and p.codigo = " + dado;
                }else if (opcao.equals("CONVENIO")) {
                    sql += " and p.convenio like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Paciente.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}