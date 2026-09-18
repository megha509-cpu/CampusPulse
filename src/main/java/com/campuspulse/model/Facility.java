package com.campuspulse.model;

public class Facility {

    private int id;
    private String facilityName;
    private String location;
    private String status;
    private String maintenanceDate;
    private String description;

    public Facility() {
    }

    public Facility(int id, String facilityName, String location,
                    String status, String maintenanceDate,
                    String description) {
        this.id = id;
        this.facilityName = facilityName;
        this.location = location;
        this.status = status;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
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

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id=" + id +
                ", facilityName='" + facilityName + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", maintenanceDate='" + maintenanceDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}