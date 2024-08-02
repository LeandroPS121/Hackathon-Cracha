/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTH.DAO;
import CONEXAO_BANCO.Banco_dados;
import SCREENS.History;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author olf5jvl
 */


public class HistoryDAOImpl implements HistoryDAO {
    Banco_dados bd = new Banco_dados();
    public void loadHistory(DefaultTableModel table){
        String query = "SELECT * FROM chamado as c";
        if(bd.getConnection()){
            try{
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    
                   String data = rs.getString("c.dataChamado").substring(0, 10);
                   
                   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                   String formattedData = sdf.format(data);
                    
                   table.addRow(new Object[]{
                        rs.getString("c.idChamado"),
                        formattedData,
                        rs.getString("c.tipoChamado"),
                        rs.getString("c.descricaoChamado"),
                        rs.getString("c.statusChamado")
                    });
                }
                rs.close();
                stmt.close();
                bd.conexao.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
}
