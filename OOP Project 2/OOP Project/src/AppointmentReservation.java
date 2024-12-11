import java.util.Arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static filehandlingexample.FileHandling.readFromFile;

public class AppointmentReservation {
    private String day;  // Day of the week
    private float timeSlot; // Format: HH:MM
    private String patient;
    private  String doctor;
    private static final String FILE_NAME = "appointments.txt";
    String APfilePath = "appointments.txt";
    // Constructor

    //mario,Mark,Sat,3
    public static boolean BookAppointment(String day, String timeSlot, Doctor doctor, String patientName) {


        boolean isAvailableDay = Arrays.asList(doctor.getAvailableDays()).contains(day);
        boolean isAvailableTime = false;

        // Check if the time slot is within the doctor's available hours
        for (float[] hours : doctor.getAvailableHours()) {
           float  start = hours[0];
            float end = hours[1];
            float requestedTime = Float.parseFloat(timeSlot);
            if (requestedTime >= start && requestedTime <= end) {
                isAvailableTime = true;
                break;
            }

        }

        if (isAvailableDay && isAvailableTime) {
            // Check if the requested slot is already booked
            for (AppointmentReservation appointment : data.Appointments) {
                if (appointment.getDay().equalsIgnoreCase(day) && appointment.getTimeSlot() == Float.parseFloat(timeSlot)
                        && appointment.getDoctor().equalsIgnoreCase(doctor.getFirstName())) {
                    System.out.println("This appointment is already booked!");
                    return false;
                }
                else {

                    return true;
                }
            }



        } else {
            if (!isAvailableDay) {
                System.out.println("The doctor is unavailable on the requested day.");
            }
            if (!isAvailableTime) {
                System.out.println("The doctor is unavailable at the requested time.");
            }
        }

        return false;
    }





    public boolean CancelAppointment(String patientName) {


        boolean appointmentFound = false;

        // Log initial state of appointments

//        for (AppointmentReservation a : data.Appointments) {
//            System.out.println("Patient: " + a.getPatient() + ", Doctor: " + a.getDoctor() +
//                    ", Day: " + a.getDay() + ", Time Slot: " + a.getTimeSlot());
//        }

        // Search and remove the appointment from the in-memory list
        for (int i = 0; i < data.Appointments.size(); i++) {
            if (data.Appointments.get(i).getPatient().equalsIgnoreCase(patientName)) {
                System.out.println(" Removing appointment for patient: " + data.Appointments.get(i).getPatient());
                data.Appointments.remove(i);
                appointmentFound = true;
                break; // Exit after first match
            }
        }



        return false;
    }
    // Getters and Setters
    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public float getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(float timeSlot) {
        this.timeSlot = timeSlot;
    }

    // Display Appointment Details
    public void displayAppointmentDetails()
    {
        System.out.println("Appointment Details:");
        System.out.println("Day: " + day);
        System.out.println("Time Slot: " + timeSlot);

    }

    @Override
    public String toString() {
        return "AppointmentReservation{" +
                ", day='" + day + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                '}';
    }
}