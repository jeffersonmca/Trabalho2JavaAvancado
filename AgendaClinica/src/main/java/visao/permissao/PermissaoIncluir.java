package jeffersonmca.com.github.gerenciadorambiente.visao.ambiente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumTipoAmbiente;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoAmbiente;
import jeffersonmca.com.github.gerenciadorambiente.servico.Validacao;

public class AmbienteIncluir extends javax.swing.JDialog {

    private ServicoAmbiente servico;    
    
    public AmbienteIncluir(java.awt.Frame parent, boolean modal, ServicoAmbiente servico) {
        super(parent, modal);
        initComponents();
        this.servico = servico;
        
        PreencheComboBox();
    }
    
    private void PreencheComboBox() {
        
        DefaultComboBoxModel dcbmTipoAmbiente = new DefaultComboBoxModel(EnumTipoAmbiente.values());
        ComboBoxTipoAmbiente.setModel(dcbmTipoAmbiente);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new JPanel();
        buttonSalvar = new JButton();
        buttonCancelar = new JButton();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        textNome = new JTextField();
        textLocalizacao = new JTextField();
        jLabel4 = new JLabel();
        ComboBoxTipoAmbiente = new JComboBox<>();
        spinnerCapacidade = new JSpinner();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir registro");

        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSalvar);

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCancelar);

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jLabel1.setForeground(new Color(255, 0, 0));
        jLabel1.setText("Nome:");

        jLabel2.setText("TipoAmbiente:");

        jLabel3.setText("Capacidade:");

        jLabel4.setText("Localização:");

        spinnerCapacidade.setModel(new SpinnerNumberModel(0, 0, null, 1));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(textLocalizacao, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textNome, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(ComboBoxTipoAmbiente, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(spinnerCapacidade, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxTipoAmbiente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(424, 265));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        if (Validacao.Vazio(textNome.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe o nome do ambiente",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }        
        
        Ambiente a = new Ambiente();
        
        a.setNome(textNome.getText());
        a.setTipoAmbiente((EnumTipoAmbiente) ComboBoxTipoAmbiente.getSelectedItem());
        a.setCapacidade((Integer)spinnerCapacidade.getValue());
        a.setLocalizacao(textLocalizacao.getText());
        
        try {
            servico.salvar(a);
        } catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        setVisible(false);
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxTipoAmbiente;
    private JButton buttonCancelar;
    private JButton buttonSalvar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JSpinner spinnerCapacidade;
    private JTextField textLocalizacao;
    private JTextField textNome;
    // End of variables declaration//GEN-END:variables
}