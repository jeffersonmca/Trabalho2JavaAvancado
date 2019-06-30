package jeffersonmca.com.github.agendaclinica.visao.especializacao;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import jeffersonmca.com.github.agendaclinica.modelo.Especializacao;
import jeffersonmca.com.github.agendaclinica.servico.ServicoEspecializacao;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class EspecializacaoEdita extends javax.swing.JDialog {

    private Especializacao especializacao;
    private ServicoEspecializacao servico;
    
    public EspecializacaoEdita(java.awt.Frame parent, boolean modal, ServicoEspecializacao servico, Especializacao especializacao) {
        
        super(parent, modal);
        initComponents();
        
        this.especializacao = especializacao;
        this.servico = servico;
        
        // Como esta editando os dados de uma Especializacao especifica, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
        PreencheCampos(especializacao);
    }
    
    // Como esta editando os dados de uma Especializacao especifica, os campos seram preenchidos
    // com os dados desse objeto para entao poder edita-los
    private void PreencheCampos(Especializacao especializacao) {
        textNome.setText(especializacao.getNome());
        textArea.setText(especializacao.getArea());
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
        textNome = new JTextField();
        textArea = new JTextField();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edita Especialização");

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

        jLabel1.setForeground(new Color(255, 0, 0));
        jLabel1.setText("Nome:");

        jLabel2.setText("Área:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(textNome)
                    .addComponent(textArea))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
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
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new Dimension(466, 177));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvar1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvar1ActionPerformed

        // Valida os campos obrigatorios antes de salvar
        
        if (Validacao.Vazio(textNome.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe o nome",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        // Todos os campos obrigatorios estao preenchidos
        // Preenche esse objeto com os dados da tela
        especializacao.setArea(textArea.getText());
        especializacao.setNome(textNome.getText());
        
        try {
            // Salva no banco de dados a Especializacao
            servico.editar(especializacao);
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

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton buttonCancelar;
    private JButton buttonSalvar1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JTextField textArea;
    private JTextField textNome;
    // End of variables declaration//GEN-END:variables
}