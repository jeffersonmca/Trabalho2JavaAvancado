package jeffersonmca.com.github.agendaclinica.visao.endereco;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;

public class EnderecoTableModel  extends AbstractTableModel {

    private List<Endereco> dados;
    private String[] colunas = {"Código", "Rua", "Bairro", "Cidade", "Número", "Cep", "Complemento"};

    public EnderecoTableModel(List<Endereco> dados) {
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
        
          Endereco a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getRua();
              case 2 : return a.getBairro();
              case 3 : return a.getCidade();
              case 4 : return a.getNumero();
              case 5 : return a.getCep();
              case 6 : return a.getComplemento();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setRua((String)value);
                case 2 : dados.get(colIndex).setBairro((String) value);
                case 3 : dados.get(colIndex).setCidade((String)value);
                case 4 : dados.get(colIndex).setNumero((Integer)value);
                case 5 : dados.get(colIndex).setCep((String)value);
                case 6 : dados.get(colIndex).setComplemento((String)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Endereco c){
       
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