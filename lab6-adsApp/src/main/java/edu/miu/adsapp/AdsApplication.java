package edu.miu.adsapp;

import edu.miu.adsapp.model.Address;
import edu.miu.adsapp.model.Appointment;
import edu.miu.adsapp.model.Patient;
import edu.miu.adsapp.model.Surgery;
import edu.miu.adsapp.service.*;
import edu.miu.adsapp.service.SurgeryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AdsApplication implements CommandLineRunner {

    private final PatientService patientService;
    private final AddressService addressService;
    private final DentistService dentistService;

    private final SurgeryService surgeryService;
    private final AppointmentService appointmentService;

    public AdsApplication(PatientService patientService, AddressService addressService, DentistService dentistService, SurgeryService surgeryService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.addressService = addressService;
        this.dentistService = dentistService;
        this.surgeryService = surgeryService;
        this.appointmentService = appointmentService;
    }

    public static void main(String[] args) {

        SpringApplication.run(AdsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Data Persistence using Spring Data JPA");

      //  Create new Patient with Address
//        System.out.println("Creating new Patient with Address");
//        var savedPatient = addNewPatient("John", "Walker");
//        System.out.println("The Patient added");
//        System.out.println(savedPatient);

//        System.out.println("Creating new Patient with new Address");
//        var burnoAddress = new Address(null, "8th Street", "Denver", "Colorado", "80249");
//        var savedBurno = addNewPatientAndAddress("Burno", "Fernandez", burnoAddress);
//        System.out.println(savedBurno);

//        printAllPatients();

//        System.out.println("Add new Dentist");
//        var savedDentist = addNewDentist("Robin", "Plevin");
//        System.out.println(savedDentist);

//        System.out.println("Add new Surgery");
//        var savedSurgery = addNewSurgery("P100", new Address());
//        System.out.println(savedSurgery);

//        System.out.println("Add new Appointment");
//        var savedAppointment = addNewAppointment(LocalDate.of(2013,9,15 ),"18.00" );
//        System.out.println(savedAppointment);


        var patientId = 2;
        var patientFound = getPatientById(patientId);
        if( patientFound != null) {
            //TODO
            System.out.printf("Patient with id: %d, found\n %s", patientId, patientFound);
        } else {
            System.out.printf("Error: Patient with id %d, is not found", patientId);
        }

//        var patientId = 2;
//        var patientUpdated = updatePatientById(patientId);
//        if( patientUpdated != null) {
//            //TODO
//            System.out.printf("Patient with id: %d, updated\n %s", patientId, patientUpdated);
//        } else {
//            System.out.printf("Error: Patient with id %d, is not found", patientId);
//        }

        //Delete patient by id
     //   patientService.deletePatientById(3);
//        printAllAddresses();

//        System.out.println(patientService.getPatientByFirstNameStart("Lu"));

    }

//    private Patient addNewPatient(String firstName, String lastName) {
//        var patientAdd = addNewAddress("4th Street", "Denver", "CO", "42879");
//        var newPatient = new Patient(null, firstName, lastName, patientAdd);
//        return patientService.addNewPatient(newPatient);
//    }

//    private Patient addNewPatientAndAddress(String firstName, String lastName, Address address) {
//        var burno = new Patient(null, firstName, lastName, address);
//        return patientService.addNewPatient(burno);
//    }

//    private Dentist addNewDentist(String firstName, String lastName) {
//       var newDentist = new Dentist(null, firstName, lastName);
//       return dentistService.addNewDentist(newDentist);
//    }

//    private Surgery addNewSurgery(String surgeryNo, Address address) {
//        var newSurgery = new Surgery(null, surgeryNo, address);
//        return surgeryService.addNewSurgery(newSurgery);
//    }


//        private Appointment addNewAppointment(LocalDate date, String time) {
//        var newAppointment = new Appointment(null, date, time);
//        return appointmentService.addNewAppointment(newAppointment);
//    }


//    private Address addNewAddress(String street, String city, String state, String zipCode) {
//        var mcField = new Address(null, street, city, state, zipCode, null, null);
//        return addressService.addNewAddress(mcField);
//    }

    private Patient getPatientById(Integer patientId) {
        return patientService.getPatientId(patientId);
    }
    private void printAllPatients() {
        patientService.getAllPatients()
                .forEach(System.out::println);
    }

    private Patient updatePatientById(Integer patientId) {
        var patientFound = getPatientById(patientId);
        if(patientFound != null) {
            var address = new Address(null, "3rd street", "New York", "NY", "10357");
            patientFound.setPrimaryAddress(address);
            return patientService.updatePatient(patientFound);
        } else {
            return null;
        }
    }

    private void printAllDentists() {
        dentistService.getAllDentists()
                .forEach(System.out::println);
    }

    private void printAllAddresses() {
        addressService.getAllAddresses().forEach(System.out::println);
    }
}
