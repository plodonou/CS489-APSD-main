package edu.miu.adsApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String time;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;

    public Appointment(Integer appointmentId, LocalDate date, String time) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", date=" + date +
                ", time='" + time + '\'' +
                '}';
    }
}
