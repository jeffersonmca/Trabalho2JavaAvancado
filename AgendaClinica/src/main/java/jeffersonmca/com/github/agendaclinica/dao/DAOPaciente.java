package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Paciente;

public class DAOPaciente extends DAOGenerico<Paciente, Integer> {

    public List<Paciente> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select p from Paciente p "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and p.codigo = " + dado;
                }else if (opcao.equals("NOME")) {
                    sql += " and p.nome like '%" + dado + "%'";
                }else if (opcao.equals("CPF")) {
                    sql += " and p.cpf like '%" + dado + "%'";
                }else if (opcao.equals("IDADE")) {
                    sql += " and p.idade = " + dado;
                }else if (opcao.equals("SEXO")) {
                    sql += " and p.sexo like '%" + dado + "%'";
                }else if (opcao.equals("ID ENDERECO")) {
                    sql += " and p.endereco.codigo = " + dado;
                }else if (opcao.equals("ID CONTATO")) {
                    sql += " and p.contato.codigo = " + dado;
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