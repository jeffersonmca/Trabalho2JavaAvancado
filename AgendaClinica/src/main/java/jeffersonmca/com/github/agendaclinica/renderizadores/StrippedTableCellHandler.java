package jeffersonmca.com.github.agendaclinica.renderizadores;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class StrippedTableCellHandler implements TableCellRenderer {

    private final JLabel label;

    public StrippedTableCellHandler() {
        this.label = new JLabel();
        this.label.setOpaque(true);
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        this.label.setText(String.valueOf(value));
        this.label.setBackground(getCor(row, isSelected));                
        return this.label;
    }

    private Color getCor(int row, boolean selected) {
        
        // Se a linha estiver selecionada vai ser pintada de uma cor diferente das demais
        if (selected)
            return new Color(135,206,235);

        // Pinta as linhas PAR de uma cor e as linhas impares de outra cor
        if (row % 2 == 0)
             return new Color(255, 248, 220);
        else return new Color(220, 230, 220);
    }
}