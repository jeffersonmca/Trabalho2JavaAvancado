package jeffersonmca.com.github.agendaclinica.modelo;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "pes_codigo")
public class Medico extends Pessoa {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_PERIODO_TRABALHO = 50;     
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "med_codigo")
    private Integer codigo;

    @Column(name = "med_periodo_trabalho", length = TAMANHO_PERIODO_TRABALHO)
    private String periodoTrabalho;
    
    @ManyToMany
    @JoinTable(name = "MEDICO_ESPECIALIZACAO",
                    joinColumns = @JoinColumn(name = "med_codigo"),
                    inverseJoinColumns = @JoinColumn(name = "esp_codigo"))
    private List<Especializacao> especializacoes;

    public Medico() {
        
    }

    public Medico(Integer codigo, String periodoTrabalho, List<Especializacao> especializacoes) {
        this.codigo = codigo;
        this.periodoTrabalho = periodoTrabalho;
        this.especializacoes = especializacoes;
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

    public List<Especializacao> getEspecializacoes() {
        return especializacoes;
    }

    public void setEspecializacoes(List<Especializacao> especializacoes) {
        this.especializacoes = especializacoes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        return this.codigo + "-" + this.getNome();
    }
}