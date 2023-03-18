Feature: Add Daily Leadership from dashboard screen and verify added data
 
@SmokeTest
  Scenario: Publish new Daily Leadership and verify added dl data on dashboard
    Given TrritoryOwner is on HomePage of the application
    And attempts to create new DL to publish
      | Date       | Attended | MeetingNotes |
      |            | Yes      | Test Notes   |
    When DL data verified successfully on dashboard
    Then New DL added under timeline should 'Appear'