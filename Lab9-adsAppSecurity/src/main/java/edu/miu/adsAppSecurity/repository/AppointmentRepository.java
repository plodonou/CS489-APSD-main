package edu.miu.adsAppSecurity.repository;

import edu.miu.adsAppSecurity.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
