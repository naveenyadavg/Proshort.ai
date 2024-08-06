Feature: WorkSpace Setup

  @WorkSpaceSetup  @Sanity @Admin
  Scenario: Verify that the admin can modify WorkSpace Setup
    Given login to the application
    Then click on Admin console
    And navigate to workspace setup
    And change the workspace name as "ProShort"
    And upload the organization logo
    And save the Workspace Settings
    And  verify the pop message for detail updation
    Then verify that the Workspace name is changed
