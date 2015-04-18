Feature: Dongle Connectivity
  Canbus explorer requires a connection to the canbus network, this would be
  via an ELM327 (or ELM327 compatible such as the ST1110 or ST1170) OBD
  adapter.

  These adapters use either a USB-to-serial, Bluetooth-serial or WiFi based
  TCP socket connection. Both the USB and Bluetooth devices require that
  we know the serial port to use. The WiFi dongle requires that the user
  specify the dongle's IP address and the port to connect to.

  The application should provide the user with a method to verify dongle
  connectivity health.

  Scenario: Choose Demo connection type
    Given there are 2 serial ports on the host computer
    When I visit the settings dialog
    Then I should be able to choose the Demo dongle type
    And the dongle connection status should be notified good

  Scenario: Choose Bluetooth connection type
    Given there are 2 serial ports on the host computer
    When I visit the settings dialog
    Then I should be able to choose the serial port for my Bluetooth dongle

  Scenario: Choose USB serial connection type
    Given there are 2 serial ports on the host computer
    When I visit the settings dialog
    Then I should be able to choose the serial port for my USB dongle

  Scenario: Choose WiFi connection type
    Given there is a network interface on the host computer
    When I visit the settings dialog
    Then I choose WiFi dongle
    And I specify the dongle IP 12.34.56.78 and TCP port 7884

  Scenario: Fail to specify IP host details for WiFi connection type
    Given there is a network interface on the host computer
    And I visit the settings dialog
    And I choose WiFi dongle
    When I specify the dongle IP 1 and TCP port 7884
    Then the dongle connection status should be notified bad
    And the reason should be notified

  Scenario: Test good dongle connection
    Given I have specified a valid dongle connection
    When I click the test connection button
    Then the dongle firmware version should be queried
    And the dongle connection status should be notified good

  Scenario: Test bad dongle connection
    Given I have specified a bad dongle connection
    When I click the test connection button
    Then the dongle firmware version should be queried
    And the dongle connection status should be notified bad
    And the reason should be notified

