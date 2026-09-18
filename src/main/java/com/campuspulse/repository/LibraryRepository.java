package com.campuspulse.repository;

import com.campuspulse.model.Library;
import com.campuspulse.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {

    public void addBookIssue(Library library) {
        String sql = "INSERT INTO `library` " +
                "(book_title, author, student_name, issue_date, return_date, status) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, library.getBookTitle());
            statement.setString(2, library.getAuthor());
            statement.setString(3, library.getStudentName());

            if (library.getIssueDate() == null ||
                    library.getIssueDate().isEmpty()) {
                statement.setNull(4, java.sql.Types.DATE);
            } else {
                statement.setDate(4, Date.valueOf(library.getIssueDate()));
            }

            if (library.getReturnDate() == null ||
                    library.getReturnDate().isEmpty()) {
                statement.setNull(5, java.sql.Types.DATE);
            } else {
                statement.setDate(5, Date.valueOf(library.getReturnDate()));
            }

            statement.setString(6, library.getStatus());

            statement.executeUpdate();

            System.out.println("Library record added successfully.");

        } catch (Exception e) {
            System.out.println("Error adding library record: " + e.getMessage());
        }
    }

    public List<Library> getAllRecords() {
        List<Library> records = new ArrayList<>();

        String sql = "SELECT * FROM `library`";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                String issueDate = null;
                String returnDate = null;

                if (resultSet.getDate("issue_date") != null) {
                    issueDate = resultSet.getDate("issue_date").toString();
                }

                if (resultSet.getDate("return_date") != null) {
                    returnDate = resultSet.getDate("return_date").toString();
                }

                Library library = new Library(
                        resultSet.getInt("id"),
                        resultSet.getString("book_title"),
                        resultSet.getString("author"),
                        resultSet.getString("student_name"),
                        issueDate,
                        returnDate,
                        resultSet.getString("status")
                );

                records.add(library);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving library records: " + e.getMessage());
        }

        return records;
    }

    public void returnBook(int id, String returnDate) {
        String sql = "UPDATE `library` " +
                "SET status = 'Returned', return_date = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, Date.valueOf(returnDate));
            statement.setInt(2, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Library record not found.");
            }

        } catch (Exception e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    }

    public void deleteRecord(int id) {
        String sql = "DELETE FROM `library` WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Library record deleted successfully.");
            } else {
                System.out.println("Library record not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting library record: " + e.getMessage());
        }
    }
}