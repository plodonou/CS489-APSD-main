package edu.miu.adsApp.repository;

import edu.miu.adsApp.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
    
    @Query(value = "select d from Dentist d")
    public List<Dentist> getMyCustomListOfDentist();

    List<Dentist> findDentistByFirstNameIsStartingWith(String firstNameStart);
}
