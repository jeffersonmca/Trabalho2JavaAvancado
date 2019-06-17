package jeffersonmca.com.github.agendaclinica.visao;

import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.modelo.Pessoa;
import jeffersonmca.com.github.agendaclinica.servico.ServicoContato;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class VisaoLogin extends javax.swing.JFrame {
    
    public VisaoLogin() {
        
        initComponents();
        
        try {
            
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
            // Iniciando a conexao com o BD
            ServicoContato servico = new ServicoContato();             
            try {
                servico.buscarPorCodigo(1);
            } catch (Exception e) {}
            
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInformacoes = new javax.swing.JPanel();
        labelSenha = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        passwordSenha = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        labelRecebimento = new javax.swing.JLabel();
        panelBotoes = new javax.swing.JPanel();
        buttonCriar = new javax.swing.JButton();
        buttonEntrar = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelInformacoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelInformacoes.setLayout(null);

        labelSenha.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        labelSenha.setText("Senha:");
        labelSenha.setName("labelUsuario"); // NOI18N
        panelInformacoes.add(labelSenha);
        labelSenha.setBounds(20, 60, 90, 26);

        labelUsuario.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        labelUsuario.setText("Usuário:");
        labelUsuario.setName(""); // NOI18N
        panelInformacoes.add(labelUsuario);
        labelUsuario.setBounds(20, 30, 90, 26);
        panelInformacoes.add(textUsuario);
        textUsuario.setBounds(110, 30, 190, 27);
        panelInformacoes.add(passwordSenha);
        passwordSenha.setBounds(110, 60, 190, 27);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        labelRecebimento.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        labelRecebimento.setText("Bem Vindo!");
        jPanel1.add(labelRecebimento);
        labelRecebimento.setBounds(100, 100, 140, 40);

        panelBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBotoes.setLayout(null);

        buttonCriar.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        buttonCriar.setText("Criar");
        buttonCriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCriarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCriarMouseExited(evt);
            }
        });
        buttonCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCriarActionPerformed(evt);
            }
        });
        panelBotoes.add(buttonCriar);
        buttonCriar.setBounds(10, 10, 70, 40);

        buttonEntrar.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        buttonEntrar.setText("Entrar");
        buttonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonEntrarMouseExited(evt);
            }
        });
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });
        panelBotoes.add(buttonEntrar);
        buttonEntrar.setBounds(250, 10, 90, 40);

        buttonSair.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        buttonSair.setText("Sair");
        buttonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonSairMouseExited(evt);
            }
        });
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });
        panelBotoes.add(buttonSair);
        buttonSair.setBounds(180, 10, 70, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEntrarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonEntrarMouseExited

    private void buttonEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEntrarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonEntrarMouseEntered

    private void buttonCriarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCriarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonCriarMouseEntered

    private void buttonCriarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCriarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonCriarMouseExited

    private void buttonCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCriarActionPerformed

    }//GEN-LAST:event_buttonCriarActionPerformed

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed

        // Fecha a tela de login
        this.setVisible(false);
        this.dispose();                

        // Abre a tela principal do programa
        Principal telaPrincipal = new Principal();
        telaPrincipal.setVisible(true);
    }//GEN-LAST:event_buttonEntrarActionPerformed

    private void buttonSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSairMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSairMouseEntered

    private void buttonSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSairMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSairMouseExited

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        // Fecha a tela de login
        this.dispose();
    }//GEN-LAST:event_buttonSairActionPerformed

    public static void main(String args[]) {

        try {
            
            UIManager.setLookAndFeel(            
                    UIManager.getSystemLookAndFeelClassName()
            );
            
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisaoLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCriar;
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JButton buttonSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelRecebimento;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelInformacoes;
    private javax.swing.JPasswordField passwordSenha;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}