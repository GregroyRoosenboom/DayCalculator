package StepDefinitions.java.time;

import TimeRepresentations.Booking;
import TimeRepresentations.Day;
import TimeRepresentations.TimeRegistrationsPeriod;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.time.Duration;

public class PeriodCalculation {
    private Day firstDay;
    private Day secondDay;
    private TimeRegistrationsPeriod period;

    @Given("the first day where the normal time is {int} hours")
    public void aFirstDayWhereTheNormalTimeIsHours(int arg0) {
        firstDay.FullTime = Duration.ofHours(arg0);
    }

    @And("the first day has a normal break time of {int} minutes")
    public void theFirstDayHasANormalBreakTimeOfMinutes(int arg0) {
        firstDay.BreakTime = Duration.ofMinutes(arg0);
    }

    @And("the first day has time registrations at {int}:{int} and {int}:{int}")
    public void theFirstDayHasTimeRegistrationsAtAnd(int arg0, int arg1, int arg2, int arg3) {
        firstDay.addBooking(new Booking(arg0, arg1));
        firstDay.addBooking(new Booking(arg2, arg3));
    }

    @And("the second day where the normal time is {int} hours")
    public void aSecondDayWhereTheNormalTimeIsHours(int arg0) {
        secondDay.FullTime = Duration.ofHours(arg0);
    }

    @And("the second day has a normal break time of {int} minutes")
    public void theSecondDayHasANormalBreakTimeOfMinutes(int arg0) {
        secondDay.BreakTime = Duration.ofMinutes(arg0);
    }

    @And("the second day has time registrations at {int}:{int} and {int}:{int}")
    public void theSecondDayHasTimeRegistrationsAtAnd(int arg0, int arg1, int arg2, int arg3) {
        secondDay.addBooking(new Booking(arg0, arg1));
        secondDay.addBooking(new Booking(arg2, arg3));
    }


    @And("the period is calculated")
    public void thePeriodIsCalculated() {
        period.calculate();

    }

    @Then("the overtime for the period should be {int} minutes")
    public void theOvertimeForThePeriodShouldBeMinutes(int arg0) {
        Assert.assertEquals(arg0, period.getOvertime().toMinutes());
    }

    @And("a second day")
    public void aSecondDay() {
        secondDay = new Day();
    }

    @Given("a first day")
    public void aFirstDay() {
        firstDay = new Day();
    }

    @When("the first and second day are added to the period")
    public void theFirstAndSecondDayAreAddedToThePeriod() {
        period = new TimeRegistrationsPeriod();
        period.addDay(firstDay);
        period.addDay(secondDay);
    }
}
