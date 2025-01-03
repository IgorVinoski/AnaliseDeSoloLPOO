/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.PersistenciaJPA;

/**
 *
 * @author igor
 */
public class MainJFrame extends javax.swing.JFrame {
private PersistenciaJPA persistencia;

    /**
     * Creates new form MainJFrame
     */
   public MainJFrame(PersistenciaJPA persistencia) {
    this.persistencia = persistencia;
    initComponents();
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        miAgricultor = new javax.swing.JMenuItem();
        menuAmostragem = new javax.swing.JMenu();
        jMenuItemAmostragem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCadastro.setText("Cadastro");

        miAgricultor.setText("Agricultor");
        miAgricultor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAgricultorActionPerformed(evt);
            }
        });
        menuCadastro.add(miAgricultor);

        jMenuBar1.add(menuCadastro);

        menuAmostragem.setText("Amostragem");
        menuAmostragem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAmostragemActionPerformed(evt);
            }
        });

        jMenuItemAmostragem.setText("Ver");
        jMenuItemAmostragem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAmostragemActionPerformed(evt);
            }
        });
        menuAmostragem.add(jMenuItemAmostragem);

        jMenuBar1.add(menuAmostragem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAgricultorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAgricultorActionPerformed
        // TODO add your handling code here:
          TelaCadastroAgricultor telaCadastroAgricultor = new TelaCadastroAgricultor();
        telaCadastroAgricultor.setVisible(true);
        telaCadastroAgricultor.setLocationRelativeTo(null);
    }//GEN-LAST:event_miAgricultorActionPerformed

    private void menuAmostragemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAmostragemActionPerformed
       
    }//GEN-LAST:event_menuAmostragemActionPerformed

    private void jMenuItemAmostragemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAmostragemActionPerformed
        TelaAmostragem telaAmostragem = new TelaAmostragem(persistencia);
        telaAmostragem.setVisible(true);
        telaAmostragem.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemAmostragemActionPerformed

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
    PersistenciaJPA persistencia = new PersistenciaJPA(); // Ou como for necessário para inicializar
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new MainJFrame(persistencia).setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAmostragem;
    private javax.swing.JMenu menuAmostragem;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem miAgricultor;
    // End of variables declaration//GEN-END:variables
}
