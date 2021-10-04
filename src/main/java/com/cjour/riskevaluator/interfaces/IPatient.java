package com.cjour.riskevaluator.interfaces;

import com.cjour.riskevaluator.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value="patientClient", url = "localhost:8081")
public interface IPatient {

        @GetMapping("/")
        String welcome();

        @GetMapping("/patient/list")
        ResponseEntity<List<Patient>> getAllPatient();

        @GetMapping("/patient/{id}")
        ResponseEntity<Patient> getPatientById();

        @GetMapping("/patient/{familyName}")
        ResponseEntity<Patient> getPatientByFamilyName();
}

