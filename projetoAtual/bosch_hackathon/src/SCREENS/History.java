/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package SCREENS;

import MODULO_INICIAL.Main;
import RESOURCES.Resources;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sil9jvl
 */
public class History extends javax.swing.JDialog {

    /**
     * Creates new form History
     */
    public History(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tableFiltered(0);
    }

    // Função para testar os botões de filtro da tabela(completed,pending,canceled)
    private void tableFiltered(int n){
        // Limpa o campo com o dia selecionado caso outro botao alem do SEARCH DATE for selecionado
        if(n != 4){
            jTSelectedDate.setText("");
        }
        
        // Cria o modelo da tabela
        DefaultTableModel tabela = (DefaultTableModel) jTTable.getModel();
        tabela.setNumRows(0);
        
        // Atribui informações de teste na tabela
        tabela.addRow(new Object[]{"1","12/12/2024 14:00:00", "teste", "Robert Bosch", "COMPLETED"});
        tabela.addRow(new Object[]{"1","08/12/2024 10:00:00", "teste", "Robert Bosch", "PENDING"});
        tabela.addRow(new Object[]{"1","12/12/2024 14:00:00", "teste", "Robert Bosch", "CANCELED"});
        
        TableRowSorter sorter = new TableRowSorter(tabela);
        jTTable.setRowSorter(sorter);
        
        // Inicialização de variáveis
        String filter = "";
        int row = 4;
        
        // Filtragem
        switch (n) {
            case 1 -> filter = "COMPLETED";
            case 2 -> filter = "PENDING";
            case 3 -> filter = "CANCELED";
            case 4 ->{ filter = (jTSelectedDate.getText()).substring(0,10); row = 1;}
        }
        
        // Teste no console
        System.out.println("Filter: "+filter+" | row: "+row);
        
        // Atribui as informaçõesde filtragem com base na resposta do SWITCH(n)
        RowFilter<Object, Object> rowFilter = RowFilter.regexFilter(filter, row);
        
        // Remove a filtragem para visualizar todos os dados
        if(n==0){
            rowFilter=null;
        }
        
        // Por fim, filtra os dados
        sorter.setRowFilter(rowFilter);
    }
    
    //colocar em Resources
    public void showInputCalendar() {
        JPanel calendarPanel = new JPanel();
        calendarPanel.setLayout(new FlowLayout());

        JTextField dateField = new JTextField(10);
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        Dimension size = new Dimension(200, 30);
        dateChooser.setPreferredSize(size);
        dateChooser.setMinimumSize(size);
        dateChooser.setMaximumSize(size);
        JPanel datePanel = new JPanel();
        datePanel.add(dateChooser);
        int option = JOptionPane.showConfirmDialog(null, datePanel, "Select Date", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            Date selectedDate = dateChooser.getDate();
            if (selectedDate != null) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = sdf.format(selectedDate);
                dateField.setText(formattedDate);
                System.out.println("Data informada:" + formattedDate);
                jTSelectedDate.setText(formattedDate);
                tableFiltered(4);
            } else {
                System.out.println("calendario vazio");
                showInputCalendar();
            }
        }
        calendarPanel.add(dateField);
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
        jPTableContainer = new javax.swing.JPanel();
        jSTable = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();
        jBBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBAll = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jBSearchDate = new javax.swing.JButton();
        jTSelectedDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jBComplete = new javax.swing.JButton();
        jBPending = new javax.swing.JButton();
        jBCanceled = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPHeader = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1160, 730));
        setMinimumSize(new java.awt.Dimension(1160, 730));
        setPreferredSize(new java.awt.Dimension(1160, 730));
        setResizable(false);

        jPContainer.setBackground(new java.awt.Color(224, 226, 229));
        jPContainer.setMaximumSize(new java.awt.Dimension(1160, 750));
        jPContainer.setMinimumSize(new java.awt.Dimension(1160, 750));

        jTTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Type", "Description", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTTable.getTableHeader().setReorderingAllowed(false);
        jSTable.setViewportView(jTTable);

        jBBack.setBackground(new java.awt.Color(0, 110, 173));
        jBBack.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBBack.setForeground(new java.awt.Color(255, 255, 255));
        jBBack.setText("Back");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(224, 226, 229));

        jLabel1.setFont(new java.awt.Font("Bosch Sans", 1, 18)); // NOI18N
        jLabel1.setText("Filter");

        jBAll.setBackground(new java.awt.Color(0, 110, 173));
        jBAll.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBAll.setForeground(new java.awt.Color(255, 255, 255));
        jBAll.setText("All");
        jBAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAllActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(208, 212, 216));

        jBSearchDate.setBackground(new java.awt.Color(0, 110, 173));
        jBSearchDate.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBSearchDate.setForeground(new java.awt.Color(255, 255, 255));
        jBSearchDate.setText("Search Date");
        jBSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSearchDateActionPerformed(evt);
            }
        });

        jTSelectedDate.setEditable(false);
        jTSelectedDate.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jTSelectedDate.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSearchDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTSelectedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTSelectedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jLabel2.setFont(new java.awt.Font("Bosch Sans", 1, 18)); // NOI18N
        jLabel2.setText("Filter by STATUS");

        jPanel3.setBackground(new java.awt.Color(208, 212, 216));

        jBComplete.setBackground(new java.awt.Color(0, 110, 173));
        jBComplete.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBComplete.setForeground(new java.awt.Color(255, 255, 255));
        jBComplete.setText("Completed");
        jBComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCompleteActionPerformed(evt);
            }
        });

        jBPending.setBackground(new java.awt.Color(0, 110, 173));
        jBPending.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBPending.setForeground(new java.awt.Color(255, 255, 255));
        jBPending.setText("Pending");
        jBPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPendingActionPerformed(evt);
            }
        });

        jBCanceled.setBackground(new java.awt.Color(0, 110, 173));
        jBCanceled.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBCanceled.setForeground(new java.awt.Color(255, 255, 255));
        jBCanceled.setText("Canceled");
        jBCanceled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCanceledActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPending)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCanceled, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCanceled, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPending, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Bosch Sans", 1, 18)); // NOI18N
        jLabel3.setText("Filter by DATE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBAll, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jBAll, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPTableContainerLayout = new javax.swing.GroupLayout(jPTableContainer);
        jPTableContainer.setLayout(jPTableContainerLayout);
        jPTableContainerLayout.setHorizontalGroup(
            jPTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSTable)
                    .addGroup(jPTableContainerLayout.createSequentialGroup()
                        .addComponent(jBBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPTableContainerLayout.setVerticalGroup(
            jPTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSTable, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPTableContainerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPTableContainerLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPHeader.setBackground(new java.awt.Color(239, 241, 242));
        jPHeader.setMaximumSize(new java.awt.Dimension(1160, 100));
        jPHeader.setMinimumSize(new java.awt.Dimension(1160, 100));
        jPHeader.setPreferredSize(new java.awt.Dimension(1160, 100));

        javax.swing.GroupLayout jPHeaderLayout = new javax.swing.GroupLayout(jPHeader);
        jPHeader.setLayout(jPHeaderLayout);
        jPHeaderLayout.setHorizontalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPHeaderLayout.setVerticalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPContainerLayout = new javax.swing.GroupLayout(jPContainer);
        jPContainer.setLayout(jPContainerLayout);
        jPContainerLayout.setHorizontalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContainerLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(jPHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPContainerLayout.setVerticalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContainerLayout.createSequentialGroup()
                .addComponent(jPHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        Main main = new Main(null,true);
        this.dispose();
        main.setVisible(true);
    }//GEN-LAST:event_jBBackActionPerformed

    private void jBCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCompleteActionPerformed
        tableFiltered(1);
    }//GEN-LAST:event_jBCompleteActionPerformed

    private void jBPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPendingActionPerformed
        tableFiltered(2);
    }//GEN-LAST:event_jBPendingActionPerformed

    private void jBCanceledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCanceledActionPerformed
        tableFiltered(3);
    }//GEN-LAST:event_jBCanceledActionPerformed

    private void jBAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAllActionPerformed
        tableFiltered(0);
    }//GEN-LAST:event_jBAllActionPerformed

    private void jBSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSearchDateActionPerformed
        showInputCalendar();
    }//GEN-LAST:event_jBSearchDateActionPerformed

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
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                History dialog = new History(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBAll;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBCanceled;
    private javax.swing.JButton jBComplete;
    private javax.swing.JButton jBPending;
    private javax.swing.JButton jBSearchDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPContainer;
    private javax.swing.JPanel jPHeader;
    private javax.swing.JPanel jPTableContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jSTable;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTSelectedDate;
    private javax.swing.JTable jTTable;
    // End of variables declaration//GEN-END:variables
}
