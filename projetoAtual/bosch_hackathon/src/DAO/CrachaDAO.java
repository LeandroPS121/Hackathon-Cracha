/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import OBJECTS.Colaborador;
import OBJECTS.Cracha;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author olf5jvl
 */
public interface CrachaDAO {
    void addCracha(Cracha cracha);
    void loadCrachas(DefaultTableModel table);
    void verifyCrachaUsed(String edv,String badge);
    void disableBadge(String edv);
    Cracha getBadgeUsedByCol(Colaborador colaborador);
}
