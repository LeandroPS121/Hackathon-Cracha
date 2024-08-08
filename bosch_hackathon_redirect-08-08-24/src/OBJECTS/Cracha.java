/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

/**
 *
 * @author olf5jvl
 */
public class Cracha {
    private int id;
    private String code;
    private String status;
    private String tipo;
    private String dataExpiracao;
    private Colaborador colaborador;
    private Terceirizado terceirizado;

    public Cracha(int id, String code, String status, String tipo, String dataExpiracao, Colaborador colaborador, Terceirizado terceirizado) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.tipo = tipo;
        this.dataExpiracao = dataExpiracao;
        this.colaborador = colaborador;
        this.terceirizado = terceirizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Terceirizado getTerceirizado() {
        return terceirizado;
    }

    public void setTerceirizado(Terceirizado terceirizado) {
        this.terceirizado = terceirizado;
    }
    
    public String getDataExpiracao(){
        return dataExpiracao;
    }
    
    public void setDataExpiracao(String dataExpiracao){
        this.dataExpiracao=dataExpiracao;
    }
}
   
