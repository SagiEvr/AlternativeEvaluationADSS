package DomainLayer;
public class Appointment {
    private int id;
    private String date;
    private String time;
    private String status;
    private String doctor;
    private String patient;
    private String note;
    public Appointment(int id,String date, String time, String status, String doctor, String patient, String note) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
        this.note = note;
        System.out.println("Appointment "+ id+" created, STATUS: "+status);
    }

    public Appointment(int id,String date, String time, String status, String doctor, String patient) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
    }
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getPatient() {
        return patient;
    }

    public String getNote() {
        return note;
    }

    public int getAppointmentID() {
        return id;
    }

    public void setStatus(String status) { this.status = status; }
    public void setNote (String note) { this.note = note; }
    public void setDoctor (String doctor) { this.doctor = doctor; }
    public void setPatient (String patient) { this.patient = patient; }
    public void setDate (String date) { this.date = date; }
    public void setTime (String time) { this.time = time; }


}
