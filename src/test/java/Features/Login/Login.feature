Feature: Login

  @login
  Scenario: Verify whether the user should able to login to the application
    Given get the URL of the application
    When enter the username
    And verify the continue btn is displayed or not, if displayed enter password and login
    Then if not click on register, enter the details and login