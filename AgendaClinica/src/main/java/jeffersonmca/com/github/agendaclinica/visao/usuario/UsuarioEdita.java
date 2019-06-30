package jeffersonmca.com.github.agendaclinica.visao.usuario;

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
import javax.swing.JPasswordField;
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
import jeffersonmca.com.github.agendaclinica.modelo.Permissao;
import jeffersonmca.com.github.agendaclinica.modelo.Usuario;
import jeffersonmca.com.github.agendaclinica.renderizadores.StrippedTableCellHandler;
import jeffersonmca.com.github.agendaclinica.servico.ServicoContato;
import jeffersonmca.com.github.agendaclinica.servico.ServicoEndereco;
import jeffersonmca.com.github.agendaclinica.servico.ServicoPermissao;
import jeffersonmca.com.github.agendaclinica.servico.ServicoUsuario;
import jeffersonmca.com.github.agendaclinica.util.Validacao;
import jeffersonmca.com.github.agendaclinica.visao.contato.ContatoInclui;
import jeffersonmca.com.github.agendaclinica.visao.endereco.EnderecoInclui;

public class UsuarioEdita extends javax.swing.JDialog {

    private Usuario usuario;
    private ServicoUsuario servico;
    private ServicoEndereco endServico;
    private ServicoContato cotServico;
    private ServicoPermissao perServico;
    private List<Permissao> permissoes;
    private boolean ctrl;
    private EnderecoInclui telaEndereco;
    private ContatoInclui telaContato;
    private java.awt.Frame parent;
    private boolean entrouEndereco;
    private boolean entrouContato;
    
    public UsuarioEdita(java.awt.Frame parent, boolean modal, ServicoUsuario servico, Usuario usuario) {
        
        super(parent, modal);
        initComponents();
        
        this.usuario = usuario;
        this.servico = servico;
        this.endServico = new ServicoEndereco();
        this.cotServico = new ServicoContato();
        this.perServico = new ServicoPermissao();
        this.permissoes = new ArrayList<>();
        this.ctrl = false;
        this.telaEndereco = null;
        this.telaContato = null;
        this.parent = parent;
        this.entrouEndereco = false;
        this.entrouContato = false;
        
        // Solucao encontrada para o problema de que quando o usuario abria a tela de UsuarioEdita e
        // adicionava uma permissao e depois cancelava, se ele abrisse a tela novamente aquela permissao que
        // foi adicionado recentemente ainda estava la, e isso nao poderia ocorrer
        for (Permissao p : usuario.getPermissoes()) {
            if (p != null) {
                Permissao aux = new Permissao();
                aux.setCodigo(p.getCodigo());
                aux.setDescricao(p.getDescricao());
                this.permissoes.add(aux);
            }
        }
        
        // Preenche todos os cambo box da tela
        PreencheComboBox();
        
        // Como esta editando os dados de um Usuario especifico, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
        PreencheCampos(usuario);
        
        // Atualiza os dados da grid das permissoes
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
    
    // Preenche combo box da Permissao
    private void PreencheComboBoxPermissao() {
        List<Permissao> lista = null;
        try {
            lista = perServico.buscarPermissoesForaDaGrid(permissoes);
        } catch (ExcecaoDAO ex) {}
        
        Vector<Permissao> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmPermissao =
               new DefaultComboBoxModel(vetor);
        ComboBoxPermissao.setModel(dcbmPermissao);
        
        // Nao coloca o foco em nenhum nome
        ComboBoxPermissao.setSelectedIndex(-1);
    }
    
    // Preenche todos os cambo box da tela
    private void PreencheComboBox() {
        PreencheComboBoxEndereco();
        PreencheComboBoxContato();
        PreencheComboBoxSexo();
    }
    
    // Como esta editando os dados de um Usuario especifico, os campos seram preenchidos
    // com os dados desse objeto para entao poder edita-los
    private void PreencheCampos(Usuario usuario) {
        textNome.setText(usuario.getNome());
        spinnerIdade.setValue(usuario.getIdade());
        textCpf.setText(usuario.getCpf());
        ComboBoxSexo.setSelectedItem(usuario.getSexo());
        ComboBoxEndereco.setSelectedItem(usuario.getEndereco());
        ComboBoxContato.setSelectedItem(usuario.getContato());
        textAutenticador.setText(usuario.getAutenticador());
        passwordSenha.setText(usuario.getSenha());
    }

    // Atualiza os dados da grid dos permissoes
    private void carregaTable() {
        PermissoesTableModel atm = new PermissoesTableModel(permissoes);
        tablePermissoes.setModel(atm);
        
        // Melhorando o aspecto da grid
        tablePermissoes.setDefaultRenderer(Object.class, new StrippedTableCellHandler());
        
        // Preenche combo box do Permissao
        PreencheComboBoxPermissao();
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
        textAutenticador = new JTextField();
        jLabel1 = new JLabel();
        passwordSenha = new JPasswordField();
        jLabel2 = new JLabel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        buttonRemover = new JButton();
        jPanel5 = new JPanel();
        jLabel10 = new JLabel();
        ComboBoxPermissao = new JComboBox<>();
        buttonAdicionar = new JButton();
        jPanel6 = new JPanel();
        jScrollPane1 = new JScrollPane();
        tablePermissoes = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edita Usuário");

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

        jLabel1.setForeground(new Color(250, 0, 51));
        jLabel1.setText("Autenticador:");

        jLabel2.setForeground(new Color(250, 0, 51));
        jLabel2.setText("Senha:");

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
                                .addComponent(ComboBoxContato, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textAutenticador, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(textAutenticador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
        jLabel10.setText("Permissão:");

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
                .addComponent(ComboBoxPermissao, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAdicionar)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxPermissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdicionar)
                    .addComponent(jLabel10)))
        );

        jPanel6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        tablePermissoes.setModel(new DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePermissoes);

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
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
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

        setSize(new Dimension(464, 806));
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
                    "Informe o nome do usuário",
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
        
        if (Validacao.Vazio(textAutenticador.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe o autenticador",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Validacao.Vazio(String.valueOf(passwordSenha.getPassword()))) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe a senha",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
               
        // Todos os campos obrigatorios estao preenchidos
        // Preenche esse objeto com os dados da tela
        usuario.setNome(textNome.getText());
        usuario.setIdade((Integer) spinnerIdade.getValue());
        usuario.setCpf(textCpf.getText());
        usuario.setSexo((EnumSexo) ComboBoxSexo.getSelectedItem());
        usuario.setEndereco((Endereco) ComboBoxEndereco.getSelectedItem());
        usuario.setContato((Contato) ComboBoxContato.getSelectedItem());
        usuario.setAutenticador(textAutenticador.getText());
        usuario.setSenha(String.valueOf(passwordSenha.getPassword()));
        usuario.setPermissoes(permissoes);
        
        try {
            // Salva no banco de dados o Usuario
            servico.editar(usuario);
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

        if (tablePermissoes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um registro.");
            return;
        }

        Permissao aux = permissoes.get(tablePermissoes.getSelectedRow());

        if (aux == null) {
            JOptionPane.showMessageDialog(this, "Registro não encontrado.");
            return;
        }

        if (JOptionPane.showConfirmDialog(this,
            "Confirma a remoção da permissão: "
            + aux.getDescricao()+ "?",
            "Remoção",
            JOptionPane.YES_NO_OPTION
        )== JOptionPane.YES_OPTION )
        {
            permissoes.remove(tablePermissoes.getSelectedRow());
            carregaTable();
        }
    }//GEN-LAST:event_buttonRemoverActionPerformed

    private void buttonAdicionarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed

        // Verifica se tem alguma permissao selecionada
        if (!(ComboBoxPermissao.getSelectedIndex() <= -1)) {
            permissoes.add((Permissao) ComboBoxPermissao.getSelectedItem());
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

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxContato;
    private JComboBox<String> ComboBoxEndereco;
    private JComboBox<String> ComboBoxPermissao;
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
    private JLabel jLabel2;
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
    private JPasswordField passwordSenha;
    private JSpinner spinnerIdade;
    private JTable tablePermissoes;
    private JTextField textAutenticador;
    private JTextField textCpf;
    private JTextField textNome;
    // End of variables declaration//GEN-END:variables
}