package jeffersonmca.com.github.agendaclinica.visao.secretario;

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
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class SecretarioInclui extends javax.swing.JDialog {

    private ServicoSecretario servico;
    private ServicoEndereco endServico;
    private ServicoContato cotServico;
    private boolean ctrl;
    private EnderecoInclui telaEndereco;
    private ContatoInclui telaContato;
    private java.awt.Frame parent;
    private boolean entrouEndereco;
    private boolean entrouContato;
    
    public SecretarioInclui(java.awt.Frame parent, boolean modal, ServicoSecretario servico) {
        
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
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
    
    // Fecha a tela e sai da mesma
    private void sair() {
        setVisible(false);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new JPanel();
        buttonSalvar1 = new JButton();
        buttonCancelar = new JButton();
        jPanel4 = new JPanel();
        jLabel3 = new JLabel();
        ComboBoxEndereco = new JComboBox<>();
        jLabel4 = new JLabel();
        ComboBoxContato = new JComboBox<>();
        jLabel9 = new JLabel();
        textNome = new JTextField();
        ComboBoxSexo = new JComboBox<>();
        jLabel11 = new JLabel();
        spinnerIdade = new JSpinner();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        textCpf = new JTextField();
        try{
            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            textCpf = new JFormattedTextField(mf);
        }catch (Exception e){}
        textPeriodoTrabalho = new JTextField();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inclui Secretário");

        jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        buttonSalvar1.setIcon(new ImageIcon(getClass().getResource("/imagens/images/Salvar.png"))); // NOI18N
        buttonSalvar1.setText("Salvar");
        buttonSalvar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSalvar1ActionPerformed(evt);
            }
        });
        jPanel3.add(buttonSalvar1);

        buttonCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/cancelar.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(buttonCancelar);

        jPanel4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel3.setForeground(new Color(255, 0, 51));
        jLabel3.setText("Endereço:");

        ComboBoxEndereco.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxEnderecoMouseClicked(evt);
            }
        });
        ComboBoxEndereco.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxEnderecoKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxEnderecoKeyReleased(evt);
            }
        });

        jLabel4.setForeground(new Color(255, 0, 51));
        jLabel4.setText("Contato:");

        ComboBoxContato.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxContatoMouseClicked(evt);
            }
        });
        ComboBoxContato.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxContatoKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxContatoKeyReleased(evt);
            }
        });

        jLabel9.setForeground(new Color(255, 0, 51));
        jLabel9.setText("Nome:");

        jLabel11.setForeground(new Color(255, 0, 51));
        jLabel11.setText("Sexo:");

        spinnerIdade.setModel(new SpinnerNumberModel(1, 1, null, 1));

        jLabel12.setForeground(new Color(255, 0, 51));
        jLabel12.setText("Idade:");

        jLabel13.setForeground(new Color(255, 0, 51));
        jLabel13.setText("Cpf:");

        jLabel1.setText("Período trabalho:");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNome))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxSexo, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerIdade, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCpf, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 168, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPeriodoTrabalho))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxEndereco, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ComboBoxContato, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(spinnerIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(textCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxContato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textPeriodoTrabalho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(466, 342));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvar1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvar1ActionPerformed

        // Valida os campos obrigatorios antes de salvar
        if (Validacao.Vazio(textNome.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe o nome do secretário",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Validacao.Cpf(textCpf.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe um cpf válido",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxSexo.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o sexo",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxEndereco.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o endereço",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxContato.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o contato",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Todos os campos obrigatorios estao preenchidos
        // Instancia um novo objeto do tipo Secretario
        Secretario p = new Secretario();
        
        // Preenche esse objeto com os dados da tela
        p.setNome(textNome.getText());
        p.setIdade((Integer) spinnerIdade.getValue());
        p.setCpf(textCpf.getText());
        p.setSexo((EnumSexo) ComboBoxSexo.getSelectedItem());
        p.setEndereco((Endereco) ComboBoxEndereco.getSelectedItem());
        p.setContato((Contato) ComboBoxContato.getSelectedItem());        
        p.setPeriodoTrabalho(textPeriodoTrabalho.getText());        
        
        try {
            // Salva no banco de dados o novo Secretario
            servico.salvar(p);            
        }catch (ExcecaoDAO|ExcecaoServico|ExcecaoValidacao e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this,"Registro incluído com sucesso!","Inclusão",JOptionPane.INFORMATION_MESSAGE);
        
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
    private JComboBox<String> ComboBoxContato;
    private JComboBox<String> ComboBoxEndereco;
    private JComboBox<String> ComboBoxSexo;
    private JButton buttonCancelar;
    private JButton buttonSalvar1;
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel9;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JSpinner spinnerIdade;
    private JTextField textCpf;
    private JTextField textNome;
    private JTextField textPeriodoTrabalho;
    // End of variables declaration//GEN-END:variables
}