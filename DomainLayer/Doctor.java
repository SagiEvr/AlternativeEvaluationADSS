package DomainLayer;

public class Doctor extends User{

    private String name;
    private String specialty;
    private Schedule schedule;
    private Rate rate;


    public Doctor(String name, String specialty, String username, String password) {
        super(username, password);
        this.name = name;
        this.specialty = specialty;
        this.schedule = new Schedule();
        this.rate = new Rate();
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean checkAvailability(String date, String time) {
        return schedule.isAvailable(date, time);
    }
}
