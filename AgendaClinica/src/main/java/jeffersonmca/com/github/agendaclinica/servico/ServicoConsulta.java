package jeffersonmca.com.github.agendaclinica.servico;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.modelo.Consulta;
import jeffersonmca.com.github.agendaclinica.dao.DAOConsulta;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class ServicoConsulta {
    
    private DAOConsulta dao;

    public ServicoConsulta() {
        dao = new DAOConsulta();
    }
    
    public void editar(Consulta instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.ConsultaEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Consulta!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Consulta!");
        }
    }
    
    public void salvar(Consulta instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.Consulta(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Consulta!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Consulta!");
        }
    }

    public List<Consulta> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Consulta buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de uma Consulta!");
        }
    }
    
    
    public Consulta remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
        	
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Consulta aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de uma Consulta!");
        }
    }
    
    public List<Consulta> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        // Se a opcao for SEM FILTRO, nao importa se o resto esta vazio
        if (opcao.equals("SEM FILTRO")) {
            return dao.buscarPor(opcao, null);
        }

//ID
//PRONTUARIO
//ID MEDICO
//ID PACIENTE
//HORARIO INICIO
//HORARIO FIM
//DATA
//VALOR        
        
        // Se a opcao NAO for SEM FILTRO, agora iremos verificar se o campo esta vazio
        if  (!(opcao.equals("SEM FILTRO")) && (!Validacao.Vazio(dado))) {
            
            // Devem ser INTEGER
            if ((opcao.equals("CODIGO")) ||
                (opcao.equals("ID MEDICO")) ||
                (opcao.equals("ID PACIENTE"))) {
                
                // Verifica se string eh numero
                boolean ehNumero = dado.matches("[0-9]+");
                
                if (ehNumero)                
                    return dao.buscarPor(opcao, Integer.parseInt(dado));
            }
            
            // Devem ser STRING
            if (opcao.equals("PRONTUARIO"))
                return dao.buscarPor(opcao, dado);
            
            // Devem ser HORA
            if ((opcao.equals("HORARIO INICIO")) ||
                (opcao.equals("HORARIO FIM"))) {
                
                if (Validacao.Hora(dado))
                    return dao.buscarPor(opcao, dado);
            }
            
            // Devem ser DATA
            if (opcao.equals("DATA")) {
                
                if (Validacao.Data(dado))
                    return dao.buscarPor(opcao, dado);
            }
            
            // Devem ser FLOAT
            if (opcao.equals("VALOR")) {
                
                if (Validacao.PontoFlutuante(dado))
                    return dao.buscarPor(opcao, Float.parseFloat(dado));
            }
        }
        
        return null;
    }
}