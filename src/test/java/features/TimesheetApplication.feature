Feature: A day is processed so that the user knows how much overtime he has for that day

Background:
  Given the full time of a day is 8 hours
  And the break for that day is 30 minutes

Scenario: Entering one time returns zero hours for one day
  Given I make a time registration at 8:00
  When the times are processed
  Then the the result is 0 hours

Scenario: when the period is longer than Half a day the break is substracted
  Given that day contains a time registration at 8:00 and a registration at 16:30
  When the day is processed
  Then the result is 8 hour

Scenario: when the period is longer than Half a day the break is substracted
  Given that day contains a time registration at 8:00 and a registration at 17:30
  When the day is processed
  Then the overtime is 1 hour

Scenario: There are multiple booking that create a break longer than the minimal break
  Given that day contains a time registration at 8:00 and a registration at 12:00
  And that day contains a time registration at 13:00 and a registration at 17:00
  When the day is processed
  Then the result is 8 hour

Scenario: There are multiple bookings creating a break shorter than the minimal break
  Given that day contains a time registration at 8:00 and a registration at 12:31
  And that day contains a time registration at 13:00 and a registration at 16:30
  When the day is processed
  Then the result is 8 hour

Scenario: When there are three bookings the day can be processed
  Given that day contains a time registration at 8:00 and a registration at 12:00
  And I make a time registration at 13:00
  When the day is processed
  Then the result is 4 hour

Scenario:
  Given that day contains half a day absence
  And that day contains a time registration at 8:00 and a registration at 13:00
  When the day is processed
  Then the result is 5 hour
  And the overtime is 1 hour



