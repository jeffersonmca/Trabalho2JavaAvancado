package jeffersonmca.com.github.agendaclinica.visao.paciente;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.agendaclinica.modelo.Contato;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;
import jeffersonmca.com.github.agendaclinica.modelo.EnumSexo;
import jeffersonmca.com.github.agendaclinica.modelo.Paciente;

public class PacienteTableModel  extends AbstractTableModel {

    private List<Paciente> dados;
    private String[] colunas = {"Código", "Nome", "Idade", "Cpf", "Sexo", "ID Endereco", "ID Contato", "Convênio"};

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
              case 1 : return a.getNome();
              case 2 : return a.getIdade();
              case 3 : return a.getCpf();
              case 4 : return a.getSexo();
              case 5 : return a.getEndereco();
              case 6 : return a.getContato();
              case 7 : return a.getConvenio();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setNome((String)value);
                case 2 : dados.get(colIndex).setIdade((Integer)value);
                case 3 : dados.get(colIndex).setCpf((String)value);
                case 4 : dados.get(colIndex).setSexo((EnumSexo)value);
                case 5 : dados.get(colIndex).setEndereco((Endereco)value);
                case 6 : dados.get(colIndex).setContato((Contato)value);
                case 7 : dados.get(colIndex).setConvenio((String)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Paciente p) {
       dados.add(p);
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