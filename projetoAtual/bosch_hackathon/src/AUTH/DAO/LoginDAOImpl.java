/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTH.DAO;
import OBJECTS.User;
import AUTH.DAO.ColaboradorDAO;
import AUTH.DAO.ColaboradorDAOImpl;
import OBJECTS.Colaborador;
import AUTH.SessionManager;
import AUTH.SessionManager;
import OBJECTS.User;
import CONEXAO_BANCO.Banco_dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author olf5jvl
 */

public class LoginDAOImpl implements LoginDAO{
   
    
    Banco_dados bd = new Banco_dados();   
    
    public boolean authenticate(String edv, String password){
        System.out.println("ENTROU FUNCAO");
        String query = "SELECT u.idUser,u.passwordUser,u.isFcmUser,u.fk_idColaborador FROM user AS u INNER JOIN colaborador AS c on c.idColaborador=u.fk_idColaborador WHERE c.edvColaborador=? AND u.passwordUser=?";
        if(bd.getConnection()){
            try{
                
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1,edv);
                stmt.setString(2,password);
                System.out.println("edv: "+edv);
                System.out.println("password: "+password);
                ResultSet rs =stmt.executeQuery();
                if(rs.next()){
                    
                    int idUser = rs.getInt("u.idUser");
                    String pw = rs.getString("u.passwordUser");
                    int isFcm = rs.getInt("u.isFcmUser");
                              
                    ColaboradorDAO colDAO = new ColaboradorDAOImpl();
                    Colaborador colaborador = colDAO.getColaborador(rs.getInt("u.fk_idColaborador"));
                    
                    User user = new User(idUser,pw,isFcm,colaborador); 
                    
                    SessionManager.getInstance().clearSession();
                    SessionManager.getInstance().setCurrentUser(user);
                    
                    JOptionPane.showMessageDialog(null,"AUTENTICADO!");
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null,"USUÁRIO OU SENHA INVALIDOS!");
                }
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return false;
    }
}
