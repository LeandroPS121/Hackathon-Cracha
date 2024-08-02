/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTH.DAO;
import java.sql.*;
import java.util.List;
import CONEXAO_BANCO.Banco_dados;
import OBJECTS.Colaborador;
import OBJECTS.User;
import java.util.ArrayList;


public class UserDAOImpl {
    
    ColaboradorDAO colDAO = new ColaboradorDAOImpl();
    
    Banco_dados bd = new Banco_dados();
    
    public void addUser(User user) {
        String query = "INSERT INTO users (id, password, isFcmUser, fk_idColaborador) VALUES (?, ?, ?, ?)";
        if(bd.getConnection()){
        try (
            PreparedStatement stmt = bd.conexao.prepareStatement(query)) {
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getIsFcmUser());
            stmt.setInt(4, user.getColaborador().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar exceções adequadamente
        }
        }
     
    }

    public User getUserById(int id) {
        User user = null;
        String query = "SELECT * FROM users WHERE id = ?";
        
        if(bd.getConnection()){
        try (
            PreparedStatement stmt = bd.conexao.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                 
                 Colaborador colaborador = colDAO.getColaborador(rs.getInt("u.fk_idColaborador"));
                
                user = new User(
                    rs.getInt("id"),
                    rs.getString("password"),
                    rs.getInt("isFcmUser"),
                    colaborador
                );
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar exceções adequadamente
        }
        }
        
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        if(bd.getConnection()){
        try (
         
             Statement stmt = bd.conexao.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                
                Colaborador colaborador = colDAO.getColaborador(rs.getInt("u.fk_idColaborador"));
                
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("password"),
                    rs.getInt("isFcmUser"),
                    colaborador
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar exceções adequadamente
        }
        }
        
        return users;
    }
    
    public void updateUser(User user) {
        String query = "UPDATE users SET password = ?, isFcmUser = ?, idColaborador = ? WHERE id = ?";
        
        if(bd.getConnection()){
        try (
            PreparedStatement stmt = bd.conexao.prepareStatement(query)) {
            stmt.setString(1, user.getPassword());
            stmt.setInt(2, user.getIsFcmUser());
            stmt.setInt(3, user.getColaborador().getId());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar exceções adequadamente
        }
        }
    }

    public void deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        
        if(bd.getConnection()){
        try (
            PreparedStatement stmt = bd.conexao.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar exceções adequadamente
        }
        }
    }
}