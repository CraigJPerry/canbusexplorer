Feature: Detail view
  The detail view should display an interpretation of any row selected in the
  traffic table.

  Interpretation includes hot-linking a field of data to invoke filtering of
  the traffic table for only rows matching the value of that data field. It
  also includes decoding captured data into hex, ascii and other formats as
  appropriate.

  Scenario: Selected traffic table row appears in detail view
    Given the dongle provides valid data
    When I select the corresponding row
    Then decoded details are displayed in the detail view

