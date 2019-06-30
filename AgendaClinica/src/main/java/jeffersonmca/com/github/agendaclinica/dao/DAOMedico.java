package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Medico;

public class DAOMedico extends DAOGenerico<Medico, Integer> {

    public List<Medico> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select m from Medico m "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and m.codigo = " + dado;
                }else if (opcao.equals("NOME")) {
                    sql += " and m.nome like '%" + dado + "%'";
                }else if (opcao.equals("CPF")) {
                    sql += " and m.cpf like '%" + dado + "%'";
                }else if (opcao.equals("IDADE")) {
                    sql += " and m.idade = " + dado;
                }else if (opcao.equals("SEXO")) {
                    sql += " and m.sexo like '%" + dado + "%'";
                }else if (opcao.equals("ID ENDERECO")) {
                    sql += " and m.endereco.codigo = " + dado;
                }else if (opcao.equals("ID CONTATO")) {
                    sql += " and m.contato.codigo = " + dado;
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