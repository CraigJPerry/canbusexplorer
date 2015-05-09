Feature: Dongle Connectivity
  Canbus explorer ordinarily requires a connection to the canbus network
  being observed. This would be via an ELM327 (or perhaps ST1110 / ST1170)
  based OBD adapter.

  These adapters use either a USB-to-serial, Bluetooth-serial or WiFi based
  TCP socket connection. Both the USB and Bluetooth devices require that
  the user specify the serial port to use. The WiFi dongle requires the
  dongle's IP address and the TCP port Canbus Explorer should connect to.

  A Demo adapter type is configured with a another dongle's session log
  and it simply replays the captured traffic. This can be useful for
  offline (i.e. the vehicle or adapter are unavailable) traffic analysis
  or simply to demonstrate this software.

  Due to the remote nature of the dongle hardware, the application should
  handle connectivity interruptions responsibly. The application should
  provide the user with a method to verify dongle connectivity health.

  The output of one hardware dongle can be broadcast to multiple clients
  concurrently.

  Scenario: Choose Demo connection type
    Given I have opened the settings dialog
    When I choose the Demo dongle type
    And I specify the file "mazda-rx8.dongle.log"
    Then the dongle connection status should be good

  Scenario: Fail to specify file details for Demo connection type
    Given I have opened the settings dialog
    When I choose the Demo dongle type
    And I specify the file ""
    Then the dongle connection status should be bad

  @serialDongleAvailable
  Scenario: Choose Bluetooth connection type
    Given I have opened the settings dialog
    When I choose the Bluetooth dongle type
    And I specify the port "/dev/ttyS1"
    Then the dongle connection status should be good

  @serialDongleAvailable
  Scenario: Choose USB connection type
    Given I have opened the settings dialog
    When I choose the USB dongle type
    And I specify the port "/dev/ttyS1"
    Then the dongle connection status should be good

  @wifiDongleAvailable
  Scenario: Choose WiFi connection type
    Given I have opened the settings dialog
    When I choose the WiFi dongle type
    And I specify the host "10.0.1.18"
    And I specify the port "35000"
    Then the dongle connection status should be good

  @wifiDongleAvailable
  Scenario: Fail to specify IP host details for WiFi connection type
    Given I have opened the settings dialog
    When I choose the WiFi dongle type
    And I specify the host ""
    And I specify the port ""
    Then the dongle connection status should be bad
