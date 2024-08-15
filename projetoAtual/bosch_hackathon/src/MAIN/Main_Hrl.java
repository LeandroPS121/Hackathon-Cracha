/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package MAIN;

import SCREENS.Cracha_Hrl;
import SCREENS.History;
import SCREENS.Temporario_Hrl;

/**
 *
 * @author sil9jvl
 */
public class Main_Hrl extends javax.swing.JDialog {

    /**
     * Creates new form Main
     */
    public Main_Hrl(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jPContainer = new javax.swing.JPanel();
        jPOptions = new javax.swing.JPanel();
        jPManageOptions = new javax.swing.JPanel();
        jBAssignBadge = new javax.swing.JButton();
        jBBadgeManagement = new javax.swing.JButton();
        jBRequest = new javax.swing.JButton();
        jBHistory = new javax.swing.JButton();
        jBHistory1 = new javax.swing.JButton();
        jPHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setResizable(false);

        jPContainer.setBackground(new java.awt.Color(224, 226, 229));
        jPContainer.setMaximumSize(new java.awt.Dimension(1160, 720));
        jPContainer.setMinimumSize(new java.awt.Dimension(1160, 720));
        jPContainer.setPreferredSize(new java.awt.Dimension(1160, 720));

        jPOptions.setBackground(new java.awt.Color(0, 123, 192));
        jPOptions.setMaximumSize(new java.awt.Dimension(0, 0));
        jPOptions.setPreferredSize(new java.awt.Dimension(0, 0));

        jPManageOptions.setBackground(new java.awt.Color(0, 123, 192));

        jBAssignBadge.setBackground(new java.awt.Color(0, 110, 173));
        jBAssignBadge.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBAssignBadge.setForeground(new java.awt.Color(255, 255, 255));
        jBAssignBadge.setText("Assign Temporary Badge");
        jBAssignBadge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAssignBadgeActionPerformed(evt);
            }
        });

        jBBadgeManagement.setBackground(new java.awt.Color(0, 110, 173));
        jBBadgeManagement.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBBadgeManagement.setForeground(new java.awt.Color(255, 255, 255));
        jBBadgeManagement.setText("Badge Management");
        jBBadgeManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBadgeManagementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPManageOptionsLayout = new javax.swing.GroupLayout(jPManageOptions);
        jPManageOptions.setLayout(jPManageOptionsLayout);
        jPManageOptionsLayout.setHorizontalGroup(
            jPManageOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPManageOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPManageOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBBadgeManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBAssignBadge, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
        );
        jPManageOptionsLayout.setVerticalGroup(
            jPManageOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPManageOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAssignBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBBadgeManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBRequest.setBackground(new java.awt.Color(0, 110, 173));
        jBRequest.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBRequest.setForeground(new java.awt.Color(255, 255, 255));
        jBRequest.setText("Request");

        jBHistory.setBackground(new java.awt.Color(0, 110, 173));
        jBHistory.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBHistory.setForeground(new java.awt.Color(255, 255, 255));
        jBHistory.setText("History");
        jBHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHistoryActionPerformed(evt);
            }
        });

        jBHistory1.setBackground(new java.awt.Color(0, 110, 173));
        jBHistory1.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBHistory1.setForeground(new java.awt.Color(255, 255, 255));
        jBHistory1.setText("Logout");
        jBHistory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHistory1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPOptionsLayout = new javax.swing.GroupLayout(jPOptions);
        jPOptions.setLayout(jPOptionsLayout);
        jPOptionsLayout.setHorizontalGroup(
            jPOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPManageOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBHistory1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPOptionsLayout.setVerticalGroup(
            jPOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPManageOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jBHistory1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jPHeader.setBackground(new java.awt.Color(239, 241, 242));
        jPHeader.setMaximumSize(new java.awt.Dimension(0, 0));
        jPHeader.setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/header-bosch.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jLabel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel1.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout jPHeaderLayout = new javax.swing.GroupLayout(jPHeader);
        jPHeader.setLayout(jPHeaderLayout);
        jPHeaderLayout.setHorizontalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPHeaderLayout.setVerticalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPContainerLayout = new javax.swing.GroupLayout(jPContainer);
        jPContainer.setLayout(jPContainerLayout);
        jPContainerLayout.setHorizontalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPContainerLayout.createSequentialGroup()
                .addGroup(jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPContainerLayout.setVerticalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContainerLayout.createSequentialGroup()
                .addComponent(jPHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHistoryActionPerformed
        History history = new History(null,true);
        this.dispose();
        history.setVisible(true);
    }//GEN-LAST:event_jBHistoryActionPerformed

    private void jBHistory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHistory1ActionPerformed
        Login login = new Login(null,true);
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jBHistory1ActionPerformed

    private void jBAssignBadgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAssignBadgeActionPerformed
        Temporario_Hrl temporario_hrl = new Temporario_Hrl(null,true);
        this.dispose();
        temporario_hrl.setVisible(true);
    }//GEN-LAST:event_jBAssignBadgeActionPerformed

    private void jBBadgeManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBadgeManagementActionPerformed
        Cracha_Hrl cracha_hrl = new Cracha_Hrl(null,true);
        this.dispose();
        cracha_hrl.setVisible(true);
    }//GEN-LAST:event_jBBadgeManagementActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Hrl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Hrl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Hrl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Hrl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main_Hrl dialog = new Main_Hrl(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAssignBadge;
    private javax.swing.JButton jBBadgeManagement;
    private javax.swing.JButton jBHistory;
    private javax.swing.JButton jBHistory1;
    private javax.swing.JButton jBRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPContainer;
    private javax.swing.JPanel jPHeader;
    private javax.swing.JPanel jPManageOptions;
    private javax.swing.JPanel jPOptions;
    // End of variables declaration//GEN-END:variables
}
