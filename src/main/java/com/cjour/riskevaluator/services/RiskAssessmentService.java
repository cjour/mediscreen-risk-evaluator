package com.cjour.riskevaluator.services;

import com.cjour.riskevaluator.exception.NoNoteForThisID;
import com.cjour.riskevaluator.exception.NoNoteFoundForThisFamilyName;
import com.cjour.riskevaluator.interfaces.INote;
import com.cjour.riskevaluator.interfaces.IPatient;
import com.cjour.riskevaluator.model.Note;
import com.cjour.riskevaluator.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskAssessmentService {

    enum RISK {
        None,
        Borderline,
        InDanger,
        EarlyOnset;
    }

    @Autowired
    private IPatient IPatient;

    @Autowired
    private INote Inote;

    public String evaluateRiskById(Integer id) throws Exception {
        List<Note> notes = Inote.getNotesForId(id).getBody();
        if (notes == null || notes.isEmpty()) {
            throw new NoNoteForThisID(id);
        }
        List<String[]> splitedDescription = splitNoteDescriptionIntoWord(notes);
        int score = this.evaluateRiskAsIntValue(splitedDescription);
        return evaluateRiskAsRiskLevel(score);
    }

    public String evaluateRiskByFamilyName(String familyName) throws NoNoteFoundForThisFamilyName {
        List<Note> notes = this.getNotesForFamilyName(familyName);
        if (notes == null || notes.isEmpty()) {
            throw new NoNoteFoundForThisFamilyName(familyName);
        }
        List<String[]> splitedDescription = this.splitNoteDescriptionIntoWord(notes);
        int score = this.evaluateRiskAsIntValue(splitedDescription);

        return evaluateRiskAsRiskLevel(score);
    }

    private String evaluateRiskAsRiskLevel(int score) {
        if (score < 2 ) {
            return RISK.None.toString();
        } else {
            return RISK.Borderline.toString();
        }
    }

    private int evaluateRiskAsIntValue(List<String[]> words) {
        int score = 0;
        for (int i=0; i < words.size(); i++) {
            String[] actualWordArray = words.get(i);
            for (String string: actualWordArray) {
                switch(string) {
                    case "Hémoglobine A1C":

                    case "Anticorps":

                    case "Réaction":

                    case "Rechute":

                    case "Vertige":

                    case "Cholestérol":

                    case "Anormal":

                    case "Fumeur":

                    case "Poids":

                    case "Taille":

                    case "Microalbumine":
                        score ++;
                        break;
                }
            }
        }
        return score;
    }

    private List<String[]> splitNoteDescriptionIntoWord(List<Note> notes) {
        List<String[]> listOfDescriptionAsWord = new ArrayList<>();
        for (Note note : notes) {
            String noteDescription = note.getDescription();
            String[] noteDescriptionAsWord = noteDescription.split(" ");
            listOfDescriptionAsWord.add(noteDescriptionAsWord);
        }
        return listOfDescriptionAsWord;
    }

    private List<Note> getNotesForFamilyName(String familyName) {
        Integer id = null;
        List<Patient> listOfAllPatient = this.getListOfAllPatient().getBody();
        if(listOfAllPatient != null) {
            for (Patient patient : listOfAllPatient) {
                if (patient.getFirstname().equals(familyName)) {
                    id = patient.getId();
                }
            }
        }
        return Inote.getNotesForId(id).getBody();
    }

    private ResponseEntity<List<Patient>> getListOfAllPatient() {
        return IPatient.getAllPatient();
    }
}
