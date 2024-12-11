import java.util.Date;

// Prescription Class
class Prescription {
    private String medicineName;
    private String dosage;
    private String frequency;
    private Date date;
    private Doctor doctor;
    private Patient patient;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Prescription(String medicineName, String dosage, String frequency,Patient patient, Doctor doctor, String dateStr) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.frequency = frequency;
        this.patient = patient;
        this.doctor = doctor;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", frequency='" + frequency + '\'' +
                ", date=" + date +
                ", doctor=" + doctor.getFirstName() +
                ", patient=" + patient.getFirstName() +
                '}';
    }
}
