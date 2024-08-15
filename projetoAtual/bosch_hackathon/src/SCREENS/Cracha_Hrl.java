/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package SCREENS;

import DAO.ColaboradorDAO;
import DAO.ColaboradorDAOImpl;
import DAO.CrachaDAO;
import DAO.CrachaDAOImpl;
import MAIN.Main_Hrl;
import OBJECTS.Cracha;
import java.awt.Point;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author olf5jvl
 */
public class Cracha_Hrl extends javax.swing.JDialog {

    private CrachaDAO crachaDAO = new CrachaDAOImpl();
    private ColaboradorDAO colaboradorDAO = new ColaboradorDAOImpl();

    private DefaultTableModel tabela;
    private DefaultTableModel tableCol;

    /**
     * Creates new form
     */
    public Cracha_Hrl(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initTableListener();
        tabela = (DefaultTableModel) jTBadgeTable.getModel();
        tabela.setNumRows(0);
        crachaDAO.loadCrachas(tabela);
        filterBadgeTable(0);
        jPCreateBadgePainel.setVisible(false);
        initPanelOptions();
        initTableCol();
        jPCol.setVisible(false);
    }

    private void addBadgeInTable() {
        // Atribui informações de teste na tabela
        if (!isIdDuplicate(jTCreateBadge.getText())) {

            Cracha cracha = new Cracha(0, jTCreateBadge.getText(), "UNUSED", "EMPTY", null, null, null);

            crachaDAO.addCracha(cracha);

            System.out.println("FIM");

            //tabela.addRow(new Object[]{jTCreateBadge.getText(),"UNUSED","-"});
        } else {
            System.out.println("Dados duplicados");
        }
    }

    private void initPanelOptions() {
       jPOptionBox.add(jPCreateBadgePainel, Integer.valueOf(3));
       jPOptionBox.add(jPChangeBadgePainel, Integer.valueOf(2));
       jPOptionBox.add(jPAssociateBadgePainel, Integer.valueOf(1));
        jPCreateBadgePainel.setLocation(0, 6);
        jPChangeBadgePainel.setLocation(0, 6);
        jPAssociateBadgePainel.setLocation(0, 6);
        
        jPCreateBadgePainel.setVisible(true);
       jPChangeBadgePainel.setVisible(false);
       jPAssociateBadgePainel.setVisible(false);
    }

    private void filterBadgeTable(int n) {

        TableRowSorter sorter = new TableRowSorter(tabela);
        jTBadgeTable.setRowSorter(sorter);

        String filter = "";

        switch (n) {
            case 2 ->
                filter = "IN USE";
            case 3 ->
                filter = "UNUSED";
        }
        RowFilter<Object, Object> rowFilter = RowFilter.regexFilter(filter, 1);
        sorter.setRowFilter(rowFilter);
    }

    private void initTableListener() {
        jTBadgeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTBadgeTable.getSelectedRow();
                if (selectedRow != -1) {
                    jTChangeBadgeCode.setText(jTBadgeTable.getValueAt(selectedRow, 0).toString());
                    jTChangeBadgeOwner.setText(jTBadgeTable.getValueAt(selectedRow, 2).toString());

                    jTAssociateBadgeCode.setText(jTBadgeTable.getValueAt(selectedRow, 0).toString());

                    //ele puxará da tabela ou de colaborador, ou de terceirizado
                    //jTAssociateBadgeOwner.setText(jTBadgeTable.getValueAt(selectedRow, 2).toString());
                }
            }
        });
    }
    
    private void initTableCol() {
        jTCollaborator.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTCollaborator.getSelectedRow();
                if (selectedRow != -1) {
                    jTAssociateBadgeOwner.setText(jTCollaborator.getValueAt(selectedRow, 0).toString());
                }
            }
        });
    }

    private void init_change_table() {
        jTBadgeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTBadgeTable.getSelectedRow();
                if (selectedRow != -1) {
                    jTChangeBadgeCode.setText(jTBadgeTable.getValueAt(selectedRow, 0).toString());
                    jTChangeBadgeOwner.setText(jTBadgeTable.getValueAt(selectedRow, 2).toString());
                }
            }
        });

    }
    
    private void associate(){
        
        if(jTAssociateBadgeCode.getText().equals("")||jTAssociateBadgeOwner.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Fill in all the fields!");
        }else{
            crachaDAO.verifyCrachaUsed(jTAssociateBadgeOwner.getText(), jTAssociateBadgeCode.getText());
        }
        
        
    }

    private void turnButtons(int s) {
        switch (s) {
            case 1 -> {
                jPCreateBadgePainel.setVisible(true);
                jPChangeBadgePainel.setVisible(false);
                jPAssociateBadgePainel.setVisible(false);
            }
            case 2 -> {
                jPCreateBadgePainel.setVisible(false);
                jPChangeBadgePainel.setVisible(true);
                jPAssociateBadgePainel.setVisible(false);
            }
            case 3 -> {
                jPCreateBadgePainel.setVisible(false);
                jPChangeBadgePainel.setVisible(false);
                jPAssociateBadgePainel.setVisible(true);
                
            }
            default -> {
                // Caso nenhum dos painéis deva ser visível
                jPCreateBadgePainel.setVisible(false);
                jPChangeBadgePainel.setVisible(false);
                jPAssociateBadgePainel.setVisible(false);
            }
        }
        if(s==3){
            jPCol.setVisible(true);
        }else{
            jPCol.setVisible(false);
        }
    }
    
    private void initColaborator(){
        tableCol = (DefaultTableModel) jTCollaborator.getModel();
        tableCol.setNumRows(0);
        colaboradorDAO.loadColaborador(tableCol);
    }

    private boolean isIdDuplicate(String id) {
        // Recupera os IDs existentes
        int rowCount = tabela.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String existingId = (String) tabela.getValueAt(i, 0);
            if (id.equals(existingId)) {
                return true;
            }
        }
        return false;
    }
    
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPContainer = new javax.swing.JPanel();
        jPOptionsContainer = new javax.swing.JPanel();
        jBAssociateBadge = new javax.swing.JButton();
        jBCreateBadge = new javax.swing.JButton();
        jBChangeBadge = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPOptionBox = new javax.swing.JPanel();
        jPChangeBadgePainel = new javax.swing.JPanel();
        jLChangeLabel = new javax.swing.JLabel();
        jTChangeBadgeOwner = new javax.swing.JTextField();
        jTChangeBadgeCode = new javax.swing.JTextField();
        jBChangeBadgeConfirm = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPAssociateBadgePainel = new javax.swing.JPanel();
        jLAssociateLabel = new javax.swing.JLabel();
        jTAssociateBadgeOwner = new javax.swing.JTextField();
        jBAssociateBadgeConfirm = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTAssociateBadgeCode = new javax.swing.JTextField();
        jBBack = new javax.swing.JButton();
        jPCreateBadgePainel = new javax.swing.JPanel();
        jLCreateLabel = new javax.swing.JLabel();
        jTCreateBadge = new javax.swing.JTextField();
        jBCreateBadgeConfirm = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPCol = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCollaborator = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBadgeTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1120, 730));
        setResizable(false);

        jPContainer.setBackground(new java.awt.Color(255, 255, 255));
        jPContainer.setMaximumSize(new java.awt.Dimension(0, 0));
        jPContainer.setMinimumSize(new java.awt.Dimension(0, 0));
        jPContainer.setPreferredSize(new java.awt.Dimension(0, 0));

        jPOptionsContainer.setBackground(new java.awt.Color(245, 245, 245));

        jBAssociateBadge.setBackground(new java.awt.Color(0, 110, 173));
        jBAssociateBadge.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBAssociateBadge.setForeground(new java.awt.Color(255, 255, 255));
        jBAssociateBadge.setText("Associate");
        jBAssociateBadge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAssociateBadgeActionPerformed(evt);
            }
        });

        jBCreateBadge.setBackground(new java.awt.Color(0, 110, 173));
        jBCreateBadge.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBCreateBadge.setForeground(new java.awt.Color(255, 255, 255));
        jBCreateBadge.setText("Create");
        jBCreateBadge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCreateBadgeActionPerformed(evt);
            }
        });

        jBChangeBadge.setBackground(new java.awt.Color(0, 110, 173));
        jBChangeBadge.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBChangeBadge.setForeground(new java.awt.Color(255, 255, 255));
        jBChangeBadge.setText("Change");
        jBChangeBadge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBChangeBadgeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPOptionsContainerLayout = new javax.swing.GroupLayout(jPOptionsContainer);
        jPOptionsContainer.setLayout(jPOptionsContainerLayout);
        jPOptionsContainerLayout.setHorizontalGroup(
            jPOptionsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPOptionsContainerLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jBCreateBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBChangeBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jBAssociateBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPOptionsContainerLayout.setVerticalGroup(
            jPOptionsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPOptionsContainerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPOptionsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCreateBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBChangeBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAssociateBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jLabel2.setText("Select an Option for Badge");

        jPOptionBox.setMaximumSize(new java.awt.Dimension(490, 140));
        jPOptionBox.setMinimumSize(new java.awt.Dimension(490, 140));

        javax.swing.GroupLayout jPOptionBoxLayout = new javax.swing.GroupLayout(jPOptionBox);
        jPOptionBox.setLayout(jPOptionBoxLayout);
        jPOptionBoxLayout.setHorizontalGroup(
            jPOptionBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPOptionBoxLayout.setVerticalGroup(
            jPOptionBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPChangeBadgePainel.setBackground(new java.awt.Color(245, 245, 245));
        jPChangeBadgePainel.setMaximumSize(new java.awt.Dimension(478, 120));
        jPChangeBadgePainel.setMinimumSize(new java.awt.Dimension(478, 120));
        jPChangeBadgePainel.setPreferredSize(new java.awt.Dimension(478, 120));

        jLChangeLabel.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jLChangeLabel.setText("Remove Badge From");

        jTChangeBadgeOwner.setFont(new java.awt.Font("Bosch Sans", 0, 14)); // NOI18N
        jTChangeBadgeOwner.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTChangeBadgeOwner.setEnabled(false);

        jTChangeBadgeCode.setFont(new java.awt.Font("Bosch Sans", 0, 14)); // NOI18N
        jTChangeBadgeCode.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTChangeBadgeCode.setEnabled(false);

        jBChangeBadgeConfirm.setBackground(new java.awt.Color(0, 110, 173));
        jBChangeBadgeConfirm.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBChangeBadgeConfirm.setForeground(new java.awt.Color(255, 255, 255));
        jBChangeBadgeConfirm.setText("Confirm");
        jBChangeBadgeConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBChangeBadgeConfirmActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bosch Sans", 0, 10)); // NOI18N
        jLabel6.setText("Code");

        jLabel7.setFont(new java.awt.Font("Bosch Sans", 0, 10)); // NOI18N
        jLabel7.setText("Owner");

        javax.swing.GroupLayout jPChangeBadgePainelLayout = new javax.swing.GroupLayout(jPChangeBadgePainel);
        jPChangeBadgePainel.setLayout(jPChangeBadgePainelLayout);
        jPChangeBadgePainelLayout.setHorizontalGroup(
            jPChangeBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPChangeBadgePainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPChangeBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLChangeLabel)
                    .addGroup(jPChangeBadgePainelLayout.createSequentialGroup()
                        .addGroup(jPChangeBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTChangeBadgeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPChangeBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPChangeBadgePainelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPChangeBadgePainelLayout.createSequentialGroup()
                                .addComponent(jTChangeBadgeOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBChangeBadgeConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPChangeBadgePainelLayout.setVerticalGroup(
            jPChangeBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPChangeBadgePainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLChangeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPChangeBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPChangeBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTChangeBadgeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTChangeBadgeOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBChangeBadgeConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPAssociateBadgePainel.setBackground(new java.awt.Color(245, 245, 245));
        jPAssociateBadgePainel.setMaximumSize(new java.awt.Dimension(478, 120));
        jPAssociateBadgePainel.setMinimumSize(new java.awt.Dimension(478, 120));
        jPAssociateBadgePainel.setPreferredSize(new java.awt.Dimension(478, 120));

        jLAssociateLabel.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jLAssociateLabel.setText("Associate badge To");

        jTAssociateBadgeOwner.setFont(new java.awt.Font("Bosch Sans", 0, 14)); // NOI18N
        jTAssociateBadgeOwner.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTAssociateBadgeOwner.setEnabled(false);

        jBAssociateBadgeConfirm.setBackground(new java.awt.Color(0, 110, 173));
        jBAssociateBadgeConfirm.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBAssociateBadgeConfirm.setForeground(new java.awt.Color(255, 255, 255));
        jBAssociateBadgeConfirm.setText("Confirm");
        jBAssociateBadgeConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAssociateBadgeConfirmActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Bosch Sans", 0, 10)); // NOI18N
        jLabel9.setText("Owner");

        jLabel8.setFont(new java.awt.Font("Bosch Sans", 0, 10)); // NOI18N
        jLabel8.setText("Code");

        jTAssociateBadgeCode.setFont(new java.awt.Font("Bosch Sans", 0, 14)); // NOI18N
        jTAssociateBadgeCode.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTAssociateBadgeCode.setEnabled(false);

        javax.swing.GroupLayout jPAssociateBadgePainelLayout = new javax.swing.GroupLayout(jPAssociateBadgePainel);
        jPAssociateBadgePainel.setLayout(jPAssociateBadgePainelLayout);
        jPAssociateBadgePainelLayout.setHorizontalGroup(
            jPAssociateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAssociateBadgePainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAssociateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPAssociateBadgePainelLayout.createSequentialGroup()
                        .addComponent(jLAssociateLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPAssociateBadgePainelLayout.createSequentialGroup()
                        .addGroup(jPAssociateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTAssociateBadgeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPAssociateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPAssociateBadgePainelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPAssociateBadgePainelLayout.createSequentialGroup()
                                .addComponent(jTAssociateBadgeOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAssociateBadgeConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPAssociateBadgePainelLayout.setVerticalGroup(
            jPAssociateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAssociateBadgePainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLAssociateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPAssociateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPAssociateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTAssociateBadgeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTAssociateBadgeOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAssociateBadgeConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jBBack.setBackground(new java.awt.Color(0, 110, 173));
        jBBack.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBBack.setForeground(new java.awt.Color(255, 255, 255));
        jBBack.setText("Back");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jPCreateBadgePainel.setBackground(new java.awt.Color(243, 243, 243));
        jPCreateBadgePainel.setMaximumSize(new java.awt.Dimension(478, 120));
        jPCreateBadgePainel.setMinimumSize(new java.awt.Dimension(478, 120));
        jPCreateBadgePainel.setPreferredSize(new java.awt.Dimension(478, 120));

        jLCreateLabel.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jLCreateLabel.setText("Insert the Badge code");

        jTCreateBadge.setFont(new java.awt.Font("Bosch Sans", 0, 14)); // NOI18N
        jTCreateBadge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCreateBadgeKeyTyped(evt);
            }
        });

        jBCreateBadgeConfirm.setBackground(new java.awt.Color(0, 110, 173));
        jBCreateBadgeConfirm.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBCreateBadgeConfirm.setForeground(new java.awt.Color(255, 255, 255));
        jBCreateBadgeConfirm.setText("Confirm");
        jBCreateBadgeConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCreateBadgeConfirmActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bosch Sans", 0, 10)); // NOI18N
        jLabel5.setText("Code");

        javax.swing.GroupLayout jPCreateBadgePainelLayout = new javax.swing.GroupLayout(jPCreateBadgePainel);
        jPCreateBadgePainel.setLayout(jPCreateBadgePainelLayout);
        jPCreateBadgePainelLayout.setHorizontalGroup(
            jPCreateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCreateBadgePainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCreateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCreateLabel)
                    .addGroup(jPCreateBadgePainelLayout.createSequentialGroup()
                        .addComponent(jTCreateBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBCreateBadgeConfirm))
                    .addComponent(jLabel5))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPCreateBadgePainelLayout.setVerticalGroup(
            jPCreateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCreateBadgePainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLCreateLabel)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCreateBadgePainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCreateBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCreateBadgeConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPCol.setBackground(new java.awt.Color(245, 245, 245));
        jPCol.setMaximumSize(new java.awt.Dimension(0, 0));
        jPCol.setMinimumSize(new java.awt.Dimension(0, 0));
        jPCol.setPreferredSize(new java.awt.Dimension(0, 0));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 202));

        jTCollaborator.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EDV", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTCollaborator.setMaximumSize(new java.awt.Dimension(300, 40));
        jTCollaborator.setMinimumSize(new java.awt.Dimension(300, 40));
        jTCollaborator.setPreferredSize(new java.awt.Dimension(300, 40));
        jTCollaborator.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTCollaborator);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Collaborator");

        javax.swing.GroupLayout jPColLayout = new javax.swing.GroupLayout(jPCol);
        jPCol.setLayout(jPColLayout);
        jPColLayout.setHorizontalGroup(
            jPColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPColLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPColLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPColLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPColLayout.setVerticalGroup(
            jPColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPColLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jTBadgeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Status", "Owner"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTBadgeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTBadgeTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Badge");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addComponent(jPCol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCol, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPContainerLayout = new javax.swing.GroupLayout(jPContainer);
        jPContainer.setLayout(jPContainerLayout);
        jPContainerLayout.setHorizontalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContainerLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPAssociateBadgePainel, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPContainerLayout.createSequentialGroup()
                        .addGroup(jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPChangeBadgePainel, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPContainerLayout.createSequentialGroup()
                                .addGroup(jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPContainerLayout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(jLabel2))
                                    .addComponent(jPCreateBadgePainel, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPOptionBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPOptionsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jBBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPContainerLayout.setVerticalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPContainerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPContainerLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPContainerLayout.createSequentialGroup()
                                .addComponent(jPOptionsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPOptionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(265, 265, 265)
                        .addComponent(jPCreateBadgePainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPChangeBadgePainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPAssociateBadgePainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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
            .addGroup(jPHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPHeaderLayout.setVerticalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
            .addComponent(jPHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTCreateBadgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCreateBadgeKeyTyped
        String badgeCode = jTCreateBadge.getText();
        if (badgeCode.length() > 4) {
            badgeCode = badgeCode.substring(0, 4);
            
        }
        jTCreateBadge.setText(badgeCode);
    }//GEN-LAST:event_jTCreateBadgeKeyTyped

    private void jBChangeBadgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBChangeBadgeActionPerformed
        init_change_table();
        turnButtons(2);
        jTChangeBadgeCode.setText("");
        jTChangeBadgeOwner.setText("");

    
        filterBadgeTable(2);
    }//GEN-LAST:event_jBChangeBadgeActionPerformed

    private void jBCreateBadgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCreateBadgeActionPerformed
       turnButtons(1);
        filterBadgeTable(1);
        initPanelOptions();
    }//GEN-LAST:event_jBCreateBadgeActionPerformed

    private void jBAssociateBadgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAssociateBadgeActionPerformed
        jTAssociateBadgeCode.setText("");
        jTAssociateBadgeOwner.setText("");
        turnButtons(3);
        filterBadgeTable(3);
        initColaborator();
    }//GEN-LAST:event_jBAssociateBadgeActionPerformed

    private void jBChangeBadgeConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBChangeBadgeConfirmActionPerformed
        
        crachaDAO.disableBadge(jTChangeBadgeCode.getText());
        tabela.setNumRows(0);
        crachaDAO.loadCrachas(tabela);
    }//GEN-LAST:event_jBChangeBadgeConfirmActionPerformed

    private void jBCreateBadgeConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCreateBadgeConfirmActionPerformed
        if ((jTCreateBadge.getText()).length() == 5) {
            addBadgeInTable();
        }
        tabela.setNumRows(0);
        crachaDAO.loadCrachas(tabela);
    }//GEN-LAST:event_jBCreateBadgeConfirmActionPerformed

    private void jBAssociateBadgeConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAssociateBadgeConfirmActionPerformed
        associate();
        jTAssociateBadgeOwner.setText("");
        jTAssociateBadgeCode.setText("");
        tabela.setNumRows(0);
        crachaDAO.loadCrachas(tabela);
        
    }//GEN-LAST:event_jBAssociateBadgeConfirmActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        Main_Hrl main_hrl = new Main_Hrl(null, true);
        this.dispose();
        main_hrl.setVisible(true);
    }//GEN-LAST:event_jBBackActionPerformed

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
            java.util.logging.Logger.getLogger(Cracha_Hrl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cracha_Hrl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cracha_Hrl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cracha_Hrl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cracha_Hrl dialog = new Cracha_Hrl(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBAssociateBadge;
    private javax.swing.JButton jBAssociateBadgeConfirm;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBChangeBadge;
    private javax.swing.JButton jBChangeBadgeConfirm;
    private javax.swing.JButton jBCreateBadge;
    private javax.swing.JButton jBCreateBadgeConfirm;
    private javax.swing.JLabel jLAssociateLabel;
    private javax.swing.JLabel jLChangeLabel;
    private javax.swing.JLabel jLCreateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPAssociateBadgePainel;
    private javax.swing.JPanel jPChangeBadgePainel;
    private javax.swing.JPanel jPCol;
    private javax.swing.JPanel jPContainer;
    private javax.swing.JPanel jPCreateBadgePainel;
    private javax.swing.JPanel jPHeader;
    private javax.swing.JPanel jPOptionBox;
    private javax.swing.JPanel jPOptionsContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTAssociateBadgeCode;
    private javax.swing.JTextField jTAssociateBadgeOwner;
    private javax.swing.JTable jTBadgeTable;
    private javax.swing.JTextField jTChangeBadgeCode;
    private javax.swing.JTextField jTChangeBadgeOwner;
    private javax.swing.JTable jTCollaborator;
    private javax.swing.JTextField jTCreateBadge;
    // End of variables declaration//GEN-END:variables
}
