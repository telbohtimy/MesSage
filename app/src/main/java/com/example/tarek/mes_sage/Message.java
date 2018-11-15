package com.example.tarek.mes_sage;

public class Message {

    private String name;
    private String phoneNumber;
    private String messageText;
    private String frequency;
    private boolean send;
    private int year;
    private int day;
    private int month;
    private int hour;
    private int minute;

    //Constructor
    public Message(String name, String phoneNumber, String messageText, String frequency, int year, int day, int month, int hour, int minute) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.messageText = messageText;
        this.frequency = frequency;
        this.send = true;
        this.year = year;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.minute = minute;
    }

    //Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public boolean isSend() { return send; }
    public void setSend(boolean send) { this.send = send; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }
    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }
    public int getHour() { return hour; }
    public void setHour(int hour) { this.hour = hour; }
    public int getMinute() { return minute; }
    public void setMinute(int minute) { this.minute = minute; }
}
