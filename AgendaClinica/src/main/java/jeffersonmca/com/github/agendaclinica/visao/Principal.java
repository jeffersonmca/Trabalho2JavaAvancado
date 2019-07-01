package jeffersonmca.com.github.agendaclinica.visao;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import jeffersonmca.com.github.agendaclinica.modelo.Usuario;
import jeffersonmca.com.github.agendaclinica.modelo.Permissao;
import jeffersonmca.com.github.agendaclinica.util.Validacao;
import jeffersonmca.com.github.agendaclinica.util.Conversoes;
import jeffersonmca.com.github.agendaclinica.visao.consulta.ConsultaListagem;
import jeffersonmca.com.github.agendaclinica.visao.consulta.ConsultaPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.contato.ContatoListagem;
import jeffersonmca.com.github.agendaclinica.visao.contato.ContatoPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.endereco.EnderecoListagem;
import jeffersonmca.com.github.agendaclinica.visao.endereco.EnderecoPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.especializacao.EspecializacaoListagem;
import jeffersonmca.com.github.agendaclinica.visao.especializacao.EspecializacaoPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.medico.MedicoListagem;
import jeffersonmca.com.github.agendaclinica.visao.medico.MedicoPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.paciente.PacienteListagem;
import jeffersonmca.com.github.agendaclinica.visao.paciente.PacientePesquisa;
import jeffersonmca.com.github.agendaclinica.visao.secretario.SecretarioListagem;
import jeffersonmca.com.github.agendaclinica.visao.secretario.SecretarioPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.usuario.UsuarioListagem;
import jeffersonmca.com.github.agendaclinica.visao.usuario.UsuarioPesquisa;

public class Principal extends javax.swing.JFrame {
    
    private Usuario usuario;
    private boolean acessoTelaConsulta;
    private boolean acessoTelaContato;
    private boolean acessoTelaEndereco;
    private boolean acessoTelaEspecializacao;
    private boolean acessoTelaMedico;
    private boolean acessoTelaSecretario;
    private boolean acessoTelaUsuario;
    private boolean acessoADM;
    
    public Principal(Usuario usuario) {
        
        initComponents();
        
        this.usuario = usuario;
        
        this.acessoTelaConsulta = false;
        this.acessoTelaContato = false;
        this.acessoTelaEndereco = false;
        this.acessoTelaEspecializacao = false;
        this.acessoTelaMedico = false;
        this.acessoTelaSecretario = false;
        this.acessoTelaUsuario = false;
        this.acessoADM = false;
        
        // Preenche informacoes
        PreencheInformacoes();
        
        // Verifica quais telas este usuario tem permissao de acesso
        verificaPermissoes();
    }
    
    // Preenche informacoes
    private void PreencheInformacoes() {
        
        labelAutenticadorLogado.setText(usuario.getAutenticador());
        labelUsuarioLogado.setText(usuario.getNome());
        labelData.setText(Conversoes.dateToStr(new Date()));
    }
    
    // Verifica quais telas este usuario tem permissao de acesso
    private void verificaPermissoes() {
        
        List<Permissao> permissoes = null;
        permissoes = usuario.getPermissoes();
        for (Permissao p : permissoes) {
            
            if (Validacao.Alocado(p)) {
                
                if (p.getDescricao().equals("Consulta"))
                    acessoTelaConsulta = true;
                else if (p.getDescricao().equals("Contato"))
                    acessoTelaContato = true;
                else if (p.getDescricao().equals("Endereco"))
                    acessoTelaEndereco = true;
                else if (p.getDescricao().equals("Especialização"))
                    acessoTelaEspecializacao = true;
                else if (p.getDescricao().equals("Médico"))
                    acessoTelaMedico = true;
                else if (p.getDescricao().equals("Secretário"))
                    acessoTelaSecretario = true;
                else if (p.getDescricao().equals("Usuário"))
                    acessoTelaUsuario = true;
                else if (p.getDescricao().equals("ADM"))
                    acessoADM = true;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelUsuarioLogado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelAutenticadorLogado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cadMenuConsulta = new javax.swing.JMenuItem();
        cadMenuContato = new javax.swing.JMenuItem();
        cadMenuEndereco = new javax.swing.JMenuItem();
        cadMenuEspecializacao = new javax.swing.JMenuItem();
        cadMenuMedico = new javax.swing.JMenuItem();
        cadMenuPaciente = new javax.swing.JMenuItem();
        cadMenuSecretario = new javax.swing.JMenuItem();
        cadMenuUsuario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        pesMenuConsulta = new javax.swing.JMenuItem();
        pesMenuContato = new javax.swing.JMenuItem();
        pesMenuEndereco = new javax.swing.JMenuItem();
        pesMenuEspecializacao = new javax.swing.JMenuItem();
        pesMenuMedico = new javax.swing.JMenuItem();
        pesMenuPaciente = new javax.swing.JMenuItem();
        pesMenuSecretario = new javax.swing.JMenuItem();
        pesMenuUsuario = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        conMenuLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Usuário:");

        jLabel3.setText("Data:");

        jLabel1.setText("Autenticador:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAutenticadorLogado, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(labelAutenticadorLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(labelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenu1.setText("Listagem");

        cadMenuConsulta.setText("Consulta");
        cadMenuConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuConsultaActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuConsulta);

        cadMenuContato.setText("Contato");
        cadMenuContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuContatoActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuContato);

        cadMenuEndereco.setText("Endereço");
        cadMenuEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuEnderecoActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuEndereco);

        cadMenuEspecializacao.setText("Especialização");
        cadMenuEspecializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuEspecializacaoActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuEspecializacao);

        cadMenuMedico.setText("Médico");
        cadMenuMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuMedicoActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuMedico);

        cadMenuPaciente.setText("Paciente");
        cadMenuPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuPaciente);

        cadMenuSecretario.setText("Secretário");
        cadMenuSecretario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuSecretarioActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuSecretario);

        cadMenuUsuario.setText("Usuário");
        cadMenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuUsuario);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Pesquisa");

        pesMenuConsulta.setText("Consulta");
        pesMenuConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuConsultaActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuConsulta);

        pesMenuContato.setText("Contato");
        pesMenuContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuContatoActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuContato);

        pesMenuEndereco.setText("Endereço");
        pesMenuEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuEnderecoActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuEndereco);

        pesMenuEspecializacao.setText("Especialização");
        pesMenuEspecializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuEspecializacaoActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuEspecializacao);

        pesMenuMedico.setText("Médico");
        pesMenuMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuMedicoActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuMedico);

        pesMenuPaciente.setText("Paciente");
        pesMenuPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuPacienteActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuPaciente);

        pesMenuSecretario.setText("Secretário");
        pesMenuSecretario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuSecretarioActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuSecretario);

        pesMenuUsuario.setText("Usuário");
        pesMenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuUsuario);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Configurações");

        conMenuLogout.setText("Logout");
        conMenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conMenuLogoutActionPerformed(evt);
            }
        });
        jMenu4.add(conMenuLogout);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 291, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadMenuConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuConsultaActionPerformed
        if (acessoTelaConsulta || acessoADM) {
            ConsultaListagem tela = new ConsultaListagem();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cadMenuConsultaActionPerformed

    private void cadMenuContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuContatoActionPerformed
        if (acessoTelaContato || acessoADM) {
            ContatoListagem tela = new ContatoListagem();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cadMenuContatoActionPerformed

    private void cadMenuEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuEnderecoActionPerformed
        if (acessoTelaEndereco || acessoADM) {
            EnderecoListagem tela = new EnderecoListagem();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cadMenuEnderecoActionPerformed

    private void cadMenuMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuMedicoActionPerformed
        if (acessoTelaMedico || acessoADM) {
            MedicoListagem tela = new MedicoListagem();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cadMenuMedicoActionPerformed

    private void cadMenuSecretarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuSecretarioActionPerformed
        if (acessoTelaSecretario || acessoADM) {
            SecretarioListagem tela = new SecretarioListagem();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cadMenuSecretarioActionPerformed

    private void cadMenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuUsuarioActionPerformed
        if (acessoTelaUsuario || acessoADM) {
            UsuarioListagem tela = new UsuarioListagem();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cadMenuUsuarioActionPerformed

    private void pesMenuConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuConsultaActionPerformed
        if (acessoTelaConsulta || acessoADM) {
            ConsultaPesquisa tela = new ConsultaPesquisa();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pesMenuConsultaActionPerformed

    private void pesMenuContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuContatoActionPerformed
        if (acessoTelaContato || acessoADM) {
            ContatoPesquisa tela = new ContatoPesquisa();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pesMenuContatoActionPerformed

    private void pesMenuEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuEnderecoActionPerformed
        if (acessoTelaEndereco || acessoADM) {
            EnderecoPesquisa tela = new EnderecoPesquisa();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pesMenuEnderecoActionPerformed

    private void pesMenuEspecializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuEspecializacaoActionPerformed
        if (acessoTelaEspecializacao || acessoADM) {
            EspecializacaoPesquisa tela = new EspecializacaoPesquisa();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pesMenuEspecializacaoActionPerformed

    private void pesMenuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuPacienteActionPerformed
        if (acessoTelaSecretario || acessoADM) {
            PacientePesquisa tela = new PacientePesquisa();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pesMenuPacienteActionPerformed

    private void pesMenuSecretarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuSecretarioActionPerformed
        if (acessoTelaSecretario || acessoADM) {
            SecretarioPesquisa tela = new SecretarioPesquisa();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pesMenuSecretarioActionPerformed

    private void cadMenuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuPacienteActionPerformed
        if (acessoTelaSecretario || acessoADM) {
            PacienteListagem tela = new PacienteListagem();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cadMenuPacienteActionPerformed

    private void pesMenuMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuMedicoActionPerformed
        if (acessoTelaMedico || acessoADM) {
            MedicoPesquisa tela = new MedicoPesquisa();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pesMenuMedicoActionPerformed

    private void conMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conMenuLogoutActionPerformed
        
        this.setVisible(false);
        this.dispose();
        
        VisaoLogin tela = new VisaoLogin();
        tela.setVisible(true);
    }//GEN-LAST:event_conMenuLogoutActionPerformed

    private void cadMenuEspecializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuEspecializacaoActionPerformed
        if (acessoTelaEspecializacao || acessoADM) {
            EspecializacaoListagem tela = new EspecializacaoListagem();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cadMenuEspecializacaoActionPerformed

    private void pesMenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuUsuarioActionPerformed
        if (acessoTelaUsuario || acessoADM) {
            UsuarioPesquisa tela = new UsuarioPesquisa();
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar essa tela!", "Dica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pesMenuUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadMenuConsulta;
    private javax.swing.JMenuItem cadMenuContato;
    private javax.swing.JMenuItem cadMenuEndereco;
    private javax.swing.JMenuItem cadMenuEspecializacao;
    private javax.swing.JMenuItem cadMenuMedico;
    private javax.swing.JMenuItem cadMenuPaciente;
    private javax.swing.JMenuItem cadMenuSecretario;
    private javax.swing.JMenuItem cadMenuUsuario;
    private javax.swing.JMenuItem conMenuLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAutenticadorLogado;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelUsuarioLogado;
    private javax.swing.JMenuItem pesMenuConsulta;
    private javax.swing.JMenuItem pesMenuContato;
    private javax.swing.JMenuItem pesMenuEndereco;
    private javax.swing.JMenuItem pesMenuEspecializacao;
    private javax.swing.JMenuItem pesMenuMedico;
    private javax.swing.JMenuItem pesMenuPaciente;
    private javax.swing.JMenuItem pesMenuSecretario;
    private javax.swing.JMenuItem pesMenuUsuario;
    // End of variables declaration//GEN-END:variables
}