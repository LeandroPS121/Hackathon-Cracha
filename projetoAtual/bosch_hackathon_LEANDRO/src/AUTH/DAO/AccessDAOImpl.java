/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTH.DAO;

import CONEXAO_BANCO.Banco_dados;
import OBJECTS.Access;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sil9jvl
 */
public class AccessDAOImpl implements AccessDAO {
    Banco_dados bd = new Banco_dados();
    public void addAccess(Access access){
        if(bd.getConnection()){
            String query = "INSERT INTO access (fk_idCracha,fk_idLocal) VALUES (?,?)";
            try{
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1, access.getCracha().getId());
                stmt.setString(2, access.getLocal().getId());
                stmt.executeUpdate();
                
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
}
