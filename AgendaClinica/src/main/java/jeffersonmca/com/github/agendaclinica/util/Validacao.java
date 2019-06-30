package jeffersonmca.com.github.agendaclinica.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import jeffersonmca.com.github.agendaclinica.modelo.Consulta;
import jeffersonmca.com.github.agendaclinica.modelo.Contato;
import jeffersonmca.com.github.agendaclinica.modelo.Medico;
import jeffersonmca.com.github.agendaclinica.modelo.Paciente;
import jeffersonmca.com.github.agendaclinica.modelo.Pessoa;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;
import jeffersonmca.com.github.agendaclinica.modelo.Permissao;
import jeffersonmca.com.github.agendaclinica.modelo.Secretario;
import jeffersonmca.com.github.agendaclinica.modelo.Usuario;

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
    
    public static boolean Hora(String hora) {
        
        // Argumento esta vazio?
        if (Alocado(hora)) {
        	
            // Esta no formato correto ?
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
            try {
                sdf.parse(hora);
                return true;
            } catch (ParseException ex) {
                return false;
            }
        }
        
        return false;
    }
    
    public static boolean PontoFlutuante(String valor) {

        // Argumento esta vazio?
        if (!Vazio(valor)) {
            
            try {
                return !new Float(valor).isNaN();
            } catch (NumberFormatException e) {
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
            // Verifica se o prontuario esta vazio
            if (!Vazio(instancia.getProntuario())) {                
                // Verifica se a hora eh valida
                if (Hora(Conversoes.timeToStr(instancia.getHorarioInicio()))) {
                    //Data é valida?
                    if(Data(Conversoes.dateToStr(instancia.getData()))){
                       //Possui Chave Estrangeira Medico
                       if(Medico(instancia.getMedico())){
                            //Possui Chave Estrangeira 
                            if(Paciente(instancia.getPaciente())){
                                return true;
                            }
                        }        
                    }
                }
            }
        }
        return false;
        
    }
    
    public static boolean ContatoEdita(Contato instancia) {
        if(Alocado(instancia)){
            if(Identificador(instancia.getCodigo())){
                return Contato(instancia);
            }      
        }
        return false;
    }
    
    public static boolean Contato(Contato instancia) {
        //Alocado?
        if(Alocado(instancia)){
            return true;
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
            if(!Vazio(instancia.getRua())){
                //Bairroé valida?
                if(!Vazio(instancia.getBairro())){
                    //cidade é valida?
                    if(!Vazio(instancia.getCidade())){
                        //Numero é valida?
                        if(NaturalNaoNulo(instancia.getNumero())){
                            //Cep é valida?
                            if(!Vazio(instancia.getCep())){
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
            if(Pessoa(instancia)){
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
            if(Pessoa(instancia)){
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
        if(Alocado(instancia)){
            //Nome
            if(!Vazio(instancia.getNome())){
                //Cpf
                if(!Vazio(instancia.getCpf())){
                    //Idade
                    if(NaturalNaoNulo(instancia.getIdade())){
                        //Sexo
                        if(!Vazio(instancia.getSexo())){
                            //Endereco
                            if(Endereco(instancia.getEndereco())){
                                //Contato
                                if(Contato(instancia.getContato())){
                                    return true;
                                }
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
            if(Pessoa(instancia)){
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
            if(!Vazio(instancia.getAutenticador())){
                if(!Vazio(instancia.getSenha())){
                    if(Pessoa(instancia)){
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
            if(!Vazio(instancia.getDescricao())){
                return true;
            }
        }
        return false;
    }

    /**
    * Verifica se o cpf é válido usando o cálculo do digito verificador.
    * @param texto O cpf a ser verificado.
    * @return boolean - Retorna true se o cpf for válido, caso contrário retorna false.
    */    
    public static boolean Cpf(String texto) {
                
        //Alocado?
        if(Alocado(texto)) {

            /*Verfica se nao esta vindo nada em caso de algum erro*/
            if (texto.equals("   .   .   -  ")){
                return(false);
            }

            /*Um cpf com os pontos e o traco tem tamanho 14*/
            if (texto.length() == 14){

                /*Cria um vetor de inteiro que ira guardar os 9 primeiros numeros do cpf*/
                int digitos[] = new int[10];

                /*Cria um vetor de pesos para auxiliar na parte do digito verificador*/
                int pesos[]   = new int[10];

                /*Variavel string para auxiliar na parte de conferir se os numeros sao iguais*/
                String iguais = "";

                /*Variavel para auxiliar em qual posicao do vetor colocar os valores*/            
                int auxilia = 0;

                /*Loop indo de 0 a 10, ou seja, ele ira trabalhar so com os 9 primeiros numeros do cpf e os 2 pontos*/
                for (int i = 0; i < (texto.length() - 3); i++) {

                    /*Nessas posicoes estao os pontos e o traco, portanto nao faz nada*/
                    if ((i == 3) || (i == 7)){
                        continue;
                    }

                    digitos[auxilia]   = Integer.parseInt(String.valueOf(texto.charAt(i)));                
                    pesos[auxilia + 1] = (pesos.length - auxilia);

                    auxilia++;
                }

                /*Os mesmos numeros em sequencias burlam o calculo do digito verificador*/
                for (int i = 0; i < (digitos.length - 1); i++) {
                    iguais += digitos[i];                
                }

                /*Esses casos burlam o calculo do digito verificador entao tem que ser verificados separadamentes*/
                if (iguais.equals("111111111") ||
                    iguais.equals("222222222") ||
                    iguais.equals("333333333") ||
                    iguais.equals("444444444") ||
                    iguais.equals("555555555") ||
                    iguais.equals("666666666") ||
                    iguais.equals("777777777") ||
                    iguais.equals("888888888") ||
                    iguais.equals("999999999")){

                    return false;
                }

                /*Variavel auxiliar para guardar a soma da multiplicao dos digitos pelos pesos*/
                int soma = 0;            

                /**********************
                 * Digito verificador *
                 **********************/

                /*Primeiro digito verificador*/
                for (int i = 0; i < (digitos.length - 1); i++) {
                    soma += (digitos[i] * pesos[i + 1]);
                }

                /*
                  O resultado obtido sera divido por 11. Considere como quociente apenas o valor inteiro obtido na divisao, 
                  o resto da divisao sera responsavel pelo calculo do primeiro digito verificador.
                  Se o resultado da subtracao for maior que 9, o digito verificador e ZERO. 
                  Caso contrario, o digito verificador e o resultado dessa subtracao.
                */
                int restoDivisao = (soma % 11);
                int aux = 11 - restoDivisao;
                int primeiroVerificador = 0;
                if (!(aux > 9)){
                    primeiroVerificador = aux;
                }

                /*
                  Para calcular o segundo digito verificador, fazemos o calculo de forma analoga ao primeiro digito, 
                  acrescentando ao CPF o digito encontrado no passo anterior.
                  Na segunda linha, os pesos sao distribuidos comecando por 11.
                */
                soma     = 0; 
                pesos[0] = 11;
                digitos[digitos.length - 1] = primeiroVerificador;

                /*Segundo digito verificador*/
                for (int i = 0; i < digitos.length; i++) {
                    soma += (digitos[i] * pesos[i]);
                }

                /*Para calcular o digito verificador, voce deve subtrair o resto encontrado de onze.
                  Como agora o resultado da subtracao nao e maior que 9, o resultado e o proprio digito verificador.
                */
                restoDivisao = (soma % 11);
                int segundoVerificador = (11 - restoDivisao);

                /*Verificando no cpf informado se os dois digitos correspondem ao calculos*/
                int cpfPenultimoDigito = Integer.parseInt(String.valueOf(texto.charAt(texto.length() - 2)));
                int cpfUltimoDigito    = Integer.parseInt(String.valueOf(texto.charAt(texto.length() - 1)));

                /*Se os valores sao iguais o cpf e aceito*/
                if ((cpfPenultimoDigito == primeiroVerificador) &&
                    (cpfUltimoDigito    == segundoVerificador)){
                    return true;
                }

            }

            /*Houve alguma inconsistencia*/
            return(false);
        }
        
        return(false);
    }
}