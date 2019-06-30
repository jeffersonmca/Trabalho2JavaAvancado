package jeffersonmca.com.github.agendaclinica.visao.endereco;

import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import java.awt.Cursor;
import java.util.List;
import javax.swing.JOptionPane;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;
import jeffersonmca.com.github.agendaclinica.renderizadores.StrippedTableCellHandler;
import jeffersonmca.com.github.agendaclinica.servico.ServicoEndereco;

public class EnderecoListagem extends javax.swing.JFrame {

    private ServicoEndereco service;
    private List<Endereco> dados;
    private EnderecoTableModel tabModel;
    
    public EnderecoListagem() {
        
        initComponents();
        service = new ServicoEndereco();
        atualizaDados();
    }

    private void atualizaDados(){
        
        try {
            
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));

            try {
                dados = service.buscarTodos();
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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jbtnIncluir = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jbtnEditar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbtnRemover = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jbtnAtualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbtnFechar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEnderecos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Endereço");

        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(286, 69));

        jbtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/incluir.png"))); // NOI18N
        jbtnIncluir.setText("Incluir");
        jbtnIncluir.setToolTipText("Adcionar");
        jbtnIncluir.setFocusable(false);
        jbtnIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIncluirActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnIncluir);

        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.add(jSeparator4);

        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/editar.png"))); // NOI18N
        jbtnEditar.setText("Editar");
        jbtnEditar.setToolTipText("Editar");
        jbtnEditar.setFocusable(false);
        jbtnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnEditar);

        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.add(jSeparator3);

        jbtnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/remover.png"))); // NOI18N
        jbtnRemover.setText("Remover");
        jbtnRemover.setToolTipText("Remover");
        jbtnRemover.setFocusable(false);
        jbtnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnRemover);

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.add(jSeparator2);

        jbtnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/atualizar.png"))); // NOI18N
        jbtnAtualizar.setText("Atualizar");
        jbtnAtualizar.setToolTipText("Atualizar");
        jbtnAtualizar.setFocusable(false);
        jbtnAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnAtualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAtualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnAtualizar);

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.add(jSeparator1);

        jbtnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/cancelar.png"))); // NOI18N
        jbtnFechar.setText("Fechar");
        jbtnFechar.setToolTipText("Fechar");
        jbtnFechar.setFocusable(false);
        jbtnFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFecharActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnFechar);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(564, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIncluirActionPerformed

        // Instancia a tela de inclusao do Endereco
        EnderecoInclui tela = new EnderecoInclui(this, true, service);
        tela.setVisible(true);

        // Apos a inclusao, atualiza a grid
        atualizaDados();
    }//GEN-LAST:event_jbtnIncluirActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed

        // Verifica se o usuario selecionou alguma linha da grid para a edicao
        if (tableEnderecos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um registro.", "Dica", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Pega a linha que ele selecionou e transforma em um objeto do tipo Endereco
        Endereco aux = dados.get(tableEnderecos.getSelectedRow());

        // Precaucao caso algo de errado
        if (aux == null) {
            JOptionPane.showMessageDialog(this, "Registro não encontrado!");
            return;
        }

        // Instancia a tela de edicao do Endereco. passando de parametro
        // o servico e o Endereco a ser editado
        EnderecoEdita tela = new EnderecoEdita(this, true, service, aux);
        tela.setVisible(true);

        // Apos a edicao, atualiza a grid
        atualizaDados();
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoverActionPerformed

        // Verifica se o usuario selecionou alguma linha da grid para a remocao
        if (tableEnderecos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um registro.", "Dica", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Pega a linha que ele selecionou e transforma em um objeto do tipo Endereco
        Endereco aux = dados.get(tableEnderecos.getSelectedRow());

        // Precaucao caso algo de errado
        if (aux == null) {
            JOptionPane.showMessageDialog(this, "Registro não encontrado!");
            return;
        }

        // Pergunta o usuario se ele realmente quer deletar aquele Endereco
        if (JOptionPane.showConfirmDialog(this,
            "Confirma a remoção do endereço?",
            "Remoção",
            JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION ) {

            try {
                // Caso a escolha fora sim entao o Endereco sera removido
                service.remover(aux.getCodigo());
                // Atualiza a grid
                atualizaDados();
                JOptionPane.showMessageDialog(this, "Registro removido com sucesso.");
            } catch (ExcecaoDAO|ExcecaoServico e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbtnRemoverActionPerformed

    private void jbtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAtualizarActionPerformed
        // Atualiza os dados da grid
        atualizaDados();
    }//GEN-LAST:event_jbtnAtualizarActionPerformed

    private void jbtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtnAtualizar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnFechar;
    private javax.swing.JButton jbtnIncluir;
    private javax.swing.JButton jbtnRemover;
    private javax.swing.JTable tableEnderecos;
    // End of variables declaration//GEN-END:variables
}