package com.campuspulse.analytics;

import com.campuspulse.model.Library;
import com.campuspulse.service.LibraryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryAnalytics {

    private final LibraryService libraryService;

    public LibraryAnalytics() {
        this.libraryService = new LibraryService();
    }

    public void showLibrarySummary() {
        List<Library> records = libraryService.getAllRecords();

        if (records.isEmpty()) {
            System.out.println("No library data available.");
            return;
        }

        int issued = 0;
        int returned = 0;

        Map<String, Integer> authorCount = new HashMap<>();

        for (Library library : records) {

            if ("Issued".equalsIgnoreCase(library.getStatus())) {
                issued++;
            } else if ("Returned".equalsIgnoreCase(library.getStatus())) {
                returned++;
            }

            String author = library.getAuthor();

            if (author != null && !author.trim().isEmpty()) {
                authorCount.put(
                        author,
                        authorCount.getOrDefault(author, 0) + 1
                );
            }
        }

        System.out.println("\n========== LIBRARY ANALYTICS ==========");
        System.out.println("Total Records : " + records.size());
        System.out.println("Books Issued  : " + issued);
        System.out.println("Books Returned: " + returned);

        System.out.println("\nRecords by Author:");

        for (Map.Entry<String, Integer> entry : authorCount.entrySet()) {
            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }

        System.out.println("=======================================");
    }
}