package modelo;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Medico {

    public Medico(Integer codigo, String nome, Pessoa fkPessoa) {
        this.codigo = codigo;
        this.nome = nome;
        this.fkPessoa = fkPessoa;
    }

    public Medico() {
    }
    
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_PERIODO_TRABALHO = 50;
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "med_codigo")
    private Integer codigo;

    @Column(name = "med_periodo_trabalho", length = TAMANHO_PERIODO_TRABALHO)
    private String nome;
    
    @JoinColumn(name = "med_pess_codigo", nullable = false)
    private Pessoa fkPessoa;
    
    @ManyToMany
    @JoinTable(name = "medico_especializacao",
                    joinColumns = @JoinColumn(name = "med_codigo"),
                    inverseJoinColumns = @JoinColumn(name = "esp_codigo"))
    private List<Especializacao> especializacoes;

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

    public Pessoa getFkPessoa() {
        return fkPessoa;
    }

    public void setFkPessoa(Pessoa fkPessoa) {
        this.fkPessoa = fkPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codigo);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medico{" + "codigo=" + codigo + ", nome=" + nome + ", fkPessoa=" + fkPessoa + '}';
    }
    
    
}