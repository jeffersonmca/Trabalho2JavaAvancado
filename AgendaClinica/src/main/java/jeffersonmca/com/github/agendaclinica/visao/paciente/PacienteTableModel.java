package jeffersonmca.com.github.agendaclinica.visao.paciente;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.agendaclinica.modelo.Paciente;

public class PacienteTableModel  extends AbstractTableModel {

    private List<Paciente> dados;
    private String[] colunas = {"Código", "Convênio"};

    public PacienteTableModel(List<Paciente> dados) {
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
        
          Paciente a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getConvenio();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setConvenio((String)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Paciente c){
       
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