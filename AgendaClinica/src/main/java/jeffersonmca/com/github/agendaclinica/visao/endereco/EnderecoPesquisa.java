package jeffersonmca.com.github.agendaclinica.visao.endereco;

import java.awt.Cursor;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;
import jeffersonmca.com.github.agendaclinica.renderizadores.StrippedTableCellHandler;
import jeffersonmca.com.github.agendaclinica.servico.ServicoEndereco;
import jeffersonmca.com.github.agendaclinica.util.GerenciaRelatorio;

public class EnderecoPesquisa extends javax.swing.JFrame {

    private ServicoEndereco service;
    private List<Endereco> dados;
    private EnderecoTableModel tabModel;
    
    public EnderecoPesquisa() {
        
        initComponents();
        
        this.service = new ServicoEndereco();
    }
    
    // Atualiza os dados da grid
    private void atualizaDados() {
        
        try {
            
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));

            try {
                dados = service.buscarPor((String) ComboBoxOpcao.getSelectedItem(), textDado.getText());
                
                // Caso vier null, nao tem nada para atualizar
                if (dados == null)
                    return ;
                
            } catch (ExcecaoDAO e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Houve um erro ao buscar todos os registros.", "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            }

            tabModel = new EnderecoTableModel(dados);
            tableEnderecos.setModel(tabModel);
            
            // Melhorando o aspecto da grid
            tableEnderecos.setDefaultRenderer(Object.class, new StrippedTableCellHandler());
        
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        
//        valoresPadrao();
    }
    
    // Sempre que atualizar a grid ira selecionar a opcao "SEM FILTRO" e limpar o campo text
    private void valoresPadrao() {
        ComboBoxOpcao.setSelectedIndex(0);
        textDado.setText("");
    }
    
    // Abre o relatorio na tela ou gera o pdf do mesmo
    private void Relatorio(boolean visualizar) {
        
        try {
            
            GerenciaRelatorio g = new GerenciaRelatorio();
            
            // Qual campo do BD vai ser pesquisado
            String pAtributo = null;
            
            // Dado que foi pesquisado que esta no text
            String pDado = textDado.getText();
            
            // Hash contendo o campo pesquisado pelo valor pesquisado 
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            
            // Selecionou qual campo do BD?
            switch (ComboBoxOpcao.getSelectedItem().toString()) {
              
                // Busca todos os dados
                case "SEM FILTRO":
                    pAtributo = "1";
                    pDado = "1";
                    parametros.put("pAtributo", pAtributo);
                    parametros.put("pDado", pDado);
                    g.configuraRelatorio(visualizar, "Enderecos", parametros);
                    break;
                case "CODIGO":
                    pAtributo = "end_codigo";
                    parametros.put("pAtributo", pAtributo);
                    parametros.put("pDado", pDado);
                    g.configuraRelatorio(visualizar, "Enderecos", parametros);
                    break;
                case "RUA":
                    pAtributo = "end_rua";
                    parametros.put("pAtributo", pAtributo);
                    parametros.put("pDado", pDado);
                    g.configuraRelatorio(visualizar, "EnderecosLike", parametros);
                    break;
                case "BAIRRO":
                    pAtributo = "end_bairro";
                    parametros.put("pAtributo", pAtributo);
                    parametros.put("pDado", pDado);
                    g.configuraRelatorio(visualizar, "EnderecosLike", parametros);
                    break;
                case "CIDADE":
                    pAtributo = "end_cidade";
                    parametros.put("pAtributo", pAtributo);
                    parametros.put("pDado", pDado);
                    g.configuraRelatorio(visualizar, "EnderecosLike", parametros);
                    break;
                case "NUMERO":
                    pAtributo = "end_numero";
                    parametros.put("pAtributo", pAtributo);
                    parametros.put("pDado", pDado);
                    g.configuraRelatorio(visualizar, "Enderecos", parametros);
                    break;
                case "CEP":
                    pAtributo = "end_cep";
                    parametros.put("pAtributo", pAtributo);
                    parametros.put("pDado", pDado);
                    g.configuraRelatorio(visualizar, "EnderecosLike", parametros);
                    break;
                case "COMPLEMENTO":
                    pAtributo = "end_complemento";
                    parametros.put("pAtributo", pAtributo);
                    parametros.put("pDado", pDado);
                    g.configuraRelatorio(visualizar, "EnderecosLike", parametros);
                    break;
            }
            
        } catch (SQLException|FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Abre o relatorio na tela ou gera o pdf do mesmo
    private void RelatorioGrafico(boolean visualizar) {
        
        try {
            
            GerenciaRelatorio g = new GerenciaRelatorio();
            
            // Qual campo do BD vai ser pesquisado
            String pAtributo = null;
            
            // Dado que foi pesquisado que esta no text
            String pDado = textDado.getText();
            
            // Hash contendo o campo pesquisado pelo valor pesquisado 
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("pAtributo", "Nulo");
            parametros.put("pDado", "Nulo");
            g.configuraRelatorio(visualizar, "EnderecosGrafico", parametros);
            
        } catch (SQLException|FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ComboBoxOpcao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        buttonPesquisar = new javax.swing.JButton();
        textDado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEnderecos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        buttonVisualizarRelatorio = new javax.swing.JButton();
        buttonImprimirRelatorio = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        checkBoxGraficoCidade = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Endereço");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ComboBoxOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEM FILTRO", "CODIGO", "RUA", "BAIRRO", "CIDADE", "NUMERO", "CEP", "COMPLEMENTO" }));

        jLabel1.setText("Pesquisar Por:");

        buttonPesquisar.setText("Pesquisar");
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(ComboBoxOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPesquisar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxOpcao)
                    .addComponent(buttonPesquisar)
                    .addComponent(jLabel1)
                    .addComponent(textDado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableEnderecos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonVisualizarRelatorio.setText("Visualizar Relatório");
        buttonVisualizarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVisualizarRelatorioActionPerformed(evt);
            }
        });

        buttonImprimirRelatorio.setText("Imprimir Relatório");
        buttonImprimirRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImprimirRelatorioActionPerformed(evt);
            }
        });

        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        checkBoxGraficoCidade.setText("Gráfico Cidade");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxGraficoCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonImprimirRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonVisualizarRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(buttonSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonVisualizarRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonImprimirRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkBoxGraficoCidade))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        atualizaDados();
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        setVisible(false);
        this.dispose();
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonVisualizarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVisualizarRelatorioActionPerformed
        if (!checkBoxGraficoCidade.isSelected()) {
            // Abre o relatorio na tela ou gera o pdf do mesmo
            Relatorio(true);
        } else {
            RelatorioGrafico(true);
        }
    }//GEN-LAST:event_buttonVisualizarRelatorioActionPerformed

    private void buttonImprimirRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImprimirRelatorioActionPerformed
        if (!checkBoxGraficoCidade.isSelected()) {
            // Abre o relatorio na tela ou gera o pdf do mesmo
            Relatorio(false);
        } else {
            RelatorioGrafico(false);
        }
    }//GEN-LAST:event_buttonImprimirRelatorioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxOpcao;
    private javax.swing.JButton buttonImprimirRelatorio;
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton buttonVisualizarRelatorio;
    private javax.swing.JCheckBox checkBoxGraficoCidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEnderecos;
    private javax.swing.JTextField textDado;
    // End of variables declaration//GEN-END:variables
}