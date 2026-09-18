package com.campuspulse.repository;

import com.campuspulse.model.Mess;
import com.campuspulse.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessRepository {

    public void addMessRecord(Mess mess) {
        String sql = "INSERT INTO mess " +
                "(meal_type, meal_date, menu, rating, feedback) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, mess.getMealType());
            statement.setDate(2, Date.valueOf(mess.getMealDate()));
            statement.setString(3, mess.getMenuItem());
            statement.setDouble(4, mess.getRating());
            statement.setString(5, mess.getFeedback());

            statement.executeUpdate();

            System.out.println("Mess record added successfully.");

        } catch (Exception e) {
            System.out.println("Error adding mess record: " + e.getMessage());
        }
    }

    public List<Mess> getAllMessRecords() {
        List<Mess> records = new ArrayList<>();

        String sql = "SELECT * FROM mess";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                String mealDate = null;

                if (resultSet.getDate("meal_date") != null) {
                    mealDate = resultSet.getDate("meal_date").toString();
                }

                Mess mess = new Mess(
                        resultSet.getInt("id"),
                        resultSet.getString("meal_type"),
                        resultSet.getString("menu"),
                        mealDate,
                        resultSet.getDouble("rating"),
                        resultSet.getString("feedback")
                );

                records.add(mess);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving mess records: " + e.getMessage());
        }

        return records;
    }

    public void updateRating(int id, double rating, String feedback) {
        String sql = "UPDATE mess SET rating = ?, feedback = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, rating);
            statement.setString(2, feedback);
            statement.setInt(3, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Mess rating updated successfully.");
            } else {
                System.out.println("Mess record not found.");
            }

        } catch (Exception e) {
            System.out.println("Error updating mess rating: " + e.getMessage());
        }
    }

    public void deleteMessRecord(int id) {
        String sql = "DELETE FROM mess WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Mess record deleted successfully.");
            } else {
                System.out.println("Mess record not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting mess record: " + e.getMessage());
        }
    }
}