/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.List;
import CONEXAO_BANCO.Banco_dados;
import OBJECTS.Colaborador;
import OBJECTS.User;
import java.util.ArrayList;

public class UserDAOImpl {

    ColaboradorDAO colDAO = new ColaboradorDAOImpl();

    Banco_dados bd = new Banco_dados();

    public User getUserById(int id) {
        User user = null;
        String query = "SELECT * FROM users WHERE id = ?";

        if (bd.getConnection()) {
            try (
                    PreparedStatement stmt = bd.conexao.prepareStatement(query)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {

                    Colaborador colaborador = colDAO.getColaboradorById(rs.getInt("u.fk_idColaborador"));

                    user = new User(
                            rs.getInt("id"),
                            rs.getString("password"),
                            rs.getInt("isFcmUser"),
                            colaborador
                    );
                }
                rs.close();
                stmt.close();
                bd.conexao.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Tratar exceções adequadamente
            }
        }

        return user;
    }

    public void updateUser(User user) {
        String query = "UPDATE users SET password = ?, isFcmUser = ?, idColaborador = ? WHERE id = ?";

        if (bd.getConnection()) {
            try (
                    PreparedStatement stmt = bd.conexao.prepareStatement(query)) {
                stmt.setString(1, user.getPassword());
                stmt.setInt(2, user.getIsFcmUser());
                stmt.setInt(3, user.getColaborador().getId());
                stmt.setInt(4, user.getId());
                stmt.executeUpdate();
                stmt.close();
                bd.conexao.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Tratar exceções adequadamente
            }
        }
    }
}
