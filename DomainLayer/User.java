package DomainLayer;

import java.util.ArrayDeque;
import java.util.Queue;

public class User {
    private String username;
    private String password;
    private boolean loggedIn;
    private Queue<Notification> notifications;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
        this.notifications = new ArrayDeque<Notification>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean login(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password)){
            loggedIn = true;
            return true;
        }
        return false;
    }

    public boolean logout(String username) {
        if(this.username.equals(username) && loggedIn){
            loggedIn = false;
            return true;
        }
        return false;
    }

    public void pushNotification(int aptID, String message) {
        notifications.add(new Notification(aptID, message));
        System.out.println("Notification about apt id. "+aptID+" added to "+ username +"'s notifications" );
    }

    public Notification popNotification() {
        return notifications.poll();
    }
}
