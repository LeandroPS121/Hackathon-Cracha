/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTH;
import OBJECTS.User;
/**
 *
 * @author olf5jvl
 */
public class SessionManager {
    private static SessionManager instance;
    private User currentUser;

    // Construtor privado para garantir que a classe siga o padrão Singleton
    private SessionManager() {
    }

    // Método para obter a instância única da classe
    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void clearSession() {
        currentUser = null;
    }
}
