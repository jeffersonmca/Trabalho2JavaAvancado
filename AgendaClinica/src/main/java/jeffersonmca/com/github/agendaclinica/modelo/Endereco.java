package jeffersonmca.com.github.agendaclinica.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Endereco {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_RUA = 45;
    
    @Transient
    private final int TAMANHO_BAIRRO = 45;
    
    @Transient
    private final int TAMANHO_CIDADE = 45;
    
    @Transient
    private final int TAMANHO_CEP = 10;
    
    @Transient
    private final int TAMANHO_COMPLEMENTO = 150;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_codigo")
    private Integer codigo;

    @Column(name = "end_rua", nullable = false, length = TAMANHO_RUA)
    private String rua;
    
    @Column(name = "end_bairro", nullable = false, length = TAMANHO_BAIRRO)
    private String bairro;

    @Column(name = "end_cidade", nullable = false, length = TAMANHO_CIDADE)
    private String cidade;

    @Column(name = "end_numero", nullable = false)
    private Integer numero;

    @Column(name = "end_cep", nullable = false, length = TAMANHO_CEP)
    private String cep;

    @Column(name = "end_complemento", length = TAMANHO_COMPLEMENTO)
    private String complemento;

    public Endereco() {
        
    }

    public Endereco(Integer codigo, String rua, String bairro, String cidade, Integer numero, String cep, String complemento) {
        this.codigo = codigo;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.codigo + "-" + this.cidade + "-" + this.bairro + "-" + this.rua;
    }   
}