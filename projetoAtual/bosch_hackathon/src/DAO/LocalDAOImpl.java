/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONEXAO_BANCO.Banco_dados;
import OBJECTS.Local;
import java.sql.*;

/**
 *
 * @author olf5jvl
 */
public class LocalDAOImpl implements LocalDAO {

    Banco_dados bd = new Banco_dados();

    public Local getLocal(int id) {
        String query = "SELECT * from local where idLocal = ?";
        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {

                    Local local = new Local(rs.getInt("idLocal"), rs.getString("nomeLocal"));

                    return local;

                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }
}
