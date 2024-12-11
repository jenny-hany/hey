import java.util.ArrayList;
import java.util.Arrays;

public class Doctor extends User {
    private String[] availableDays;
    private ArrayList<float[]> availableHours; // List of start-end pairs
    private String specialization;

    private int reservedAppointments = 0;
    private static final String FILE_NAME = "doctors.txt";

    public Doctor(String username, String password, String firstName, String lastName, String email,
                  String mobileNum, String[] availableDays, ArrayList<float[]> availableHours, String specialization) {
        super(username, password, firstName, lastName, email, mobileNum);
        this.availableDays = availableDays;
        this.availableHours = availableHours;
        this.specialization = specialization;

    }

    public Prescription writePrescription(String medicineName, String dosage, String frequency, Patient patient, String dateStr) {
        Prescription prescription = new Prescription(medicineName, dosage, frequency, patient, this, dateStr);
        patient.addPrescription(prescription);
        return prescription;
    }


    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getReservedAppointments() {
        return reservedAppointments;
    }

    public void setReservedAppointments(int reservedAppointments) {
        this.reservedAppointments = reservedAppointments;
    }
   // Method to change available days
    public void changeAvailableDays(String[] newAvailableDays) {
        // Log current days for debugging
        System.out.println("Current available days: " + Arrays.toString(this.availableDays));
        this.availableDays = newAvailableDays; // Update the available days
        System.out.println("Updated available days: " + Arrays.toString(newAvailableDays));
    }

    // Method to change available hours
    public void changeAvailableHours(ArrayList<float[]> newAvailableHours) {
        // Log current hours for debugging
        System.out.println("Current available hours: " + this.availableHours);
        this.availableHours = newAvailableHours; // Update the available hours
        System.out.println("Updated available hours: " + newAvailableHours);
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

    public String getSpecialization() {

        return specialization;
    }
}
