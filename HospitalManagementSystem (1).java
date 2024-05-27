package HospitalManagementSystem;

import java.lang.annotation.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface PatientClass {
}

@PatientClass
class Patient {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String medicalHistory;

    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + "Medical History:"
                + medicalHistory;
    }

    public Patient() {
        this.id = "";
        this.name = "";
        this.age = 0;
        this.gender = "";
        this.medicalHistory = "";
    }

    public void registerPatient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patient ID: ");
        this.id = scanner.nextLine();

        System.out.println("Enter patient name: ");
        this.name = scanner.nextLine();

        System.out.println("Enter patient age: ");
        this.age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter patient gender: ");
        this.gender = scanner.nextLine();

        System.out.println("Enter patient medical history: ");
        this.medicalHistory = scanner.nextLine();
    }

    public void viewPatientDetails() {
        System.out.println("Patient ID: " + this.id);
        System.out.println("Patient Name: " + this.name);
        System.out.println("Patient Age: " + this.age);
        System.out.println("Patient Gender: " + this.gender);
        System.out.println("Patient Medical History: " + this.medicalHistory);
    }

    public void updateMedicalHistory(String medicalHistory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new medical history: ");
        this.medicalHistory = scanner.nextLine();
    }

    // Getter methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DoctorClass {
}

@DoctorClass
class Doctor {
    private String id;
    private String name;
    private String specialization;
    private String qualification;
    private int roomNumber;

    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Specialization:" + specialization + ", Qualifiaction: "
                + qualification + "Room Number:" + roomNumber;
    }

    public Doctor(String id, String name, String Specialization, String Qualification, int roomNumber) {
        this.id = id;
        this.name = name;
        this.specialization = Specialization;
        this.qualification = Qualification;
        this.roomNumber = roomNumber;
    }

    public Doctor() {
        this.id = "";
        this.name = "";
        this.specialization = "";
        this.qualification = "";
        this.roomNumber = 0;
    }

    public void addDoctor(ArrayList<Doctor> doctors) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter doctor ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter doctor name: ");
        String name = scanner.nextLine();

        System.out.println("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        System.out.println("Enter doctor qualification: ");
        String qualification = scanner.nextLine();

        System.out.println("Enter doctor room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization, qualification, roomNumber);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("D001", "Ram", "Cardiology", "MBBS", 101));
        doctors.add(new Doctor("D002", "Charan", "Neurology", "PhD", 102));
        doctors.add(new Doctor("D003", "Nitish", "Oncology", "MBBS", 103));
        return doctors;
    }

    public void listDoctors(List<Doctor> doctors) {
        if (doctors.isEmpty()) {
            System.out.println("There are no doctors in the system.");
        } else {
            System.out.println("List of doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    public void viewDoctorDetails() {
        System.out.println("Doctor ID: " + this.id);
        System.out.println("Doctor Name: " + this.name);
        System.out.println("Doctor Specialization: " + this.specialization);
        System.out.println("Doctor Qualification: " + this.qualification);
        System.out.println("Doctor Room Number: " + this.roomNumber);
    }

    // Getter methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface AppointmentClass {
}

@AppointmentClass
class Appointment {

    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime appointmentDateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = appointmentDateTime;
    }

    public void viewAppointmentDetails() {
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Doctor Name: " + doctor.getName());
        System.out.println("Appointment Date and Time: "
                + appointmentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }

    // Getter methods

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface HospitalClass {
}

@HospitalClass
class Hospital {
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public Hospital() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void addPatient() {
        Patient patient = new Patient();
        patient.registerPatient();
        patients.add(patient);
        System.out.println("Patient registered successfully!");
    }

    public void addDoctor() {
        Doctor doctor = new Doctor();
        doctor.addDoctor(doctors);
        System.out.println("Doctor added successfully!");
    }

    public void showAllDoctors() {
        Doctor doctor = new Doctor();
        List<Doctor> doctors = doctor.getAllDoctors();
        doctor.listDoctors(doctors);
    }

    public void scheduleAppointment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patient ID: ");
        String patientId = scanner.nextLine();
        System.out.println("Enter doctor ID: ");
        String doctorId = scanner.nextLine();
        System.out.println("Enter date and time of appointment (yyyy-MM-d HH:mm:ss): ");
        String dateTime = scanner.nextLine();
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId,doctors);

        if (patient == null || doctor == null) {
            System.out.println("Invalid patient or doctor ID!");
            return;
        }
        LocalDateTime appointmentDateTime = LocalDateTime.parse(dateTime,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Appointment appointment = new Appointment(patient, doctor, appointmentDateTime);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully!");
    }

    public void viewPatientDetails(String patientId) {
        Patient patient = findPatientById(patientId);

        if (patient == null) {
            System.out.println("Invalid patient ID!");
            return;
        }
        System.out.println("Patient details:");
        System.out.println(patient.toString());
    }

    public void viewDoctorDetails(String doctorId) {
        Doctor doctor = new Doctor();
        List<Doctor> doctors = doctor.getAllDoctors();
        Doctor founddoctor = findDoctorById(doctorId, doctors);

        if (founddoctor == null) {
            System.out.println("Invalid doctor ID!");
            return;
        }

        System.out.println("Doctor details:");
        System.out.println(doctor.toString());
    }

    

    public void viewAppointmentDetails(String patientId, String doctorId) {
        ArrayList<Appointment> matchingAppointments = new ArrayList<>();

        for (Appointment appointment : appointments) {
            Patient patient = appointment.getPatient();
            Doctor doctor = appointment.getDoctor();

            if (patient.getId().equals(patientId) && doctor.getId().equals(doctorId)) {
                matchingAppointments.add(appointment);
            }
        }

        if (matchingAppointments.isEmpty()) {
            System.out.println("No matching appointments found!");
        } else {
            System.out.println("Matching appointments:");
            for (Appointment appointment : matchingAppointments) {
                System.out.println(appointment.toString());
            }
        }
    }

    public void updatePatientMedicalHistory(String patientId) {
        Patient patient = findPatientById(patientId);

        if (patient == null) {
            System.out.println("Invalid patient ID!");
            return;
        }

        System.out.println("Enter new medical history:");
        String medicalHistory = new Scanner(System.in).nextLine();
        patient.updateMedicalHistory(medicalHistory);
        System.out.println("Patient medical history updated successfully!");
    }

    private Patient findPatientById(String Id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(Id)) {
                return patient;
            }
        }
        return null;
    }

    private Doctor findDoctorById(String Id, List<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(Id)) {
                return doctor;
            }
            
        }
        return null;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MainClass {
}

@MainClass
public class HospitalManagementSystem {
    public static void main(String[] args) {

        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Register patient");
            System.out.println("2. Add a new doctor");
            System.out.println("3. See All doctors in this hospital for more information");
            System.out.println("4. Schedule appointment");
            System.out.println("5. View patient details");
            System.out.println("6. View doctor details");
            System.out.println("7. View appointment details");
            System.out.println("8. Update patient medical history");
            System.out.println("9. Exit");
            System.out.println("Enter your choice what you want to do:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hospital.addPatient();
                    break;
                case 2:
                    hospital.addDoctor();
                    break;
                case 3:
                    hospital.showAllDoctors();
                    break;
                case 4:
                    hospital.scheduleAppointment();
                    break;
                case 5:
                    System.out.println("Enter patient ID: ");
                    String patientId = scanner.nextLine();
                    hospital.viewPatientDetails(patientId);
                    break;
                case 6:
                    System.out.println("Enter doctor ID: ");
                    String doctorId = scanner.nextLine();
                    hospital.viewDoctorDetails(doctorId);
                    break;
                case 7:
                    System.out.println("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.println("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    hospital.viewAppointmentDetails(patientName, doctorName);
                    break;
                case 8:
                    System.out.println("Enter patient ID: ");
                    String id = scanner.nextLine();
                    hospital.updatePatientMedicalHistory(id);
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }
}
