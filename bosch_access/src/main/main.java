/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package main;

import CONEXAO_BANCO.Banco_dados;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
                    if (rs.getInt("u.isFcmUser") == 0) {
                        change_panel(jPLogin, jPHomeHrl);
                        // Get a reference to the JPanel
                    } else {

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

    // Cria o painel e o botão
    public void show_input_calendar() {
        JPanel calendarPanel = new JPanel();
        calendarPanel.setLayout(new FlowLayout());

// Create a text field to display the selected date
        JTextField dateField = new JTextField(10);
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        Dimension size = new Dimension(200, 30);
        dateChooser.setPreferredSize(size);
        dateChooser.setMinimumSize(size);
        dateChooser.setMaximumSize(size);

        // Create a panel for the date chooser
        JPanel datePanel = new JPanel();
        datePanel.add(dateChooser);

        // Show the date chooser in a dialog
        int option = JOptionPane.showConfirmDialog(null, datePanel, "Select Date", JOptionPane.OK_CANCEL_OPTION);

        // If the user clicked OK, get the selected date and display it in the text field
        if (option == JOptionPane.OK_OPTION) {
            Date selectedDate = dateChooser.getDate();
            System.out.println("clickou");
            if (selectedDate != null) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = sdf.format(selectedDate);
                dateField.setText(formattedDate);
                System.out.println("texto:" + formattedDate);
            } else {
                System.out.println("ta vazio nengue");
                show_input_calendar();
            }
        }
        calendarPanel.add(dateField);

// Add the calendar panel to the jPHistoryHrl panel
        jPHistoryHrl.add(calendarPanel);
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
        jBRequestHrl = new javax.swing.JButton();
        jBHistoryHrl = new javax.swing.JButton();
        jPMenuLateralHrl = new javax.swing.JPanel();
        jBAbrirMenuLateralHrl = new javax.swing.JButton();
        jPHeader = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        jPHistoryHrl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBCancelarHistoryHrl = new javax.swing.JToggleButton();
        jBCancelarHistoryHrl1 = new javax.swing.JToggleButton();
        jBCancelarHistoryHrl2 = new javax.swing.JToggleButton();
        jBCancelarHistoryHrl3 = new javax.swing.JToggleButton();
        jBCalendarHistoryHrl = new javax.swing.JButton();
        jPFormularioHrl = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(224, 226, 229));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1160, 720));
        setMinimumSize(new java.awt.Dimension(1160, 720));
        setName("mainDialog"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1160, 720));
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

        jPHomeHrl.setBackground(new java.awt.Color(255, 255, 255));
        jPHomeHrl.setMaximumSize(new java.awt.Dimension(0, 0));
        jPHomeHrl.setMinimumSize(new java.awt.Dimension(0, 0));
        jPHomeHrl.setPreferredSize(new java.awt.Dimension(0, 0));

        jBRequestHrl.setBackground(new java.awt.Color(0, 110, 173));
        jBRequestHrl.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBRequestHrl.setForeground(new java.awt.Color(255, 255, 255));
        jBRequestHrl.setText("Requests");
        jBRequestHrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRequestHrlActionPerformed(evt);
            }
        });

        jBHistoryHrl.setBackground(new java.awt.Color(0, 110, 173));
        jBHistoryHrl.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jBHistoryHrl.setForeground(new java.awt.Color(255, 255, 255));
        jBHistoryHrl.setText("History");
        jBHistoryHrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHistoryHrlActionPerformed(evt);
            }
        });

        jPMenuLateralHrl.setBackground(new java.awt.Color(0, 85, 135));
        jPMenuLateralHrl.setMaximumSize(new java.awt.Dimension(0, 0));
        jPMenuLateralHrl.setMinimumSize(new java.awt.Dimension(0, 0));
        jPMenuLateralHrl.setPreferredSize(new java.awt.Dimension(0, 0));

        jBAbrirMenuLateralHrl.setBackground(new java.awt.Color(0, 62, 100));
        jBAbrirMenuLateralHrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/IMAGES/bosch-ic-arrow-double-bold-left-sharp-arc-32px.png"))); // NOI18N
        jBAbrirMenuLateralHrl.setBorderPainted(false);
        jBAbrirMenuLateralHrl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBAbrirMenuLateralHrl.setOpaque(true);
        jBAbrirMenuLateralHrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbrirMenuLateralHrlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPMenuLateralHrlLayout = new javax.swing.GroupLayout(jPMenuLateralHrl);
        jPMenuLateralHrl.setLayout(jPMenuLateralHrlLayout);
        jPMenuLateralHrlLayout.setHorizontalGroup(
            jPMenuLateralHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMenuLateralHrlLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jBAbrirMenuLateralHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPMenuLateralHrlLayout.setVerticalGroup(
            jPMenuLateralHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMenuLateralHrlLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBAbrirMenuLateralHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(585, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPHomeHrlLayout = new javax.swing.GroupLayout(jPHomeHrl);
        jPHomeHrl.setLayout(jPHomeHrlLayout);
        jPHomeHrlLayout.setHorizontalGroup(
            jPHomeHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHomeHrlLayout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jBRequestHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jBHistoryHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(394, 394, 394)
                .addComponent(jPMenuLateralHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPHomeHrlLayout.setVerticalGroup(
            jPHomeHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPHomeHrlLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPMenuLateralHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPHomeHrlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPHomeHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBHistoryHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBRequestHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(220, 220, 220))
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

        jPHistoryHrl.setBackground(new java.awt.Color(255, 255, 255));
        jPHistoryHrl.setMaximumSize(new java.awt.Dimension(0, 0));
        jPHistoryHrl.setMinimumSize(new java.awt.Dimension(0, 0));
        jPHistoryHrl.setPreferredSize(new java.awt.Dimension(0, 0));

        jTable1.setFont(new java.awt.Font("Bosch Sans", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jBCancelarHistoryHrl.setBackground(new java.awt.Color(0, 85, 135));
        jBCancelarHistoryHrl.setFont(new java.awt.Font("Bosch Sans Black", 0, 14)); // NOI18N
        jBCancelarHistoryHrl.setForeground(new java.awt.Color(255, 255, 255));
        jBCancelarHistoryHrl.setText("All");

        jBCancelarHistoryHrl1.setBackground(new java.awt.Color(0, 85, 135));
        jBCancelarHistoryHrl1.setFont(new java.awt.Font("Bosch Sans Black", 0, 14)); // NOI18N
        jBCancelarHistoryHrl1.setForeground(new java.awt.Color(255, 255, 255));
        jBCancelarHistoryHrl1.setText("Completed");
        jBCancelarHistoryHrl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarHistoryHrl1ActionPerformed(evt);
            }
        });

        jBCancelarHistoryHrl2.setBackground(new java.awt.Color(0, 85, 135));
        jBCancelarHistoryHrl2.setFont(new java.awt.Font("Bosch Sans Black", 0, 14)); // NOI18N
        jBCancelarHistoryHrl2.setForeground(new java.awt.Color(255, 255, 255));
        jBCancelarHistoryHrl2.setText("Pending");
        jBCancelarHistoryHrl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarHistoryHrl2ActionPerformed(evt);
            }
        });

        jBCancelarHistoryHrl3.setBackground(new java.awt.Color(0, 85, 135));
        jBCancelarHistoryHrl3.setFont(new java.awt.Font("Bosch Sans Black", 0, 14)); // NOI18N
        jBCancelarHistoryHrl3.setForeground(new java.awt.Color(255, 255, 255));
        jBCancelarHistoryHrl3.setText("Canceled");
        jBCancelarHistoryHrl3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarHistoryHrl3ActionPerformed(evt);
            }
        });

        jBCalendarHistoryHrl.setBackground(new java.awt.Color(0, 85, 135));
        jBCalendarHistoryHrl.setFont(new java.awt.Font("Bosch Sans Black", 0, 14)); // NOI18N
        jBCalendarHistoryHrl.setForeground(new java.awt.Color(255, 255, 255));
        jBCalendarHistoryHrl.setText("Search Date");
        jBCalendarHistoryHrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalendarHistoryHrlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPHistoryHrlLayout = new javax.swing.GroupLayout(jPHistoryHrl);
        jPHistoryHrl.setLayout(jPHistoryHrlLayout);
        jPHistoryHrlLayout.setHorizontalGroup(
            jPHistoryHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHistoryHrlLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(jPHistoryHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPHistoryHrlLayout.createSequentialGroup()
                        .addComponent(jBCalendarHistoryHrl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBCancelarHistoryHrl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBCancelarHistoryHrl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBCancelarHistoryHrl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBCancelarHistoryHrl3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );
        jPHistoryHrlLayout.setVerticalGroup(
            jPHistoryHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHistoryHrlLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPHistoryHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelarHistoryHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelarHistoryHrl1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelarHistoryHrl2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelarHistoryHrl3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCalendarHistoryHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPFormularioHrl.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(239, 241, 242));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/IMAGES/bosch-logo.png"))); // NOI18N

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 110, 173));
        jButton2.setFont(new java.awt.Font("Bosch Sans", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Enviadar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(126, 126, 126)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addGap(131, 131, 131)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPFormularioHrlLayout = new javax.swing.GroupLayout(jPFormularioHrl);
        jPFormularioHrl.setLayout(jPFormularioHrlLayout);
        jPFormularioHrlLayout.setHorizontalGroup(
            jPFormularioHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFormularioHrlLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPFormularioHrlLayout.setVerticalGroup(
            jPFormularioHrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFormularioHrlLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 1168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPFormularioHrl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPHistoryHrl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
                        .addComponent(jPHomeHrl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addComponent(jPHistoryHrl, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFormularioHrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 2185, Short.MAX_VALUE)
                    .addComponent(jPLogin, 630, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2185, Short.MAX_VALUE)))
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

    private void jBAbrirMenuLateralHrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbrirMenuLateralHrlActionPerformed
        if(jPMenuLateralHrl.getX() != 1060){
            jPMenuLateralHrl.setSize(jPMenuLateralHrl.getWidth()-175,jPMenuLateralHrl.getHeight());
            jPMenuLateralHrl.setLocation(jPMenuLateralHrl.getX()+175,jPMenuLateralHrl.getY());
        }else{
            jPMenuLateralHrl.setSize(jPMenuLateralHrl.getWidth()+175,jPMenuLateralHrl.getHeight());
            jPMenuLateralHrl.setLocation(jPMenuLateralHrl.getX()-175,jPMenuLateralHrl.getY());
        }
    }//GEN-LAST:event_jBAbrirMenuLateralHrlActionPerformed

    private void jBRequestHrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRequestHrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBRequestHrlActionPerformed

    private void jBHistoryHrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHistoryHrlActionPerformed
        change_panel(jPHomeHrl, jPHistoryHrl);
    }//GEN-LAST:event_jBHistoryHrlActionPerformed

    private void jPLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPLoginMouseClicked

    }//GEN-LAST:event_jPLoginMouseClicked

    private void jBCancelarHistoryHrl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarHistoryHrl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelarHistoryHrl1ActionPerformed

    private void jBCancelarHistoryHrl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarHistoryHrl2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelarHistoryHrl2ActionPerformed

    private void jBCancelarHistoryHrl3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarHistoryHrl3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelarHistoryHrl3ActionPerformed

    private void jBCalendarHistoryHrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalendarHistoryHrlActionPerformed
        show_input_calendar();
    }//GEN-LAST:event_jBCalendarHistoryHrlActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
    private javax.swing.JButton jBAbrirMenuLateralHrl;
    private javax.swing.JButton jBCalendarHistoryHrl;
    private javax.swing.JToggleButton jBCancelarHistoryHrl;
    private javax.swing.JToggleButton jBCancelarHistoryHrl1;
    private javax.swing.JToggleButton jBCancelarHistoryHrl2;
    private javax.swing.JToggleButton jBCancelarHistoryHrl3;
    private javax.swing.JButton jBHistoryHrl;
    private javax.swing.JButton jBRequestHrl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLGuy;
    private javax.swing.JLabel jLHideUnhide;
    private javax.swing.JLabel jLUserOrPwError;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPBox;
    private javax.swing.JPanel jPFormularioHrl;
    private javax.swing.JPanel jPHeader;
    private javax.swing.JPanel jPHistoryHrl;
    private javax.swing.JPanel jPHomeHrl;
    private javax.swing.JPanel jPLogin;
    private javax.swing.JPanel jPMenuLateralHrl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTEDV;
    private javax.swing.JPasswordField jTPassword;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
