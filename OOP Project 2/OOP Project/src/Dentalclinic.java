public class Dentalclinic {
    private String name;
    private String location;
    private String[] services; // Array to hold services offered by the clinic
    private float[] servicePrices; // Array to hold the prices of the services
    private Doctor[] doctors; // Array to hold doctors at the clinic
    private Patient[] patients; // Array to hold patients of the clinic
    private Receptionist[] receptionists; // Array to hold receptionists of the clinic

    public Dentalclinic(String name, String location, String listOfDoctors, String listOfPatients, String prices, String service) {
    }

    //name,location,list of doctors,list of patients, list of receptionist ,prices, service
    // Getter methods
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String[] getServices() {
        return services;
    }

    public float[] getServicePrices() {
        return servicePrices;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public Receptionist[] getReceptionists() {
        return receptionists;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    public void setServicePrices(float[] servicePrices) {
        this.servicePrices = servicePrices;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public void setReceptionists(Receptionist[] receptionists) {
        this.receptionists = receptionists;
    }

    // Method to add a doctor to the clinic
    public void addDoctor(Doctor doctor) {
        for (int i = 0; i < doctors.length; i++) {
            if (doctors[i] == null) {
                doctors[i] = doctor;
                break;
            }
        }
    }

    // Method to add a patient to the clinic
    public void addPatient(Patient patient) {
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] == null) {
                patients[i] = patient;
                break;
            }
        }
    }

    // Method to add a receptionist to the clinic
    public void addReceptionist(Receptionist receptionist) {
        for (int i = 0; i < receptionists.length; i++) {
            if (receptionists[i] == null) {
                receptionists[i] = receptionist;
                break;
            }
        }
    }

    // Display all services with prices
    public void displayServicesAndPrices() {
        System.out.println("Services offered by " + name + ":");
        for (int i = 0; i < services.length; i++) {
            if (services[i] != null && servicePrices[i] != 0) {
                System.out.println(services[i] + " - $" + servicePrices[i]);
            }
        }
    }

    @Override
    public String toString() {
        return "DentalClinic{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
