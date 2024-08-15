/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONEXAO_BANCO.Banco_dados;
import OBJECTS.Colaborador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import RESOURCES.Resources;

/**
 *
 * @author olf5jvl
 */
public class ColaboradorDAOImpl implements ColaboradorDAO {

    Banco_dados bd = new Banco_dados();

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Colaborador getColaboradorById(int id) {
        String query = "SELECT * FROM colaborador where idColaborador=?";
        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Colaborador colaborador = new Colaborador(rs.getInt("idColaborador"), rs.getString("edvColaborador"), rs.getString("nomeCompletoColaborador"));
                    return colaborador;

                }
                rs.close();
                stmt.close();
                bd.conexao.close();

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    /**
     *
     * @param edv
     * @return
     */
    @Override
    public Colaborador getColaboradorByEdv(String edv) {
        String query = "SELECT * FROM colaborador where edvColaborador=?";
        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1, edv);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Colaborador colaborador = new Colaborador(rs.getInt("idColaborador"), rs.getString("edvColaborador"), rs.getString("nomeCompletoColaborador"));
                    return colaborador;
                }
                rs.close();
                stmt.close();
                bd.conexao.close();

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Colaborador getColaboradorByName(String name) {
        String query = "SELECT * FROM colaborador WHERE nomeCompletoColaborador=?";
        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1, name);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Colaborador colaborador = new Colaborador(rs.getInt("idColaborador"), rs.getString("edvColaborador"), rs.getString("nomeCompletoColaborador"));
                    return colaborador;

                }
                rs.close();
                stmt.close();
                bd.conexao.close();

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    /**
     *
     * @param table
     */
    @Override
    public void loadColaborador(DefaultTableModel table) {
        String query = "SELECT c.edvColaborador,c.nomeCompletoColaborador from colaborador as c";
        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    System.out.println("encontrou");

                    table.addRow(new Object[]{
                        rs.getString("c.edvColaborador"),
                        rs.getString("c.nomeCompletoColaborador"),});
                    System.out.println("terminou");
                }
                rs.close();
                stmt.close();
                bd.conexao.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    /**
     *
     * @param edvOrName
     * @param table
     */
    public void checkColaboradorTable(String edvOrName, DefaultTableModel table) {

        String query = "SELECT c.edvColaborador,c.nomeCompletoColaborador,cr.codeCracha from colaborador as c left join cracha as cr on c.idColaborador = cr.fk_idColaborador where ";

        if (Resources.isNumeric(edvOrName)) {
            query += "c.edvColaborador = ?";
        } else {
            query += "c.nomeCompletoColaborador = ?";
        }

        if (bd.getConnection()) {
            try {
                System.out.println(query);
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1, edvOrName);
                ResultSet rs = stmt.executeQuery();

                String badge = "NONE";

                while (rs.next()) {
                    System.out.println("encontrou");

                    if (rs.getString("codeCracha") != null) {
                        badge = rs.getString("cr.codeCracha");
                    }
                    table.setRowCount(0);
                    table.addRow(new Object[]{
                        rs.getString("c.nomeCompletoColaborador"),
                        rs.getString("c.edvColaborador"),
                        badge,});
                    System.out.println("terminou");
                }

                stmt.close();
                bd.conexao.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
