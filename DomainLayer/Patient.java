package DomainLayer;

import java.util.HashMap;
import java.util.Queue;

public class Patient extends User{
    private String name;
    private String birthdate;
    private HashMap<Integer,Appointment> ExpectedAppointments; // dictionary of appointments with the key being the appointment id
    private HashMap<Integer,Appointment> HistoryAppointments; // dictionary of appointments with the key being the appointment id

    public Patient(String username, String password,String name, String birthdate) {
        super(username, password);
        this.name = name;
        this.birthdate = birthdate;
        this.ExpectedAppointments = new HashMap<Integer, Appointment>();
        this.HistoryAppointments = new HashMap<Integer, Appointment>();
    }
    public String getName() {
        return name;
    }
    public String getBirthdate() { return birthdate; }

    public Appointment requestAppointment(int id,String date, String time, String doctor, String note){
        // create a new appointment object
        Appointment appointment = new Appointment(id,date, time, "Pending", doctor, super.getUsername(), note);
        // add the appointment to the ExpectedAppointments dictionary
        ExpectedAppointments.put(appointment.getAppointmentID(), appointment);
        System.out.println("added to expected appointments of " + super.getUsername());
        return appointment;
    }

    //    Operation: requestAppointment(date:Date , hour:Time , DoctorId:string, note: string, pictureLink : string)
//    References: Use cases: Book an appointment, update appointment, postpone appointment
//    Preconditions:    -      There is an underway booking appointment process
//                      -	doctorId is valid and relevant to the category the patient chosen earlier.
//                      -	doctor is available on date and hour.
//    Postconditions:   -      Appointment instance was created
//                      -	Appointment status is “pending”
//                      -	Patient’s request added to his ExpectedAppointments queue
//                      -	Notification instance was created and was sent to the doctor’s instance
}
