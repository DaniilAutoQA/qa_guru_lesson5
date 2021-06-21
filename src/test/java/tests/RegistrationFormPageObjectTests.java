package tests;

import com.github.javafaker.Faker;
import components.CalendarElement;
import components.TestBase;
import data.ExpectedStudentData;
import model.StudentModel;
import org.junit.jupiter.api.Test;
import page.FillRegistrationForm;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static components.CalendarElement.calendarComponent;

public class RegistrationFormPageObjectTests extends TestBase {

    Faker faker = new Faker();
    ExpectedStudentData expectedStudentData = new ExpectedStudentData();
    FillRegistrationForm registration = new FillRegistrationForm();
    CalendarElement calendar = new CalendarElement("1", "March", "2000");
    StudentModel student = new StudentModel(
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            "Male",
            faker.phoneNumber().subscriberNumber(10),
            "Sports",
            "Haryana","Karnal",
            "English",
            faker.address().fullAddress(),
            "load.txt");

    @Test
    void fillFormTest(){
        open("https://demoqa.com/automation-practice-form");
        registration.inputFirstName(student.getFirstName());
        registration.inputLastName(student.getLastName());
        registration.inputEmail(student.getEmail());
        registration.chooseGender(student.getGender());
        registration.inputMobile(student.getMobile());
        registration.uploadFile(student.getFileName());
        registration.currentAddress(student.getCurrentAddress());
        calendarComponent(calendar.getDay(),calendar.getMonth(),calendar.getYear());
        registration.chooseStateAndCity(student.getState(), student.getCity());
        registration.chooseHobby(student.getHobbies());
        registration.chooseSubject(student.getSubjects());

        registration.submit();

        expectedStudentData.getTitleSubmittingForm().shouldHave(text("Thanks for submitting the form"));
        expectedStudentData.getStudentName().shouldHave(text(student.getFirstName() + " " + student.getLastName()));
        expectedStudentData.getStudentEmail().shouldHave(text(student.getEmail()));
        expectedStudentData.getGender().shouldHave(text(student.getGender()));
        expectedStudentData.getMobile().shouldHave(text(student.getMobile()));
        expectedStudentData.getDateOfBirth().shouldHave(text(calendar.getDay() + " " + calendar.getMonth() + "," + calendar.getYear()));
        expectedStudentData.getSubjects().shouldHave(text(student.getSubjects()));
        expectedStudentData.getHobbies().shouldHave(text(student.getHobbies()));
        expectedStudentData.getPicture().shouldHave(text(student.getFileName()));
        expectedStudentData.getAddress().shouldHave(text(student.getCurrentAddress()));
        expectedStudentData.getStateAndCity().shouldHave(text(student.getState() + " " + student.getCity()));

    }

}