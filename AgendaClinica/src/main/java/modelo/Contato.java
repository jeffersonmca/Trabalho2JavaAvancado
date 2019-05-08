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
}