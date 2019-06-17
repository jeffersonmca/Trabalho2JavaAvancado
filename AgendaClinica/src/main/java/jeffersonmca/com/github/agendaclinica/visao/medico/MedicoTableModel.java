package jeffersonmca.com.github.agendaclinica.visao.medico;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.agendaclinica.modelo.Medico;

public class MedicoTableModel  extends AbstractTableModel {

    private List<Medico> dados;
    private String[] colunas = {"Código", "Periodo Trabalho"};

    public MedicoTableModel(List<Medico> dados) {
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
        
          Medico a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getPeriodoTrabalho();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setPeriodoTrabalho((String)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Medico c){
       
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