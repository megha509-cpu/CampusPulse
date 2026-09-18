package com.campuspulse.analytics;

import com.campuspulse.model.Issue;
import com.campuspulse.service.IssueService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueAnalytics {

    private final IssueService issueService;

    public IssueAnalytics() {
        this.issueService = new IssueService();
    }

    public void showIssueSummary() {
        List<Issue> issues = issueService.getAllIssues();

        if (issues.isEmpty()) {
            System.out.println("No issue data available.");
            return;
        }

        int pending = 0;
        int inProgress = 0;
        int resolved = 0;

        Map<String, Integer> categoryCount = new HashMap<>();

        for (Issue issue : issues) {

            String status = issue.getStatus();

            if ("Pending".equalsIgnoreCase(status)) {
                pending++;
            } else if ("In Progress".equalsIgnoreCase(status)) {
                inProgress++;
            } else if ("Resolved".equalsIgnoreCase(status)) {
                resolved++;
            }

            String category = issue.getCategory();

            if (category != null && !category.trim().isEmpty()) {
                categoryCount.put(
                        category,
                        categoryCount.getOrDefault(category, 0) + 1
                );
            }
        }

        System.out.println("\n========== ISSUE ANALYTICS ==========");
        System.out.println("Total Issues : " + issues.size());
        System.out.println("Pending      : " + pending);
        System.out.println("In Progress  : " + inProgress);
        System.out.println("Resolved     : " + resolved);

        System.out.println("\nIssues by Category:");

        for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }

        System.out.println("=====================================");
    }
}