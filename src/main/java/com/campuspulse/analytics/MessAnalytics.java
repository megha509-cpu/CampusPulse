package com.campuspulse.analytics;

import com.campuspulse.model.Mess;
import com.campuspulse.service.MessService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessAnalytics {

    private final MessService messService;

    public MessAnalytics() {
        this.messService = new MessService();
    }

    public void showMessSummary() {
        List<Mess> records = messService.getAllMessRecords();

        if (records.isEmpty()) {
            System.out.println("No mess data available.");
            return;
        }

        double totalRating = 0;
        int ratedMeals = 0;

        Map<String, Integer> mealCount = new HashMap<>();
        Map<String, Double> mealRatings = new HashMap<>();

        for (Mess mess : records) {
            String mealType = mess.getMealType();

            if (mealType != null && !mealType.trim().isEmpty()) {
                mealCount.put(
                        mealType,
                        mealCount.getOrDefault(mealType, 0) + 1
                );

                mealRatings.put(
                        mealType,
                        mealRatings.getOrDefault(mealType, 0.0)
                                + mess.getRating()
                );
            }

            if (mess.getRating() > 0) {
                totalRating += mess.getRating();
                ratedMeals++;
            }
        }

        double averageRating = ratedMeals > 0
                ? totalRating / ratedMeals
                : 0;

        System.out.println("\n========== MESS ANALYTICS ==========");
        System.out.println("Total Records : " + records.size());
        System.out.printf("Average Rating: %.2f / 5%n", averageRating);

        System.out.println("\nMeals by Type:");

        for (Map.Entry<String, Integer> entry : mealCount.entrySet()) {
            String mealType = entry.getKey();
            int count = entry.getValue();

            double averageMealRating =
                    mealRatings.get(mealType) / count;

            System.out.printf(
                    "%s : %d records, Average Rating: %.2f%n",
                    mealType,
                    count,
                    averageMealRating
            );
        }

        System.out.println("====================================");
    }
}