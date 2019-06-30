package jeffersonmca.com.github.agendaclinica.visao.consulta;

import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.agendaclinica.modelo.Consulta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
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
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.modelo.Medico;
import jeffersonmca.com.github.agendaclinica.modelo.Paciente;
import jeffersonmca.com.github.agendaclinica.servico.ServicoConsulta;
import jeffersonmca.com.github.agendaclinica.servico.ServicoMedico;
import jeffersonmca.com.github.agendaclinica.servico.ServicoPaciente;
import jeffersonmca.com.github.agendaclinica.util.Conversoes;
import jeffersonmca.com.github.agendaclinica.util.Validacao;
import jeffersonmca.com.github.agendaclinica.visao.medico.MedicoInclui;
import jeffersonmca.com.github.agendaclinica.visao.paciente.PacienteInclui;

public class ConsultaEdita extends javax.swing.JDialog {

    private Consulta consulta;
    private ServicoConsulta servico;
    private ServicoMedico medServico;
    private ServicoPaciente pacServico;
    private boolean ctrl;
    private MedicoInclui telaMedico;
    private PacienteInclui telaPaciente;
    private java.awt.Frame parent;
    private boolean entrou;
    
    public ConsultaEdita(java.awt.Frame parent, boolean modal, ServicoConsulta servico, Consulta consulta) {
        
        super(parent, modal);
        initComponents();
        
        this.consulta = consulta;
        this.servico = servico;
        this.medServico = new ServicoMedico();
        this.pacServico = new ServicoPaciente();
        this.ctrl = false;
        this.telaMedico = null;
        this.telaPaciente = null;
        this.parent = parent;
        this.entrou = false;
        
        // Preenche todos os cambo box da tela
        PreencheComboBox();
        
        // Como esta editando os dados de uma Consultas especifica, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
        PreencheCampos(consulta);
    }
    
    // Preenche combo box do Medico
    private void PreencheComboBoxMedico() {
        
        List<Medico> lista = null;
        try {
            lista = medServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Medico> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmMedico =
               new DefaultComboBoxModel(vetor);
        ComboBoxMedico.setModel(dcbmMedico);        
    }
    
    // Preenche combo box do Paciente
    private void PreencheComboBoxPaciente() {
        
        List<Paciente> lista = null;
        try {
            lista = pacServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Paciente> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmPaciente =
               new DefaultComboBoxModel(vetor);
        ComboBoxPaciente.setModel(dcbmPaciente);
    }
    
    // Preenche todos os cambo box da tela
    private void PreencheComboBox() {
        PreencheComboBoxMedico();
        PreencheComboBoxPaciente();
    }
    
    // Como esta editando os dados de uma Consultas especifica, os campos seram preenchidos
    // com os dados desse objeto para entao poder edita-los
    private void PreencheCampos(Consulta consulta) {
        textProntuario.setText(consulta.getProntuario());
        ComboBoxMedico.setSelectedItem(consulta.getMedico());
        ComboBoxPaciente.setSelectedItem(consulta.getPaciente());
        textHorarioInicio.setText(Conversoes.timeToStr(consulta.getHorarioInicio()));
        textHorarioFim.setText(Conversoes.timeToStr(consulta.getHorarioFim()));
        textData.setText(Conversoes.dateToStr(consulta.getData()));
        textValor.setText(Conversoes.floattToStr(consulta.getValor()));
    }

    // Fecha a tela e sai da mesma
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
        try{
            MaskFormatter mf = new MaskFormatter("##:##");
            textHorarioInicio = new JFormattedTextField(mf);
        }catch (Exception e){}
        jLabel4 = new JLabel();
        ComboBoxMedico = new JComboBox<>();
        jLabel3 = new JLabel();
        ComboBoxPaciente = new JComboBox<>();
        textHorarioFim = new JTextField();
        try{
            MaskFormatter mf = new MaskFormatter("##:##");
            textHorarioFim = new JFormattedTextField(mf);
        }catch (Exception e){}
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        textData = new JTextField();
        try{
            MaskFormatter mf = new MaskFormatter("##/##/####");
            textData = new JFormattedTextField(mf);
        }catch (Exception e){}
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
        setTitle("Edita Consulta");

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

        jLabel1.setForeground(new Color(250, 0, 0));
        jLabel1.setText("Prontuario:");

        jLabel2.setForeground(new Color(255, 0, 0));
        jLabel2.setText("Medico:");

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

        jLabel4.setForeground(new Color(250, 0, 0));
        jLabel4.setText("Horário Início:");

        ComboBoxMedico.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxMedicoMouseClicked(evt);
            }
        });
        ComboBoxMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ComboBoxMedicoActionPerformed(evt);
            }
        });
        ComboBoxMedico.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxMedicoKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxMedicoKeyReleased(evt);
            }
        });

        jLabel3.setForeground(new Color(255, 0, 0));
        jLabel3.setText("Paciente:");

        ComboBoxPaciente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxPacienteMouseClicked(evt);
            }
        });
        ComboBoxPaciente.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxPacienteKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxPacienteKeyReleased(evt);
            }
        });

        textHorarioFim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textHorarioFimActionPerformed(evt);
            }
        });

        jLabel9.setText("Horário Fim:");

        jLabel10.setForeground(new Color(255, 0, 0));
        jLabel10.setText("Data:");

        textData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textDataActionPerformed(evt);
            }
        });

        jLabel11.setText("Valor:");

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)
                                .addComponent(textProntuario))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboBoxPaciente, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxMedico, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textHorarioInicio, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textHorarioFim, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textValor))
                                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textData, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(textProntuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(textHorarioInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textHorarioFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
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
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new Dimension(466, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvar1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvar1ActionPerformed
        
        // Valida os campos obrigatorios antes de salvar
        
        if (Validacao.Vazio(textProntuario.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe o prontuário da consulta",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxMedico.getSelectedIndex()<=-1) {

            JOptionPane.showMessageDialog(this,
                "Informe o Médico",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ComboBoxPaciente.getSelectedIndex()<=-1) {

            JOptionPane.showMessageDialog(this,
                "Informe o Paciente",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Transforma string para data
        Date aux1 = Conversoes.strToDate(textData.getText());

        if (!Validacao.Alocado(aux1)) {
            JOptionPane.showMessageDialog(this,
                "Informe a Data",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Transforma string para hora
        Date aux2 = Conversoes.strToTime(textHorarioInicio.getText());
        
        if (!Validacao.Alocado(aux2)) {

            JOptionPane.showMessageDialog(this,
                "Informe o horário de início da consulta",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Validacao.PontoFlutuante(textValor.getText())) {

            JOptionPane.showMessageDialog(this,
                "Digite um valor válido",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            textValor.setText(consulta.getValor().toString());
            return;
        }

        // Todos os campos obrigatorios estao preenchidos
        // Preenche esse objeto com os dados da tela
        consulta.setProntuario(textProntuario.getText());
        consulta.setHorarioInicio(Conversoes.strToTime(textHorarioInicio.getText()));
        consulta.setHorarioFim(Conversoes.strToTime(textHorarioFim.getText()));
        consulta.setData(Conversoes.strToDate(textData.getText()));
        consulta.setValor(Float.parseFloat(textValor.getText()));
        consulta.setMedico((Medico)ComboBoxMedico.getSelectedItem());
        consulta.setPaciente((Paciente)ComboBoxPaciente.getSelectedItem());
                
        try {
            // Salva no banco de dados a Consulta
            servico.editar(consulta);
        } catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Registro editado com sucesso!", "Inclusão", JOptionPane.INFORMATION_MESSAGE);

        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonSalvar1ActionPerformed

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // Fecha a tela e sai da mesma
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

    private void ComboBoxMedicoKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxMedicoKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = true;
    }//GEN-LAST:event_ComboBoxMedicoKeyPressed

    private void ComboBoxPacienteKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxPacienteKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = true;
    }//GEN-LAST:event_ComboBoxPacienteKeyPressed

    private void ComboBoxMedicoKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxMedicoKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = false;
    }//GEN-LAST:event_ComboBoxMedicoKeyReleased

    private void ComboBoxPacienteKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxPacienteKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = false;
    }//GEN-LAST:event_ComboBoxPacienteKeyReleased

    private void ComboBoxMedicoMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxMedicoMouseClicked
        
        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaMedico == null) {
            
            // Instancia o tela de incluir do Medico
            telaMedico = new MedicoInclui(parent, true, new ServicoMedico());
            
            // Faz ela ficar visivel
            telaMedico.setVisible(true);
            
            // A tela foi instanciada
            entrou = true;
            
            // Para de apertar Ctrl
            ctrl = false;
            
            // Preenche combo box do Medico
            PreencheComboBoxMedico();
            
        // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrou) {
            
            // Se ela foi fechada
            if (!telaMedico.isActive()) {
                
                // Faz ela ficar visivel
                telaMedico.setVisible(true);
                
                // Para de apertar Ctrl
                ctrl = false;
                
                // Preenche combo box do Medico
                PreencheComboBoxMedico();
            }
        }
    }//GEN-LAST:event_ComboBoxMedicoMouseClicked

    private void ComboBoxPacienteMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxPacienteMouseClicked
        
        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaPaciente == null) {
            
            // Instancia o tela de incluir do Paciente
            telaPaciente = new PacienteInclui(parent, true, new ServicoPaciente());
            
            // Faz ela ficar visivel
            telaPaciente.setVisible(true);
            
            // A tela foi instanciada
            entrou = true;
            
            // Para de apertar Ctrl
            ctrl = false;
            
            // Preenche combo box do Paciente
            PreencheComboBoxPaciente();
            
        // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrou) {
            
            // Se ela foi fechada
            if (!telaPaciente.isActive()) {
                
                // Faz ela ficar visivel
                telaPaciente.setVisible(true);
                
                // Para de apertar Ctrl
                ctrl = false;
                
                // Preenche combo box do Paciente
                PreencheComboBoxPaciente();
            }
        }
    }//GEN-LAST:event_ComboBoxPacienteMouseClicked

   
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