package jeffersonmca.com.github.agendaclinica.dao;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Usuario;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class DAOUsuario extends DAOGenerico<Usuario, Integer> {

    public List<Usuario> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select u from Usuario u "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and u.codigo = " + dado;
                }else if (opcao.equals("NOME")) {
                    sql += " and u.nome like '%" + dado + "%'";
                }else if (opcao.equals("CPF")) {
                    sql += " and u.cpf like '%" + dado + "%'";
                }else if (opcao.equals("IDADE")) {
                    sql += " and u.idade = " + dado;
                }else if (opcao.equals("SEXO")) {
                    sql += " and u.sexo like '%" + dado + "%'";
                }else if (opcao.equals("ID ENDERECO")) {
                    sql += " and u.endereco.codigo = " + dado;
                }else if (opcao.equals("ID CONTATO")) {
                    sql += " and u.contato.codigo = " + dado;
                }else if (opcao.equals("AUTENTICADOR")) {
                    sql += " and u.autenticador like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Usuario.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
    
    public Usuario buscarPorAutenticador(String autenticador) throws ExcecaoDAO {
        
        try {            
            String sql = "select u from Usuario u "
                    + " where (1 = 1) "
                    + " and u.autenticador = '" + autenticador + "'";
            
            List<Usuario> usuarios = em.createQuery(sql, Usuario.class).getResultList();            
            for (Usuario u : usuarios) {
                
                if (Validacao.Alocado(u)) {
                    return u;
                }
            }
            
            return null;
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}