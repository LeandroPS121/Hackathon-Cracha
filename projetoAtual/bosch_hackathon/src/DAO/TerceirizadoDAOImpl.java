/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONEXAO_BANCO.Banco_dados;
import OBJECTS.Terceirizado;
import java.sql.*;

/**
 *
 * @author olf5jvl
 */
public class TerceirizadoDAOImpl implements TerceirizadoDAO {

    Banco_dados bd = new Banco_dados();

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Terceirizado getTerceirizadoById(int id) {
        if (bd.getConnection()) {
            try {
                String query = "SELECT * FROM terceirizado WHERE idTerceirizado = ?";
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                    
                    Terceirizado terceirizado = new Terceirizado(
                            rs.getInt("idTerceirizado"),
                            rs.getString("cpfTerceirizado"),
                            rs.getString("nomeCompletoTerceirizado"),
                            rs.getString("empresaTerceirizado"),
                            rs.getString("areaAtuacao"),
                            rs.getString("locaisSelecionadoChamado")
                    );
                    
                    return terceirizado;
                    
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }
    
    /**
     *
     * @param terceirizado
     */
    @Override
    public void addTerceirizado(Terceirizado terceirizado){
        String query="INSERT INTO terceirizado (cpfTerceirizado,nomeCompletoTerceirizado,empresaTerceirizado,areaAtuacaoTerceirizado) VALUES (?,?,?,?)";
        if(bd.getConnection()){
            try{
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1,terceirizado.getCpf());
                stmt.setString(2,terceirizado.getNomeCompleto());
                stmt.setString(3,terceirizado.getEmpresa());
                stmt.setString(4,terceirizado.getAreaAtuacao());
                stmt.executeUpdate();
                stmt.close();
                bd.conexao.close();
                
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
    
  
}
