package jeffersonmca.com.github.agendaclinica.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

@Entity
public class Contato {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_EMAIL = 600;
    
    @Transient
    private final int TAMANHO_TELEFONE = 11;
    
    @Transient
    private final int TAMANHO_CELULAR = 11;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cot_codigo")
    private Integer codigo;

    @Column(name = "cot_email", nullable = false, length = TAMANHO_EMAIL)
    private String email;
    
    @Column(name = "cot_telefone", nullable = false, length = TAMANHO_TELEFONE)
    private String telefone;

    @Column(name = "cot_celular", nullable = false, length = TAMANHO_CELULAR)
    private String celular;

    public Contato() {
        
    }

    public Contato(Integer codigo, String email, String telefone, String celular) {
        this.codigo = codigo;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }
        
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.codigo);
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
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        if (!Validacao.Vazio(this.celular)) {
            return this.codigo + "-" + this.celular;
        }
        
        if (!Validacao.Vazio(this.email)) {
            return this.codigo + "-" + this.email;
        }
        
        if (!Validacao.Vazio(this.telefone)) {
            return this.codigo + "-" + this.telefone;
        }
        
        return this.codigo.toString();
    }
}