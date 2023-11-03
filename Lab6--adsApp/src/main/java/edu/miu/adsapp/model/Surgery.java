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
//@Table(name = "surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryId;
    private String surgeryNo;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address primaryAddress;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;

    public Surgery(Integer surgeryId, String surgeryNo, Address primaryAddress) {
        this.surgeryId = surgeryId;
        this.surgeryNo = surgeryNo;
        this.primaryAddress = primaryAddress;
    }

    @Override
    public String toString() {
        return "Surgery{" +
                "surgeryId=" + surgeryId +
                ", surgeryNo='" + surgeryNo + '\'' +
                ", primaryAddress=" + primaryAddress +
                '}';
    }
}
