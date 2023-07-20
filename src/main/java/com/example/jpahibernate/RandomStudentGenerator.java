package com.example.jpahibernate;
import com.example.jpahibernate.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStudentGenerator {


    List<Student> students = generateRandomStudents(390);

    public RandomStudentGenerator() throws ParseException {
    }

    public static List<Student> generateRandomStudents(int count) throws ParseException {
        List<Student> students = new ArrayList<>();
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < count; i++) {
            long id = i + 1;
            String firstName = getRandomName();
            String lastName = getRandomName();
            Date dateOfBirth = getRandomDateOfBirth();
            String address = getRandomAddress();
            String city = getRandomCity();
            String state = getRandomState();
            String zipCode = getRandomZipCode();
            String email = getRandomEmail(firstName, lastName);
            String phoneNumber = getRandomPhoneNumber();
            String major = getRandomMajor();
            int yearLevel = random.nextInt(4) + 1;
            double gpa = 2.0 + (4.0 - 2.0) * random.nextDouble();
            boolean isActive = random.nextBoolean();

            Student student = new Student(id, firstName, lastName, dateOfBirth, address, city, state, zipCode, email,
                    phoneNumber, major, yearLevel, gpa, isActive);
            students.add(student);
        }

        return students;
    }

    private static String getRandomName() {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hannah", "Ivan", "Julia"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    private static Date getRandomDateOfBirth() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse("1990-01-01");
        Date endDate = dateFormat.parse("2005-12-31");
        long randomDate = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
        return new Date(randomDate);
    }

    private static String getRandomAddress() {
        String[] streets = {"Main Street", "Oak Avenue", "Maple Road", "Elm Street", "Pine Lane"};
        String[] suffixes = {"Apt", "Suite", "Building"};
        Random random = new Random();
        return random.nextInt(100) + " " + streets[random.nextInt(streets.length)] + " " +
                suffixes[random.nextInt(suffixes.length)] + " " + (random.nextInt(9999) + 1);
    }

    private static String getRandomCity() {
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "San Francisco"};
        Random random = new Random();
        return cities[random.nextInt(cities.length)];
    }

    private static String getRandomState() {
        String[] states = {"NY", "CA", "IL", "TX", "CA"};
        Random random = new Random();
        return states[random.nextInt(states.length)];
    }

    private static String getRandomZipCode() {
        return String.format("%05d", ThreadLocalRandom.current().nextInt(10000));
    }

    private static String getRandomEmail(String firstName, String lastName) {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "example.com"};
        Random random = new Random();
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + domains[random.nextInt(domains.length)];
    }

    private static String getRandomPhoneNumber() {
        return String.format("(%03d) %03d-%04d", ThreadLocalRandom.current().nextInt(1000),
                ThreadLocalRandom.current().nextInt(1000), ThreadLocalRandom.current().nextInt(10000));
    }

    private static String getRandomMajor() {
        String[] majors = {"Computer Science", "Biology", "Engineering", "Business", "Psychology"};
        Random random = new Random();
        return majors[random.nextInt(majors.length)];
    }
}

