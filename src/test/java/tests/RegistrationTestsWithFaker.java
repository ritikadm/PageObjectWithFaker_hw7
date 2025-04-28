
package tests;


import org.junit.jupiter.api.Test;
import page.FormPage;
import page.components.ResultTableComponent;


public class RegistrationTestsWithFaker extends TestBase {
    FormPage formPage = new FormPage();
    ResultTableComponent resultTable = formPage.getResultTable();

    TestDataRandom testData = new TestDataRandom();

    String firstName = testData.getFirstName(),
            lastName = testData.getLastName(),
            userEmail = testData.getEmail(),
            userGender = testData.getGender(),
            userNumber = testData.getNumber(),
            subject = testData.getRandomSubject(),
            picture = "picture.jpg",
            hobbies = testData.getRandomHobbies(),
            streetAddress = testData.getAddress(),
            state = testData.getState(),
            city = testData.getCity(state);
    String[] dateOfBirth = testData.getDateOfBirth();

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

