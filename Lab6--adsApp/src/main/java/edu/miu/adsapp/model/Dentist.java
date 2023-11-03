package edu.miu.adsapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;

    public Dentist(Integer dentistId, String firstName, String lastName) {
        this.dentistId = dentistId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "dentistId=" + dentistId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
