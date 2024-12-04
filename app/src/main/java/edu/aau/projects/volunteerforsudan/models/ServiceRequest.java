package edu.aau.projects.volunteerforsudan.models;

import java.io.Serializable;

public class ServiceRequest implements Serializable {
    private int id;
    private String type;
    private String description;
    private String volunteer;
    private String location;
    private double amount;
    private String date;

    private int helpers;// in case volunteer wanted some help from people

    public ServiceRequest() {
    }

    public ServiceRequest(String type, String volunteer, String location, double amount, String date) {
        this.type = type;
        this.volunteer = volunteer;
        this.location = location;
        this.amount = amount;
        this.date = date;
    }

    public ServiceRequest(String type, int helpers, String description, String volunteer, String location, double amount, String date) {
        this.type = type;
        this.description = description;
        this.volunteer = volunteer;
        this.location = location;
        this.amount = amount;
        this.date = date;
        this.helpers = helpers;
    }

    public int getHelpers() {
        return helpers;
    }

    public void setHelpers(int helpers) {
        this.helpers = helpers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
        this.volunteer = volunteer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
