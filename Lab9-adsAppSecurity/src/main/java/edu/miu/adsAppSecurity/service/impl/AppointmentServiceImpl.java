package edu.miu.adsAppSecurity.service.impl;

import edu.miu.adsAppSecurity.model.Appointment;
import edu.miu.adsAppSecurity.repository.AppointmentRepository;
import edu.miu.adsAppSecurity.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment addNewAppointment(Appointment newAppointment) {
        return appointmentRepository.save(newAppointment);
    }

    @Override
    public Appointment getAppointmentId(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElse(null);
    }


}
