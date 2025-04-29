package helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataRandom {
   public static Faker faker = new Faker(new Locale("en"));

    public static String getFirstName(){
        return faker.name().firstName();
    }
    public static String getLastName(){
        return faker.name().lastName();
    }
    public static String getEmail(){
        return faker.internet().emailAddress();
    }
    public static String getGender(){
        return faker.options().option("Male", "Female", "Other");
    }
    public static String getNumber(){
        return faker.number().digits(10);
    }

    public static String[] getDateOfBirth(){
        int day = faker.number().numberBetween(1, 28);
        String month = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        int year = faker.number().numberBetween(1900, 2025);

        String dayStr = String.valueOf(day);
        if (day < 10){
            dayStr = "0" + dayStr;
        }

        return new String[]{dayStr, month, String.valueOf(year)};
    }
    public static String getRandomSubject() {
        return faker.options().option("Maths", "Physics", "Chemistry", "English", "Biology");
    }
    public static String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }
    public static String getAddress() {
        return faker.address().fullAddress();
    }
    public static String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }
    public static String getCity(String state) {
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




