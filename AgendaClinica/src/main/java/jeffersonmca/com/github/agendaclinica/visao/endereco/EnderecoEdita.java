package jeffersonmca.com.github.agendaclinica.visao.endereco;

import jeffersonmca.com.github.agendaclinica.visao.endereco.*;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;
import jeffersonmca.com.github.agendaclinica.servico.ServicoEndereco;
import jeffersonmca.com.github.agendaclinica.util.Validacao;

public class EnderecoEdita extends javax.swing.JDialog {

    private Endereco endereco;
    private ServicoEndereco servico;
    
    public EnderecoEdita(java.awt.Frame parent, boolean modal, ServicoEndereco servico, Endereco endereco) {
        
        super(parent, modal);
        initComponents();
        
        this.endereco = endereco;
        this.servico = servico;
        
        // Como esta editando os dados de um Endereco especifico, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
        PreencheCampos(endereco);
    }
    
    // Como esta editando os dados de um Endereco especifico, os campos seram preenchidos
    // com os dados desse objeto para entao poder edita-los
    private void PreencheCampos(Endereco endereco) {
        spinnerNumero.setValue(endereco.getNumero());
        textRua.setText(endereco.getRua());
        textBairro.setText(endereco.getBairro());
        textCep.setText(endereco.getCep());
        textCidade.setText(endereco.getCidade());
        textComplemento.setText(endereco.getComplemento());
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
        buttonSalvar = new JButton();
        buttonCancelar = new JButton();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        textRua = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        textBairro = new JTextField();
        jLabel4 = new JLabel();
        textCep = new JTextField();
        jLabel9 = new JLabel();
        textCidade = new JTextField();
        jLabel10 = new JLabel();
        textComplemento = new JTextField();
        spinnerNumero = new JSpinner();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edita Endereço");

        jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        buttonSalvar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/Salvar.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        jPanel3.add(buttonSalvar);

        buttonCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/cancelar.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(buttonCancelar);

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel1.setText("Número:");

        jLabel2.setForeground(new Color(255, 0, 0));
        jLabel2.setText("Rua:");

        jLabel3.setForeground(new Color(255, 0, 0));
        jLabel3.setText("Bairro:");

        jLabel4.setForeground(new Color(255, 0, 0));
        jLabel4.setText("Cep:");

        jLabel9.setForeground(new Color(255, 0, 0));
        jLabel9.setText("Cidade:");

        jLabel10.setText("Complemento:");

        spinnerNumero.setModel(new SpinnerNumberModel(1, 1, null, 1));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textRua))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(4, 4, 4)
                        .addComponent(textComplemento))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(spinnerNumero, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 270, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textBairro))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCep))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(3, 3, 3)
                        .addComponent(textCidade)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(spinnerNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(textCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(textComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new Dimension(466, 314));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed

        // Valida os campos obrigatorios antes de salvar
        
        if (Validacao.Vazio(textRua.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe a rua",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Validacao.Vazio(textBairro.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe o bairro",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Validacao.Vazio(textCep.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe o cep",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Validacao.Vazio(textCidade.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe a cidade",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Todos os campos obrigatorios estao preenchidos
        // Preenche esse objeto com os dados da tela        
        endereco.setNumero((Integer)spinnerNumero.getValue());
        endereco.setRua(textRua.getText());
        endereco.setBairro(textBairro.getText());
        endereco.setCep(textCep.getText());
        endereco.setCidade(textCidade.getText());
        endereco.setComplemento(textComplemento.getText());
        
        try {
            // Salva no banco de dados o Endereco
            servico.editar(endereco);
        } catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,"Registro editado com sucesso!","Inclusão",JOptionPane.INFORMATION_MESSAGE);
        
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonCancelarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton buttonCancelar;
    private JButton buttonSalvar;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JSpinner spinnerNumero;
    private JTextField textBairro;
    private JTextField textCep;
    private JTextField textCidade;
    private JTextField textComplemento;
    private JTextField textRua;
    // End of variables declaration//GEN-END:variables
}