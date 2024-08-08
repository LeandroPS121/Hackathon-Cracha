/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import OBJECTS.Colaborador;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author olf5jvl
 */
public interface ColaboradorDAO {
    Colaborador getColaboradorById(int id);
    Colaborador getColaboradorByEdv(String edv);
    Colaborador getColaboradorByName(String name);
    void loadColaborador(DefaultTableModel table);
}
