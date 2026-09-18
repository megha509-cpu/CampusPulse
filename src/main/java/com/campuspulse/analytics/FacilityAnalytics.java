package com.campuspulse.analytics;

import com.campuspulse.model.Facility;
import com.campuspulse.service.FacilityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityAnalytics {

    private final FacilityService facilityService;

    public FacilityAnalytics() {
        this.facilityService = new FacilityService();
    }

    public void showFacilitySummary() {
        List<Facility> facilities =
                facilityService.getAllFacilities();

        if (facilities.isEmpty()) {
            System.out.println("No facility data available.");
            return;
        }

        Map<String, Integer> statusCount = new HashMap<>();

        for (Facility facility : facilities) {
            String status = facility.getStatus();

            if (status != null && !status.trim().isEmpty()) {
                statusCount.put(
                        status,
                        statusCount.getOrDefault(status, 0) + 1
                );
            }
        }

        System.out.println("\n========== FACILITY ANALYTICS ==========");
        System.out.println("Total Facilities: " + facilities.size());

        System.out.println("\nFacilities by Status:");

        for (Map.Entry<String, Integer> entry : statusCount.entrySet()) {
            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }

        System.out.println("========================================");
    }
}