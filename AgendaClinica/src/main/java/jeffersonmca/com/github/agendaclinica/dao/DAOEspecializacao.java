package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Especializacao;

public class DAOEspecializacao extends DAOGenerico<Especializacao, Integer> {

    public List<Especializacao> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select e from Especializacao e "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and e.codigo = " + dado;
                }else if (opcao.equals("NOME")) {
                    sql += " and e.nome like '%" + dado + "%'";
                }else if (opcao.equals("AREA")) {
                    sql += " and e.area like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Especializacao.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
    
    public List<Especializacao> buscarEspecializacoesForaDaGrid(List<Especializacao> especializacoes) throws ExcecaoDAO {
        try {         
            
            String sql = "select e from Especializacao e "
                    + " where (1 = 1) ";
            
            for (Especializacao e : especializacoes) {
                if (e != null) {
                    sql += " and e.codigo != " + e.getCodigo();
                }
            }
            
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar as especializações!");
        }
    }
}