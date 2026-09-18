package com.campuspulse.model;

public class Library {

    private int id;
    private String bookTitle;
    private String author;
    private String studentName;
    private String issueDate;
    private String returnDate;
    private String status;

    public Library() {
    }

    public Library(int id, String bookTitle, String author,
                   String studentName, String issueDate,
                   String returnDate, String status) {

        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.studentName = studentName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", studentName='" + studentName + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}