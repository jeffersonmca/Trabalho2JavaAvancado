package jeffersonmca.com.github.agendaclinica.visao.secretario;

import jeffersonmca.com.github.agendaclinica.visao.secretario.*;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;
import jeffersonmca.com.github.agendaclinica.modelo.Contato;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;
import jeffersonmca.com.github.agendaclinica.modelo.EnumSexo;
import jeffersonmca.com.github.agendaclinica.modelo.Secretario;
import jeffersonmca.com.github.agendaclinica.servico.ServicoContato;
import jeffersonmca.com.github.agendaclinica.servico.ServicoEndereco;
import jeffersonmca.com.github.agendaclinica.servico.ServicoSecretario;
import jeffersonmca.com.github.agendaclinica.util.Validacao;
import jeffersonmca.com.github.agendaclinica.visao.contato.ContatoInclui;
import jeffersonmca.com.github.agendaclinica.visao.endereco.EnderecoInclui;

public class SecretarioEdita extends javax.swing.JDialog {

    private Secretario secretario;
    private ServicoSecretario servico;
    private ServicoEndereco endServico;
    private ServicoContato cotServico;
    private boolean ctrl;
    private EnderecoInclui telaEndereco;
    private ContatoInclui telaContato;
    private java.awt.Frame parent;
    private boolean entrouEndereco;
    private boolean entrouContato;
    
    public SecretarioEdita(java.awt.Frame parent, boolean modal, ServicoSecretario servico, Secretario secretario) {
        
        super(parent, modal);
        initComponents();
        
        this.secretario = secretario;
        this.servico = servico;
        this.endServico = new ServicoEndereco();
        this.cotServico = new ServicoContato();
        this.ctrl = false;
        this.telaEndereco = null;
        this.telaContato = null;
        this.parent = parent;
        this.entrouEndereco = false;
        this.entrouContato = false;
        
        // Preenche todos os cambo box da tela
        PreencheComboBox();
        
        // Como esta editando os dados de um Secretario especifico, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
        PreencheCampos(secretario);
    }
    
    // Preenche combo box do Enum Sexo
    private void PreencheComboBoxSexo() {
        DefaultComboBoxModel dcbmSexo = new DefaultComboBoxModel(EnumSexo.values());
        ComboBoxSexo.setModel(dcbmSexo);
    }
    
    // Preenche combo box do Endereco
    private void PreencheComboBoxEndereco() {
        List<Endereco> lista = null;
        try {
            lista = endServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Endereco> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmEndereco =
               new DefaultComboBoxModel(vetor);
        ComboBoxEndereco.setModel(dcbmEndereco);
    }
    
    // Preenche combo box do Contato
    private void PreencheComboBoxContato() {
        List<Contato> lista = null;
        try {
            lista = cotServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Contato> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmContato =
               new DefaultComboBoxModel(vetor);
        ComboBoxContato.setModel(dcbmContato);
    }
    
    // Preenche todos os cambo box da tela
    private void PreencheComboBox() {
        PreencheComboBoxEndereco();
        PreencheComboBoxContato();
        PreencheComboBoxSexo();
    }
    
    // Como esta editando os dados de um Secretario especifico, os campos seram preenchidos
    // com os dados desse objeto para entao poder edita-los
    private void PreencheCampos(Secretario secretario) {
        textNome.setText(secretario.getNome());
        spinnerIdade.setValue(secretario.getIdade());
        textCpf.setText(secretario.getCpf());
        ComboBoxSexo.setSelectedItem(secretario.getSexo());
        ComboBoxEndereco.setSelectedItem(secretario.getEndereco());
        ComboBoxContato.setSelectedItem(secretario.getContato());
        textPeriodoTrabalho.setText(secretario.getPeriodoTrabalho());
    }
    
    // Fecha a tela e sai da mesma
    private void sair() {
        setVisible(false);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        buttonSalvar1 = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ComboBoxEndereco = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ComboBoxContato = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        ComboBoxSexo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        spinnerIdade = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textCpf = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter mf = new javax.swing.text.MaskFormatter("###.###.###-##");
            textCpf = new javax.swing.JFormattedTextField(mf);
        }catch (Exception e){}
        textPeriodoTrabalho = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edita Secretário");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/Salvar.png"))); // NOI18N
        buttonSalvar1.setText("Salvar");
        buttonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvar1ActionPerformed(evt);
            }
        });
        jPanel3.add(buttonSalvar1);

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/cancelar.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(buttonCancelar);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Endereço:");

        ComboBoxEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxEnderecoMouseClicked(evt);
            }
        });
        ComboBoxEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxEnderecoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboBoxEnderecoKeyReleased(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Contato:");

        ComboBoxContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxContatoMouseClicked(evt);
            }
        });
        ComboBoxContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxContatoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboBoxContatoKeyReleased(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("Nome:");

        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Sexo:");

        spinnerIdade.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Idade:");

        jLabel13.setForeground(new java.awt.Color(255, 0, 51));
        jLabel13.setText("Cpf:");

        jLabel1.setText("Período trabalho:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNome))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPeriodoTrabalho))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ComboBoxContato, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ComboBoxEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spinnerIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(textCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textPeriodoTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(466, 344));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvar1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvar1ActionPerformed

        // Valida os campos obrigatorios antes de salvar
        if (Validacao.Vazio(textNome.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe o nome do secretário",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Validacao.Cpf(textCpf.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe um cpf válido",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxSexo.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o sexo",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxEndereco.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o endereço",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxContato.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o contato",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
               
        // Todos os campos obrigatorios estao preenchidos
        // Preenche esse objeto com os dados da tela
        secretario.setNome(textNome.getText());
        secretario.setIdade((Integer) spinnerIdade.getValue());
        secretario.setCpf(textCpf.getText());
        secretario.setSexo((EnumSexo) ComboBoxSexo.getSelectedItem());
        secretario.setEndereco((Endereco) ComboBoxEndereco.getSelectedItem());
        secretario.setContato((Contato) ComboBoxContato.getSelectedItem());        
        secretario.setPeriodoTrabalho(textPeriodoTrabalho.getText());
        
        try {
            // Salva no banco de dados o Secretario
            servico.editar(secretario);
        }catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,"Registro editado com sucesso!","Inclusão",JOptionPane.INFORMATION_MESSAGE);
        
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonSalvar1ActionPerformed

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void ComboBoxEnderecoMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxEnderecoMouseClicked

        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaEndereco == null) {

            // Instancia o tela de incluir da Endereco
            telaEndereco = new EnderecoInclui(parent, true, new ServicoEndereco());

            // Faz ela ficar visivel
            telaEndereco.setVisible(true);

            // A tela foi instanciada
            entrouEndereco = true;

            // Para de apertar Ctrl
            ctrl = false;

            // Preenche combo box da Endereco
            PreencheComboBoxEndereco();

            // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrouEndereco) {

            // Se ela foi fechada
            if (!telaEndereco.isActive()) {

                // Faz ela ficar visivel
                telaEndereco.setVisible(true);

                // Para de apertar Ctrl
                ctrl = false;

                // Preenche combo box da Endereco
                PreencheComboBoxEndereco();
            }
        }
    }//GEN-LAST:event_ComboBoxEnderecoMouseClicked

    private void ComboBoxEnderecoKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxEnderecoKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = true;
    }//GEN-LAST:event_ComboBoxEnderecoKeyPressed

    private void ComboBoxEnderecoKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxEnderecoKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = false;
    }//GEN-LAST:event_ComboBoxEnderecoKeyReleased

    private void ComboBoxContatoMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxContatoMouseClicked

        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaContato == null) {

            // Instancia o tela de incluir do Contato
            telaContato = new ContatoInclui(parent, true, new ServicoContato());

            // Faz ela ficar visivel
            telaContato.setVisible(true);

            // A tela foi instanciada
            entrouContato = true;

            // Para de apertar Ctrl
            ctrl = false;

            // Preenche combo box do Contato
            PreencheComboBoxContato();

            // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrouContato) {

            // Se ela foi fechada
            if (!telaContato.isActive()) {

                // Faz ela ficar visivel
                telaContato.setVisible(true);

                // Para de apertar Ctrl
                ctrl = false;

                // Preenche combo box do Contato
                PreencheComboBoxContato();
            }
        }
    }//GEN-LAST:event_ComboBoxContatoMouseClicked

    private void ComboBoxContatoKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxContatoKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = true;
    }//GEN-LAST:event_ComboBoxContatoKeyPressed

    private void ComboBoxContatoKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxContatoKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = false;
    }//GEN-LAST:event_ComboBoxContatoKeyReleased

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxContato;
    private javax.swing.JComboBox<String> ComboBoxEndereco;
    private javax.swing.JComboBox<String> ComboBoxSexo;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSpinner spinnerIdade;
    private javax.swing.JTextField textCpf;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textPeriodoTrabalho;
    // End of variables declaration//GEN-END:variables
}