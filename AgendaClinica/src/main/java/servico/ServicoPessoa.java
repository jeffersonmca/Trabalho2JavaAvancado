package servico;

import java.util.List;
import modelo.Pessoa;
import dao.DaoPessoa;
import excecao.ExcecaoDao;
import excecao.ExcecaoServico;
import excecao.ExcecaoValidacao;

public class ServicoPessoa {
    
    private DaoPessoa dao;

    public ServicoPessoa() {
        dao = new DaoPessoa();
    }
    
    public void editar(Pessoa instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.PessoaEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Pessoa!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Pessoa!");
        }
    }
    
    public void salvar(Pessoa instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.Pessoa(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Pessoa!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Pessoa!");
        }
    }

    public List<Pessoa> buscarTodos() throws ExcecaoDao {
        return dao.buscarTodos();
    }
    
    public Pessoa buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDao {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um Pessoa!");
        }
    }
    
    
    public Pessoa remover(Integer codigo) throws ExcecaoDao, ExcecaoServico {
        
        try {
        	
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Pessoa aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um Pessoa!");
        }
    }
}