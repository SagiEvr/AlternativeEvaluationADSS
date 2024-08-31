import DomainLayer.*;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //patient account:
        String username = "johndoe"; //username is the patient's id
        String password = "123456";



        //Set-up needed:
        UserController uc = new UserController(new HashMap<String, User>());
        uc.registerDoctor("drsmith", "123456", "Dr. Smith", "General Practitioner");
        uc.registerPatient(username, password, "John Doe", "Y. Rager, Beer Sheva");
        uc.login(username, password);

        //we'll test the use case: PATIENT REQUESTS AN APPOINTMENT (that I suggested in the test)
        //we'll request an appointment
        uc.requestAppointment(username,password,"2024-12-01", "10:00", "drsmith", "I'm feeling sick");


        //Appointment appointment = patient.requestAppointment("2024-12-01", "10:00", "Dr. Smith", "I'm feeling sick");
        //output should be:
        // "apt id. 0 requested for 2024-12-01 at 10:00 with Dr. Smith"
        // "status: pending"
        // "sent notification to Dr. Smith"
        // "added to expected appointments"

    }
}