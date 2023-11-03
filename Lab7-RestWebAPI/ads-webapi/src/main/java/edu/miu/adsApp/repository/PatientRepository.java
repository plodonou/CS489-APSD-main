package edu.miu.adsApp.repository;

import edu.miu.adsApp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "select p from Patient p")
    public List<Patient> getMyCustomListOfPatient();

    //error
//    @Query(value = "select p from Patient p where p.firstName = :firstName")
//    public Optional<Patient> getMyCustomPatientByName(String firstName, String lastName);

    @Query(value = "SELECT * FROM `dental-surgeries-appointments-db`.patient p where p.first_name like 'Ji%'",nativeQuery = true)
    public Optional<Patient> getMyNativeCustomPatientByName(String firstName, String lastName);


    // Using Query methods
//    public List<Patient> findPatientByFirstNameIsStartingWith(String strFirstNameStart);

//    public default List<Patient> findPatientsByFirstNameContainingOrPrimaryAddress_CityContaining(
//            String firstName
//    ) {
//        return null;
//    }

    public List<Patient> findPatientsByFirstNameContainingOrPrimaryAddress_CityContaining (
            String firstName, String city
    );
}
