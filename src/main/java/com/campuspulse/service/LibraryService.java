package com.campuspulse.service;

import com.campuspulse.model.Library;
import com.campuspulse.repository.LibraryRepository;

import java.time.LocalDate;
import java.util.List;

public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService() {
        this.libraryRepository = new LibraryRepository();
    }

    public void issueBook(Library library) {
        if (library == null) {
            System.out.println("Library information cannot be empty.");
            return;
        }

        if (library.getBookTitle() == null ||
                library.getBookTitle().trim().isEmpty()) {
            System.out.println("Book title is required.");
            return;
        }

        if (library.getAuthor() == null ||
                library.getAuthor().trim().isEmpty()) {
            System.out.println("Author name is required.");
            return;
        }

        if (library.getStudentName() == null ||
                library.getStudentName().trim().isEmpty()) {
            System.out.println("Student name is required.");
            return;
        }

        if (library.getIssueDate() == null ||
                library.getIssueDate().trim().isEmpty()) {
            library.setIssueDate(LocalDate.now().toString());
        }

        if (library.getStatus() == null ||
                library.getStatus().trim().isEmpty()) {
            library.setStatus("Issued");
        }

        libraryRepository.addBookIssue(library);
    }

    public List<Library> getAllRecords() {
        return libraryRepository.getAllRecords();
    }

    public void returnBook(int id, String returnDate) {
        if (id <= 0) {
            System.out.println("Invalid library record ID.");
            return;
        }

        if (returnDate == null || returnDate.trim().isEmpty()) {
            returnDate = LocalDate.now().toString();
        }

        libraryRepository.returnBook(id, returnDate);
    }

    public void deleteRecord(int id) {
        if (id <= 0) {
            System.out.println("Invalid library record ID.");
            return;
        }

        libraryRepository.deleteRecord(id);
    }
}