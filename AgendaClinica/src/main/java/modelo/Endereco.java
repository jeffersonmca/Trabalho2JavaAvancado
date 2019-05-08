package modelo;

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
}