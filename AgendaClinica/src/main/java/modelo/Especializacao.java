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
public class Especializacao {
    
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

}
