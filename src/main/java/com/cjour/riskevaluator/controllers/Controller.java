package com.cjour.riskevaluator.controllers;

import com.cjour.riskevaluator.exception.NoNoteFoundForThisFamilyName;
import com.cjour.riskevaluator.model.Note;
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
    public String evaluateRisk(@PathVariable Integer id) throws Exception {
        return riskAssessmentService.evaluateRiskById(id);
    }

    @GetMapping("/assess/familyName/{familyName}")
    public String evaluateRisk(@PathVariable String familyName) throws NoNoteFoundForThisFamilyName {
        return riskAssessmentService.evaluateRiskByFamilyName(familyName);
    }
}
