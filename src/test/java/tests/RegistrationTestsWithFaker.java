
package tests;


import helpers.TestDataRandom;
import org.junit.jupiter.api.Test;
import pages.FormPage;
import pages.components.ResultTableComponent;


public class RegistrationTestsWithFaker extends TestBase {
    FormPage formPage = new FormPage();
    ResultTableComponent resultTable = formPage.getResultTable();

    String firstName = TestDataRandom.getFirstName(),
            lastName = TestDataRandom.getLastName(),
            userEmail = TestDataRandom.getEmail(),
            userGender = TestDataRandom.getGender(),
            userNumber = TestDataRandom.getNumber(),
            subject = TestDataRandom.getRandomSubject(),
            picture = "picture.jpg",
            hobbies = TestDataRandom.getRandomHobbies(),
            streetAddress = TestDataRandom.getAddress(),
            state = TestDataRandom.getState(),
            city = TestDataRandom.getCity(state);
    String[] dateOfBirth = TestDataRandom.getDateOfBirth();

    @Test
    void fillFormTest() {

        formPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDate0fBirth(dateOfBirth[0], dateOfBirth[1], dateOfBirth[2])
                .setSubjectsInput(subject)
                .setHobbiesCheckbox(hobbies)
                .selectUploadPicture(picture)
                .setCurrentAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        resultTable.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dateOfBirth[0] + " " + dateOfBirth[1] + "," + dateOfBirth[2])
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", state + " " + city);

    }


}

