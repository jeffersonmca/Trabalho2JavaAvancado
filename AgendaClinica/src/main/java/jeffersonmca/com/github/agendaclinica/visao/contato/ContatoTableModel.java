package jeffersonmca.com.github.agendaclinica.visao.contato;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.agendaclinica.modelo.Contato;

public class ContatoTableModel  extends AbstractTableModel {

    private List<Contato> dados;
    private String[] colunas = {"Código", "E-mail", "Telefone", "Celular"};

    public ContatoTableModel(List<Contato> dados) {
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
        
          Contato a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getEmail();
              case 2 : return a.getTelefone();
              case 3 : return a.getCelular();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setEmail((String)value);
                case 2 : dados.get(colIndex).setTelefone((String) value);
                case 3 : dados.get(colIndex).setCelular((String)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Contato c) {       
       dados.add(c);
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