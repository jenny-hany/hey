import java.util.ArrayList;

public class Doctor extends User {
    private String[] availableDays;
    private ArrayList<float[]> availableHours; // List of start-end pairs
    private String specialization;

    private int reservedAppointments = 0;
    private static final String FILE_NAME = "doctors.txt";
    public Doctor (String username, String password, String firstName, String lastName, String email,
                   String mobileNum,String[] availableDays,ArrayList<float[]> availableHours,String specialization)
    {
        super(username, password, firstName, lastName, email, mobileNum);
        this.availableDays = availableDays;
        this.availableHours = availableHours;
        this.specialization = specialization;

    }
    public Prescription writePrescription(String medicineName, String dosage, String frequency, Patient patient, String dateStr) {
        Prescription prescription = new Prescription(medicineName, dosage, frequency, patient,this, dateStr);
        patient.addPrescription(prescription);
        return prescription;
    }
    // Getters and Setters
    public String[] getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String[] availableDays) {
        this.availableDays = availableDays;
    }

    public ArrayList<float[]> getAvailableHours() {
        return availableHours;
    }
    public String getSpecialization()
    {

        return specialization;
    }

/*
    public void setAvailableHours(double availableHours) {
        this.availableHours = availableHours;
    }


    public void setReservedAppointments(int reservedAppointments) {
        this.reservedAppointments = reservedAppointments;
    }

    public int getReservedAppointments() {
        return reservedAppointments;
    }

    // Additional Methods
    public void createPrescription(String patientName, String details) {
        System.out.println("Prescription for " + patientName + ": " + details);
    }

    public void showAppointmentsOfTheDay(String doctorName) {
        System.out.println("The number of reserved appointments with Dr. " + doctorName + " is " + getReservedAppointments());
    }

    // File Handling Methods
    public String toFileFormat() {
        return getFirstName() + "," + getLastName() + "," + getEmail() + "," +
                String.join(";", availableDays) + "," + availableHours + "," + reservedAppointments;
    }



    // Doctor Menu
    static public void menuDoctor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Doctor Menu:");
        System.out.println("1. View All Doctors");
        System.out.println("2. Add a New Doctor");
        System.out.println("3. View Appointments for the Day");
        System.out.println("4. Exit");

        int choice = input.nextInt();
        input.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> {
                // View all doctors
                List<Doctor> doctors = loadAll();
                System.out.println("Doctors in the system:");
                for (Doctor doctor : doctors) {
                    System.out.println(doctor.toFileFormat());
                }
            }
            case 2 -> {
                // Add a new doctor
                System.out.println("Enter First Name:");
                String firstName = input.nextLine();
                System.out.println("Enter Last Name:");
                String lastName = input.nextLine();
                System.out.println("Enter Email:");
                String email = input.nextLine();
                System.out.println("Enter Available Days (comma-separated):");
                String[] days = input.nextLine().split(",");
                System.out.println("Enter Available Hours:");
                double hours = input.nextDouble();

                Doctor doctor = new Doctor();
                doctor.setFirstName(firstName);
                doctor.setLastName(lastName);
                doctor.setEmail(email);
                doctor.setAvailableDays(days);
                doctor.setAvailableHours(hours);

                doctor.save();
                System.out.println("Doctor added successfully!");
            }
            case 3 -> {
                // Show appointments for a doctor
                System.out.println("Enter Doctor's Name:");
                String doctorName = input.nextLine();
                List<Doctor> doctors = loadAll();
                for (Doctor doctor : doctors) {
                    if (doctor.getFirstName().equalsIgnoreCase(doctorName)) {
                        doctor.showAppointmentsOfTheDay(doctorName);
                        return;
                    }
                }
                System.out.println("Doctor not found.");
            }
            case 4 -> {
                System.out.println("Exiting Doctor Menu...");
            }
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }
    */
}
