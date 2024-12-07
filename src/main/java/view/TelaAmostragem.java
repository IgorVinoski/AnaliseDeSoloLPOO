/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.PersistenciaJPA;
import igor.sistemaanalisedesololpoo.Agricultor;
import igor.sistemaanalisedesololpoo.Parcela;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author igor
 */
public class TelaAmostragem extends javax.swing.JFrame {

     private PersistenciaJPA persistencia;

    /**
     * Creates new form TelaAmostragem
     */
    public TelaAmostragem(PersistenciaJPA persistencia) {
        this.persistencia = persistencia;
        initComponents();
        carregarAgricultores();
        
        
        jListParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) { // Verifica se é um clique duplo
            abrirTelaGraficoParcela();
        }
    }
});

        
        carregarParcelas(null);  // Carregar todas as parcelas inicialmente
    }
private void abrirTelaGraficoParcela() {
    String selecionado = jListParcelas.getSelectedValue();
    if (selecionado == null) {
        JOptionPane.showMessageDialog(this, "Selecione uma parcela para visualizar o gráfico.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Extrair o ID da parcela
    Long idParcela = extrairIdDaParcela(selecionado);
    if (idParcela == null) {
        JOptionPane.showMessageDialog(this, "ID inválido ou não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Buscar a parcela no banco de dados
    Parcela parcela = persistencia.getEntityManager().find(Parcela.class, idParcela);
    if (parcela == null) {
        JOptionPane.showMessageDialog(this, "Parcela não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Abrir a nova janela com o gráfico
    TelaGraficoParcela telaGrafico = new TelaGraficoParcela(parcela);
    telaGrafico.setVisible(true);
}

    TelaAmostragem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Long extrairIdDaParcela(String textoParcela) {
    try {
        // Supondo que o formato seja "id=123, tipoSolo=Argiloso..."
        String[] partes = textoParcela.split(",");
        for (String parte : partes) {
            if (parte.trim().startsWith("id=")) {
                return Long.parseLong(parte.trim().substring(3)); // Extrai o número após "id="
            }
        }
        return null; // Caso o ID não seja encontrado
    } catch (NumberFormatException e) {
        return null; // Caso o formato seja inválido
    }
}

  private void removerParcelaSelecionada() {
    try {
        // Obtem o item selecionado na JList
        String selecionado = jListParcelas.getSelectedValue();
        if (selecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma parcela para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Extrai o ID da string selecionada
        Long idParcela = extrairIdDaParcela(selecionado);
        if (idParcela == null) {
            JOptionPane.showMessageDialog(this, "ID inválido ou não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Busca a parcela pelo ID
        Parcela parcela = persistencia.getEntityManager().find(Parcela.class, idParcela);
        if (parcela == null) {
            JOptionPane.showMessageDialog(this, "Parcela não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Remove a parcela
        persistencia.remover(parcela);

        // Atualiza a lista de parcelas na interface
        carregarParcelas(jComboBoxAgricultores.getSelectedItem());

        // Mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Parcela removida com sucesso.");
    } catch (Exception e) {
        // Mensagem de erro
        JOptionPane.showMessageDialog(this, "Erro ao remover parcela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


private void carregarAgricultores() {
    try {
        List<Agricultor> agricultores = persistencia.getEntityManager()
                .createQuery("SELECT a FROM Agricultor a", Agricultor.class)
                .getResultList();

        jComboBoxAgricultores.removeAllItems();
        jComboBoxAgricultores.addItem("Todos"); // Adiciona a opção "Todos"

        for (Agricultor agricultor : agricultores) {
            jComboBoxAgricultores.addItem(agricultor);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar agricultores: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


 private void carregarParcelas(Object selecionado) {
        try {
            List<Parcela> parcelas;

            if (selecionado == null || "Todos".equals(selecionado)) {
                // Carrega todas as parcelas se nenhum agricultor for selecionado ou se "Todos" for escolhido
                parcelas = persistencia.getEntityManager()
                        .createQuery("SELECT p FROM Parcela p", Parcela.class)
                        .getResultList();
            } else if (selecionado instanceof Agricultor) {
                // Carrega as parcelas associadas ao agricultor selecionado
                Agricultor agricultorSelecionado = (Agricultor) selecionado;
                parcelas = persistencia.getEntityManager()
                        .createQuery("SELECT p FROM Parcela p WHERE p.agricultor = :agricultor", Parcela.class)
                        .setParameter("agricultor", agricultorSelecionado)
                        .getResultList();
            } else {
                // Caso não seja nem "Todos" nem um Agricultor válido, não faz nada
                parcelas = new ArrayList<>();
            }

            // Preenche a lista com as parcelas encontradas
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (Parcela parcela : parcelas) {
                listModel.addElement(parcela.toString());
            }
            jListParcelas.setModel(listModel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar parcelas: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


     private void abrirTelaCadastrarParcela() {
        // Exemplo: Supondo que exista uma classe TelaCadastrarParcela
        TelaCadastroParcela telaCadastrarParcela = new TelaCadastroParcela(persistencia);
        telaCadastrarParcela.setVisible(true);
    }
     
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListParcelas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxAgricultores = new javax.swing.JComboBox<>();
        jButton1Cadastro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jListParcelas);

        jLabel1.setText("Agricultor");

        jComboBoxAgricultores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAgricultoresActionPerformed(evt);
            }
        });

        jButton1Cadastro.setText("Nova");
        jButton1Cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1CadastroActionPerformed(evt);
            }
        });

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1)
                        .addGap(50, 50, 50)
                        .addComponent(jComboBoxAgricultores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1Cadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxAgricultores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1Cadastro)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1CadastroActionPerformed
        // TODO add your handling code here:
           TelaCadastroParcela telaCadastroParcela = new TelaCadastroParcela(persistencia);
            telaCadastroParcela.setVisible(true);
            
            
             telaCadastroParcela.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            // Recarregar a lista de parcelas após a janela de cadastro ser fechada
            carregarParcelas(jComboBoxAgricultores.getSelectedItem());
        }
    });
    }//GEN-LAST:event_jButton1CadastroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        removerParcelaSelecionada();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxAgricultoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAgricultoresActionPerformed
        // TODO add your handling code here:
        Object selecionado = jComboBoxAgricultores.getSelectedItem();
        if ("Todos".equals(selecionado)) {
            carregarParcelas(null); // Carrega todas as parcelas
        } else {
            carregarParcelas(selecionado); // Filtra pelas parcelas do agricultor selecionado
        }
    }//GEN-LAST:event_jComboBoxAgricultoresActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1Cadastro;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<Object> jComboBoxAgricultores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListParcelas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
