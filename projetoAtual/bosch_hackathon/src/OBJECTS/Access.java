/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

/**
 *
 * @author sil9jvl
 */
public class Access {
    private int id;
    private Cracha cracha;
    private Local local;

    public Access(int id, Cracha cracha, Local local) {
        this.id = id;
        this.cracha = cracha;
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cracha getCracha() {
        return cracha;
    }

    public void setCracha(Cracha cracha) {
        this.cracha = cracha;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}

