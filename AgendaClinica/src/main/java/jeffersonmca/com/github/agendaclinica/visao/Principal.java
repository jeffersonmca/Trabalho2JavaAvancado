package jeffersonmca.com.github.agendaclinica.visao;

import jeffersonmca.com.github.agendaclinica.visao.consulta.ConsultaListagem;
import jeffersonmca.com.github.agendaclinica.visao.consulta.ConsultaPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.contato.ContatoListagem;
import jeffersonmca.com.github.agendaclinica.visao.contato.ContatoPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.endereco.EnderecoListagem;
import jeffersonmca.com.github.agendaclinica.visao.endereco.EnderecoPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.medico.MedicoListagem;
import jeffersonmca.com.github.agendaclinica.visao.medico.MedicoPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.paciente.PacienteListagem;
import jeffersonmca.com.github.agendaclinica.visao.paciente.PacientePesquisa;
import jeffersonmca.com.github.agendaclinica.visao.permissao.PermissaoListagem;
import jeffersonmca.com.github.agendaclinica.visao.permissao.PermissaoPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.secretario.SecretarioListagem;
import jeffersonmca.com.github.agendaclinica.visao.secretario.SecretarioPesquisa;
import jeffersonmca.com.github.agendaclinica.visao.usuario.UsuarioListagem;
import jeffersonmca.com.github.agendaclinica.visao.usuario.UsuarioPesquisa;

public class Principal extends javax.swing.JFrame {
    
    public Principal() {
        
        initComponents();
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
        labelIdLogado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cadMenuConsulta = new javax.swing.JMenuItem();
        cadMenuContato = new javax.swing.JMenuItem();
        cadMenuEndereco = new javax.swing.JMenuItem();
        cadMenuEspecializacao = new javax.swing.JMenuItem();
        cadMenuMedico = new javax.swing.JMenuItem();
        cadMenuPaciente = new javax.swing.JMenuItem();
        cadMenuPermissao = new javax.swing.JMenuItem();
        cadMenuSecretario = new javax.swing.JMenuItem();
        cadMenuUsuario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        pesMenuConsulta = new javax.swing.JMenuItem();
        pesMenuContato = new javax.swing.JMenuItem();
        pesMenuEndereco = new javax.swing.JMenuItem();
        pesMenuEspecializacao = new javax.swing.JMenuItem();
        pesMenuMedico = new javax.swing.JMenuItem();
        pesMenuPaciente = new javax.swing.JMenuItem();
        pesMenuPermissao = new javax.swing.JMenuItem();
        pesMenuSecretario = new javax.swing.JMenuItem();
        pesMenuUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        relMenuConsulta = new javax.swing.JMenuItem();
        relMenuContato = new javax.swing.JMenuItem();
        relMenuEndereco = new javax.swing.JMenuItem();
        relMenuEspecializacao = new javax.swing.JMenuItem();
        relMenuMedico = new javax.swing.JMenuItem();
        relMenuPaciente = new javax.swing.JMenuItem();
        relMenuPermissao = new javax.swing.JMenuItem();
        relMenuSecretario = new javax.swing.JMenuItem();
        relMenuUsuario = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        conMenuLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Usuário:");

        jLabel3.setText("Data:");

        jLabel1.setText("id:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIdLogado, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelIdLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
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

        cadMenuPermissao.setText("Permissão");
        cadMenuPermissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuPermissaoActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuPermissao);

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

        pesMenuPermissao.setText("Permissão");
        pesMenuPermissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuPermissaoActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuPermissao);

        pesMenuSecretario.setText("Secretário");
        pesMenuSecretario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuSecretarioActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuSecretario);

        pesMenuUsuario.setText("Usuário");
        jMenu3.add(pesMenuUsuario);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Relatório");

        relMenuConsulta.setText("Consulta");
        relMenuConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relMenuConsultaActionPerformed(evt);
            }
        });
        jMenu2.add(relMenuConsulta);

        relMenuContato.setText("Contato");
        jMenu2.add(relMenuContato);

        relMenuEndereco.setText("Endereço");
        jMenu2.add(relMenuEndereco);

        relMenuEspecializacao.setText("Especialização");
        jMenu2.add(relMenuEspecializacao);

        relMenuMedico.setText("Médico");
        jMenu2.add(relMenuMedico);

        relMenuPaciente.setText("Paciente");
        jMenu2.add(relMenuPaciente);

        relMenuPermissao.setText("Permissão");
        jMenu2.add(relMenuPermissao);

        relMenuSecretario.setText("Secretário");
        jMenu2.add(relMenuSecretario);

        relMenuUsuario.setText("Usuário");
        jMenu2.add(relMenuUsuario);

        jMenuBar1.add(jMenu2);

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
        ConsultaListagem tela = new ConsultaListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuConsultaActionPerformed

    private void cadMenuContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuContatoActionPerformed
        ContatoListagem tela = new ContatoListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuContatoActionPerformed

    private void cadMenuEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuEnderecoActionPerformed
        EnderecoListagem tela = new EnderecoListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuEnderecoActionPerformed

    private void cadMenuMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuMedicoActionPerformed
        MedicoListagem tela = new MedicoListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuMedicoActionPerformed

    private void cadMenuPermissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuPermissaoActionPerformed
        PermissaoListagem tela = new PermissaoListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuPermissaoActionPerformed

    private void cadMenuSecretarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuSecretarioActionPerformed
        SecretarioListagem tela = new SecretarioListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuSecretarioActionPerformed

    private void cadMenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuUsuarioActionPerformed
        UsuarioListagem tela = new UsuarioListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuUsuarioActionPerformed

    private void relMenuConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relMenuConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_relMenuConsultaActionPerformed

    private void pesMenuConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuConsultaActionPerformed
        ConsultaPesquisa tela = new ConsultaPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuConsultaActionPerformed

    private void pesMenuContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuContatoActionPerformed
        ContatoPesquisa tela = new ContatoPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuContatoActionPerformed

    private void pesMenuEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuEnderecoActionPerformed
        EnderecoPesquisa tela = new EnderecoPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuEnderecoActionPerformed

    private void pesMenuEspecializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuEspecializacaoActionPerformed
        MedicoPesquisa tela = new MedicoPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuEspecializacaoActionPerformed

    private void pesMenuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuPacienteActionPerformed
        PermissaoPesquisa tela = new PermissaoPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuPacienteActionPerformed

    private void pesMenuPermissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuPermissaoActionPerformed
        SecretarioPesquisa tela = new SecretarioPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuPermissaoActionPerformed

    private void pesMenuSecretarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuSecretarioActionPerformed
        UsuarioPesquisa tela = new UsuarioPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuSecretarioActionPerformed

    private void cadMenuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuPacienteActionPerformed
        PacienteListagem tela = new PacienteListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuPacienteActionPerformed

    private void pesMenuMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuMedicoActionPerformed
        PacientePesquisa tela = new PacientePesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuMedicoActionPerformed

    private void conMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conMenuLogoutActionPerformed
        
        this.setVisible(false);
        this.dispose();
        
        VisaoLogin tela = new VisaoLogin();
        tela.setVisible(true);
    }//GEN-LAST:event_conMenuLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadMenuConsulta;
    private javax.swing.JMenuItem cadMenuContato;
    private javax.swing.JMenuItem cadMenuEndereco;
    private javax.swing.JMenuItem cadMenuEspecializacao;
    private javax.swing.JMenuItem cadMenuMedico;
    private javax.swing.JMenuItem cadMenuPaciente;
    private javax.swing.JMenuItem cadMenuPermissao;
    private javax.swing.JMenuItem cadMenuSecretario;
    private javax.swing.JMenuItem cadMenuUsuario;
    private javax.swing.JMenuItem conMenuLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelIdLogado;
    private javax.swing.JLabel labelUsuarioLogado;
    private javax.swing.JMenuItem pesMenuConsulta;
    private javax.swing.JMenuItem pesMenuContato;
    private javax.swing.JMenuItem pesMenuEndereco;
    private javax.swing.JMenuItem pesMenuEspecializacao;
    private javax.swing.JMenuItem pesMenuMedico;
    private javax.swing.JMenuItem pesMenuPaciente;
    private javax.swing.JMenuItem pesMenuPermissao;
    private javax.swing.JMenuItem pesMenuSecretario;
    private javax.swing.JMenuItem pesMenuUsuario;
    private javax.swing.JMenuItem relMenuConsulta;
    private javax.swing.JMenuItem relMenuContato;
    private javax.swing.JMenuItem relMenuEndereco;
    private javax.swing.JMenuItem relMenuEspecializacao;
    private javax.swing.JMenuItem relMenuMedico;
    private javax.swing.JMenuItem relMenuPaciente;
    private javax.swing.JMenuItem relMenuPermissao;
    private javax.swing.JMenuItem relMenuSecretario;
    private javax.swing.JMenuItem relMenuUsuario;
    // End of variables declaration//GEN-END:variables
}