package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataRandom {
    Faker faker = new Faker(new Locale("en"));

    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getLastName(){
        return faker.name().lastName();
    }
    public String getEmail(){
        return faker.internet().emailAddress();
    }
    public String getGender(){
        return faker.options().option("Male", "Female", "Other");
    }
    public String getNumber(){
        return faker.number().digits(10);
    }

    public String[] getDateOfBirth(){
        int day = faker.number().numberBetween(1, 28);
        String month = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        int year = faker.number().numberBetween(1900, 2025);
        return new String[]{String.valueOf(day), month, String.valueOf(year)};
    }
    public String getRandomSubject() {
        return faker.options().option("Maths", "Physics", "Chemistry", "English", "Biology");
    }
    public String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }
    public String getAddress() {
        return faker.address().fullAddress();
    }
    public String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }
    public String getCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                throw new IllegalArgumentException("Unknown state: " + state);
        }
    }


}




