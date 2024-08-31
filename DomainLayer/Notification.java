package DomainLayer;

public class Notification {
    private String message;
    private int aptID;

    public Notification(int aptID, String message) {
        this.message = message;
        this.aptID = aptID;
    }

    public String getMessage() {
        return message;
    }

    public int getAppointmentID() {
        return aptID;
    }
}
