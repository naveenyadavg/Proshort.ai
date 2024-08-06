Feature: Call Insights

  @Call_Insights @Admin @Sanity
  Scenario Outline: Ensure that admin should able to view the sales bot
    Given login to the application
    Then click on Admin console
    And click on "<manageType>" in menu
    And check the "<view>"
    Then verify the "<manageType>" page and setup
    And select "<type>" folder
    And select video and click on 'Add to Snippets' button
    Then verify the success Message after uploading the video in "<manageType>"

    Examples:
      | manageType    | type   | view               |
      | Call Insights | Upload | Configure Insights |

  @Call_Insights @Admin @Sanity
  Scenario Outline: Ensure that admin should able to view the sales bot
    Given login to the application
    Then click on Admin console
    And click on "<manageType>" in menu
    And check the "<view>"
    Then verify the "<manageType>" page and setup
    And select "<type>" folder
    And select video and click on 'Add to Snippets' button
    Then verify the success Message after uploading the video in "<manageType>"

    Examples:
      | manageType    | type              | view               |
      | Call Insights | Proshort Platform | Configure Insights |

  @Call_Insights @Admin @Sanity
  Scenario Outline: Ensure that admin should able to view the sales bot
    Given login to the application
    Then click on Admin console
    And click on "<manageType>" in menu
    And check the "<view>"
    Then verify the "<manageType>" page and setup
    And select "<type>" folder
    And select video and click on 'Add to Snippets' button
    Then verify the success Message after uploading the video in "<manageType>"

    Examples:
      | manageType    | type     | view               |
      | Call Insights | Snippets | Configure Insights |