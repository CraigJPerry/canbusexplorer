Feature: Traffic table
  The captured traffic should be rendered in real time, to a table on screen.

  The table should facilitate scrolling rows, selecting rows, sorting by
  column and filtering by column. It should not persist rows indefinitely
  since this would only fill the user's memory, eventually crashing the
  application.

  Scenario Outline: Capture buttons
    Given the application has launched successfully
    When I visit the application page
    Then I should see the <capture> button

    Examples:
      | capture |
      | start   |
      | stop    |

  Scenario: Initiate explore session
    Given the application has launched successfully
    When I click the start capture button
    Then an explore session should be initiated
    And valid data is received from the dongle

  Scenario: Data fields split into rows
    Given a explore session has been initiated
    When valid data is received from the dongle
    Then the traffic table should append a row
    And a row contains the captured data

