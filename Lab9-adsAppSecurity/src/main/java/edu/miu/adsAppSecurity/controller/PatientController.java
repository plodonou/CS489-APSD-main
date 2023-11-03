package edu.miu.adsAppSecurity.controller;

import edu.miu.adsAppSecurity.dto.patient.PatientResponse;
import edu.miu.adsAppSecurity.exception.PatientNotFoundException;
import edu.miu.adsAppSecurity.model.Patient;
import edu.miu.adsAppSecurity.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsApp/api/v1/patient" )
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

//    @GetMapping(value = "/adsApp/api/v1/patient/list")
//    public List<PatientResponse> listPatients() {
//        return patientService.getAllPatients();
//    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<PatientResponse>> listPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    //send patientId as Query Parameter
//    @GetMapping(value = "/adsApp/api/v1/patient/?patientId={patientId}")
//    public ResponseEntity<Patient> getPatientById(Integer patientId) {
//
//    }

    //send patientId as Path Variable
    @GetMapping(value = "/get/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer patientId) throws PatientNotFoundException {
        return ResponseEntity.ok(patientService.getPatientId(patientId));
    }

    @PostMapping(value = "/register") //@PostMapping(value = "/new")
    public ResponseEntity<Patient> registerNewPatient(@Valid @RequestBody Patient newPatient) {
        return new ResponseEntity<>(patientService.addNewPatient(newPatient), HttpStatus.CREATED);
    }

    @PutMapping(value =  "/update/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer patientId, @RequestBody Patient editedPatient) {
        return new ResponseEntity<>(patientService.updatePatient(patientId, editedPatient), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer patientId) {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatient(@PathVariable String searchString) {
        return ResponseEntity.ok(patientService.searchPatient(searchString));
    }

}
