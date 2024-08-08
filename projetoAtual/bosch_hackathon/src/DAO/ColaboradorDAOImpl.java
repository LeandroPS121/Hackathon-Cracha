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

/**
 *
 * @author olf5jvl
 */
public class ColaboradorDAOImpl implements ColaboradorDAO{

    Banco_dados bd = new Banco_dados();

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
    public Colaborador getColaboradorByName(String name){
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
                        rs.getString("c.nomeCompletoColaborador"),
                    });
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
}
