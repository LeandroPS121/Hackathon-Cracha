/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

/**
 *
 * @author olf5jvl
 */
public class Colaborador {
    private int id;
    private String edv;
    private String nomeCompleto;
    
    public Colaborador(int id, String edv, String nomeCompleto) {
        this.id = id;
        this.edv = edv;
        this.nomeCompleto = nomeCompleto;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEdv() {
        return edv;
    }
    public void setEdv(String edv) {
        this.edv = edv;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}
