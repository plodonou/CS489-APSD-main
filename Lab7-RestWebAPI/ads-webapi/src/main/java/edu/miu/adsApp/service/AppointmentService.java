package edu.miu.adsApp.service;

import edu.miu.adsApp.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointment();

    Appointment addNewAppointment(Appointment newAppointment);

    Appointment getAppointmentId(Integer appointmentId);

}
