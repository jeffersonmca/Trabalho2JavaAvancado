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
public class Pessoa {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_NOME = 50;

    @Transient
    private final int TAMANHO_CPF = 15;
    
    @Transient
    private final int TAMANHO_SEXO = 15;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_codigo")
    private Integer codigo;

    @Column(name = "pes_nome", nullable = false, length = TAMANHO_NOME)
    private String nome;

    @Column(name = "pes_cpf", nullable = false, length = TAMANHO_CPF)
    private String cpf;

    @Column(name = "pes_idade", nullable = false)
    private Integer idade;

    @Column(name = "pes_sexo", nullable = false, length = TAMANHO_SEXO)
    private String sexo;

    @JoinColumn(name = "pes_end_codigo", nullable = false)
    private Endereco fkEndereco;

    @JoinColumn(name = "pes_cot_codigo", nullable = false)
    private Contato fkContato;


}