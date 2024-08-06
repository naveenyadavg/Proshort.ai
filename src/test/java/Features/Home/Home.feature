Feature: Home

  @Home @Member @Sanity
  Scenario: Verify that the member is able to react to the video
    Given login to the application
    And get the count of like and saved video
    Then Verify that the count matches the profile after reacting to the video

