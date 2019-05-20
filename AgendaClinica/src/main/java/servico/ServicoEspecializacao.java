package servico;

import dao.DaoEspecializacao;
import excecao.ExcecaoDao;
import excecao.ExcecaoServico;
import excecao.ExcecaoValidacao;
import java.util.List;
import modelo.Especializacao;

public class ServicoEspecializacao {
    
    private DaoEspecializacao dao;

    public ServicoEspecializacao() {
        dao = new DaoEspecializacao();
    }
    
    public void editar(Especializacao instancia) throws ExcecaoDao, ExcecaoServico {
        
    	try {
            /*Regra de negocio*/
            dao.salvar(instancia); 
    	} catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do ambiente!");
        }
    }
    
    public void salvar(Especializacao instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
               dao.salvar(instancia);       
    	} catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do ambiente!");
        }
    }

    public List<Especializacao> buscarTodos() throws ExcecaoDao {
        return dao.buscarTodos();
    }
    
    public Especializacao buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDao {
        
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
    
    
    public Especializacao remover(Integer codigo) throws ExcecaoDao, ExcecaoServico {
        
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
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um ambiente!");
        }
    }
}