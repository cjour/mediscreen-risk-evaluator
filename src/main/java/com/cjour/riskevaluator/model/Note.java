package com.cjour.riskevaluator.model;

public class Note {

    private String id;
    private Integer patId;
    private String description;

    public Note() {
    }

    public Note(String id, Integer patId, String description) {
        this.id = id;
        this.patId = patId;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPatId() {
        return patId;
    }

    public void setPatId(Integer patId) {
        this.patId = patId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

