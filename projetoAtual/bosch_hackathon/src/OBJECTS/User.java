/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

/**
 *
 * @author olf5jvl
 */
public class User {
    private int id;
    private String password;
    private int isFcmUser;
    private Colaborador colaborador;
    
    public User(int id,String password,int isFcmUser, Colaborador colaborador){
        this.id=id;
        this.password=password;
        this.isFcmUser=isFcmUser;
        this.colaborador=colaborador;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public int getIsFcmUser(){
        return isFcmUser;
    }
    public void setIsFcmUser(int isFcmUser){
        this.isFcmUser=isFcmUser;
    }
    public Colaborador getColaborador(){
        return colaborador;
    }
    public void setColaborador(Colaborador colaborador){
        this.colaborador=colaborador;
    }
}
