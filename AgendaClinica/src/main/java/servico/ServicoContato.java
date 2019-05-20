package servico;

import dao.DaoContato;
import excecao.ExcecaoDao;
import excecao.ExcecaoServico;
import excecao.ExcecaoValidacao;
import java.util.List;
import modelo.Contato;

public class ServicoContato {
    
    private DaoContato dao;

    public ServicoContato() {
        dao = new DaoContato();
    }
    
    public void editar(Contato instancia) throws ExcecaoDao, ExcecaoServico {
        
    	try {
            /*Regra de negocio*/
            dao.salvar(instancia); 
    	} catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do ambiente!");
        }
    }
    
    public void salvar(Contato instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
               dao.salvar(instancia);       
    	} catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do ambiente!");
        }
    }

    public List<Contato> buscarTodos() throws ExcecaoDao {
        return dao.buscarTodos();
    }
    
    public Contato buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDao {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um ambiente!");
        }
    }
    
    
    public Contato remover(Integer codigo) throws ExcecaoDao, ExcecaoServico {
        
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
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um ambiente!");
        }
    }
}