package jeffersonmca.com.github.agendaclinica.modelo;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "con_horario_inicio", nullable = false)
    private Date horarioInicio;

    @Temporal(TemporalType.TIME)
    @Column(name = "con_horario_fim")
    private Date horarioFim;

    @Temporal(TemporalType.DATE)
    @Column(name = "con_data", nullable = false)
    private Date data;
    
    @Column(name = "con_valor")
    private Float valor;

    @JoinColumn(name = "con_medCodigo", nullable = false)
    private Medico medico;

    @JoinColumn(name = "con_pacCodigo", nullable = false)
    private Paciente paciente;

    public Consulta() {
        
    }

    public Consulta(Integer codigo, String prontuario, Date horarioInicio, Date horarioFim, Date data, Float valor, Medico medico, Paciente paciente) {
        this.codigo = codigo;
        this.prontuario = prontuario;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.data = data;
        this.valor = valor;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Date horarioFim) {
        this.horarioFim = horarioFim;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.codigo);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.prontuario;
    }
}