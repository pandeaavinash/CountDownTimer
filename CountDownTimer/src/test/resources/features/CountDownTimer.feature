
Feature: Verify count Down timer is running for given time

  @tensecond
  Scenario: Verify Count Down Timer is running for given seconds
    Given Navigate to eggtimer url
    And wait till page gets load
    When user enter the time as 10 seconds in given text box
    And click on the start timer button
    Then Count Timer should gets starts and it should decrement by 1-sec
    And close the page

 @parameter
  Scenario: Verify Count Down Timer is running for given seconds
    Given Navigate to eggtimer url
    And wait till page gets load
    When user enter the time <30> seconds in given text box
    And click on the start timer button
    Then Count Timer should gets starts and it should decrement by 1-sec
    And close the page
    
  @parameterization
  Scenario Outline: Verify Count Down Timer is running for given seconds
    Given Navigate to eggtimer url
    And wait till page gets load
    When user enter the time "<timeInSeconds>" seconds in given text box
    And click on the start timer button
    Then Count Timer should gets starts and it should decrement by 1-sec
    And close the page
    Examples:
    |timeInSeconds|
    |10|
    |30|
    |50|
