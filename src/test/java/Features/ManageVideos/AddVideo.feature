Feature: AddVideo

  @AddVideo @Sanity @Member
  Scenario: Ensure that member can able to add the videos in to the group
    Given login to the application
    When click on new video
    And upload video & enter the details
    Then verify the uploaded video in respective group

  @AddVideo @Sanity @Member
  Scenario: verify the uploaded video under post section in account profile
    Given login to the application
    When click on new video
    And upload video & enter the details
    And click on account profile
    Then verify the video in account profile

  @Search @Sanity @Member
  Scenario: verify that based on search it should display the exact suggested video
    Given login to the application
    When based on any search
    Then it should display respective suggestion