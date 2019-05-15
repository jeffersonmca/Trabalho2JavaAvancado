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
public class Especializacao {

    public Especializacao(Integer codigo, String nome, String area) {
        this.codigo = codigo;
        this.nome = nome;
        this.area = area;
    }

    public Especializacao() {
    }
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_NOME = 50;
    
    @Transient
    private final int TAMANHO_AREA = 50;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esp_codigo")
    private Integer codigo;

    @Column(name = "esp_rua", length = TAMANHO_NOME)
    private String nome;
    
    @Column(name = "esp_bairro", length = TAMANHO_AREA)
    private String area;

    @ManyToMany
    @JoinTable(name = "medico_especializacao",
                    joinColumns = @JoinColumn(name = "esp_codigo"),
                    inverseJoinColumns = @JoinColumn(name = "med_codigo"))
    private List<Medico> medicos;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Especializacao other = (Especializacao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Especializacao{" + "codigo=" + codigo + ", nome=" + nome + ", area=" + area + '}';
    }
    
    
    

}
