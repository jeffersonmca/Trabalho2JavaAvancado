package visao.consulta;

import excecao.ExcecaoDao;
import excecao.ExcecaoServico;
import excecao.ExcecaoValidacao;
import visao.contato.*;
import modelo.Consulta;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import modelo.Medico;
import modelo.Paciente;
import servico.ServicoConsulta;
import servico.ServicoMedico;
import servico.ServicoPaciente;
import servico.Validacao;

public class ConsultaIncluir extends javax.swing.JDialog {

    private ServicoConsulta servico;
    private ServicoMedico medServico;
    private ServicoPaciente pacServico;
    
    public ConsultaIncluir(java.awt.Frame parent, boolean modal, ServicoConsulta servico) {
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        this.medServico = new ServicoMedico();
        this.pacServico = new ServicoPaciente();
        PreencheComboBox();
    }
    
    private void PreencheComboBox() {       
        //MEDICO
        List<Medico> lista1 = null;
        try {
            lista1 = medServico.buscarTodos();
        } catch (ExcecaoDao ex) {}
        
        Vector<Medico> vetor1 = new Vector<>(lista1);
        
        DefaultComboBoxModel dcbmMedico =
               new DefaultComboBoxModel(vetor1);
        ComboBoxMedico.setModel(dcbmMedico);
     
        //PACIENTE
        List<Paciente> lista2 = null;
        try {
            lista2 = pacServico.buscarTodos();
        } catch (ExcecaoDao ex) {}
        
        Vector<Paciente> vetor2 = new Vector<>(lista2);
        
        DefaultComboBoxModel dcbmPaciente =
               new DefaultComboBoxModel(vetor2);
        ComboBoxPaciente.setModel(dcbmPaciente);
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
        jLabel2 = new JLabel();
        textProntuario = new JTextField();
        textHorarioInicio = new JTextField();
        jLabel4 = new JLabel();
        ComboBoxMedico = new JComboBox<>();
        jLabel3 = new JLabel();
        ComboBoxPaciente = new JComboBox<>();
        textHorarioFim = new JTextField();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        textData = new JTextField();
        jLabel11 = new JLabel();
        textValor = new JTextField();

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

        jLabel1.setText("Prontuario");

        jLabel2.setForeground(new Color(255, 0, 0));
        jLabel2.setText("Medico");

        textProntuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textProntuarioActionPerformed(evt);
            }
        });

        textHorarioInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textHorarioInicioActionPerformed(evt);
            }
        });

        jLabel4.setText("Horario Inicio");

        ComboBoxMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ComboBoxMedicoActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new Color(255, 0, 0));
        jLabel3.setText("Paciente");

        textHorarioFim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textHorarioFimActionPerformed(evt);
            }
        });

        jLabel9.setText("Horario Fim");

        jLabel10.setForeground(new Color(255, 0, 0));
        jLabel10.setText("Data");

        textData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textDataActionPerformed(evt);
            }
        });

        jLabel11.setText("Valor");

        textValor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textValorActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(textHorarioFim)
                            .addComponent(textHorarioInicio)
                            .addComponent(textData)
                            .addComponent(textValor)
                            .addComponent(textProntuario)
                            .addComponent(ComboBoxMedico, 0, 212, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ComboBoxPaciente, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textProntuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ComboBoxMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textHorarioInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textHorarioFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(109, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(299, Short.MAX_VALUE)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE)))
        );

        setSize(new Dimension(466, 374));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvar1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvar1ActionPerformed
        //Medico
        if (ComboBoxMedico.getSelectedIndex()<=-1) {

            JOptionPane.showMessageDialog(this,
                "Informe o Medico",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Paciente
        if (ComboBoxPaciente.getSelectedIndex()<=-1) {

            JOptionPane.showMessageDialog(this,
                "Informe o Paciente",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Data
        if(Validacao.Vazio(textData.getText())){
            JOptionPane.showMessageDialog(this,
                "Informe a Data",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

                
        Consulta a = new Consulta();
        a.setProntuario(textProntuario.getText());    
        a.setHorarioInicio(Validacao.ConverteStringParaHora(textHorarioInicio.getText()));
        a.setHorarioFim(Validacao.ConverteStringParaHora(textHorarioFim.getText()));
        a.setData(Validacao.ConverteStringParaData(textData.getText()));
        a.setValor(Float.parseFloat(textValor.getText()));
        a.setFkMedico((Medico)ComboBoxMedico.getSelectedItem());
        a.setFkPaciente((Paciente)ComboBoxMedico.getSelectedItem());

                
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

    private void textHorarioInicioActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textHorarioInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHorarioInicioActionPerformed

    private void textHorarioFimActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textHorarioFimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHorarioFimActionPerformed

    private void textDataActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataActionPerformed

    private void textValorActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textValorActionPerformed

    private void ComboBoxMedicoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ComboBoxMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxMedicoActionPerformed

    private void textProntuarioActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textProntuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textProntuarioActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxMedico;
    private JComboBox<String> ComboBoxPaciente;
    private JComboBox<String> ComboBoxTipoAmbiente1;
    private JButton buttonCancelar;
    private JButton buttonSalvar1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
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
    private JTextField textData;
    private JTextField textHorarioFim;
    private JTextField textHorarioInicio;
    private JTextField textLocalizacao1;
    private JTextField textNome1;
    private JTextField textProntuario;
    private JTextField textValor;
    // End of variables declaration//GEN-END:variables
}