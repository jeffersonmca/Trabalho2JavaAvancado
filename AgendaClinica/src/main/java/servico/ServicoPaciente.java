package servico;

import java.util.List;
import modelo.Paciente;
import dao.DaoPaciente;
import excecao.ExcecaoDao;
import excecao.ExcecaoServico;
import excecao.ExcecaoValidacao;

public class ServicoPaciente {
    
    private DaoPaciente dao;

    public ServicoPaciente() {
        dao = new DaoPaciente();
    }
    
    public void editar(Paciente instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.PacienteEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Paciente!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Paciente!");
        }
    }
    
    public void salvar(Paciente instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.Paciente(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Paciente!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Paciente!");
        }
    }

    public List<Paciente> buscarTodos() throws ExcecaoDao {
        return dao.buscarTodos();
    }
    
    public Paciente buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDao {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um Paciente!");
        }
    }
    
    
    public Paciente remover(Integer codigo) throws ExcecaoDao, ExcecaoServico {
        
        try {
        	
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Paciente aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um Paciente!");
        }
    }
}