/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONEXAO_BANCO.Banco_dados;
import OBJECTS.Colaborador;
import OBJECTS.Cracha;
import OBJECTS.Terceirizado;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author olf5jvl
 */
public class CrachaDAOImpl implements CrachaDAO {

    private ColaboradorDAO colaboradorDAO = new ColaboradorDAOImpl();
    private TerceirizadoDAO terceirizadoDAO = new TerceirizadoDAOImpl();

    Banco_dados bd = new Banco_dados();

    public void addCracha(Cracha cracha) {
        if (bd.getConnection()) {
            String query = "INSERT INTO cracha (codeCracha,statusCracha,tipoAtribuicaoCracha,fk_idColaborador,fk_idTerceirizado) VALUES (?,?,?,?,?)";
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1, cracha.getCode());
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

    /**
     *
     * @param table
     */
    @Override
    public void loadCrachas(DefaultTableModel table) {
        table.setRowCount(0);
        String query = "SELECT cr.codeCracha,cr.statusCracha,col.nomeCompletoColaborador,ter.nomeCompletoTerceirizado FROM cracha as cr left join colaborador as col on col.idColaborador=cr.fk_idColaborador left join terceirizado as ter on ter.idTerceirizado=cr.fk_idTerceirizado";
        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    String owner;

                    if (rs.getString("col.nomeCompletoColaborador") != null) {
                        owner = rs.getString("col.nomeCompletoColaborador");
                    } else if (rs.getString("ter.nomeCompletoTerceirizado") != null) {
                        owner = rs.getString("col.nomeCompletoTerceirizado");
                    } else {
                        owner = "-";
                    }
                    
                    
                    
                    table.addRow(new Object[]{
                        rs.getString("cr.codeCracha"),
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

    public boolean updateCracha(String edv, String badge) {

        Colaborador colaborador = colaboradorDAO.getColaboradorByEdv(edv);

        String query = "UPDATE cracha SET fk_idColaborador = ?, statusCracha = ? WHERE codeCracha = ?";

        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setInt(1, colaborador.getId());
                stmt.setString(2, "IN USE");
                stmt.setString(3, badge);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }

    public void verifyCrachaUsed(String edv, String badge) {

        Colaborador colaborador = colaboradorDAO.getColaboradorByEdv(edv);

        String query = "SELECT codeCracha FROM cracha WHERE fk_idColaborador = ?";

        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);

                stmt.setInt(1, colaborador.getId());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println(badge);
                    System.out.println("existe");

                    if (rs.getString("codeCracha") != null) {
                        System.out.println("caiu cracha existente");
                        disableBadge(rs.getString("codeCracha"));
                    }
                } else {
                    System.out.println("nao existe");
                }
                updateCracha(edv, badge);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public Cracha getBadgeUsedByCol(Colaborador colaborador) {
        String query = "SELECT * FROM cracha WHERE fk_idColaborador = ?";
        if (bd.getConnection()) {
            try{
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setInt(1, colaborador.getId());
                stmt.executeQuery();
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Cracha cracha = new Cracha(
                    rs.getInt("idCracha"),
                            rs.getString("codeCracha"),
                            rs.getString("statusCracha"),
                            rs.getString("tipoAtribuicaoCracha"),
                            rs.getString("expiracaoUsoCracha"),
                            colaborador,
                            null
                    );
                    return cracha;
                }
                
                
            } catch (SQLException e) {
                System.out.println(e);
            }
            
        }
        return null;
    }
    

    

    

    public void disableBadge(String badge) {
        String query = "UPDATE cracha SET statusCracha = ?, fk_idColaborador = ? WHERE codeCracha = ?";
        if (bd.getConnection()) {
            try {
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1, "UNUSED");
                stmt.setString(2, null);
                System.out.println(badge);
                stmt.setString(3, badge);
                stmt.executeUpdate();
                System.out.println("removeu");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
