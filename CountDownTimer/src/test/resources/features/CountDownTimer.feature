
Feature: Verify count Down timer is running for given time

  @tensecond
  Scenario: Verify Count Down Timer is running for given seconds
    Given Navigate to eggtimer url
    And wait till page gets load
    When user enter the time in seconds in given text box
    And click on the start timer button
    Then Count Timer should gets starts and it should decrement by 1-sec
    And close the page

 
