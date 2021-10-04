package com.cjour.riskevaluator.exception;

public class NoNoteForThisID extends Exception {

    public NoNoteForThisID(Integer id) {
        super("No notes found for this ID : " + String.valueOf(id));
    }
}
