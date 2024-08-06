Feature: Account

  @Account @Sanity @Member
  Scenario: Ensure that member should able to change the user profile & other details
    Given login to the application
    When click on account profile
    And click on Edit Profile
    Then verify the title and click on change profile
    And upload a image & verify the toast msg
    And edit the details & click on save
    Then verify the updated details in the account profile

#  @Account# @Sanity# @Member#
  Scenario: Ensure that user should able to change the password
    Given login to the application
    When click on account profile
    And click on settings
    And verify the page title
    Then update password, submit & verify title

  @Account @Sanity @Member
  Scenario: Ensure that user should able to send a feedback
    Given login to the application
    When click on account profile
    And click on settings
    And verify the page title
    Then click & enter the feedback
    Then submit & verify the msg

  @Account @Sanity @Member
  Scenario: Ensure that user can able to take a help & support
    Given login to the application
    When click on account profile
    And click on settings
    Then verify the page title
    And click & enter the support message
    Then submit & verify the msg

#  @Notification @Sanity @Member
  Scenario: Ensure that when user clicks on any course in notification it should able to navigate to respective course
    Given login to the application
    When click on account profile
    And click on notification
    And select any notification
    Then check whether it was navigating to respective course