/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package main;

import CONEXAO_BANCO.Banco_dados;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 *
 * @author sil9jvl
 */
public class main extends javax.swing.JDialog {

    private final char[] senha = new char[0]; // armazena a senha como um array de caracteres
    private final boolean senhaVisivel = false; // flag para indicar se a senha está visíve

    ImageIcon iconUnhided = new ImageIcon(getClass().getResource("/main/resources/IMAGES/pw2.png"));
    ImageIcon iconHided = new ImageIcon(getClass().getResource("/main/resources/IMAGES/pw1.png"));
    /**
     * Creates new form Login
     */
    public main(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        placeholder_login();
        SwingUtilities.invokeLater(() -> jLGuy.requestFocusInWindow());
        jTEDV.setHorizontalAlignment(SwingConstants.CENTER);
        jTPassword.setHorizontalAlignment(SwingConstants.CENTER);
        jLHideUnhide.setVisible(true);
        jLUserOrPwError.setVisible(false);
       
        change_panel(jPHomeHrl, jPLogin);
        
    }

    Banco_dados bd = new Banco_dados();

    private void login() {
        if (bd.getConnection()) {
            try {
                String query = "SELECT c.edvColaborador,u.isFcmUser FROM user as u INNER JOIN"
                        + " colaborador as c on c.idColaborador=u.fk_idColaborador where c.edvColaborador = ? and u.passwordUser = ?";
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                String pwr = String.valueOf(jTPassword.getPassword());
                stmt.setString(1, jTEDV.getText());
                stmt.setString(2, pwr);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "LOGADO!");
                    if(rs.getInt("u.isFcmUser")==0){
                     change_panel(jPLogin, jPHomeHrl);
                    // Get a reference to the JPanel
                    }else{
                        
                    }    
                } else {
                    change_panel(jPLogin, jPHomeHrl);
                    jLUserOrPwError.setVisible(true);
                }
                stmt.close();
                bd.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro" + e.toString());
            }
        }
    }

    private void change_panel(javax.swing.JPanel anterior, javax.swing.JPanel novo) {
        anterior.setVisible(false);
        novo.getParent().setLayout(null);
        novo.setLocation(0, 90);
        novo.setVisible(true);
        validate();
        repaint();
    }

    private void placeholder_login() {
        jTEDV.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTEDV.getText().equals("EDV")) {
                    jTEDV.setText("");
                    jTEDV.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTEDV.getText().isEmpty()) {
                    jTEDV.setText("EDV");
                    jTEDV.setForeground(new Color(204, 204, 204));
                }
            }
        });

        jTPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jLUserOrPwError.setVisible(false);
                String pwrd = String.valueOf(jTPassword.getPassword());
                System.out.println("pwrd" + pwrd);
                if (pwrd.equals("Password")) {
                    jTPassword.setText("");
                    jTPassword.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTPassword.getPassword().length == 0 || jTPassword.getPassword() == null) {
                    jTPassword.setText("Password");
                    jTPassword.setForeground(new Color(204, 204, 204));
                }
            }
        });

    }

    private void atualizarCampoSenha() {
        if (senhaVisivel) {
            jTPassword.setText(new String(senha));
        } else {
            jTPassword.setText(new String(new char[senha.length]).replace("\0", "*"));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPLogin = new javax.swing.JPanel();
        jPBox = new javax.swing.JPanel();
        jTEDV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLHideUnhide = new javax.swing.JLabel();
        jTPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLUserOrPwError = new javax.swing.JLabel();
        jLGuy = new javax.swing.JLabel();
        jPHomeHrl = new javax.swing.JPanel();
        jPmenuLateralHrl = new javax.swing.JPanel();
        jBexpandeHrl = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBCliente1 = new javax.swing.JButton();
        jBHistoryHrl = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPHeader = new javax.swing.JPanel();
        header = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(224, 226, 229));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1160, 720));
        setName("mainDialog"); // NOI18N
        setResizable(false);

        jPLogin.setBackground(new java.awt.Color(224, 226, 229));
        jPLogin.setMaximumSize(new java.awt.Dimension(0, 0));
        jPLogin.setMinimumSize(new java.awt.Dimension(0, 0));
        jPLogin.setPreferredSize(new java.awt.Dimension(0, 0));
        jPLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPLoginMouseClicked(evt);
            }
        });

        jPBox.setBackground(new java.awt.Color(255, 255, 255));
        jPBox.setMaximumSize(new java.awt.Dimension(0, 0));
        jPBox.setPreferredSize(new java.awt.Dimension(0, 0));

        jTEDV.setFont(new java.awt.Font("Bosch Sans", 0, 14)); // NOI18N
        jTEDV.setForeground(new java.awt.Color(204, 204, 204));
        jTEDV.setText("EDV");
        jTEDV.setMaximumSize(new java.awt.Dimension(0, 0));
        jTEDV.setMinimumSize(new java.awt.Dimension(0, 0));
        jTEDV.setPreferredSize(new java.awt.Dimension(0, 0));
        jTEDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEDVActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bosch Sans", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Forgot your password?");

        jButton1.setBackground(new java.awt.Color(0, 62, 100));
        jButton1.setFont(new java.awt.Font("Bosch Sans", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

        jLHideUnhide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/IMAGES/pw1.png"))); // NOI18N
        jLHideUnhide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLHideUnhide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLHideUnhideMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLHideUnhide, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLHideUnhide, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTPassword.setForeground(new java.awt.Color(204, 204, 204));
        jTPassword.setText("Password");
        jTPassword.setMaximumSize(new java.awt.Dimension(0, 0));
        jTPassword.setMinimumSize(new java.awt.Dimension(0, 0));
        jTPassword.setPreferredSize(new java.awt.Dimension(0, 0));
        jTPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPasswordActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));

        jLUserOrPwError.setBackground(new java.awt.Color(255, 51, 51));
        jLUserOrPwError.setForeground(new java.awt.Color(255, 0, 51));
        jLUserOrPwError.setText("Incorrect username or password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLUserOrPwError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLUserOrPwError))
        );

        javax.swing.GroupLayout jPBoxLayout = new javax.swing.GroupLayout(jPBox);
        jPBox.setLayout(jPBoxLayout);
        jPBoxLayout.setHorizontalGroup(
            jPBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBoxLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEDV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(101, 101, 101))
        );
        jPBoxLayout.setVerticalGroup(
            jPBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBoxLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jTEDV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jLGuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/IMAGES/guy.png"))); // NOI18N

        javax.swing.GroupLayout jPLoginLayout = new javax.swing.GroupLayout(jPLogin);
        jPLogin.setLayout(jPLoginLayout);
        jPLoginLayout.setHorizontalGroup(
            jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPLoginLayout.createSequentialGroup()
                .addContainerGap(367, Short.MAX_VALUE)
                .addComponent(jPBox, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLGuy)
                .addGap(79, 79, 79))
        );
        jPLoginLayout.setVerticalGroup(
            jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLoginLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLGuy)
                    .addComponent(jPBox, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jPHomeHrl.setBackground(new java.awt.Color(224, 226, 229));
        jPHomeHrl.setMaximumSize(new java.awt.Dimension(0, 0));
        jPHomeHrl.setMinimumSize(new java.awt.Dimension(0, 0));
        jPHomeHrl.setPreferredSize(new java.awt.Dimension(0, 0));

        jPmenuLateralHrl.setBackground(new java.awt.Color(0, 85, 135));
        jPmenuLateralHrl.setMaximumSize(new java.awt.Dimension(0, 0));
        jPmenuLateralHrl.setMinimumSize(new java.awt.Dimension(0, 0));
        jPmenuLateralHrl.setPreferredSize(new java.awt.Dimension(0, 0));

        jBexpandeHrl.setBackground(new java.awt.Color(0, 62, 100));
        jBexpandeHrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/IMAGES/bosch-ic-arrow-double-bold-left-sharp-arc-32px.png"))); // NOI18N
        jBexpandeHrl.setBorderPainted(false);
        jBexpandeHrl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBexpandeHrl.setOpaque(true);
        jBexpandeHrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBexpandeHrlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPmenuLateralHrlLayout = new javax.swing.GroupLayout(jPmenuLateralHrl);
        jPmenuLateralHrl.setLayout(jPmenuLateralHrlLayout);
        jPmenuLateralHrlLayout.setHorizontalGroup(
            jPmenuLateralHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPmenuLateralHrlLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jBexpandeHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPmenuLateralHrlLayout.setVerticalGroup(
            jPmenuLateralHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPmenuLateralHrlLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jBexpandeHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBCliente1.setBackground(new java.awt.Color(0, 98, 154));
        jBCliente1.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBCliente1.setForeground(new java.awt.Color(255, 255, 255));
        jBCliente1.setText("Requests");

        jBHistoryHrl.setBackground(new java.awt.Color(0, 98, 154));
        jBHistoryHrl.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBHistoryHrl.setForeground(new java.awt.Color(255, 255, 255));
        jBHistoryHrl.setText("History");
        jBHistoryHrl.setPreferredSize(new java.awt.Dimension(200, 200));
        jBHistoryHrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHistoryHrlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBHistoryHrl, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jBCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jBHistoryHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPHomeHrlLayout = new javax.swing.GroupLayout(jPHomeHrl);
        jPHomeHrl.setLayout(jPHomeHrlLayout);
        jPHomeHrlLayout.setHorizontalGroup(
            jPHomeHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHomeHrlLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPHomeHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 559, Short.MAX_VALUE)
                .addComponent(jPmenuLateralHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPHomeHrlLayout.setVerticalGroup(
            jPHomeHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHomeHrlLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPHomeHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPHomeHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPmenuLateralHrl, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPHomeHrlLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPHeader.setBackground(new java.awt.Color(224, 226, 229));
        jPHeader.setMaximumSize(new java.awt.Dimension(0, 0));
        jPHeader.setPreferredSize(new java.awt.Dimension(0, 0));

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/IMAGES/header-bosch.png"))); // NOI18N
        header.setMaximumSize(new java.awt.Dimension(0, 0));
        header.setMinimumSize(new java.awt.Dimension(0, 0));
        header.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout jPHeaderLayout = new javax.swing.GroupLayout(jPHeader);
        jPHeader.setLayout(jPHeaderLayout);
        jPHeaderLayout.setHorizontalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE)
        );
        jPHeaderLayout.setVerticalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHeaderLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 1168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPHomeHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPHomeHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3737, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 1913, Short.MAX_VALUE)
                    .addComponent(jPLogin, 630, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1914, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTEDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEDVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLHideUnhideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLHideUnhideMouseClicked
        if (jTPassword.getEchoChar() == '*') {
            jTPassword.setEchoChar((char) 0); // mostra a senha
            jLHideUnhide.setIcon(iconUnhided);
        } else {
            jTPassword.setEchoChar('*'); // oculta a senha
            jLHideUnhide.setIcon(iconHided);
        }
    }//GEN-LAST:event_jLHideUnhideMouseClicked

    private void jTPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPasswordActionPerformed

    private void jBexpandeHrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexpandeHrlActionPerformed

        int menuLateralPosition = jPmenuLateralHrl.getX();
        if(jPmenuLateralHrl.getX() != 1060){
            jPmenuLateralHrl.setLocation(menuLateralPosition+175,jPmenuLateralHrl.getY());
            jPmenuLateralHrl.setSize(jPmenuLateralHrl.getWidth(),jPmenuLateralHrl.getHeight());
        } else{
            jPmenuLateralHrl.setLocation(menuLateralPosition-175,jPmenuLateralHrl.getY());
            jPmenuLateralHrl.setSize((jPmenuLateralHrl.getWidth())+175,jPmenuLateralHrl.getHeight());
        }
    }//GEN-LAST:event_jBexpandeHrlActionPerformed

    private void jBHistoryHrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHistoryHrlActionPerformed
         change_panel(jPLogin, jPHomeHrl);
    }//GEN-LAST:event_jBHistoryHrlActionPerformed

    private void jPLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPLoginMouseClicked
    
    }//GEN-LAST:event_jPLoginMouseClicked

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                main dialog = new main(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel header;
    private javax.swing.JButton jBCliente1;
    private javax.swing.JButton jBHistoryHrl;
    private javax.swing.JButton jBexpandeHrl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLGuy;
    private javax.swing.JLabel jLHideUnhide;
    private javax.swing.JLabel jLUserOrPwError;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPBox;
    private javax.swing.JPanel jPHeader;
    private javax.swing.JPanel jPHomeHrl;
    private javax.swing.JPanel jPLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPmenuLateralHrl;
    private javax.swing.JTextField jTEDV;
    private javax.swing.JPasswordField jTPassword;
    // End of variables declaration//GEN-END:variables
}
