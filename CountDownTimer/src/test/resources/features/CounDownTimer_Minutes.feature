
Feature: Verify count down timer is running for selected minutes of time.
  

  Scenario: Verify Count Down Timer is running for given Minutes and decrements the counter by 1-seconds
    Given Navigate to the site https:\\e.ggtimer url
    And wait till Home page of e.ggtimer gets load
    When select <5> -minutes link    
    Then Count Down Timer should gets starts and it should decrement by 1-sec
    And close the page and application
    