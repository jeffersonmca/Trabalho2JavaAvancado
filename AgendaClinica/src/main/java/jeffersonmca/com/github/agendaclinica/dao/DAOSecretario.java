package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Secretario;

public class DAOSecretario extends DAOGenerico<Secretario, Integer> {

    public List<Secretario> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select s from Secretario s "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and s.codigo = " + dado;
                }else if (opcao.equals("NOME")) {
                    sql += " and s.nome like '%" + dado + "%'";
                }else if (opcao.equals("CPF")) {
                    sql += " and s.cpf like '%" + dado + "%'";
                }else if (opcao.equals("IDADE")) {
                    sql += " and s.idade = " + dado;
                }else if (opcao.equals("SEXO")) {
                    sql += " and s.sexo like '%" + dado + "%'";
                }else if (opcao.equals("ID ENDERECO")) {
                    sql += " and s.endereco.codigo = " + dado;
                }else if (opcao.equals("ID CONTATO")) {
                    sql += " and s.contato.codigo = " + dado;
                }else if (opcao.equals("PERIODO TRABALHO")) {
                    sql += " and s.periodoTrabalho like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Secretario.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}