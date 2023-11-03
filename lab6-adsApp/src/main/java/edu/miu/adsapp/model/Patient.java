package edu.miu.adsapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @Column(nullable = false)
//    @NotNull(message = "Patient Name is required and cannot be null") //new patient ("")
//    @NotEmpty(message = "Patient Name is required and cannot be null or empty string") //new patient (" ")
    @NotBlank(message = "Patient Name is required and cannot be null or empty string or blank spaces")
    private String firstName;
    private  String lastName;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    private Address primaryAddress;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(Integer patientId, String firstName, String lastName, Address primaryAddress) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryAddress = primaryAddress;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", primaryAddress=" + primaryAddress +
                '}';
    }
}
