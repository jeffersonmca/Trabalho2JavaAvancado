package jeffersonmca.com.github.gerenciadorambiente.visao.ambiente;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumTipoAmbiente;

public class AmbienteTableModel  extends AbstractTableModel {

    private List<Ambiente> dados;
    private String[] colunas = {"Código", "Nome", "Tipo Ambiente", "Capacidade", "Localização"};

    public AmbienteTableModel(List<Ambiente> dados) {
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
        
          Ambiente a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getNome();
              case 2 : return a.getTipoAmbiente();
              case 3 : return a.getCapacidade();
              case 4 : return a.getLocalizacao();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setNome((String)value);
                case 2 : dados.get(colIndex).setTipoAmbiente((EnumTipoAmbiente) value);
                case 3 : dados.get(colIndex).setCapacidade((Integer)value);
                case 4 : dados.get(colIndex).setLocalizacao((String)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Ambiente c){
       
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