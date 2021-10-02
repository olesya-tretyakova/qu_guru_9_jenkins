package test.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ToolsQATest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        String firstName = "Tom";
        String lastName = "Cruise";
        String email = "tom_cruise@gmail.com";
        String gender = "Male";
        String mobileNumber = "1234512345";
        String address = "USA";
        String state = "NCR";
        String city = "Noida";
        String subject = "Math";
        String day = "3";
        String month = "July";
        String year = "1962";
        String hobby = "Sports";
        String fileName = "photo.jpg";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(byText(day)).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(fileName);
        $("#currentAddress").setValue(address);
        $("#stateCity-wrapper").$(byText("Select State")).scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(mobileNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(fileName));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));
    }
}
