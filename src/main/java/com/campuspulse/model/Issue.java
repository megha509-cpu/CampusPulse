package com.campuspulse.model;

public class Issue {

    private int id;
    private String studentName;
    private String category;
    private String description;
    private String location;
    private String status;
    private String priority;

    public Issue() {
    }

    public Issue(int id, String studentName, String category,
                 String description, String location,
                 String status, String priority) {

        this.id = id;
        this.studentName = studentName;
        this.category = category;
        this.description = description;
        this.location = location;
        this.status = status;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}