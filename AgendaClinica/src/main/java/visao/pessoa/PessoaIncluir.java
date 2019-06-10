package visao.pessoa;

import excecao.ExcecaoDao;
import excecao.ExcecaoServico;
import excecao.ExcecaoValidacao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import modelo.Contato;
import modelo.Endereco;
import modelo.Pessoa;
import servico.ServicoContato;
import servico.ServicoEndereco;
import servico.ServicoPessoa;
import servico.Validacao;

public class PessoaIncluir extends javax.swing.JDialog {

    private ServicoPessoa servico;
    private ServicoEndereco endServico;
    private ServicoContato conServico;
    
    public PessoaIncluir(java.awt.Frame parent, boolean modal, ServicoPessoa servico) {
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        
        PreencheComboBox();
    }
    
    private void PreencheComboBox() {
        //Endereco
        List<Endereco> lista1 = null;
        try {
            lista1 = endServico.buscarTodos();
        } catch (ExcecaoDao ex) {}
        
        Vector<Endereco> vetor1 = new Vector<>(lista1);
        
        DefaultComboBoxModel dcbmEndereco =
               new DefaultComboBoxModel(vetor1);
        ComboBoxEndereco.setModel(dcbmEndereco);
        
        
        //Contato
        List<Contato> lista2 = null;
        try {
            lista2 = conServico.buscarTodos();
        } catch (ExcecaoDao ex) {}
        
        Vector<Contato> vetor2 = new Vector<>(lista2);
        
        DefaultComboBoxModel dcbmContato =
               new DefaultComboBoxModel(vetor2);
        ComboBoxEndereco.setModel(dcbmContato);
    }
 

    private void sair(){
        setVisible(false);
        dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new JPanel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        textNome1 = new JTextField();
        textLocalizacao1 = new JTextField();
        jLabel8 = new JLabel();
        ComboBoxTipoAmbiente1 = new JComboBox<>();
        spinnerCapacidade1 = new JSpinner();
        jPanel3 = new JPanel();
        buttonSalvar1 = new JButton();
        buttonCancelar = new JButton();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        textNome = new JTextField();
        ComboBoxEndereco = new JComboBox<>();
        jLabel3 = new JLabel();
        jLabel2 = new JLabel();
        textCpf = new JTextField();
        textIdade = new JTextField();
        jLabel4 = new JLabel();
        jLabel9 = new JLabel();
        textSexo = new JTextField();
        jLabel10 = new JLabel();
        ComboBoxContato = new JComboBox<>();

        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        jLabel5.setForeground(new Color(255, 0, 0));
        jLabel5.setText("Nome:");

        jLabel6.setText("TipoAmbiente:");

        jLabel7.setText("Capacidade:");

        jLabel8.setText("Localização:");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(textLocalizacao1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textNome1, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(ComboBoxTipoAmbiente1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(spinnerCapacidade1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboBoxTipoAmbiente1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spinnerCapacidade1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textLocalizacao1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar registro");

        jPanel3.setBorder(BorderFactory.createEtchedBorder());

        buttonSalvar1.setText("Salvar");
        buttonSalvar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSalvar1ActionPerformed(evt);
            }
        });
        jPanel3.add(buttonSalvar1);

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(buttonCancelar);

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jLabel1.setForeground(new Color(255, 0, 0));
        jLabel1.setText("Nome");

        jLabel3.setForeground(new Color(255, 0, 0));
        jLabel3.setText("Endereco");

        jLabel2.setForeground(new Color(255, 0, 0));
        jLabel2.setText("CPF");

        jLabel4.setForeground(new Color(255, 0, 0));
        jLabel4.setText("Idade");

        jLabel9.setForeground(new Color(255, 0, 0));
        jLabel9.setText("Sexo");

        jLabel10.setForeground(new Color(255, 0, 0));
        jLabel10.setText("Contato");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(textNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textIdade, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                    .addComponent(textCpf, GroupLayout.Alignment.LEADING)
                                    .addComponent(textSexo, GroupLayout.Alignment.LEADING)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxEndereco, 0, 361, Short.MAX_VALUE)
                            .addComponent(ComboBoxContato, 0, 361, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ComboBoxContato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(481, 391));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvar1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvar1ActionPerformed
        
        //Nome
        if (Validacao.Vazio(textNome.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe o nome do pessoa",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //CPF
        if (Validacao.Vazio(textCpf.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe o nome do Cpf",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
         //Idade
        if (Validacao.Vazio(textIdade.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe a idade",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //sexo
        if (Validacao.Vazio(textSexo.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe o sexo",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
         
        //Contato
        if (ComboBoxContato.getSelectedIndex()<=-1) {

            JOptionPane.showMessageDialog(this,
                "Informe o Contato",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Endereco
        if (ComboBoxEndereco.getSelectedIndex()<=-1) {

            JOptionPane.showMessageDialog(this,
                "Informe o Endereço",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Pessoa a = new Pessoa();
        a.setNome(textNome.getText());
        a.setCpf(textCpf.getText());
        a.setIdade(Integer.parseInt(textIdade.getText()));
        a.setSexo(textSexo.getText());
        a.setFkEndereco((Endereco)ComboBoxEndereco.getSelectedItem());
        a.setFkContato((Contato)ComboBoxContato.getSelectedItem());
        
        try {
            servico.salvar(a);
        } catch (ExcecaoDao|ExcecaoValidacao|ExcecaoServico e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this,"Registro incluído com sucesso!","Inclusão",JOptionPane.INFORMATION_MESSAGE);
        sair();
    }//GEN-LAST:event_buttonSalvar1ActionPerformed

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        sair();
    }//GEN-LAST:event_buttonCancelarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxContato;
    private JComboBox<String> ComboBoxEndereco;
    private JComboBox<String> ComboBoxTipoAmbiente1;
    private JButton buttonCancelar;
    private JButton buttonSalvar1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JSpinner spinnerCapacidade1;
    private JTextField textCpf;
    private JTextField textIdade;
    private JTextField textLocalizacao1;
    private JTextField textNome;
    private JTextField textNome1;
    private JTextField textSexo;
    // End of variables declaration//GEN-END:variables
}