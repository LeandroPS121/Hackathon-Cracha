/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTH.DAO;

import CONEXAO_BANCO.Banco_dados;
import OBJECTS.Cracha;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author olf5jvl
 */
public class CrachaDAOImpl implements CrachaDAO {

    Banco_dados bd = new Banco_dados();

    public void addCracha(Cracha cracha) {
        if (bd.getConnection()) {
            String query = "INSERT INTO cracha (idCracha,statusCracha,tipoAtribuicaoCracha,fk_idColaborador,fk_idTerceirizado) VALUES (?,?,?,?,?)";
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1, cracha.getId());
                stmt.setString(2, cracha.getStatus());
                stmt.setString(3, cracha.getTipo());
                System.out.println(cracha.getColaborador());
                stmt.setNull(4, java.sql.Types.INTEGER);
                stmt.setNull(5, java.sql.Types.INTEGER);
                if (cracha.getColaborador() != null) {
                    stmt.setNull(4, cracha.getColaborador().getId());
                }
                if (cracha.getTerceirizado() != null) {
                    stmt.setInt(5, cracha.getTerceirizado().getId());
                }
                stmt.executeUpdate();
                System.out.println("SUCESSO!");
                stmt.close();
                bd.conexao.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void loadCrachas(DefaultTableModel table) {
        String query = "SELECT cr.idCracha,cr.statusCracha,col.nomeCompletoColaborador,ter.nomeCompletoTerceirizado FROM cracha as cr left join colaborador as col on col.idColaborador=cr.fk_idColaborador left join terceirizado as ter on ter.idTerceirizado=cr.fk_idTerceirizado";
        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    String owner;
                    
                    if(rs.getString("col.nomeCompletoColaborador")!=null){
                        owner = rs.getString("col.nomeCompletoColaborador");
                    }else if(rs.getString("ter.nomeCompletoTerceirizado")!=null){
                         owner = rs.getString("col.nomeCompletoTerceirizado");
                    }else{
                        owner = "UNUSED";
                    } 
                    
                    table.addRow(new Object[]{
                        rs.getString("cr.idCracha"),
                        rs.getString("cr.statusCracha"),
                        owner
                    });
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
