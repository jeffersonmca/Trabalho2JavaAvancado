package jeffersonmca.com.github.agendaclinica.util;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import jeffersonmca.com.github.agendaclinica.relatorio.Relatorio;
import net.sf.jasperreports.engine.JRException;

public class GerenciaRelatorio {

    private static Connection conexao = null;
    
    public GerenciaRelatorio() throws SQLException {
        configuraConexao();
    }
    
    private void configuraConexao() throws SQLException {
        
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/AgendaClinica?zeroDateTimeBehavior=convertToNull",
                "root", 
                "root");
    }
    
    public static void configuraRelatorio(boolean opcao, String nomeRelatorio, HashMap<String, Object> parametros) throws JRException, FileNotFoundException, Exception {
        
        String nomeSistema = "Agenda Clínica";
        String urlImagem = "./imagens/customers.jpg";
        
        // Parametros de entrada do relatorio.
        parametros.put("pImagem", urlImagem);
        parametros.put("pSistema", nomeSistema);
        parametros.put("pNomeRelatorio", nomeRelatorio);
        parametros.put("REPORT_LOCALE", new Locale("pt","BR"));
        
        // Classe auxiliar para gerar o relatorio
        Relatorio relatorio = new Relatorio();
        
        if (opcao)
             relatorio.geraRelatorio(opcao, nomeRelatorio, parametros, conexao);
        else relatorio.geraRelatorio(opcao, nomeRelatorio, parametros, conexao);
    }
}