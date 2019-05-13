package modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Pessoa {

    public Pessoa(Integer codigo, String nome, String cpf, Integer idade, String sexo, Endereco fkEndereco, Contato fkContato) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.fkEndereco = fkEndereco;
        this.fkContato = fkContato;
    }

    public Pessoa() {
    }
    
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

    @Column(name = "pes_cpf", nullable = false, length = TAMANHO_CPF)
    private String cpf;

    @Column(name = "pes_idade", nullable = false)
    private Integer idade;

    @Column(name = "pes_sexo", nullable = false, length = TAMANHO_SEXO)
    private String sexo;

    @JoinColumn(name = "pes_end_codigo", nullable = false)
    private Endereco fkEndereco;

    @JoinColumn(name = "pes_cot_codigo", nullable = false)
    private Contato fkContato;

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Endereco getFkEndereco() {
        return fkEndereco;
    }

    public void setFkEndereco(Endereco fkEndereco) {
        this.fkEndereco = fkEndereco;
    }

    public Contato getFkContato() {
        return fkContato;
    }

    public void setFkContato(Contato fkContato) {
        this.fkContato = fkContato;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.codigo);
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
        return "Pessoa{" + "codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", sexo=" + sexo + ", fkEndereco=" + fkEndereco + ", fkContato=" + fkContato + '}';
    }

    
}