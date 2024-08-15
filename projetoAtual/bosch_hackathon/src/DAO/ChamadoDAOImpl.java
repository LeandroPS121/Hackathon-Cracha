/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONEXAO_BANCO.Banco_dados;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.sql.*;

/**
 *
 * @author olf5jvl
 */
public class ChamadoDAOImpl implements ChamadoDAO{
    
    Banco_dados bd = new Banco_dados();
    
    public void sendTempChamado(String edv, String badgeCode, int expTime){
        
        LocalDateTime agora = LocalDateTime.now();

        LocalDateTime novaDataHora = agora.plus(expTime, ChronoUnit.HOURS);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = novaDataHora.format(formatter);
        
        String query = "INSERT INTO chamado ("
                + "dataChamado,tipoChamado,descricaoChamado,statusChamado,edvChamado,crachaSelecionadoChamado)"
                + " VALUES (?,?,?,?,?,?)";
        
        if(bd.getConnection()){
            try{
                PreparedStatement stmt = bd.conexao.prepareStatement(query);
                stmt.setString(1,dataHoraFormatada);
                stmt.setString(2, "Temporary");
                stmt.setString(3, "HRL - Temporary access for visitors or employees who have forgotten their badge");
                stmt.setString(4, "COMPLETED");
                stmt.setString(5, edv);
                stmt.setString(6, badgeCode);
                stmt.executeUpdate();
                stmt.close();
                bd.conexao.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
}
