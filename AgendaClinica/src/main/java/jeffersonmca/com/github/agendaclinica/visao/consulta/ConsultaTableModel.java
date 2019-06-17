package jeffersonmca.com.github.agendaclinica.visao.consulta;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.agendaclinica.modelo.Consulta;
import jeffersonmca.com.github.agendaclinica.modelo.Medico;
import jeffersonmca.com.github.agendaclinica.modelo.Paciente;

public class ConsultaTableModel  extends AbstractTableModel {

    private List<Consulta> dados;
    private String[] colunas = {"Código", "Prontuário", "Início", "Fim", "Data", "ID Medico", "ID Paciente"};

    public ConsultaTableModel(List<Consulta> dados) {
        this.dados = dados;
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
          Consulta a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getProntuario();
              case 2 : return a.getHorarioInicio();
              case 3 : return a.getHorarioFim();
              case 4 : return a.getData();
              case 5 : return a.getMedico();
              case 6 : return a.getPaciente();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setProntuario((String)value);
                case 2 : dados.get(colIndex).setHorarioInicio((Date) value);
                case 3 : dados.get(colIndex).setHorarioFim((Date) value);
                case 4 : dados.get(colIndex).setData((Date)value);
                case 5 : dados.get(colIndex).setMedico((Medico)value);
                case 6 : dados.get(colIndex).setPaciente((Paciente)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Consulta c){
       
       dados.add(c);
       this.fireTableDataChanged();
   } 
   
   public void removeRow(int linha){
       
       dados.remove(linha);
       this.fireTableDataChanged();
   } 
   
    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
}