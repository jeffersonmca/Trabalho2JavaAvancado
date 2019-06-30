package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;

public class DAOEndereco extends DAOGenerico<Endereco, Integer> {

    public List<Endereco> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select e from Endereco e "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and e.codigo = " + dado;
                }else if (opcao.equals("RUA")) {
                    sql += " and e.rua like '%" + dado + "%'";
                }else if (opcao.equals("BAIRRO")) {
                    sql += " and e.bairro like '%" + dado + "%'";
                }else if (opcao.equals("CIDADE")) {
                    sql += " and e.cidade like '%" + dado + "%'";
                }else if (opcao.equals("NUMERO")) {
                    sql += " and e.numero = " + dado;
                }else if (opcao.equals("CEP")) {
                    sql += " and e.cep like '%" + dado + "%'";
                }else if (opcao.equals("COMPLEMENTO")) {
                    sql += " and e.complemento like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Endereco.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}