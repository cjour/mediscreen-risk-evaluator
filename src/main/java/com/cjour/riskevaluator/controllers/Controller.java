package com.cjour.riskevaluator.controllers;

import com.cjour.riskevaluator.model.Note;
import com.cjour.riskevaluator.model.Patient;
import com.cjour.riskevaluator.services.RiskAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    RiskAssessmentService riskAssessmentService;

    @GetMapping("/assess/id/{id}")
    public ResponseEntity<List<Note>> evaluateRisk(@PathVariable Integer id){
        return riskAssessmentService.evaluateRiskById(id);
    }

    @GetMapping("/assess/familyName/{familyName}")
    public ResponseEntity<List<Note>> evaluateRisk(@PathVariable String familyName){
        return riskAssessmentService.evaluateRiskByFamilyName(familyName);
    }
}
