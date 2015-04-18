Feature: Presenation format
  The single page application that is displayed for the user must show
  a live-updating table of captured canbus traffic, a panel decoding a selected
  table row and a panel for configuring dongle connectivity.

  All these features must work equally well on a PC sized screen, a tablet
  sized screen and a phone sized screen.

  Scenario Outline: Display single page application
    Given the app has been started
    When I visit the application URL on my <device>
    Then I should see the panel <name>

    Examples:
      | device  | name         |
      | desktop | connectivity |
      | desktop | traffic      |
      | desktop | detail       |
      | tablet  | connectivity |
      | tablet  | traffic      |
      | tablet  | detail       |
      | phone   | connectivity |
      | phone   | traffic      |
      | phone   | detail       |

