package jeffersonmca.com.github.agendaclinica.visao.medico;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoServico;
import jeffersonmca.com.github.agendaclinica.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.agendaclinica.modelo.Contato;
import jeffersonmca.com.github.agendaclinica.modelo.Endereco;
import jeffersonmca.com.github.agendaclinica.modelo.EnumSexo;
import jeffersonmca.com.github.agendaclinica.modelo.Especializacao;
import jeffersonmca.com.github.agendaclinica.modelo.Medico;
import jeffersonmca.com.github.agendaclinica.renderizadores.StrippedTableCellHandler;
import jeffersonmca.com.github.agendaclinica.servico.ServicoContato;
import jeffersonmca.com.github.agendaclinica.servico.ServicoEndereco;
import jeffersonmca.com.github.agendaclinica.servico.ServicoEspecializacao;
import jeffersonmca.com.github.agendaclinica.servico.ServicoMedico;
import jeffersonmca.com.github.agendaclinica.util.Validacao;
import jeffersonmca.com.github.agendaclinica.visao.contato.ContatoInclui;
import jeffersonmca.com.github.agendaclinica.visao.endereco.EnderecoInclui;
import jeffersonmca.com.github.agendaclinica.visao.especializacao.EspecializacaoInclui;

public class MedicoEdita extends javax.swing.JDialog {

    private Medico medico;
    private ServicoMedico servico;
    private ServicoEndereco endServico;
    private ServicoContato cotServico;
    private ServicoEspecializacao espServico;
    private List<Especializacao> especializacoes;
    private boolean ctrl;
    private EnderecoInclui telaEndereco;
    private ContatoInclui telaContato;
    private EspecializacaoInclui telaEspecializacao;
    private java.awt.Frame parent;
    private boolean entrouEndereco;
    private boolean entrouContato;
    private boolean entrouEspecializacao;
    
    public MedicoEdita(java.awt.Frame parent, boolean modal, ServicoMedico servico, Medico medico) {
        
        super(parent, modal);
        initComponents();
        
        this.medico = medico;
        this.servico = servico;
        this.endServico = new ServicoEndereco();
        this.cotServico = new ServicoContato();
        this.espServico = new ServicoEspecializacao();
        this.especializacoes = new ArrayList<>();
        this.ctrl = false;
        this.telaEndereco = null;
        this.telaContato = null;
        this.telaEspecializacao = null;
        this.parent = parent;
        this.entrouEndereco = false;
        this.entrouContato = false;
        this.entrouEspecializacao = false;
        
        // Solucao encontrada para o problema de que quando o usuario abria a tela de MedicoEdita e
        // adicionava uma especializacao e depois cancelava, se ele abrisse a tela novamente aquela especializacao que
        // foi adicionado recentemente ainda estava la, e isso nao poderia ocorrer
        for (Especializacao e : medico.getEspecializacoes()) {
            if (e != null) {
                Especializacao aux = new Especializacao();
                aux.setCodigo(e.getCodigo());
                aux.setNome(e.getNome());
                aux.setArea(e.getArea());
                this.especializacoes.add(aux);
            }
        }
        
        // Preenche todos os cambo box da tela
        PreencheComboBox();
        
        // Como esta editando os dados de um Medico especifico, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
        PreencheCampos(medico);
        
        // Atualiza os dados da grid das especializacoes
        carregaTable();
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
    
    // Preenche combo box da Especializacao
    private void PreencheComboBoxEspecializacao() {
        List<Especializacao> lista = null;
        try {
            lista = espServico.buscarEspecializacoesForaDaGrid(especializacoes);
        } catch (ExcecaoDAO ex) {}
        
        Vector<Especializacao> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmEspecializacao =
               new DefaultComboBoxModel(vetor);
        ComboBoxEspecializacao.setModel(dcbmEspecializacao);
        
        // Nao coloca o foco em nenhum nome
        ComboBoxEspecializacao.setSelectedIndex(-1);
    }
    
    // Preenche todos os cambo box da tela
    private void PreencheComboBox() {
        PreencheComboBoxEndereco();
        PreencheComboBoxContato();
        PreencheComboBoxSexo();
    }
    
    // Como esta editando os dados de um Medico especifico, os campos seram preenchidos
    // com os dados desse objeto para entao poder edita-los
    private void PreencheCampos(Medico medico) {
        textNome.setText(medico.getNome());
        spinnerIdade.setValue(medico.getIdade());
        textCpf.setText(medico.getCpf());
        ComboBoxSexo.setSelectedItem(medico.getSexo());
        ComboBoxEndereco.setSelectedItem(medico.getEndereco());
        ComboBoxContato.setSelectedItem(medico.getContato());
        textPeriodoTrabalho.setText(medico.getPeriodoTrabalho());
    }

    // Atualiza os dados da grid dos especializacoes
    private void carregaTable() {
        EspecializacoesTableModel atm = new EspecializacoesTableModel(especializacoes);
        tableEspecializacoes.setModel(atm);
        
        // Melhorando o aspecto da grid
        tableEspecializacoes.setDefaultRenderer(Object.class, new StrippedTableCellHandler());
        
        // Preenche combo box do Especializacao
        PreencheComboBoxEspecializacao();
    }
    
    // Fecha a tela e sai da mesma
    private void sair() {
        setVisible(false);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotoes = new JPanel();
        buttonSalvar = new JButton();
        buttonCancelar = new JButton();
        jPanel1 = new JPanel();
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
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        buttonRemover = new JButton();
        jPanel5 = new JPanel();
        jLabel10 = new JLabel();
        ComboBoxEspecializacao = new JComboBox<>();
        buttonAdicionar = new JButton();
        jPanel6 = new JPanel();
        jScrollPane1 = new JScrollPane();
        tableEspecializacoes = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edita Médico");

        panelBotoes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        buttonSalvar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/Salvar.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                buttonSalvarMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                buttonSalvarMouseExited(evt);
            }
        });
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        panelBotoes.add(buttonSalvar);

        buttonCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/cancelar.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                buttonCancelarMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                buttonCancelarMouseExited(evt);
            }
        });
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        panelBotoes.add(buttonCancelar);

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

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

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxEndereco, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxSexo, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerIdade, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCpf, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxContato, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textPeriodoTrabalho, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(spinnerIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(textCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxContato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textPeriodoTrabalho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jPanel4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        buttonRemover.setIcon(new ImageIcon(getClass().getResource("/imagens/images/remover.png"))); // NOI18N
        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRemover)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonRemover))
        );

        jPanel5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel10.setForeground(new Color(21, 5, 8));
        jLabel10.setText("Especialização:");

        ComboBoxEspecializacao.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxEspecializacaoMouseClicked(evt);
            }
        });
        ComboBoxEspecializacao.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxEspecializacaoKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxEspecializacaoKeyReleased(evt);
            }
        });

        buttonAdicionar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/incluir.png"))); // NOI18N
        buttonAdicionar.setText("Adicionar");
        buttonAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonAdicionarActionPerformed(evt);
            }
        });

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(3, 3, 3)
                .addComponent(ComboBoxEspecializacao, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAdicionar)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxEspecializacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdicionar)
                    .addComponent(jLabel10)))
        );

        jPanel6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        tableEspecializacoes.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableEspecializacoes);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBotoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new Dimension(464, 754));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSalvarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonSalvarMouseEntered

    private void buttonSalvarMouseExited(MouseEvent evt) {//GEN-FIRST:event_buttonSalvarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonSalvarMouseExited

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        // Valida os campos obrigatorios antes de salvar
        if (Validacao.Vazio(textNome.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe o nome do médico",
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
        medico.setNome(textNome.getText());
        medico.setIdade((Integer) spinnerIdade.getValue());
        medico.setCpf(textCpf.getText());
        medico.setSexo((EnumSexo) ComboBoxSexo.getSelectedItem());
        medico.setEndereco((Endereco) ComboBoxEndereco.getSelectedItem());
        medico.setContato((Contato) ComboBoxContato.getSelectedItem());
        medico.setPeriodoTrabalho(textPeriodoTrabalho.getText());
        medico.setEspecializacoes(especializacoes);
        
        try {
            // Salva no banco de dados o Medico
            servico.editar(medico);
        } catch (ExcecaoServico|ExcecaoDAO|ExcecaoValidacao e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Registro editado com sucesso!", "Inclusão", JOptionPane.INFORMATION_MESSAGE);
        
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarMouseEntered(MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonCancelarMouseEntered

    private void buttonCancelarMouseExited(MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonCancelarMouseExited

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // Fecha a tela e sai da mesma
        sair();      
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonRemoverActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed

        if (tableEspecializacoes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um registro.");
            return;
        }

        Especializacao aux = especializacoes.get(tableEspecializacoes.getSelectedRow());

        if (aux == null) {
            JOptionPane.showMessageDialog(this, "Registro não encontrado.");
            return;
        }

        if (JOptionPane.showConfirmDialog(this,
            "Confirma a remoção da especialização: "
            + aux.getNome() + "?",
            "Remoção",
            JOptionPane.YES_NO_OPTION
        )== JOptionPane.YES_OPTION )
        {
            especializacoes.remove(tableEspecializacoes.getSelectedRow());
            carregaTable();
        }
    }//GEN-LAST:event_buttonRemoverActionPerformed

    private void buttonAdicionarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed

        // Verifica se tem alguma especializacao selecionada
        if (!(ComboBoxEspecializacao.getSelectedIndex() <= -1)) {
            especializacoes.add((Especializacao) ComboBoxEspecializacao.getSelectedItem());
            carregaTable();
        }
    }//GEN-LAST:event_buttonAdicionarActionPerformed

    private void ComboBoxEnderecoKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxEnderecoKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = true;
    }//GEN-LAST:event_ComboBoxEnderecoKeyPressed

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

    private void ComboBoxEnderecoKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxEnderecoKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = false;
    }//GEN-LAST:event_ComboBoxEnderecoKeyReleased

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

    private void ComboBoxEspecializacaoKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxEspecializacaoKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = true;
    }//GEN-LAST:event_ComboBoxEspecializacaoKeyPressed

    private void ComboBoxEspecializacaoKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxEspecializacaoKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = false;
    }//GEN-LAST:event_ComboBoxEspecializacaoKeyReleased

    private void ComboBoxEspecializacaoMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxEspecializacaoMouseClicked
        
        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaEspecializacao == null) {
            
            // Instancia o tela de incluir do Especializacao
            telaEspecializacao = new EspecializacaoInclui(parent, true, new ServicoEspecializacao());
            
            // Faz ela ficar visivel
            telaEspecializacao.setVisible(true);
            
            // A tela foi instanciada
            entrouEspecializacao = true;
            
            // Para de apertar Ctrl
            ctrl = false;
            
            // Preenche combo box do Especializacao
            PreencheComboBoxEspecializacao();
            
        // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrouEspecializacao) {
            
            // Se ela foi fechada
            if (!telaEspecializacao.isActive()) {
                
                // Faz ela ficar visivel
                telaEspecializacao.setVisible(true);
                
                // Para de apertar Ctrl
                ctrl = false;
                
                // Preenche combo box do Especializacao
                PreencheComboBoxEspecializacao();
            }
        }
    }//GEN-LAST:event_ComboBoxEspecializacaoMouseClicked

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxContato;
    private JComboBox<String> ComboBoxEndereco;
    private JComboBox<String> ComboBoxEspecializacao;
    private JComboBox<String> ComboBoxSexo;
    private JButton buttonAdicionar;
    private JButton buttonCancelar;
    private JButton buttonRemover;
    private JButton buttonSalvar;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JPanel panelBotoes;
    private JSpinner spinnerIdade;
    private JTable tableEspecializacoes;
    private JTextField textCpf;
    private JTextField textNome;
    private JTextField textPeriodoTrabalho;
    // End of variables declaration//GEN-END:variables
}