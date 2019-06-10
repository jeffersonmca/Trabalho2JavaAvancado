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
public class Paciente {

    public Paciente(Integer codigo, String convenio, Pessoa fkPessoa) {
        this.codigo = codigo;
        this.convenio = convenio;
        this.fkPessoa = fkPessoa;
    }

    public Paciente() {
    }
    
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_CONVENIO = 50;
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pac_codigo")
    private Integer codigo;

    @Column(name = "pac_convenio", length = TAMANHO_CONVENIO)
    private String convenio;
    
    @JoinColumn(name = "pac_pes_codigo", nullable = false)
    private Pessoa fkPessoa;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
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
        hash = 79 * hash + Objects.hashCode(this.codigo);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paciente{" + "codigo=" + codigo + ", convenio=" + convenio + ", fkPessoa=" + fkPessoa + '}';
    }
    
}