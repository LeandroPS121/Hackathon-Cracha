/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

/**
 *
 * @author olf5jvl
 */
public class Chamado {

    private int id;
    private String data;
    private String tipo;
    private String descricao;
    private String status;
    private String edv;
    private String crachaSelecionado;
    private String locaisSelecionado;
    private Terceirizado terceirizado;

    public Chamado(int id, String data, String tipo, String descricao, String status, String edv, String crachaSelecionado, String locaisSelecionado, Terceirizado terceirizado) {
        this.id = id;
        this.data = data;
        this.tipo = tipo;
        this.descricao = descricao;
        this.status = status;
        this.edv = edv;
        this.crachaSelecionado = crachaSelecionado;
        this.locaisSelecionado = locaisSelecionado;
        this.terceirizado = terceirizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEdv() {
        return edv;
    }

    public void setEdv(String edv) {
        this.edv = edv;
    }

    public String getCrachaSelecionado() {
        return crachaSelecionado;
    }

    public void setCrachaSelecionado(String crachaSelecionado) {
        this.crachaSelecionado = crachaSelecionado;
    }

    public String getLocaisSelecionado() {
        return locaisSelecionado;
    }

    public void setLocaisSelecionado(String locaisSelecionado) {
        this.locaisSelecionado = locaisSelecionado;
    }

    public Terceirizado getTerceirizado() {
        return terceirizado;
    }

    public void setTerceirizado(Terceirizado terceirizado) {
        this.terceirizado = terceirizado;
    }

}
