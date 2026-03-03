package com.petkingdom.model;

public class ActionLog {
    private String description;
    private String type;
    private Object data;

    public ActionLog(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Nội dung: " + description;
    }
}