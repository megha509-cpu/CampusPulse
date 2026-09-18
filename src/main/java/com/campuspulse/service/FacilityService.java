package com.campuspulse.service;

import com.campuspulse.model.Facility;
import com.campuspulse.repository.FacilityRepository;

import java.util.List;

public class FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityService() {
        this.facilityRepository = new FacilityRepository();
    }

    public void addFacility(Facility facility) {
        if (facility == null) {
            System.out.println("Facility information cannot be empty.");
            return;
        }

        if (facility.getFacilityName() == null ||
                facility.getFacilityName().trim().isEmpty()) {
            System.out.println("Facility name is required.");
            return;
        }

        if (facility.getLocation() == null ||
                facility.getLocation().trim().isEmpty()) {
            System.out.println("Facility location is required.");
            return;
        }

        if (facility.getStatus() == null ||
                facility.getStatus().trim().isEmpty()) {
            facility.setStatus("Available");
        }

        facilityRepository.addFacility(facility);
    }

    public List<Facility> getAllFacilities() {
        return facilityRepository.getAllFacilities();
    }

    public void updateFacilityStatus(int id, String status) {
        if (id <= 0) {
            System.out.println("Invalid facility ID.");
            return;
        }

        if (status == null || status.trim().isEmpty()) {
            System.out.println("Status cannot be empty.");
            return;
        }

        facilityRepository.updateFacilityStatus(id, status);
    }

    public void deleteFacility(int id) {
        if (id <= 0) {
            System.out.println("Invalid facility ID.");
            return;
        }

        facilityRepository.deleteFacility(id);
    }
}