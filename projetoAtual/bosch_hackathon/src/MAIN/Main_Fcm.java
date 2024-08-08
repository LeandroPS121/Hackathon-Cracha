/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package MAIN;

import SCREENS.History;

/**
 *
 * @author sil9jvl
 */
public class Main_Fcm extends javax.swing.JDialog {

    /**
     * Creates new form Main
     */
    public Main_Fcm(java.awt.Frame parent, boolean modal) {
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
        jBRequest = new javax.swing.JButton();
        jBHistory = new javax.swing.JButton();
        jBRequest1 = new javax.swing.JButton();
        jBHistory1 = new javax.swing.JButton();
        jPHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1160, 720));
        setResizable(false);

        jPContainer.setBackground(new java.awt.Color(224, 226, 229));
        jPContainer.setMaximumSize(new java.awt.Dimension(1160, 720));
        jPContainer.setMinimumSize(new java.awt.Dimension(1160, 720));
        jPContainer.setPreferredSize(new java.awt.Dimension(1160, 720));

        jPOptions.setBackground(new java.awt.Color(0, 123, 192));
        jPOptions.setMaximumSize(new java.awt.Dimension(0, 0));

        jBRequest.setBackground(new java.awt.Color(0, 110, 173));
        jBRequest.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBRequest.setForeground(new java.awt.Color(255, 255, 255));
        jBRequest.setText("Manage External Worker");

        jBHistory.setBackground(new java.awt.Color(0, 110, 173));
        jBHistory.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBHistory.setForeground(new java.awt.Color(255, 255, 255));
        jBHistory.setText("History");
        jBHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHistoryActionPerformed(evt);
            }
        });

        jBRequest1.setBackground(new java.awt.Color(0, 110, 173));
        jBRequest1.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBRequest1.setForeground(new java.awt.Color(255, 255, 255));
        jBRequest1.setText("Request");

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
                .addGap(14, 14, 14)
                .addGroup(jPOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBHistory1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPOptionsLayout.setVerticalGroup(
            jPOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPOptionsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jBRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(jBHistory1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPHeader.setBackground(new java.awt.Color(239, 241, 242));
        jPHeader.setMaximumSize(new java.awt.Dimension(0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/header-bosch.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jLabel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel1.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout jPHeaderLayout = new javax.swing.GroupLayout(jPHeader);
        jPHeader.setLayout(jPHeaderLayout);
        jPHeaderLayout.setHorizontalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPHeaderLayout.setVerticalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPContainerLayout = new javax.swing.GroupLayout(jPContainer);
        jPContainer.setLayout(jPContainerLayout);
        jPContainerLayout.setHorizontalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPContainerLayout.createSequentialGroup()
                .addGap(860, 860, 860)
                .addComponent(jPOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPContainerLayout.setVerticalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContainerLayout.createSequentialGroup()
                .addComponent(jPHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGap(0, 733, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Main_Fcm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Fcm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Fcm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Fcm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Main_Fcm dialog = new Main_Fcm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBHistory;
    private javax.swing.JButton jBHistory1;
    private javax.swing.JButton jBRequest;
    private javax.swing.JButton jBRequest1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPContainer;
    private javax.swing.JPanel jPHeader;
    private javax.swing.JPanel jPOptions;
    // End of variables declaration//GEN-END:variables
}
