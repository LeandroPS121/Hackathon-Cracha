/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import OBJECTS.Terceirizado;

/**
 *
 * @author olf5jvl
 */
public interface TerceirizadoDAO {
    Terceirizado getTerceirizadoById(int id);
    void addTerceirizado(Terceirizado terceirizado);
}
