package com.campuspulse.repository;

import com.campuspulse.model.Issue;
import com.campuspulse.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IssueRepository {

    public void addIssue(Issue issue) {
        String sql = "INSERT INTO issues " +
                "(student_name, category, description, location, status, priority) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, issue.getStudentName());
            statement.setString(2, issue.getCategory());
            statement.setString(3, issue.getDescription());
            statement.setString(4, issue.getLocation());
            statement.setString(5, issue.getStatus());
            statement.setString(6, issue.getPriority());

            statement.executeUpdate();

            System.out.println("Issue added successfully.");

        } catch (Exception e) {
            System.out.println("Error adding issue: " + e.getMessage());
        }
    }

    public List<Issue> getAllIssues() {
        List<Issue> issues = new ArrayList<>();

        String sql = "SELECT * FROM issues";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Issue issue = new Issue(
                        resultSet.getInt("id"),
                        resultSet.getString("student_name"),
                        resultSet.getString("category"),
                        resultSet.getString("description"),
                        resultSet.getString("location"),
                        resultSet.getString("status"),
                        resultSet.getString("priority")
                );

                issues.add(issue);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving issues: " + e.getMessage());
        }

        return issues;
    }

    public void updateIssueStatus(int id, String status) {
        String sql = "UPDATE issues SET status = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, status);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Issue status updated successfully.");
            } else {
                System.out.println("Issue not found.");
            }

        } catch (Exception e) {
            System.out.println("Error updating issue: " + e.getMessage());
        }
    }

    public void deleteIssue(int id) {
        String sql = "DELETE FROM issues WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Issue deleted successfully.");
            } else {
                System.out.println("Issue not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting issue: " + e.getMessage());
        }
    }
}