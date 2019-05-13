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
public class Contato {

    public Contato(Integer codigo, String email, String telefone, String celular) {
        this.codigo = codigo;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public Contato() {
    }
    
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
    public String toString() {
        return "Contato{" + "codigo=" + codigo + ", email=" + email + ", telefone=" + telefone + ", celular=" + celular + '}';
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
    
}