package visao.paciente;

import excecao.ExcecaoDao;
import excecao.ExcecaoServico;
import excecao.ExcecaoValidacao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import modelo.Paciente;
import modelo.Pessoa;
import servico.ServicoPaciente;
import servico.ServicoPessoa;

public class PacienteIncluir extends javax.swing.JDialog {

    private ServicoPaciente servico;
    private ServicoPessoa pesServico;
    
    public PacienteIncluir(java.awt.Frame parent, boolean modal, ServicoPaciente servico) {
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        
        PreencheComboBox();
    }
    
    private void PreencheComboBox() {
        //Pessoa
        List<Pessoa> lista1 = null;
        try {
            lista1 = pesServico.buscarTodos();
        } catch (ExcecaoDao ex) {}
        
        Vector<Pessoa> vetor1 = new Vector<>(lista1);
        
        DefaultComboBoxModel dcbmPessoa =
               new DefaultComboBoxModel(vetor1);
        ComboBoxPessoa.setModel(dcbmPessoa);
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
        textConvenio = new JTextField();
        ComboBoxPessoa = new JComboBox<>();
        jLabel3 = new JLabel();

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

        jLabel1.setText("Convenio");

        jLabel3.setForeground(new Color(255, 0, 0));
        jLabel3.setText("Pessoa");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(textConvenio)
                            .addComponent(ComboBoxPessoa, 0, 190, Short.MAX_VALUE)))
                    .addComponent(jLabel3))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textConvenio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxPessoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(466, 258));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvar1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvar1ActionPerformed

        //Pessoa
        if (ComboBoxPessoa.getSelectedIndex()<=-1) {

            JOptionPane.showMessageDialog(this,
                "Informe a Pessoa",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        Paciente a = new Paciente();
        a.setConvenio(textConvenio.getText());
        a.setFkPessoa((Pessoa)ComboBoxPessoa.getSelectedItem());
        try {
                servico.salvar(a);
            
        }catch (ExcecaoDao|ExcecaoServico e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (ExcecaoValidacao ex) {
                Logger.getLogger(PacienteIncluir.class.getName()).log(Level.SEVERE, null, ex);
        }

        setVisible(false);
        dispose();
        JOptionPane.showMessageDialog(this,"Registro incluído com sucesso!","Inclusão",JOptionPane.INFORMATION_MESSAGE);
        sair();
    }//GEN-LAST:event_buttonSalvar1ActionPerformed

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        setVisible(false);
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxPessoa;
    private JComboBox<String> ComboBoxTipoAmbiente1;
    private JButton buttonCancelar;
    private JButton buttonSalvar1;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JSpinner spinnerCapacidade1;
    private JTextField textConvenio;
    private JTextField textLocalizacao1;
    private JTextField textNome1;
    // End of variables declaration//GEN-END:variables
}