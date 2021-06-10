package data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ExpectedStudentData {
    private final SelenideElement studentName = $x("//td[text()= 'Student Name']").parent(),
            studentEmail = $x("//td[text()='Student Email']").parent(),
            gender = $x("//td[text()='Gender']").parent(),
            mobile = $x("//td[text()='Mobile']").parent(),
            dateOfBirth = $x("//td[text()='Date of Birth']").parent(),
            subjects = $x("//td[text()='Subjects']").parent(),
            hobbies = $x("//td[text()='Hobbies']").parent(),
            picture = $x("//td[text()='Picture']").parent(),
            address = $x("//td[text()='Address']").parent(),
            stateAndCity = $x("//td[text()='State and City']").parent(),
            titleSubmittingForm = $(".modal-title");


    public SelenideElement getTitleSubmittingForm() {
        return titleSubmittingForm;
    }


    public SelenideElement getStudentName() {
        return studentName;
    }

    public SelenideElement getStudentEmail() {
        return studentEmail;
    }

    public SelenideElement getGender() { return gender; }

    public SelenideElement getMobile() { return mobile; }

    public SelenideElement getDateOfBirth() {
        return dateOfBirth;
    }

    public SelenideElement getSubjects() {
        return subjects;
    }

    public SelenideElement getHobbies() {
        return hobbies;
    }

    public SelenideElement getPicture() {
        return picture;
    }

    public SelenideElement getAddress() {
        return address;
    }

    public SelenideElement getStateAndCity() {
        return stateAndCity;
    }

}

