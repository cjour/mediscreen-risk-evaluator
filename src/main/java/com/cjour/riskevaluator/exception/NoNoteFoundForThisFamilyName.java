package com.cjour.riskevaluator.exception;

public class NoNoteFoundForThisFamilyName extends Exception {

    public NoNoteFoundForThisFamilyName(String familyName) {
        super("No notes found for this ID : " + familyName);
    }

}
