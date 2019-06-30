package jeffersonmca.com.github.agendaclinica.renderizadores;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class DateTableCellHandler  extends DefaultTableCellRenderer{

    public DateTableCellHandler() {
        setHorizontalAlignment(CENTER);
    }
 
    @Override
    protected void setValue(Object value) {
        
        if (Validacao.Alocado(value)) {
            
            Date dt = (Date)value;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            super.setValue(sdf.format(dt)); 
            
        }else super.setValue(value);
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);        
        setBackground(getColor(row, isSelected));
        
        return this;
    }

    private Color getColor(int row, boolean selected) {
        
        // Se a linha estiver selecionada vai ser pintada de uma cor diferente das demais
        if (selected)
            return new Color(135,206,235);

        // Pinta as linhas PAR de uma cor e as linhas impares de outra cor
        if (row % 2 == 0)
             return new Color(255, 248, 220);
        else return new Color(220, 230, 220);
    }
}