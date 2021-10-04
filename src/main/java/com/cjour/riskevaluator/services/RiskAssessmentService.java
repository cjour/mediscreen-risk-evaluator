package com.cjour.riskevaluator.services;

import com.cjour.riskevaluator.interfaces.INote;
import com.cjour.riskevaluator.interfaces.IPatient;
import com.cjour.riskevaluator.model.Note;
import com.cjour.riskevaluator.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssessmentService {

    @Autowired
    private IPatient IPatient;

    @Autowired
    private INote Inote;

    public ResponseEntity<List<Note>> evaluateRiskById(Integer id) {
        List<Note> notes = Inote.getNotesForId(id).getBody();

        return null;
    }

    public ResponseEntity<List<Note>> evaluateRiskByFamilyName(String familyName) {
        List<Note> notes = this.getNotesForFamilyName(familyName);

        return null;
    }

    private String readNotes(List<Note> notes) {
        for (Note note : notes) {
            //lire la description et utiliser un switch case de la mort qui permet de
            //déterminer si les mots clés sont trouvés.
        }

        return null;
    }



    private List<Note> getNotesForFamilyName(String familyName) {
        Integer id = null;
        List<Patient> listOfAllPatient = this.listOfAllPatient().getBody();
        if(listOfAllPatient != null) {
            for (Patient patient : listOfAllPatient) {
                if (patient.getFirstname().equals(familyName)) {
                    id = patient.getId();
                }
            }
        }
        return Inote.getNotesForId(id).getBody();
    }

    private ResponseEntity<List<Patient>> listOfAllPatient() {
        return IPatient.getAllPatient();
    }
}
