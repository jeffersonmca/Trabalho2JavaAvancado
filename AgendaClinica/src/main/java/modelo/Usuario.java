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
public class Usuario {
    
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
    private Paciente fkPessoa;
}