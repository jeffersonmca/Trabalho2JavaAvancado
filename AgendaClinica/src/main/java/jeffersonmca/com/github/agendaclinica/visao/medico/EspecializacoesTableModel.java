package jeffersonmca.com.github.agendaclinica.visao.medico;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.agendaclinica.modelo.Especializacao;

public class EspecializacoesTableModel  extends AbstractTableModel {

    private List<Especializacao> dados;
    private String[] colunas = {"Código", "Nome", "Area"};

    public EspecializacoesTableModel(List<Especializacao> dados) {
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
        
          Especializacao a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getNome();
              case 2 : return a.getArea();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setNome((String)value);
                case 2 : dados.get(colIndex).setArea((String) value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Especializacao e) {       
       dados.add(e);
       this.fireTableDataChanged();
   } 
   
   public void removeRow(int linha) {       
       dados.remove(linha);
       this.fireTableDataChanged();
   } 
   
    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
}