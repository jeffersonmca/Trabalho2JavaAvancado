package servico;

import java.util.List;
import modelo.Secretario;
import dao.DaoSecretario;
import excecao.ExcecaoDao;
import excecao.ExcecaoServico;
import excecao.ExcecaoValidacao;

public class ServicoSecretario {
    
    private DaoSecretario dao;

    public ServicoSecretario() {
        dao = new DaoSecretario();
    }
    
    public void editar(Secretario instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.SecretarioEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Secretario!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Secretario!");
        }
    }
    
    public void salvar(Secretario instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.Secretario(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Secretario!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Secretario!");
        }
    }

    public List<Secretario> buscarTodos() throws ExcecaoDao {
        return dao.buscarTodos();
    }
    
    public Secretario buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDao {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um Secretario!");
        }
    }
    
    
    public Secretario remover(Integer codigo) throws ExcecaoDao, ExcecaoServico {
        
        try {
        	
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Secretario aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um Secretario!");
        }
    }
}