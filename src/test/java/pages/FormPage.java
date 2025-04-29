
package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();


    public FormPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    public FormPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public FormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public FormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public FormPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public FormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public FormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public FormPage setDate0fBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public FormPage setSubjectsInput(String value) {

        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public FormPage setHobbiesCheckbox(String value) {
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }

    public FormPage selectUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public FormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public FormPage setState(String value) {
        state.click();
        $(byText(value)).click();
        return this;
    }

    public FormPage setCity(String value) {
        city.click();
        $(byText(value)).click();
        return this;
    }

    public FormPage clickSubmit() {
        submit.click();
        return this;
    }

    public ResultTableComponent getResultTable() {
        return resultTableComponent;
    }

}


