package com.campuspulse;

import com.campuspulse.model.Issue;
import com.campuspulse.model.Mess;
import com.campuspulse.model.Library;
import com.campuspulse.model.Facility;

import com.campuspulse.service.IssueService;
import com.campuspulse.service.MessService;
import com.campuspulse.service.LibraryService;
import com.campuspulse.service.FacilityService;

import com.campuspulse.analytics.IssueAnalytics;
import com.campuspulse.analytics.MessAnalytics;
import com.campuspulse.analytics.LibraryAnalytics;
import com.campuspulse.analytics.FacilityAnalytics;

import com.campuspulse.assistant.CampusAssistant;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final IssueService issueService =
            new IssueService();

    private static final MessService messService =
            new MessService();

    private static final LibraryService libraryService =
            new LibraryService();

    private static final FacilityService facilityService =
            new FacilityService();

    private static final IssueAnalytics issueAnalytics =
            new IssueAnalytics();

    private static final MessAnalytics messAnalytics =
            new MessAnalytics();

    private static final LibraryAnalytics libraryAnalytics =
            new LibraryAnalytics();

    private static final FacilityAnalytics facilityAnalytics =
            new FacilityAnalytics();

    private static final CampusAssistant campusAssistant =
            new CampusAssistant();


    public static void main(String[] args) {

        boolean running = true;

        System.out.println("======================================");
        System.out.println("           CAMPUSPULSE");
        System.out.println("   Campus Operations Platform");
        System.out.println("======================================");

        while (running) {

            showMainMenu();

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    issueMenu();
                    break;

                case "2":
                    messMenu();
                    break;

                case "3":
                    libraryMenu();
                    break;

                case "4":
                    facilityMenu();
                    break;

                case "5":
                    analyticsMenu();
                    break;

                case "6":
                    assistantMenu();
                    break;

                case "0":
                    running = false;
                    System.out.println(
                            "\nThank you for using CampusPulse!"
                    );
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }


    // ==================== MAIN MENU ====================

    private static void showMainMenu() {

        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Issue Management");
        System.out.println("2. Mess Management");
        System.out.println("3. Library Management");
        System.out.println("4. Facilities Management");
        System.out.println("5. Analytics");
        System.out.println("6. Campus Assistant");
        System.out.println("0. Exit");
        System.out.println("===============================");
        System.out.print("Enter your choice: ");
    }


    // ==================== ISSUE MANAGEMENT ====================

    private static void issueMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n====== ISSUE MANAGEMENT ======");
            System.out.println("1. Report New Issue");
            System.out.println("2. View All Issues");
            System.out.println("3. Update Issue Status");
            System.out.println("4. Delete Issue");
            System.out.println("0. Back to Main Menu");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addIssue();
                    break;

                case "2":
                    viewIssues();
                    break;

                case "3":
                    updateIssueStatus();
                    break;

                case "4":
                    deleteIssue();
                    break;

                case "0":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private static void addIssue() {

        System.out.println("\n------ REPORT NEW ISSUE ------");

        System.out.print("Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Location: ");
        String location = scanner.nextLine();

        System.out.print("Priority (Low/Medium/High): ");
        String priority = scanner.nextLine();

        Issue issue = new Issue(
                0,
                studentName,
                category,
                description,
                location,
                "Pending",
                priority
        );

        issueService.addIssue(issue);
    }


    private static void viewIssues() {

        System.out.println("\n------ ALL ISSUES ------");

        List<Issue> issues =
                issueService.getAllIssues();

        if (issues.isEmpty()) {
            System.out.println("No issues found.");
            return;
        }

        for (Issue issue : issues) {

            System.out.println("--------------------------------");
            System.out.println("ID          : " + issue.getId());
            System.out.println("Student     : " + issue.getStudentName());
            System.out.println("Category    : " + issue.getCategory());
            System.out.println("Description : " + issue.getDescription());
            System.out.println("Location    : " + issue.getLocation());
            System.out.println("Status      : " + issue.getStatus());
            System.out.println("Priority    : " + issue.getPriority());
        }

        System.out.println("--------------------------------");
    }


    private static void updateIssueStatus() {

        System.out.print("\nEnter Issue ID: ");

        int id = readInteger();

        System.out.print(
                "Enter new status (Pending/In Progress/Resolved): "
        );

        String status = scanner.nextLine();

        issueService.updateIssueStatus(
                id,
                status
        );
    }


    private static void deleteIssue() {

        System.out.print("\nEnter Issue ID to delete: ");

        int id = readInteger();

        issueService.deleteIssue(id);
    }


    // ==================== MESS MANAGEMENT ====================

    private static void messMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n========= MESS MANAGEMENT =========");
            System.out.println("1. Add Mess Record");
            System.out.println("2. View All Mess Records");
            System.out.println("3. Update Rating");
            System.out.println("4. Delete Mess Record");
            System.out.println("0. Back to Main Menu");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addMessRecord();
                    break;

                case "2":
                    viewMessRecords();
                    break;

                case "3":
                    updateMessRating();
                    break;

                case "4":
                    deleteMessRecord();
                    break;

                case "0":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private static void addMessRecord() {

        System.out.println("\n------ ADD MESS RECORD ------");

        System.out.print("Meal Type: ");
        String mealType = scanner.nextLine();

        System.out.print("Menu Item: ");
        String menuItem = scanner.nextLine();

        System.out.print("Meal Date (YYYY-MM-DD): ");
        String mealDate = scanner.nextLine();

        System.out.print("Rating (0-5): ");
        double rating = readDouble();

        System.out.print("Feedback: ");
        String feedback = scanner.nextLine();

        Mess mess = new Mess(
                0,
                mealType,
                menuItem,
                mealDate,
                rating,
                feedback
        );

        messService.addMessRecord(mess);
    }


    private static void viewMessRecords() {

        System.out.println("\n------ ALL MESS RECORDS ------");

        List<Mess> records =
                messService.getAllMessRecords();

        if (records.isEmpty()) {
            System.out.println("No mess records found.");
            return;
        }

        for (Mess mess : records) {

            System.out.println("--------------------------------");
            System.out.println("ID       : " + mess.getId());
            System.out.println("Meal     : " + mess.getMealType());
            System.out.println("Menu     : " + mess.getMenuItem());
            System.out.println("Date     : " + mess.getMealDate());
            System.out.println("Rating   : " + mess.getRating() + " / 5");
            System.out.println("Feedback : " + mess.getFeedback());
        }

        System.out.println("--------------------------------");
    }


    private static void updateMessRating() {

        System.out.print("\nEnter Mess Record ID: ");

        int id = readInteger();

        System.out.print("Enter new rating (0-5): ");

        double rating = readDouble();

        System.out.print("Enter feedback: ");

        String feedback = scanner.nextLine();

        messService.updateRating(
                id,
                rating,
                feedback
        );
    }


    private static void deleteMessRecord() {

        System.out.print("\nEnter Mess Record ID to delete: ");

        int id = readInteger();

        messService.deleteMessRecord(id);
    }
    
 // ==================== LIBRARY MANAGEMENT ====================

    private static void libraryMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n======= LIBRARY MANAGEMENT =======");
            System.out.println("1. Issue Book");
            System.out.println("2. View All Library Records");
            System.out.println("3. Return Book");
            System.out.println("4. Delete Library Record");
            System.out.println("0. Back to Main Menu");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    issueBook();
                    break;

                case "2":
                    viewLibraryRecords();
                    break;

                case "3":
                    returnBook();
                    break;

                case "4":
                    deleteLibraryRecord();
                    break;

                case "0":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private static void issueBook() {

        System.out.println("\n------ ISSUE BOOK ------");

        System.out.print("Book Title: ");
        String bookTitle = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Issue Date (YYYY-MM-DD): ");
        String issueDate = scanner.nextLine();

        Library library = new Library(
                0,
                bookTitle,
                author,
                studentName,
                issueDate,
                "",
                "Issued"
        );

        libraryService.issueBook(library);
    }


    private static void viewLibraryRecords() {

        System.out.println("\n------ ALL LIBRARY RECORDS ------");

        List<Library> records =
                libraryService.getAllRecords();

        if (records.isEmpty()) {
            System.out.println("No library records found.");
            return;
        }

        for (Library library : records) {

            System.out.println("--------------------------------");
            System.out.println("ID          : " + library.getId());
            System.out.println("Book Title  : " + library.getBookTitle());
            System.out.println("Author      : " + library.getAuthor());
            System.out.println("Student     : " + library.getStudentName());
            System.out.println("Issue Date  : " + library.getIssueDate());
            System.out.println("Return Date : " + library.getReturnDate());
            System.out.println("Status      : " + library.getStatus());
        }

        System.out.println("--------------------------------");
    }


    private static void returnBook() {

        System.out.print("\nEnter Library Record ID: ");

        int id = readInteger();

        System.out.print("Return Date (YYYY-MM-DD): ");

        String returnDate = scanner.nextLine();

        libraryService.returnBook(
                id,
                returnDate
        );
    }


    private static void deleteLibraryRecord() {

        System.out.print("\nEnter Library Record ID to delete: ");

        int id = readInteger();

        libraryService.deleteRecord(id);
    }


    // ==================== FACILITIES MANAGEMENT ====================

    private static void facilityMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n====== FACILITIES MANAGEMENT ======");
            System.out.println("1. Add Facility");
            System.out.println("2. View All Facilities");
            System.out.println("3. Update Facility Status");
            System.out.println("4. Delete Facility");
            System.out.println("0. Back to Main Menu");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addFacility();
                    break;

                case "2":
                    viewFacilities();
                    break;

                case "3":
                    updateFacilityStatus();
                    break;

                case "4":
                    deleteFacility();
                    break;

                case "0":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private static void addFacility() {

        System.out.println("\n------ ADD FACILITY ------");

        System.out.print("Facility Name: ");
        String facilityName = scanner.nextLine();

        System.out.print("Location: ");
        String location = scanner.nextLine();

        System.out.print(
                "Status (Available/Occupied/Maintenance): "
        );

        String status = scanner.nextLine();

        System.out.print(
                "Maintenance Date (YYYY-MM-DD, optional): "
        );

        String maintenanceDate = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        Facility facility = new Facility(
                0,
                facilityName,
                location,
                status,
                maintenanceDate,
                description
        );

        facilityService.addFacility(facility);
    }


    private static void viewFacilities() {

        System.out.println("\n------ ALL FACILITIES ------");

        List<Facility> facilities =
                facilityService.getAllFacilities();

        if (facilities.isEmpty()) {
            System.out.println("No facilities found.");
            return;
        }

        for (Facility facility : facilities) {

            System.out.println("--------------------------------");
            System.out.println(
                    "ID              : " + facility.getId()
            );

            System.out.println(
                    "Facility        : " + facility.getFacilityName()
            );

            System.out.println(
                    "Location        : " + facility.getLocation()
            );

            System.out.println(
                    "Status          : " + facility.getStatus()
            );

            System.out.println(
                    "Maintenance Date: "
                            + facility.getMaintenanceDate()
            );

            System.out.println(
                    "Description     : " + facility.getDescription()
            );
        }

        System.out.println("--------------------------------");
    }


    private static void updateFacilityStatus() {

        System.out.print("\nEnter Facility ID: ");

        int id = readInteger();

        System.out.print(
                "Enter new status (Available/Occupied/Maintenance): "
        );

        String status = scanner.nextLine();

        facilityService.updateFacilityStatus(
                id,
                status
        );
    }


    private static void deleteFacility() {

        System.out.print("\nEnter Facility ID to delete: ");

        int id = readInteger();

        facilityService.deleteFacility(id);
    }


    // ==================== ANALYTICS ====================

    private static void analyticsMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n========== ANALYTICS ==========");
            System.out.println("1. Issue Analytics");
            System.out.println("2. Mess Analytics");
            System.out.println("3. Library Analytics");
            System.out.println("4. Facility Analytics");
            System.out.println("5. View Complete Analytics");
            System.out.println("0. Back to Main Menu");
            System.out.println("===============================");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    issueAnalytics.showIssueSummary();
                    break;

                case "2":
                    messAnalytics.showMessSummary();
                    break;

                case "3":
                    libraryAnalytics.showLibrarySummary();
                    break;

                case "4":
                    facilityAnalytics.showFacilitySummary();
                    break;

                case "5":
                    showCompleteAnalytics();
                    break;

                case "0":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private static void showCompleteAnalytics() {

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("       CAMPUSPULSE ANALYTICS REPORT");
        System.out.println("==========================================");

        issueAnalytics.showIssueSummary();

        messAnalytics.showMessSummary();

        libraryAnalytics.showLibrarySummary();

        facilityAnalytics.showFacilitySummary();

        System.out.println("\n==========================================");
        System.out.println("       END OF ANALYTICS REPORT");
        System.out.println("==========================================");
    }
    
 // ==================== CAMPUS ASSISTANT ====================

    private static void assistantMenu() {

        boolean back = false;

        System.out.println("\n======================================");
        System.out.println("        CAMPUSPULSE ASSISTANT");
        System.out.println("======================================");
        System.out.println(
                "Ask about issues, mess, library, facilities,"
        );
        System.out.println(
                "or analytics."
        );
        System.out.println(
                "Type 'back' to return to the Main Menu."
        );

        while (!back) {

            System.out.print("\nYou: ");

            String question = scanner.nextLine();

            if ("back".equalsIgnoreCase(question.trim())) {
                back = true;
                continue;
            }

            String response =
                    campusAssistant.getResponse(question);

            System.out.println("Assistant: " + response);
        }
    }


    // ==================== INPUT HELPERS ====================

    private static int readInteger() {

        while (true) {

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.print(
                        "Please enter a valid number: "
                );
            }
        }
    }


    private static double readDouble() {

        while (true) {

            String input = scanner.nextLine();

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.print(
                        "Please enter a valid number: "
                );
            }
        }
    }
}