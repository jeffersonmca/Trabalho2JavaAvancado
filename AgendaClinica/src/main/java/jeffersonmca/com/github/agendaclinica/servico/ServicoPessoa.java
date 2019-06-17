package jeffersonmca.com.github.agendaclinica.servico;

import java.util.List;
import jeffersonmca.com.github.agendaclinica.modelo.Pessoa;
import jeffersonmca.com.github.agendaclinica.dao.DAOPessoa;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class ServicoPessoa {
    
    private DAOPessoa dao;

    public ServicoPessoa() {
        dao = new DAOPessoa();
    }
    
    public void editar(Pessoa instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.PessoaEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Pessoa!");
            }
            
        } catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Pessoa!");
        }
    }
    
    public void salvar(Pessoa instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Pessoa(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Pessoa!");
            }
            
        } catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Pessoa!");
        }
    }

    public List<Pessoa> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Pessoa buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de uma Pessoa!");
        }
    }
    
    
    public Pessoa remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
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
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de uma Pessoa!");
        }
    }
    
    public List<Pessoa> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        // Se a opcao for SEM FILTRO, nao importa se o resto esta vazio
        if (opcao.equals("SEM FILTRO")) {
            return dao.buscarPor(opcao, null);
        }

//CODIGO
//NOME
//CPF
//IDADE
//SEXO
//ID ENDERECO
//ID CONTATO
        
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
                (opcao.equals("SEXO"))) {
                
                return dao.buscarPor(opcao, dado);
            }
        }
        
        return null;
    }
}