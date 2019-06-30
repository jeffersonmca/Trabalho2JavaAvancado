package jeffersonmca.com.github.agendaclinica.servico;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.modelo.Usuario;
import jeffersonmca.com.github.agendaclinica.dao.DAOUsuario;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class ServicoUsuario {
    
    private DAOUsuario dao;

    public ServicoUsuario() {
        dao = new DAOUsuario();
    }
    
    public void editar(Usuario instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.UsuarioEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar o Usuario!");
            }
            
        } catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDAO e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Usuario!");
        }
    }
    
    public void salvar(Usuario instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Usuario(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar o Usuario!");
            }
            
        } catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDAO e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Usuario!");
        }
    }

    public List<Usuario> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Usuario buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um Usuario!");
        }
    }
    
    
    public Usuario remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Usuario aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um Usuario!");
        }
    }
    
    public List<Usuario> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        // Se a opcao for SEM FILTRO, nao importa se o resto esta vazio
        if (opcao.equals("SEM FILTRO")) {
            return dao.buscarPor(opcao, null);
        }
        
        // Se a opcao NAO for SEM FILTRO, agora iremos verificar se o campo esta vazio
        if  (!(opcao.equals("SEM FILTRO")) && (!Validacao.Vazio(dado))) {
            
            // Devem ser INTEGER
            if ((opcao.equals("CODIGO")) ||
                (opcao.equals("IDADE")) ||
                (opcao.equals("ID ENDERECO")) ||
                (opcao.equals("ID CONTATO"))) {
                
                // Verifica se string eh numero
                boolean ehNumero = dado.matches("[0-9]+");
                
                if (ehNumero)                
                    return dao.buscarPor(opcao, Integer.parseInt(dado));
            }
            
            // Devem ser STRING
            if ((opcao.equals("NOME")) ||
                (opcao.equals("CPF")) ||
                (opcao.equals("SEXO")) ||
                (opcao.equals("AUTENTICADOR"))) {
                
                return dao.buscarPor(opcao, dado);
            }
        }
        
        return null;
    }
    
    public Usuario buscarPorAutenticador(String autenticador) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (!Validacao.Vazio(autenticador)) {
                return dao.buscarPorAutenticador(autenticador);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um Usuário!");
        }
    }

    public boolean logar(Usuario login, String senha) {
        
        // Se as senhas baterem entao ele pode logar
        if (login.getSenha().equals(senha))
             return true;
        else return false;
    }
}