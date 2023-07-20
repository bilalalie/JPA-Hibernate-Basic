package com.example.jpahibernate.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;            // Unique identifier for the student
    private String firstName;   // First name of the student
    private String lastName;    // Last name of the student
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;   // Date of birth of the student
    private String address;     // Address of the student
    private String city;        // City where the student resides
    private String state;       // State where the student resides
    private String zipCode;     // ZIP code of the student's address
    private String email;       // Email address of the student
    private String phoneNumber; // Contact phone number of the student
    private String major;       // Major or course of study of the student
    private int yearLevel;      // Year level of the student (e.g., freshman, sophomore, etc.)
    private double gpa;         // Grade Point Average of the student
    private boolean isActive;   // Whether the student is currently active or not

    public Student() {

    }

    public Student(long id, String firstName, String lastName, Date dateOfBirth, String address, String city, String state, String zipCode, String email, String phoneNumber, String major, int yearLevel, double gpa, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.yearLevel = yearLevel;
        this.gpa = gpa;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateFormat.format(dateOfBirth) +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", major='" + major + '\'' +
                ", yearLevel=" + yearLevel +
                ", gpa=" + gpa +
                ", isActive=" + isActive +
                '}';
    }
}
