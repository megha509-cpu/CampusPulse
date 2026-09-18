package com.campuspulse.model;

public class Mess {

    private int id;
    private String mealType;
    private String menuItem;
    private String mealDate;
    private double rating;
    private String feedback;

    public Mess() {
    }

    public Mess(int id, String mealType, String menuItem,
                String mealDate, double rating, String feedback) {

        this.id = id;
        this.mealType = mealType;
        this.menuItem = menuItem;
        this.mealDate = mealDate;
        this.rating = rating;
        this.feedback = feedback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getMealDate() {
        return mealDate;
    }

    public void setMealDate(String mealDate) {
        this.mealDate = mealDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Mess{" +
                "id=" + id +
                ", mealType='" + mealType + '\'' +
                ", menuItem='" + menuItem + '\'' +
                ", mealDate='" + mealDate + '\'' +
                ", rating=" + rating +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}