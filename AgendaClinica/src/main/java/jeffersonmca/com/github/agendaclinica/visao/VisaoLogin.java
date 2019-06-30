package jeffersonmca.com.github.agendaclinica.visao;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.agendaclinica.modelo.Contato;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;
import jeffersonmca.com.github.agendaclinica.modelo.EnumSexo;
import jeffersonmca.com.github.agendaclinica.modelo.Permissao;
import jeffersonmca.com.github.agendaclinica.modelo.Usuario;
import jeffersonmca.com.github.agendaclinica.servico.ServicoPermissao;
import jeffersonmca.com.github.agendaclinica.servico.ServicoUsuario;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class VisaoLogin extends javax.swing.JFrame {
    
    public VisaoLogin() {
        
        initComponents();
        
        try {
            
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
            // Criando as permissoes do programa caso ainda nao existam
            criaPermissoes();

            // Cria usuario adm caso ainda nao exista
            criaADM();
            
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    // Cria usuario adm caso ainda nao exista
    private void criaADM() {
        
        ServicoUsuario servico = new ServicoUsuario();
        List<Usuario> usuarios = null;
        try {
            usuarios = servico.buscarPor("AUTENTICADOR", "ADM");

            if (Validacao.Vazio(usuarios)) {
                Usuario u = new Usuario();
                u.setNome("Administrador");
                u.setIdade(30);
                Contato c = new Contato();
                c.setCelular("(37) 99545-5369");
                u.setContato(c);
                u.setAutenticador("ADM");
                u.setSenha("ADM");
                u.setSexo(EnumSexo.MASCULINO);
                Endereco e = new Endereco();
                e.setBairro("Juca Dias");
                e.setCep("213589");
                e.setCidade("São Paulo/SP");
                e.setNumero(15);
                e.setRua("Antonieta de Vilela");
                u.setEndereco(e);
                u.setCpf("456.294.736-54");
                
                ServicoPermissao serP = new ServicoPermissao();
                List<Permissao> permissoes = serP.buscarPor("DESCRICAO", "ADM");
                u.setPermissoes(permissoes);
                servico.salvar(u);
            }
        } catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico ex) {}
    }
    
    // Criando as permissoes do programa caso ainda nao existam
    private void criaPermissoes() {
          
        ServicoPermissao servico = new ServicoPermissao();
        
        List<String> descricaoTelas = new ArrayList<>();
        descricaoTelas.add("Consulta");
        descricaoTelas.add("Contato");
        descricaoTelas.add("Endereco");
        descricaoTelas.add("Especialização");
        descricaoTelas.add("Médico");
        descricaoTelas.add("Secretário");
        descricaoTelas.add("Usuário");
        descricaoTelas.add("ADM");
        List<Permissao> permissoes = null;
        
        for (String d : descricaoTelas) {
                    
            try {
                permissoes = servico.buscarPor("DESCRICAO", d);
                if (Validacao.Vazio(permissoes)) {
                    Permissao p = new Permissao();
                    p.setDescricao(d);
                    servico.salvar(p);
                }
                permissoes = null;
            } catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico ex) {}
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

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed

        try {
            
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
            // Pega o usuario e senha digitados
            String usuario = textUsuario.getText();
            String senha = String.valueOf(passwordSenha.getPassword());

            if (Validacao.Vazio(usuario)) {

                JOptionPane.showMessageDialog(this,
                    "Informe o usuário",
                    "Dica",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Validacao.Vazio(senha)) {

                JOptionPane.showMessageDialog(this,
                    "Informe a senha",
                    "Dica",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            ServicoUsuario servico = new ServicoUsuario();
            Usuario u = null;
            try {
                u = servico.buscarPorAutenticador(textUsuario.getText());
            } catch (ExcecaoDAO|ExcecaoServico ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // NAO achou um usuario com este login
            if (!Validacao.Alocado(u)) {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return ;
            }

            // Verifica se a senha esta correta
            if (servico.logar(u, senha)) {

                // Fecha a tela de login
                this.setVisible(false);
                this.dispose();                

                // Abre a tela principal do programa
                Principal telaPrincipal = new Principal(u);
                telaPrincipal.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(this, "Senha esta errada!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
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