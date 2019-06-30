package jeffersonmca.com.github.agendaclinica.renderizadores;

import jeffersonmca.com.github.agendaclinica.util.Validacao;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TimeTableCellHandler extends DefaultTableCellRenderer {

    public TimeTableCellHandler() {
        setHorizontalAlignment(CENTER);
    }
 
    @Override
    protected void setValue(Object value) {
        
        if (Validacao.Alocado(value)) {

            Date hora = (Date) value;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            super.setValue(sdf.format(hora));

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