package edu.miu.adsAppSecurity.service;

import edu.miu.adsAppSecurity.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointment();

    Appointment addNewAppointment(Appointment newAppointment);

    Appointment getAppointmentId(Integer appointmentId);

}
