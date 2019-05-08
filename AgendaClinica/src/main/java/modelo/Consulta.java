package modelo;

import java.util.Date;
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
public class Consulta {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_PRONTUARIO = 600;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_codigo")
    private Integer codigo;

    @Column(name = "con_prontuario", nullable = false, length = TAMANHO_PRONTUARIO)
    private String prontuario;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "con_horario_inicio")
    private Date horarioInicio;

    @Temporal(TemporalType.TIME)
    @Column(name = "con_horario_fim")
    private Date horarioFim;

    @Temporal(TemporalType.DATE)
    @Column(name = "con_data")
    private Date data;
    
    @Column(name = "con_valor")
    private Float valor;

    @JoinColumn(name = "con_med_codigo", nullable = false)
    private Medico fkMedico;

    @JoinColumn(name = "con_pac_codigo", nullable = false)
    private Paciente fkPaciente;
    
}