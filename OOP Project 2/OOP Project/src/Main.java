import filehandlingexample.FileHandling;
import javax.print.Doc;
import javax.xml.crypto.Data;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import static filehandlingexample.FileHandling.*;

class patientControl
{

    public static void removeDoctor(String username)
    {
        int size= data.Doctors.size();
        for (int i = 0; i <size; i++)
        {
            if(data.Doctors.get(i).getUsername().equals(username))
            {
                data.Doctors.remove(i);
                break;
            }
        }
    }

}


public class Main {
    public static void main(String[] args) {

        data.Load();

        //Login and Sign Up

        System.out.println("Welcome to the Dental Clinic System Management\n " +
                "Choose If ypu are a Patient , Doctor or Receptionist\n" +
                "1) Doctor \n" +
                "2) Patient \n" +
                "3) Receptionist \n");

        Scanner input = new Scanner(System.in);
        int idetinty = input.nextInt();

        if (idetinty == 1) {
            String username;
            String password;
            do {
                System.out.println("Enter Your UserName  : \n ");
                username = input.next();
                System.out.println("Enter Your Password : \n ");
                password = input.next();
                if (Doctor.login(username, password)) {
                    System.out.println("logged in successfully\n ");

                } else {
                    System.out.println("wrong password or username \n " + "Don't You have an Account?\n " +
                "1)Enter Username and password Again\n" + "2)Sign Up\n");
                    int choice = input.nextInt();
                    if( choice == 1)
                    {
                        continue;
                    }
                    else {
                        System.out.println("Enter your details:");
                        System.out.print("Username: ");
                        String d_username = input.next();
                        System.out.print("Password: ");
                        String d_password = input.next();
                        System.out.print("First Name: ");
                        String d_firstName = input.next();
                        System.out.print("Last Name: ");
                        String d_lastName = input.next();
                        System.out.print("Email: ");
                        String d_email = input.next();
                        System.out.print("Phone Number: ");
                        String d_phone = input.next();
                        String [] d_availableDays = new String[3];
                        ArrayList<float[]> d_availableHours = new ArrayList<>();
                        for (int i =0 ;i < 3 ;i++) {
                            System.out.println("Enter Day");
                            d_availableDays[i] = input.next();
                            System.out.println("Enter available time (Start End, in hours, e.g., 9 17):");
                           float  start = input.nextFloat(); // Get start time
                           float  end = input.nextFloat();   // Get end time

                            d_availableHours.add(new float[]{start, end});
                        }
                        System.out.println("Specialization: ");
                       String d_specialization = input.next();
                               Doctor doctor = new Doctor(d_username, d_password, d_firstName, d_lastName, d_email,
                                       d_phone, d_availableDays, d_availableHours, d_specialization);
                        data.Doctors.add(doctor);
                        System.out.println("You are now signed up");

                        break;
                    }
                }
            } while (!Doctor.login(username, password));

            data.Store();

            int action;
            boolean option = true;
            while (option) {
                System.out.println("1.Create patient's prescription \n" +
                        "2.Show all your Appointments \n" +
                        "3.Contact the Receptionist \n" +
                        "4.Get patient info \n" +
                        "5.Change availability \n" +
                        "6.Exit");
                action = input.nextInt();
                switch (action)
                {
                    case 1:
                        Scanner scanner = new Scanner(System.in);
                        // Prompt user for input
                        System.out.println("Enter Medicine's name: ");
                        String medicineName = scanner.nextLine();
                        System.out.println("Enter Dosage: ");
                        String dosageQuant = scanner.nextLine();
                        System.out.println("Enter Frequency (e.g., 2 times/day): ");
                        String frequency = scanner.nextLine();
                        System.out.println("Enter Patient's name: ");
                        String patientPresName = scanner.nextLine();
                        System.out.println("Enter Doctor's name: ");
                        String doctorPresName = scanner.nextLine();
                        System.out.println("Enter Date (e.g., YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                       // Find the doctor and patient objects from the respective lists
                        Doctor doctor = data.Doctors.stream()
                                .filter(d -> d.getUsername().trim().equalsIgnoreCase(doctorPresName.trim()))
                                .findFirst()
                                .orElse(null);

                        Patient patient = data.Patients.stream()
                                .filter(p -> p.getUsername().trim().equalsIgnoreCase(patientPresName.trim()))
                                .findFirst()
                                .orElse(null);


                        // Validate doctor and patient objects
                        if (doctor != null && patient != null) {
                            // Create a Prescription object
                            Prescription prescription = new Prescription(medicineName, dosageQuant, frequency, patient, doctor, date);
                            // Add the Prescription to the data list
                            data.Prescriptions.add(prescription);
                            System.out.println("Prescription added successfully.");
                        } else {
                            System.out.println("Error: Could not find matching doctor or patient.");
                        }
                        option = false;
                        break;

                    case 2:
                        
                        option=false;
                        break;

                    case 3:
                        break;
                    case 4:
                     break;
                    case 5:
                        break;
                    case 6 :
                        System.exit(1);
                }
            }

        } else if (idetinty == 2) {

            String username;
            String password;
            do {
                System.out.println("Enter Your UserName and Password : \n ");
                username = input.next();
                password = input.next();
                if (Patient.login(username, password)) {
                    System.out.println("logged in successfully\n ");

                } else {
                    System.out.println("wrong password or username \n " + "Don't You have an Account?\n " +
                            "1)Enter Username and password Again\n" + "2)Sign Up\n");
                    int choice = input.nextInt();
                    if( choice == 1)
                    {
                        continue;
                    }
                    else {
                        System.out.println("Enter your details:");
                        System.out.print("Username: ");
                        String p_username = input.next();
                        System.out.print("Password: ");
                        String p_password = input.next();
                        System.out.print("First Name: ");
                        String p_firstName = input.next();
                        System.out.print("Last Name: ");
                        String p_lastName = input.next();
                        System.out.print("Gender : ");
                        String p_Gender = input.next();
                        System.out.print("Email: ");
                        String p_email = input.next();
                        System.out.print("Phone Number: ");
                        String p_phone = input.next();
                        System.out.print("weight: ");
                        float p_weight = input.nextFloat();
                        System.out.print("Height: ");
                        float p_Height = input.nextFloat();
                        System.out.print("age : ");
                        int p_age = input.nextInt();
                        System.out.print("Blood type: ");
                        String p_bloodtype = input.next();

                        String[] patientHistory = new String[10];
                        int count = 0; // use it in displaying the describtion
                        String detail;
                        for (int i = 0; i < 10; i++) {

                            if (i == 0) {
                                System.out.print("Enter the next history detail (or press Enter to finish): ");
                                detail = input.nextLine(); // Read the entire line
                            } else {

                                detail = input.nextLine(); // Read the entire line


                                if (i > 0 && detail.isEmpty()) { // Allow empty input only after the first entry
                                    break; // Exit the loop
                                }
                            }
                            patientHistory[i] = detail;
                            count++;
                        }
                        Patient patient = new Patient(p_username, p_password, p_firstName, p_lastName, p_email,
                                p_phone, patientHistory, p_age, p_Gender, p_bloodtype, p_weight, p_Height);
                        data.Patients.add(patient);
                        System.out.println("You are now signed up");
                        break;
                    }
                }
            } while (!Patient.login(username, password));
            data.Store();

            int action;
            boolean option = true;
            while (option) {
                System.out.println("Choose an option \n" +
                        "1. Update information \n" +
                        "2. Reserve an Appointment \n" +
                        "3. Cancel Appointment \n" +
                        "4. Exit \n" );
                action = input.nextInt();
                switch (action)
                {
                    case 1:
                        System.out.println("What do you like to Update: \n" +
                                "1. Update Email \n" +
                                "2. Update Mobile number \n" +
                                "3. Update Weight \n" +
                                "4. Update Height \n");

                        int update = input.nextInt();
                        if( update == 1) {
                            System.out.println("Enter your current Email: ");
                            String currentEmail = input.next();
                            System.out.println("Enter your new Email: ");
                            String newEmail = input.next();
                            Patient.changeEmail( currentEmail,newEmail );
                            option = false;

                        } else if(update==2) {
                            System.out.println("Enter your current Mobile Nmber: ");
                            String currentMobilenum = input.next();
                            System.out.println("Enter your new Moble Number: ");
                            String newMobileNum = input.next();
                            Patient.changeMobileNum(currentMobilenum ,newMobileNum );
                            option = false;

                        } else if (update==3) {
                            System.out.println("Enter your current Weight: ");
                            float currentWeight = input.nextFloat();
                            System.out.println("Enter your newWeight: ");
                            float newWeight = input.nextFloat();
                            Patient.changeWeight(currentWeight ,newWeight);
                            option = false;

                        } else if (update==4) {
                            System.out.println("Enter your current Height: ");
                            float currentHeight = input.nextFloat();
                            System.out.println("Enter your newHeight: ");
                            float newHeight = input.nextFloat();
                            Patient.changeHeight(currentHeight ,newHeight);
                            option = false;

                        }
                        break;

                    case 2:
                        System.out.println("Enter doctor's name or mobile number:");
                        String doctorData = input.next();
                        System.out.println("Enter day: ");
                        String requestedDay = input.next();
                        System.out.println("Enter timeslot ( e.g. 10 ): ");
                        String requestedTimeSlot = input.next();
                        System.out.println("Enter your name: ");
                        String patientName = input.next();

                        boolean doctorFound = false;

                        for (Doctor doctor : data.Doctors) {
                            if (doctor.getFirstName().equals(doctorData) || doctor.getMobileNumber().equals(doctorData)) {
                                doctorFound = true;

                                AppointmentReservation newAppointment = new AppointmentReservation();
                                newAppointment.setPatient(patientName);
                                newAppointment.setDoctor(doctor.getFirstName());
                                newAppointment.setDay(requestedDay);
                                newAppointment.setTimeSlot(Float.parseFloat(requestedTimeSlot));
                              if( newAppointment.BookAppointment(requestedDay, requestedTimeSlot, doctor , patientName)) {
                                  // Add the appointment to the data list if successfully booked

                                  data.Appointments.add(newAppointment);
                                  System.out.println("Successfully Booked.");
                              }
                            }
                        }
                     option = false;
                        break;

                    case 3:
                        System.out.println("Enter your name:");
                        String cancelPatientName = input.next();
                        AppointmentReservation CancelAppointments = new AppointmentReservation();
                        CancelAppointments.CancelAppointment(cancelPatientName);
                      option = false;
                        break;
                    case 4:
                        System.exit(1);
                    default:
                        System.out.println("Invalid Action!!! \n" +
                                "Please choose again \n");
                }
            }
        } else if (idetinty == 3) {
            String username;
            String password;
            do {
                System.out.println("Enter Your UserName : \n ");
                username = input.next();
                System.out.println("Enter Your Password : \n ");
                password = input.next();
                if (Receptionist.login(username, password)) {
                    System.out.println("Logged in successfully\n ");

                } else {
                    System.out.println("wrong password or username \n " + "Don't You have an Account?\n " +
                            "1)Enter Username and password Again\n" + "2)Sign Up\n");
                    int choice = input.nextInt();
                    if (choice == 1) {
                        continue;
                    } else {
                        System.out.println("Enter your details:");
                        System.out.print("Username: ");
                        String r_username = input.next();
                        System.out.print("Password: ");
                        String r_password = input.next();
                        System.out.print("First Name: ");
                        String r_firstName = input.next();
                        System.out.print("Last Name: ");
                        String r_lastName = input.next();
                        System.out.print("Gender : ");
                        String r_Gender = input.next();
                        System.out.print("Email: ");
                        String r_email = input.next();
                        System.out.print("Phone Number: ");
                        String r_phone = input.next();
                        System.out.print("age : ");
                        int r_age = input.nextInt();

                        Receptionist receptionist= new Receptionist(r_username, r_password, r_firstName, r_lastName, r_email,
                                r_phone, r_age, r_Gender);
                        data.Receptionists.add(receptionist);
                        System.out.println("You are now signed up");

                        break;
                      }
                    }
                }while (!Receptionist.login(username, password));

            int action;
            boolean option=true;
            while (option){
                System.out.println("Choose an option \n" +
                        "1. Update information \n" +
                        "2. Reserve an Appointment \n" +
                        "3. Cancel Appointment \n" +
                        "4. Exit" );
                action = input.nextInt();
                switch (action) {
                    case 1:
                        System.out.println("What do you like to Update: \n" +
                                "1. Update Email \n" +
                                "2. Update Mobile number \n" );

                        int update = input.nextInt();

                        if( update == 1)
                        {
                            System.out.println("Enter your current Email: ");
                            String currentEmail = input.next();
                            System.out.println("Enter your new Email: ");
                            String newEmail = input.next();
                            Receptionist.changeEmail( currentEmail,newEmail );
                            option=false;

                        }
                        else if(update==2)
                        {
                            System.out.println("Enter your current Mobile Nmber: ");
                            String currentMobilenum = input.next();
                            System.out.println("Enter your new Moble Number: ");
                            String newMobileNum = input.next();
                            Receptionist.changeMobileNum(currentMobilenum ,newMobileNum );
                            option=false;

                        }
                        break;
                    case 2:
                        System.out.println("Enter doctor's name or mobile number:");
                        String doctorData = input.next();
                        System.out.println("Enter day: ");
                        String requestedDay = input.next();
                        System.out.println("Enter timeslot ( e.g. 10 ): ");
                        String requestedTimeSlot = input.next();
                        System.out.println("Enter patient name: ");
                        String patientName = input.next();

                        boolean doctorFound = false;

                        for (Doctor doctor : data.Doctors) {
                            if (doctor.getFirstName().equals(doctorData) || doctor.getMobileNumber().equals(doctorData)) {
                                doctorFound = true;

                                AppointmentReservation newAppointment = new AppointmentReservation();
                                newAppointment.setPatient(patientName);
                                newAppointment.setDoctor(doctor.getFirstName());
                                newAppointment.setDay(requestedDay);
                                newAppointment.setTimeSlot(Float.parseFloat(requestedTimeSlot));
                                if( newAppointment.BookAppointment(requestedDay, requestedTimeSlot, doctor , patientName)) {
                                    // Add the appointment to the data list if successfully booked

                                    data.Appointments.add(newAppointment);
                                    System.out.println("Successfully Booked.");
                                }
                            }
                        }
                        option = false;
                        break;
                    case 3:
                        System.out.println("Enter patient name:");
                        String cancelPatientName = input.next();
                        AppointmentReservation CancelAppointments = new AppointmentReservation();
                        CancelAppointments.CancelAppointment(cancelPatientName);
                        option = false;
                        break;
                    case 4:
                        System.exit(1);
                    default:
                        System.out.println("Invalid action !!! \n" +
                                "Please choose again \n");
                }
            }
        }
        data.Store();
    }
}