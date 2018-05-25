package com.example.chikakodama.calendarproject;

public class Event {

    private int year;
    private int month;
    private int dayOfMonth;
    private String event;

    //This class is created only for making an Object that stores an event, and its date.

    public Event (int year, int month, int dayOfMonth, String event) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.event = event;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public String getEvent() {
        return event;
    }
}
