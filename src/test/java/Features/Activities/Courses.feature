Feature: Courses

  @Courses @Sanity @Admin
  Scenario Outline: Ensure that admin can able to create and assign a course by uploading a video and quiz
    Given login to the application
    Then click on Admin console
    And inside Activities menu select "<activity>" option
    Then click on create "<activity>" button
    And enter the "<activity>" name and click on 'Add Modules'
    And select 'Video' option and enter module name
    Then click on upload button
    And select "<type>" folder
    Then select video and click on 'Add to <activity>'
    Then select 'Quiz' option and enter module name
    And enter the questions, options and add a quiz by selecting the "<choice>" options
    And click on Next button
    Then select the participant group as "<Group>"
    And edit the other details
    Then enter the description for the "<activity>"
    And click on continue to review
    Then verify the modules, schedule the date, and click on the 'Schedule' button
    Then verify that created "<activity>" is displayed in 'Scheduled' state
    Examples:
      | activity | choice | Group   | type   |
      | Course   | single | general | Upload |

  @Courses @Sanity @Admin
  Scenario Outline: Ensure that admin can able to edit the course details and lesson details
    Given login to the application
    Then click on Admin console
    And inside Activities menu select "<activity>" option
    Then navigate to 'Scheduled' state
    And select an existing "<activity>"
    And edit the created "<activity>" details
    And add the 'Quiz' by selecting 'single' options for "<activity>"
    And click on Next button
    And click on continue to review
    Then schedule the date, and click on 'Schedule' button
    Examples:
      | activity |
      | Course   |

  @Courses @Sanity @Admin
  Scenario Outline: Ensure that admin can able to activate and deactivate the course created.
    Given login to the application
    Then click on Admin console
    And inside Activities menu select "<activity>" option
    Then navigate to 'Scheduled' state
    And verify the details in 'Inactive' state after deactivating the created "<activity>"
    Then verify the details in 'Active' state after activating the created "<activity>"
    Examples:
      | activity |
      | Course   |

#  @Course @Member @Sanity
  Scenario Outline: Verify that the member can Join Course
    Given login to the application
#    When click on the chevron down icon beside the workspace or user name
    Then click on Participate
    And inside Activities page select "<activity>" option
    And get the count of completed, started and pending for the "<activity>"
    And select the first course assigned by an admin
    And complete the "<activity>"
    Then verify the "<activity>" count after completing
    Examples:
      | activity |
      | Course   |