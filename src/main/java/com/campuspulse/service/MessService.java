package com.campuspulse.service;

import com.campuspulse.model.Mess;
import com.campuspulse.repository.MessRepository;

import java.time.LocalDate;
import java.util.List;

public class MessService {

    private final MessRepository messRepository;

    public MessService() {
        this.messRepository = new MessRepository();
    }

    public void addMessRecord(Mess mess) {
        if (mess == null) {
            System.out.println("Mess information cannot be empty.");
            return;
        }

        if (mess.getMealType() == null ||
                mess.getMealType().trim().isEmpty()) {
            System.out.println("Meal type is required.");
            return;
        }

        if (mess.getMenuItem() == null ||
                mess.getMenuItem().trim().isEmpty()) {
            System.out.println("Menu item is required.");
            return;
        }

        if (mess.getMealDate() == null ||
                mess.getMealDate().trim().isEmpty()) {
            mess.setMealDate(LocalDate.now().toString());
        }

        if (mess.getRating() < 0 || mess.getRating() > 5) {
            System.out.println("Rating must be between 0 and 5.");
            return;
        }

        if (mess.getFeedback() == null) {
            mess.setFeedback("");
        }

        messRepository.addMessRecord(mess);
    }

    public List<Mess> getAllMessRecords() {
        return messRepository.getAllMessRecords();
    }

    public void updateRating(int id, double rating, String feedback) {
        if (id <= 0) {
            System.out.println("Invalid mess record ID.");
            return;
        }

        if (rating < 0 || rating > 5) {
            System.out.println("Rating must be between 0 and 5.");
            return;
        }

        if (feedback == null) {
            feedback = "";
        }

        messRepository.updateRating(id, rating, feedback);
    }

    public void deleteMessRecord(int id) {
        if (id <= 0) {
            System.out.println("Invalid mess record ID.");
            return;
        }

        messRepository.deleteMessRecord(id);
    }
}