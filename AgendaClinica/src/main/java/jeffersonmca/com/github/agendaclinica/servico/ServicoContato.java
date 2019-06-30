package jeffersonmca.com.github.agendaclinica.servico;

import jeffersonmca.com.github.agendaclinica.dao.DAOContato;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import java.util.List;
import jeffersonmca.com.github.agendaclinica.modelo.Contato;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class ServicoContato {
    
    private DAOContato dao;

    public ServicoContato() {
        dao = new DAOContato();
    }
    
    public void editar(Contato instancia) throws ExcecaoDAO, ExcecaoServico {
        
    	try {
            /*Regra de negocio*/
            if (Validacao.ContatoEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar o Contato!");
            }
            
    	} catch (ExcecaoDAO e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Contato!");
        }
    }
    
    public void salvar(Contato instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.Contato(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar o Contato!");
            }
            
    	} catch (ExcecaoDAO e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Contato!");
        }
    }

    public List<Contato> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Contato buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um Contato!");
        }
    }
    
    
    public Contato remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
        	
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Contato aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um Contato!");
        }
    }
    
    public List<Contato> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        // Se a opcao for SEM FILTRO, nao importa se o resto esta vazio
        if (opcao.equals("SEM FILTRO")) {
            return dao.buscarPor(opcao, null);
        }
        
        // Se a opcao NAO for SEM FILTRO, agora iremos verificar se o campo esta vazio
        if  (!(opcao.equals("SEM FILTRO")) && (!Validacao.Vazio(dado))) {
            
            // Devem ser INTEGER
            if (opcao.equals("CODIGO")) {
                
                // Verifica se string eh numero
                boolean ehNumero = dado.matches("[0-9]+");
                
                if (ehNumero)                
                    return dao.buscarPor(opcao, Integer.parseInt(dado));
            }
            
            // Devem ser STRING
            if ((opcao.equals("E-MAIL")) ||
                (opcao.equals("TELEFONE")) ||
                (opcao.equals("CELULAR"))) {            
            
                return dao.buscarPor(opcao, dado);
            }
        }
        
        return null;
    }
}