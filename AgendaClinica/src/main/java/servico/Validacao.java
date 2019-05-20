package servico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import modelo.Consulta;
import modelo.Endereco;
import modelo.Medico;
import modelo.Paciente;
import modelo.Pessoa;
import modelo.Endereco;
import modelo.Permissao;
import modelo.Secretario;
import modelo.Usuario;

public class Validacao {

    public Validacao() { 
        
    }
    
    /**
     * Verifica se o argumento esta Vazio
     * @param texto - O texto informado para ser verificado. 
     * @return Vazio=true	Preenchido=false
     */
    public static boolean Vazio(String texto) {
        
        // Argumento esta vazio?
        if (Alocado(texto)) {
            
            // Continua vazio?
            if (!(texto.trim().equals(""))) {
                return false; 
            }
        }
        
        return true;
    }

    public static boolean Vazio(Enum instancia) {
        
        // Argumento esta vazio?
        if (Alocado(instancia)) {
            
            String texto = instancia.toString();
        	
            // Continua vazio?
            if (!(texto.trim().equals(""))) {
                return false; 
            }
        }
        
        return true;
    }
        
    public static boolean Vazio(Object [] vetor) {
        
        // Argumento esta vazio?
        if (Alocado(vetor)) {
            
            // Tem algo nele?
            if (vetor.length != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean Vazio(List vetor) {
        
        // Argumento esta vazio?
        if (Alocado(vetor)) {
            
            // Tem algo nele?
            if (vetor.size() != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean Identificador(Object id) {
         return NaturalNaoNulo(id);
    }
    
    public static boolean NaturalNaoNulo(Object id) {
                
        // Argumento esta vazio?
        if (Alocado(id)) {
                  
            // Argumento eh do tipo esperado?
            if (id instanceof Integer) {

                // Eh valido para BD?
                if ((Integer)id > 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean Alocado(Object instancia) {
        // Argumento esta vazio?
        if (instancia != null) {
            return true;
        }
        
        return false;
    }
    
    public static boolean Data(Date data) {
        // Argumento esta vazio?
        if (Alocado(data)) {
            // Argumento esta vazio?
            if (Data(data.toString())) {
               return true;
            }
            return false;
        }
        return false;
    }
    
    public static boolean Data(String data) {
        // Argumento esta vazio?
        if (Alocado(data)) {
            // Esta no formato correto ?
            try{
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate d = LocalDate.parse(data, formato);
                return true;
            }catch(DateTimeParseException erro){
                return false;
            }
        }
        return false;
    }
    
    public static boolean ConsultaEdita(Consulta instancia) {
        if(Alocado(instancia)){
            if(Identificador(instancia.getCodigo())){
                return Consulta(instancia);
            }      
        }
        return false;
    }    
    public static boolean Consulta(Consulta instancia) {
        //Alocado?
        if(Alocado(instancia)){
            //Data é valida?
            if(Data(instancia.getData())){
               //Possui Chave Estrangeira Medico
               if(Medico(instancia.getFkMedico())){
                    //Possui Chave Estrangeira 
                    if(Paciente(instancia.getFkPaciente())){
                        return true;
                    }
                }        
            }
        }
        return false;
        
    }
    public static boolean EnderecoEdita(Endereco instancia) {
        if(Alocado(instancia)){
            if(Identificador(instancia.getCodigo())){
                return Endereco(instancia);
            }      
        }
        return false;
    }
    public static boolean Endereco(Endereco instancia) {
        //Alocado?
        if(Alocado(instancia)){
            //Rua é valida?
            if(Vazio(instancia.getRua())){
                //Bairroé valida?
                if(Vazio(instancia.getBairro())){
                    //cidade é valida?
                    if(Vazio(instancia.getCidade())){
                        //Numero é valida?
                        if(NaturalNaoNulo(instancia.getNumero())){
                            //Cep é valida?
                            if(Vazio(instancia.getRua())){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean MedicoEdita(Medico instancia) {
        if(Alocado(instancia)){
            if(Identificador(instancia.getCodigo())){
                return Medico(instancia);
            }      
        }
        return false;
    } 
    public static boolean Medico(Medico instancia) {
        //Alocado?
        if(Alocado(instancia)){
            //Pessoa é valida?
            if(Pessoa(instancia.getFkPessoa())){
                return true;
            }
        }
        return false;
    }
    public static boolean PacienteEdita(Paciente instancia) {
        if(Alocado(instancia)){
            if(Identificador(instancia.getCodigo())){
                return Paciente(instancia);
            }      
        }
        return false;
    }
    public static boolean Paciente(Paciente instancia) {
        //Alocado?
        if(Alocado(instancia)){
            //Rua é valida?
            if(Pessoa(instancia.getFkPessoa())){
                return true;
            }
        }
        return false;
    }
    public static boolean PessoaEdita(Pessoa instancia) {
        if(Alocado(instancia)){
            if(Identificador(instancia.getCodigo())){
                return Pessoa(instancia);
            }      
        }
        return false;
    }
    public static boolean Pessoa(Pessoa instancia) {
        //Alocado?
        if(Alocado(instancia)){        //Nome
            if(Vazio(instancia.getNome())){
                //Cpf
                if(Vazio(instancia.getCpf())){
                    //Idade
                    if(NaturalNaoNulo(instancia.getIdade())){
                        //Sexo
                        if(Vazio(instancia.getSexo())){
                            //Endereco
                            if(Endereco(instancia.getFkEndereco())){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean SecretarioEdita(Secretario instancia) {
        if(Alocado(instancia)){
            if(Identificador(instancia.getCodigo())){
                return Secretario(instancia);
            }      
        }
        return false;
    }
    public static boolean Secretario(Secretario instancia) {
        //Alocado?
        if(Alocado(instancia)){
            if(Pessoa(instancia.getFkPessoa())){
                return true;
            }
        }
        return false;
    }
    public static boolean UsuarioEdita(Usuario instancia) {
        if(Alocado(instancia)){
            if(Identificador(instancia.getCodigo())){
                return Usuario(instancia);
            }      
        }
        return false;
    }
    public static boolean Usuario(Usuario instancia) {
        //Alocado?
        if(Alocado(instancia)){
            if(Vazio(instancia.getAutenticador())){
                if(Vazio(instancia.getSenha())){
                    if(Pessoa(instancia.getFkPessoa())){
                        return true;
                    }
                }
            }
        }
        return false;
    }    
    public static boolean PermissaoEdita(Permissao instancia) {
        if(Alocado(instancia)){
            if(Identificador(instancia.getCodigo())){
                return Permissao(instancia);
            }      
        }
        return false;
    }
    public static boolean Permissao(Permissao instancia) {
        //Alocado?
        if(Alocado(instancia)){
            if(Vazio(instancia.getDescricao())){
                return true;
            }
        }
        return false;
    }    
}

