package modelo;

import java.util.Date;
import java.util.Objects;
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

    public Consulta(Integer codigo, String prontuario, Date horarioInicio, Date horarioFim, Date data, Float valor, Medico fkMedico, Paciente fkPaciente) {
        this.codigo = codigo;
        this.prontuario = prontuario;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.data = data;
        this.valor = valor;
        this.fkMedico = fkMedico;
        this.fkPaciente = fkPaciente;
    }
    
    public Consulta() {
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

    public Medico getFkMedico() {
        return fkMedico;
    }

    public void setFkMedico(Medico fkMedico) {
        this.fkMedico = fkMedico;
    }

    public Paciente getFkPaciente() {
        return fkPaciente;
    }

    public void setFkPaciente(Paciente fkPaciente) {
        this.fkPaciente = fkPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.codigo);
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
        return "Consulta{" + "codigo=" + codigo + ", prontuario=" + prontuario + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim + ", data=" + data + ", valor=" + valor + ", fkMedico=" + fkMedico + ", fkPaciente=" + fkPaciente + '}';
    }

    

    
}