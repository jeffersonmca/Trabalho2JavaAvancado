package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Pessoa;

public class DAOPessoa extends DAOGenerico<Pessoa, Integer> {

    public List<Pessoa> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select p from Pessoa p "
                    + " where (1 = 1) ";
//CODIGO
//NOME
//CPF
//IDADE
//SEXO
//ID ENDERECO
//ID CONTATO

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and p.codigo = " + dado;
                }else if (opcao.equals("NOME")) {
                    sql += " and p.nome like '%" + dado + "%'";
                }else if (opcao.equals("CPF")) {
                    sql += " and p.cpf like '%" + dado + "%'";
                }else if (opcao.equals("IDADE")) {
                    sql += " and p.idadae = " + dado;
                }else if (opcao.equals("SEXO")) {
                    sql += " and p.sexo like '%" + dado + "%'";
                }else if (opcao.equals("ID ENDERECO")) {
                    sql += " and p.endereco.codigo = " + dado;
                }else if (opcao.equals("ID CONTATO")) {
                    sql += " and p.contato.codigo = " + dado;
                }
            }
            
            return em.createQuery(sql, Pessoa.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}