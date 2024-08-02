/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTH.DAO;

import OBJECTS.Cracha;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author olf5jvl
 */
public interface CrachaDAO {
    void addCracha(Cracha cracha);
    void loadCrachas(DefaultTableModel table);
}
