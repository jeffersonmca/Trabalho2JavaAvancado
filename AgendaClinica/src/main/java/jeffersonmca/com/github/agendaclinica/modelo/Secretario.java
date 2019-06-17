package jeffersonmca.com.github.agendaclinica.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "pes_codigo")
public class Secretario extends Pessoa {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_PERIODO_TRABALHO = 50;
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sec_codigo")
    private Integer codigo;

    @Column(name = "sec_periodo_trabalho", length = TAMANHO_PERIODO_TRABALHO)
    private String periodoTrabalho;

    public Secretario() {
        
    }

    public Secretario(Integer codigo, String periodoTrabalho) {
        this.codigo = codigo;
        this.periodoTrabalho = periodoTrabalho;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPeriodoTrabalho() {
        return periodoTrabalho;
    }

    public void setPeriodoTrabalho(String periodoTrabalho) {
        this.periodoTrabalho = periodoTrabalho;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Secretario other = (Secretario) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.codigo + "-" + this.getNome();
    }    
}