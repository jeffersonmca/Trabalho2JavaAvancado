package jeffersonmca.com.github.agendaclinica.visao.contato;

import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
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
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;
import jeffersonmca.com.github.agendaclinica.modelo.Contato;
import jeffersonmca.com.github.agendaclinica.servico.ServicoContato;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class ContatoEdita extends javax.swing.JDialog {

    private Contato contato;
    private ServicoContato servico;
    
    public ContatoEdita(java.awt.Frame parent, boolean modal, ServicoContato servico, Contato contato) {
        
        super(parent, modal);
        initComponents();
        
        this.contato = contato;
        this.servico = servico;
        
        // Como esta editando os dados de um Contato especifico, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
        PreencheCampos(contato);
    }
    
    // Como esta editando os dados de um Contato especifico, os campos seram preenchidos
    // com os dados desse objeto para entao poder edita-los
    private void PreencheCampos(Contato contato) {
        textEmail.setText(contato.getEmail());
        textTelefone.setText(contato.getTelefone());
        textCelular.setText(contato.getCelular());
    }

    // Fecha a tela e sai da mesma
    private void sair(){
        setVisible(false);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new JPanel();
        buttonSalvar1 = new JButton();
        buttonCancelar = new JButton();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        textEmail = new JTextField();
        textTelefone = new JTextField();
        try{
            MaskFormatter mf = new MaskFormatter("(##) ####-####");
            textTelefone = new JFormattedTextField(mf);
        }catch (Exception e){}
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        textCelular = new JTextField();
        try{
            MaskFormatter mf = new MaskFormatter("(##) #####-####");
            textCelular = new JFormattedTextField(mf);
        }catch (Exception e){}

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edita Contato");

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

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel1.setText("E-mail:");

        textEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });

        jLabel2.setText("Telefone:");

        jLabel3.setText("Celular:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9))
                            .addComponent(jLabel2, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCelular, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEmail)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new Dimension(466, 209));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvar1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvar1ActionPerformed
        
        // Pelo menos um campo deve ser preenchido
        if ((Validacao.Vazio(textEmail.getText())) &&
            (textTelefone.getText().equals("(  )     -    ")) &&
            (textCelular.getText().equals("(  )      -    "))) {
            
            JOptionPane.showMessageDialog(this,
                "Pelo menos um campo deve ser preenchido",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Preenche esse objeto com os dados da tela
        contato.setEmail(textEmail.getText());
        contato.setTelefone(textTelefone.getText());
        contato.setCelular(textCelular.getText());
        
        try {
            // Salva no banco de dados o Contato
            servico.editar(contato);
        } catch (ExcecaoDAO|ExcecaoServico e) {
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

    private void textEmailActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton buttonCancelar;
    private JButton buttonSalvar1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JTextField textCelular;
    private JTextField textEmail;
    private JTextField textTelefone;
    // End of variables declaration//GEN-END:variables
}