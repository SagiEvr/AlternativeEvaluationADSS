package DomainLayer;

import java.util.HashMap;

public class UserController {
    private HashMap<String,User> users;
    private HashMap<Integer,Appointment> appointments;
    private int nextID;

    public UserController(HashMap<String, User> users) {
        this.users = users;
        appointments = new HashMap<Integer, Appointment>();
        nextID = 0;
    }


    //USERS FUNCTIONS
    public boolean registerPatient(String username, String password, String name,String birthdate){
        if(users.containsKey(username)){
            return false;
        }
        users.put(username, new Patient(username, password, name, birthdate));
        return true;
    }

    public boolean registerDoctor(String username, String password, String name,String specialty){
        if(users.containsKey(username)){
            return false;
        }
        users.put(username, new Doctor(name, specialty,username, password));
        return true;
    }

    public boolean login(String username, String password) {
        if(users.containsKey(username)){
            return users.get(username).login(username,password);
        }
        return false;
    }

    public boolean logout(String username) {
        if(users.containsKey(username)){
            return users.get(username).logout(username);
        }
        return false;
    }

    //HELPER FUNCTIONS
    private boolean validateCanOperate(String username, String password){
        return validateUser(username) && validatePassword(username, password) && validateLoggedIn(username);
    }

    private boolean validateUser(String username){
        return users.containsKey(username);
    }

    private boolean validatePassword(String username, String password){
        return users.get(username).checkPassword(password);
    }

    private boolean validateLoggedIn(String username){
        return users.get(username).isLoggedIn();
    }

    private boolean validateDoctor(String username){
        if(!validateUser(username)) return false;
        return users.get(username) instanceof Doctor;
    }

    private boolean validatePatient(String username){
        if(!validateUser(username)) return false;
        return users.get(username) instanceof Patient;
    }

    private boolean validateAppointment(int aptID){
        return appointments.containsKey(aptID);
    }

    private void addAppointment(Appointment appointment){
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    private void removeAppointment(int aptID){
        appointments.remove(aptID);
    }

    private Appointment getAppointment(int aptID){
        return appointments.get(aptID);
    }

    private void updateAppointment(int aptID, Appointment newApt){
        appointments.put(aptID, newApt);
    }

    //PATIENT FUNCTIONS
    //returns appointmentID or -1 if failed

//    ~Operation: requestAppointment(date:Date , hour:Time , DoctorId:string, note: string, pictureLink : string)
//    ~References: Use cases: Book an appointment, update appointment, postpone appointment
//    ~Preconditions:   -   There is an underway booking appointment process
//                      -	doctorId is valid and relevant to the category the patient chosen earlier.
//                      -	doctor is available on date and hour.
//    ~Postconditions:  -   Appointment instance was created
//                      -	Appointment status is “pending”
//                      -	Patient’s request added to his ExpectedAppointments queue
//                      -	Notification instance was created and was sent to the doctor’s instance
    public int requestAppointment(String username, String password, String date, String time, String doctorID, String note) {
        //pre-conditions check:
        //user is valid and logged-in:
        validateCanOperate(username, password);
        //the actor is a patient (doctor can't request appointments)
        if(!validatePatient(username)){
            System.out.println("Patient isn't valid!");
            return -1;
        }
        //doctor is valid check
        if(!validateDoctor(doctorID)){
            System.out.println("Doctor isn't valid!");
            return -1;
        }
        //doctor is available check
        Doctor doctor = (Doctor) users.get(doctorID);
        if(!doctor.checkAvailability(date, time)) {
            System.out.println("Doctor isn't available at this time!");
            return -1;
        }
        else {
            Patient patient = (Patient) users.get(username);
            //patient requests appointment + system creates appointment
            Appointment appointment = patient.requestAppointment(nextID++,date, time, doctorID, note);
            int aptID = appointment.getAppointmentID();
            System.out.println("apt id. " + aptID + " requested for " + date + " at " + time + " with " + doctor.getName());
            doctor.pushNotification(aptID, "You have a new appointment request");
            addAppointment(appointment);
            return aptID;
        }
    }


        //DOCTOR FUNCTIONS




}
