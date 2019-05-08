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
public class Secretario {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_PERIODO_TRABALHO = 50;
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sec_codigo")
    private Integer codigo;

    @Column(name = "sec_periodo_trabalho", length = TAMANHO_PERIODO_TRABALHO)
    private String nome;
    
    @JoinColumn(name = "sec_pess_codigo", nullable = false)
    private Paciente fkPessoa;
}