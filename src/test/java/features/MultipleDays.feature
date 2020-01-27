Feature: as a user
  In order to know how much overtime I have
  I can save A period and calculate the overtime for that period

  Scenario: the overtime for multiple days is added
    Given a first day
    And the first day where the normal time is 8 hours
    And the first day has a normal break time of 30 minutes
    And the first day has time registrations at 8:00 and 16:45
    And a second day
    And the second day where the normal time is 8 hours
    And the second day has a normal break time of 30 minutes
    And the second day has time registrations at 8:00 and 16:25
    When the first and second day are added to the period
    And the period is calculated
    Then the overtime for the period should be 10 minutes
