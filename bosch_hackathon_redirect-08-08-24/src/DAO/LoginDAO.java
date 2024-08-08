/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import OBJECTS.User;

/**
 *
 * @author olf5jvl
 */
public interface LoginDAO {
    User authenticate(String edv, String password);
}
