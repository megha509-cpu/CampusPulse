package com.campuspulse.service;

import com.campuspulse.model.Issue;
import com.campuspulse.repository.IssueRepository;

import java.util.List;

public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService() {
        this.issueRepository = new IssueRepository();
    }

    public void addIssue(Issue issue) {
        if (issue == null) {
            System.out.println("Issue information cannot be empty.");
            return;
        }

        if (issue.getStudentName() == null ||
                issue.getStudentName().trim().isEmpty()) {
            System.out.println("Student name is required.");
            return;
        }

        if (issue.getCategory() == null ||
                issue.getCategory().trim().isEmpty()) {
            System.out.println("Issue category is required.");
            return;
        }

        if (issue.getDescription() == null ||
                issue.getDescription().trim().isEmpty()) {
            System.out.println("Issue description is required.");
            return;
        }

        if (issue.getLocation() == null ||
                issue.getLocation().trim().isEmpty()) {
            System.out.println("Issue location is required.");
            return;
        }

        if (issue.getStatus() == null ||
                issue.getStatus().trim().isEmpty()) {
            issue.setStatus("Pending");
        }

        if (issue.getPriority() == null ||
                issue.getPriority().trim().isEmpty()) {
            issue.setPriority("Medium");
        }

        issueRepository.addIssue(issue);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.getAllIssues();
    }

    public void updateIssueStatus(int id, String status) {
        if (id <= 0) {
            System.out.println("Invalid issue ID.");
            return;
        }

        if (status == null || status.trim().isEmpty()) {
            System.out.println("Status cannot be empty.");
            return;
        }

        issueRepository.updateIssueStatus(id, status);
    }

    public void deleteIssue(int id) {
        if (id <= 0) {
            System.out.println("Invalid issue ID.");
            return;
        }

        issueRepository.deleteIssue(id);
    }
}