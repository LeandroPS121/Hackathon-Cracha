/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTH.DAO;

import CONEXAO_BANCO.Banco_dados;
import OBJECTS.Colaborador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author olf5jvl
 */
public class ColaboradorDAOImpl implements ColaboradorDAO{

    Banco_dados bd = new Banco_dados();

    public Colaborador getColaborador(int id) {
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

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }
}
