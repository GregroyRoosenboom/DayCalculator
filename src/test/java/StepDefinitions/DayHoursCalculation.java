package StepDefinitions;

import Calculators.HoursForDaysCalculator;
import TimeRepresentations.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.time.Duration;

public class DayHoursCalculation {
    private Day day;

    @Given("I make a time registration at {int}:{int}")
    public void iMakeATimeRegistrationAt(int arg0, int arg1) {
        day.addBooking(new Booking(arg0, arg1));
    }

    @When("the times are processed")
    public void theTimesAreProcessed() {
        HoursForDaysCalculator.CalculateHours(day);
    }


    @Then("the the result is {int} hours")
    public void theTheResultIsHours(int arg0) {
        Assert.assertEquals(Duration.ofHours(arg0).toMinutes(), day.WorkedTime.toMinutes());
    }

    @Given("a day that contains a time registration at {int}:{int} and a registration at {int}:{int}")
    public void aDayThatContainsATimeRegisytrationAtAndARegistrationAt(int arg0, int arg1, int arg2, int arg3) {
        day.addBooking(new Booking(arg0, arg1));
        day.addBooking(new Booking(arg2, arg3));
    }

    @When("the day is processed")
    public void theDayIsProcessed() {
        HoursForDaysCalculator.CalculateHours(day);
    }

    @Then("the result is {int} hour")
    public void theResultIsHour(int arg0) {
        Assert.assertEquals(Duration.ofHours(arg0).toMinutes(), day.WorkedTime.toMinutes());
    }

    @Given("the full time of a day is {int} hours")
    public void aTheFullTimeOfADayIsHours(int arg0) {
        day = new Day();
        day.FullTime = Duration.ofMinutes(arg0*60);
    }

    @And("the break for that day is {int} minutes")
    public void theBreakForThatDayIsMinutes(int arg0) {
        day.BreakTime = Duration.ofMinutes(30);

    }

    @And("that day contains a time registration at {int}:{int} and a registration at {int}:{int}")
    public void thatDayContainsATimeRegistrationAtAndARegistrationAt(int arg0, int arg1, int arg2, int arg3) {
        day.addBooking(new Booking(arg0, arg1));
        day.addBooking(new Booking(arg2, arg3));
    }

    @Then("the overtime is {int} hour")
    public void theOvertimeIsHour(int arg0) {
        Assert.assertEquals(Duration.ofHours(1),day.getOvertime());;
    }

    @Given("that day contains half a day absence")
    public void thatDayContainsHalfADayAbsence() {
        day.WorkedFullDay = false;
    }
}
