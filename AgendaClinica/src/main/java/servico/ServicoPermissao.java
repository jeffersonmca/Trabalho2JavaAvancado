package servico;

import java.util.List;
import modelo.Permissao;
import dao.DaoPermissao;
import excecao.ExcecaoDao;
import excecao.ExcecaoServico;
import excecao.ExcecaoValidacao;

public class ServicoPermissao {
    
    private DaoPermissao dao;

    public ServicoPermissao() {
        dao = new DaoPermissao();
    }
    
    public void editar(Permissao instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.PermissaoEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Permissao!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Permissao!");
        }
    }
    
    public void salvar(Permissao instancia) throws ExcecaoDao, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.Permissao(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Permissao!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (ExcecaoDao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Permissao!");
        }
    }

    public List<Permissao> buscarTodos() throws ExcecaoDao {
        return dao.buscarTodos();
    }
    
    public Permissao buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDao {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um Permissao!");
        }
    }
    
    
    public Permissao remover(Integer codigo) throws ExcecaoDao, ExcecaoServico {
        
        try {
        	
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Permissao aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDao e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um Permissao!");
        }
    }
}