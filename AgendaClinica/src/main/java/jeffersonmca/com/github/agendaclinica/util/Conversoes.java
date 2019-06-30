package jeffersonmca.com.github.agendaclinica.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Conversoes {

    public Conversoes() {
        
    }
   
    public static Date strToTime(String texto) {
        
        if (Validacao.Hora(texto)) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

            try {
                return sdf.parse(texto);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Hora está errada!");
                return null;
            }
        }
        
        return null;
    } 
    
    public static String timeToStr(Date hora) {

        if (Validacao.Alocado(hora)) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");        
            return sdf.format(hora);
        }
        
        return null;
    }
    
    public static Date strToDate(String texto) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            return sdf.parse(texto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data está errada!");
            return null;
        }
    } 
    
    public static String dateToStr(Date data) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");        
        return sdf.format(data);
    }
    
    public static Float strToFloat(String valor) {        
        return Float.parseFloat(valor);
    } 
    
    public static String floattToStr(Float valor){
        return valor.toString();
    }
}