import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static filehandlingexample.FileHandling.readFromFile;

public class data {
    public static List<Doctor> Doctors=new ArrayList<>();
    public static List<Patient> Patients=new ArrayList<>();
    public static List<Receptionist> Receptionists =new ArrayList<>();
    public static List<Dentalclinic> Dentalclinics=new ArrayList<>();
    public static List<AppointmentReservation> Appointments = new ArrayList<>();
    public static  List<Prescription> Prescriptions = new ArrayList<>();

    public static boolean Load() {
      List<String> RowPatientData=readFromFile("patients.txt");
      List<String> RowDoctorData=readFromFile("DentalClinic.txt");
      List<String> RowReceptionistData=readFromFile("receptionist.txt");
      List<String> RowDentalClinicData=readFromFile("doctors.txt");
      List<String> RowAppointmentData=readFromFile("appointments.txt");
      List <String> RowPrescriptionData=readFromFile("prescriptions.txt");


        String DRfilePath = "doctors.txt"; // Replace with the path to your file
        String PAfilePath = "patients.txt";
        String REfilePath = "receptionist.txt";
        String DCfilePath = "DentalClinic.txt";
        String APfilePath = "appointments.txt";
        String PRfilePath = "prescriptions.txt";

        //DOCTOR LOAD FILE

        try (BufferedReader br = new BufferedReader(new FileReader(DRfilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Parse each field
                String username = fields[0];
                String password = fields[1];
                String firstName = fields[2];
                String lastName = fields[3];
                String email = fields[4];
                String mobileNumber = fields[5];
                String[] availableDays = fields[6].split(":");

                // Parse available hours into a list of integer pairs
                ArrayList<float[]> availableHours = new ArrayList<>();
                String[] hourRanges = fields[7].split("\\$");
                for (String range : hourRanges) {
                    String[] times = range.split(":");
                    float start = Float.parseFloat(times[0]);
                    float end = Float.parseFloat(times[1]);
                    availableHours.add(new float[]{start, end});
                }

                String specialization = fields[8];

                // Create a UserData object and add it to the list
                Doctor DoctorData = new Doctor(username, password, firstName, lastName, email,
                                                  mobileNumber, availableDays, availableHours, specialization);
                Doctors.add(DoctorData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //PATIENT LOAD FILE

        try (BufferedReader br = new BufferedReader(new FileReader(PAfilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Parse each field
                String username = fields[0];
                String password = fields[1];
                String firstName = fields[2];
                String lastName = fields[3];
                String email = fields[4];
                String mobileNumber = fields[5];
                String[] patientHistory = fields[6].split(":");
                String age = fields[7];
                String gender = fields[8];
                String bloodType = fields[9];
                String weight = fields[10];
                String height = fields[11];
                // Create a UserData object and add it to the list
                Patient PatientData = new Patient(username, password, firstName, lastName, email,
                        mobileNumber, patientHistory, Integer.parseInt(age),gender,bloodType,Float.parseFloat(weight), Float.parseFloat(height));
                Patients.add(PatientData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //RECEPTIONIST LOAD FILE

        try (BufferedReader br = new BufferedReader(new FileReader(REfilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Parse each field
                String username = fields[0];
                String password = fields[1];
                String firstName = fields[2];
                String lastName = fields[3];
                String email = fields[4];
                String mobileNumber = fields[5];
                String age = fields[5];
                String gender = fields[5];
                // Create a UserData object and add it to the list
                Receptionist ReceptionistData = new Receptionist(username, password, firstName, lastName, email,
                        mobileNumber, Integer.parseInt(age),gender);
                Receptionists.add(ReceptionistData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //DENTAL CLINIC LOAD FILE

        try (BufferedReader br = new BufferedReader(new FileReader(DCfilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
           //name,location,list of doctors,list of patients, list of receptionist ,prices, service
                // Parse each field
                String name = fields[0];
                String location = fields[1];
                String ListOfDoctors = fields[2];
                String ListOfPatients = fields[3];
                String Prices = fields[4];
                String service = fields[4];
                // Create a UserData object and add it to the list
                Dentalclinic DentalclinicsData = new Dentalclinic(name, location, ListOfDoctors, ListOfPatients,Prices,service);
                Dentalclinics.add(DentalclinicsData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Appointments LOAD FILE
        try (BufferedReader br = new BufferedReader(new FileReader(APfilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length == 4) {
                    String patient = fields[0].trim();
                    String doctor = fields[1].trim();
                    String day = fields[2].trim();
                    String timeSlotStr = fields[3].trim();

                    try {
                        Float timeSlot = Float.parseFloat(timeSlotStr);

                        AppointmentReservation appointment = new AppointmentReservation();
                        appointment.setPatient(patient);
                        appointment.setDoctor(doctor);
                        appointment.setDay(day);
                        appointment.setTimeSlot(timeSlot);

                        data.Appointments.add(appointment);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid time slot: " + line);
                    }
                } else {
                    System.err.println("Skipping invalid line in appointments file: " + line);
                }
            }

        }
          catch (IOException e) {
            e.printStackTrace();
        }

//presc
        try (BufferedReader br = new BufferedReader(new FileReader(PRfilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Parse each field
                String medicineName = fields[0];
                String dosage = fields[1];
                String frequency = fields[2];
                String doctorUsername = fields[3];
                String patientUsername = fields[4];
                String dateStr = fields[5];

                // Find doctor and patient objects based on username
                Doctor doctor = Doctors.stream()
                        .filter(d -> d.getUsername().equals(doctorUsername))
                        .findFirst()
                        .orElse(null);

                Patient patient = Patients.stream()
                        .filter(p -> p.getUsername().equals(patientUsername))
                        .findFirst()
                        .orElse(null);

                // Ensure valid doctor and patient before creating a prescription
                if (doctor != null && patient != null) {
                    Prescription prescription = new Prescription(medicineName, dosage, frequency, patient,doctor, dateStr);
                    Prescriptions.add(prescription);
                } else {
                    System.err.println("Skipping invalid prescription entry: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean Store() {
        String DRfilePath = "doctors.txt"; // Replace with the path to your file
        String PAfilePath = "patients.txt";
        String REfilePath = "receptionist.txt";
        String DCfilePath = "DentalClinic.txt";
        String APfilePath = "appointments.txt";
        String PRfilePath = "prescriptions.txt";

        //

        //DOCTOR FILE HANDLING

        //

        // Step 1: Clear the file by opening it in write mode without appending
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DRfilePath, false))) {
            // File is cleared because we're opening in write mode (default truncates content)
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if file clearing fails
        }

        // Step 2: Write the new data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DRfilePath, true))) {
            for (Doctor doctor : Doctors) {
                // Serialize the doctor object into a string
                StringBuilder line = new StringBuilder();
                line.append(doctor.getUsername()).append(",");
                line.append(doctor.getPassword()).append(",");
                line.append(doctor.getFirstName()).append(",");
                line.append(doctor.getLastName()).append(",");
                line.append(doctor.getEmail()).append(",");
                line.append(doctor.getMobileNumber()).append(",");

                // Join available days with ":"
                line.append(String.join(":", doctor.getAvailableDays())).append(",");

                // Join available hours with "$"
                List<String> hours = new ArrayList<>();
                for (float[] range : doctor.getAvailableHours()) {
                    hours.add(range[0] + ":" + range[1]);
                }
                line.append(String.join("$", hours)).append(",");

                line.append(doctor.getSpecialization());

                // Write the serialized string to the file
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if writing fails
        }


        //

        //PATIENT FILE HANDLING

        //

        // Step 1: Clear the file by opening it in write mode without appending
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PAfilePath, false))) {
            // File is cleared because we're opening in write mode (default truncates content)
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if file clearing fails
        }

        // Step 2: Write the new data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PAfilePath, true))) {
            for (Patient patient : Patients) {
                // Serialize the doctor object into a string
                StringBuilder line = new StringBuilder();
                line.append(patient.getUsername()).append(",");
                line.append(patient.getPassword()).append(",");
                line.append(patient.getFirstName()).append(",");
                line.append(patient.getLastName()).append(",");
                line.append(patient.getEmail()).append(",");
                line.append(patient.getMobileNumber()).append(",");
                // Join Patient history with ":"
                line.append(String.join(":", patient.getPatientHistory())).append(",");
                line.append(patient.getAge()).append(",");
                line.append(patient.getGender()).append(",");
                line.append(patient.getBloodType()).append(",");
                line.append(patient.getWeight()).append(",");
                line.append(patient.getHeight());
                // Write the serialized string to the file
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if writing fails
        }


        //

        //RECEPTIONIST FILE HANDLING

        //

        // Step 1: Clear the file by opening it in write mode without appending
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REfilePath, false))) {
            // File is cleared because we're opening in write mode (default truncates content)
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if file clearing fails
        }

        // Step 2: Write the new data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REfilePath, true))) {
            for (Receptionist receptionist : Receptionists) {
                // Serialize the doctor object into a string
                StringBuilder line = new StringBuilder();
                line.append(receptionist.getUsername()).append(",");
                line.append(receptionist.getPassword()).append(",");
                line.append(receptionist.getFirstName()).append(",");
                line.append(receptionist.getLastName()).append(",");
                line.append(receptionist.getEmail()).append(",");
                line.append(receptionist.getMobileNumber()).append(",");
                line.append(receptionist.getAge()).append(",");
                line.append(receptionist.getGender()).append(",");
                // Write the serialized string to the file
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if writing fails
        }


        //

        //DENTAL CLINIC FILE HANDLING

        //

        // Step 1: Clear the file by opening it in write mode without appending
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DCfilePath, false))) {
            // File is cleared because we're opening in write mode (default truncates content)
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if file clearing fails
        }

        // Step 2: Write the new data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DCfilePath, true))) {
            for (Dentalclinic dentalclinic : Dentalclinics) {
                // Serialize the doctor object into a string
                StringBuilder line = new StringBuilder();
                line.append(dentalclinic.getName()).append(",");
                line.append(dentalclinic.getLocation()).append(",");
                line.append(dentalclinic.getDoctors()).append(",");
                line.append(dentalclinic.getPatients()).append(",");
                line.append(dentalclinic.getReceptionists()).append(",");
                line.append(dentalclinic.getServicePrices()).append(",");
                line.append(dentalclinic.getServices()).append(",");
                // Write the serialized string to the file
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if writing fails
        }

        //appointment code


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(APfilePath, false))) {

            for (AppointmentReservation appointment : data.Appointments) {

                    StringBuilder line = new StringBuilder();

                    if (appointment.getPatient() == null || appointment.getDoctor() == null) {
                        System.out.println("Error: Found an invalid appointment with missing data.");
                        continue; // Skip invalid appointments
                    }

                    line.append(appointment.getPatient()).append(",");
                    line.append(appointment.getDoctor()).append(",");
                    line.append(appointment.getDay()).append(",");
                    line.append(appointment.getTimeSlot());
                    writer.write(line.toString());
                    writer.newLine();

            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //pres
// Step 1: Clear the file by opening it in write mode without appending
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRfilePath, false))) {
            // File is cleared because we're opening in write mode (default truncates content)
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if file clearing fails
        }

// Step 2: Write the new data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRfilePath, true))) {
            for (Prescription prescription : Prescriptions) {
                // Serialize the prescription object into a string
                StringBuilder line = new StringBuilder();
                line.append(prescription.getMedicineName()).append(",");
                line.append(prescription.getDosage()).append(",");
                line.append(prescription.getFrequency()).append(",");
                line.append(prescription.getDoctor().getUsername()).append(",");
                line.append(prescription.getPatient().getUsername()).append(",");
                line.append(prescription.getDate()); // Assume date is stored as a string

                // Write the serialized string to the file
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false if writing fails
        }
        return false; // Successfully cleared and wrote new data
    }
}