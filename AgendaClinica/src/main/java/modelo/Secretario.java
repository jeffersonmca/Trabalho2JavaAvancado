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
public class Secretario {

    public Secretario(Integer codigo, String nome, Paciente fkPessoa) {
        this.codigo = codigo;
        this.nome = nome;
        this.fkPessoa = fkPessoa;
    }

    public Secretario() {
    }
    
    
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_PERIODO_TRABALHO = 50;
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sec_codigo")
    private Integer codigo;

    @Column(name = "sec_periodo_trabalho", length = TAMANHO_PERIODO_TRABALHO)
    private String nome;
    
    @JoinColumn(name = "sec_pess_codigo", nullable = false)
    private Paciente fkPessoa;

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

    public Paciente getFkPessoa() {
        return fkPessoa;
    }

    public void setFkPessoa(Paciente fkPessoa) {
        this.fkPessoa = fkPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.codigo);
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
        final Secretario other = (Secretario) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Secretario{" + "codigo=" + codigo + ", nome=" + nome + ", fkPessoa=" + fkPessoa + '}';
    }
    
    
    
}