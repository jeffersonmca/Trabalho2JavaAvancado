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
public class Usuario {

    public Usuario() {
    }

    public Usuario(Integer codigo, String autenticador, String senha, Pessoa fkPessoa) {
        this.codigo = codigo;
        this.autenticador = autenticador;
        this.senha = senha;
        this.fkPessoa = fkPessoa;
    }
    
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_AUTENTICADOR = 10;
    private final int TAMANHO_SENHA = 10;
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_codigo")
    private Integer codigo;

    @Column(name = "usu_periodo_trabalho", length = TAMANHO_AUTENTICADOR)
    private String autenticador;
    
    @Column(name = "usu_periodo_trabalho", length = TAMANHO_SENHA)
    private String senha;
    
    @JoinColumn(name = "usu_pess_codigo", nullable = false)
    private Pessoa fkPessoa;
    
    @ManyToMany
    @JoinTable(name = "usuario_permissao",
                    joinColumns = @JoinColumn(name = "usu_codigo"),
                    inverseJoinColumns = @JoinColumn(name = "per_codigo"))
    private List<Permissao> permissoes;

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getAutenticador() {
        return autenticador;
    }

    public void setAutenticador(String autenticador) {
        this.autenticador = autenticador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        hash = 41 * hash + Objects.hashCode(this.codigo);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", autenticador=" + autenticador + ", senha=" + senha + ", fkPessoa=" + fkPessoa + '}';
    }
    
    
}