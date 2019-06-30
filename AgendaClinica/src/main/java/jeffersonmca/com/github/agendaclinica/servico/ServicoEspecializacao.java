package jeffersonmca.com.github.agendaclinica.servico;

import jeffersonmca.com.github.agendaclinica.dao.DAOEspecializacao;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import java.util.List;
import jeffersonmca.com.github.agendaclinica.modelo.Especializacao;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class ServicoEspecializacao {
    
    private DAOEspecializacao dao;

    public ServicoEspecializacao() {
        dao = new DAOEspecializacao();
    }
    
    public void editar(Especializacao instancia) throws ExcecaoDAO, ExcecaoServico {
        
        try {
            /*Regra de negocio*/
            dao.salvar(instancia); 
        } catch (ExcecaoDAO e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Especialização!");
        }
    }
    
    public void salvar(Especializacao instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
               dao.salvar(instancia);       
        } catch (ExcecaoDAO e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Especialização!");
        }
    }

    public List<Especializacao> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Especializacao buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de uma Especialização!");
        }
    }
    
    
    public Especializacao remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Especializacao aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de uma Especialização!");
        }
    }
    
    public List<Especializacao> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
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
            if ((opcao.equals("NOME")) ||
                (opcao.equals("AREA"))) {
                
                return dao.buscarPor(opcao, dado);
            }
        }
        
        return null;
    }

    public List<Especializacao> buscarEspecializacoesForaDaGrid(List<Especializacao> especializacoes) throws ExcecaoDAO {
        return dao.buscarEspecializacoesForaDaGrid(especializacoes);
    }
}