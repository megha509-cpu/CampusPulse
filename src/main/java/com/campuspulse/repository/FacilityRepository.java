package com.campuspulse.repository;

import com.campuspulse.model.Facility;
import com.campuspulse.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository {

    public void addFacility(Facility facility) {
        String sql = "INSERT INTO facilities " +
                "(facility_name, location, status, maintenance_date, description) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, facility.getFacilityName());
            statement.setString(2, facility.getLocation());
            statement.setString(3, facility.getStatus());

            if (facility.getMaintenanceDate() == null ||
                    facility.getMaintenanceDate().isEmpty()) {
                statement.setNull(4, java.sql.Types.DATE);
            } else {
                statement.setDate(4, Date.valueOf(facility.getMaintenanceDate()));
            }

            statement.setString(5, facility.getDescription());

            statement.executeUpdate();

            System.out.println("Facility added successfully.");

        } catch (Exception e) {
            System.out.println("Error adding facility: " + e.getMessage());
        }
    }

    public List<Facility> getAllFacilities() {
        List<Facility> facilities = new ArrayList<>();

        String sql = "SELECT * FROM facilities";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                String maintenanceDate = null;

                if (resultSet.getDate("maintenance_date") != null) {
                    maintenanceDate =
                            resultSet.getDate("maintenance_date").toString();
                }

                Facility facility = new Facility(
                        resultSet.getInt("id"),
                        resultSet.getString("facility_name"),
                        resultSet.getString("location"),
                        resultSet.getString("status"),
                        maintenanceDate,
                        resultSet.getString("description")
                );

                facilities.add(facility);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving facilities: " + e.getMessage());
        }

        return facilities;
    }

    public void updateFacilityStatus(int id, String status) {
        String sql = "UPDATE facilities SET status = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, status);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Facility status updated successfully.");
            } else {
                System.out.println("Facility not found.");
            }

        } catch (Exception e) {
            System.out.println("Error updating facility: " + e.getMessage());
        }
    }

    public void deleteFacility(int id) {
        String sql = "DELETE FROM facilities WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Facility deleted successfully.");
            } else {
                System.out.println("Facility not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting facility: " + e.getMessage());
        }
    }
}