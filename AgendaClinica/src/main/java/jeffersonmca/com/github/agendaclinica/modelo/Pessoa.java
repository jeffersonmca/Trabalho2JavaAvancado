package jeffersonmca.com.github.agendaclinica.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
      
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_NOME = 50;

    @Transient
    private final int TAMANHO_CPF = 15;
    
    @Transient
    private final int TAMANHO_SEXO = 15;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_codigo")
    private Integer codigo;

    @Column(name = "pes_nome", nullable = false, length = TAMANHO_NOME)
    private String nome;

    @Column(name = "pes_cpf", nullable = false, unique = true, length = TAMANHO_CPF)
    private String cpf;

    @Column(name = "pes_idade", nullable = false)
    private Integer idade;

    @Enumerated(EnumType.STRING)
    @Column(name = "pes_sexo", nullable = false, length = TAMANHO_SEXO)
    private EnumSexo sexo;

    @JoinColumn(name = "pes_endCodigo", nullable = false)
    private Endereco endereco;

    @JoinColumn(name = "pes_cotCodigo", nullable = false)
    private Contato contato;

    public Pessoa() {
        
    }

    public Pessoa(Integer codigo, String nome, String cpf, Integer idade, EnumSexo sexo, Endereco endereco, Contato contato) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public EnumSexo getSexo() {
        return sexo;
    }

    public void setSexo(EnumSexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.codigo + "-" + this.nome;
    }    
}