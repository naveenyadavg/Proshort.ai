Feature: SalesBot

  @SalesBot @Admin @Sanity
  Scenario Outline: Ensure that admin should able to view the sales bot
    Given login to the application
    Then click on Admin console
    And click on "<manageType>" in menu
    Then verify the "<manageType>" page and setup
    And select "<type>" folder
    And select video and click on 'Add to Salesbot' button
    Then verify the success Message after uploading the video in "<manageType>"
    Examples:
      | manageType | type   |
      | Sales Bot  | Upload |

  @SalesBot @Admin @Sanity
  Scenario Outline: Ensure that admin should able to view the sales bot
    Given login to the application
    Then click on Admin console
    And click on "<manageType>" in menu
    Then verify the "<manageType>" page and setup
    And select "<type>" folder
    And select video and click on 'Add to Salesbot' button
    Then verify the success Message after uploading the video in "<manageType>"
    Examples:
      | manageType | type   |
      | Sales Bot  | Proshort Platform |

  @SalesBot @Admin @Sanity
  Scenario Outline: Ensure that admin should able to view the sales bot
    Given login to the application
    Then click on Admin console
    And click on "<manageType>" in menu
    Then verify the "<manageType>" page and setup
    And select "<type>" folder
    And select video and click on 'Add to Salesbot' button
    Then verify the success Message after uploading the video in "<manageType>"
    Examples:
      | manageType | type   |
      | Sales Bot  | Snippets |

  @SalesBot @Member @Sanity
  Scenario Outline: Verify that the member can Join Campaigns
    Given login to the application
    Then click on Participate
    And inside Activities page select "<activity>" option
    Examples:
      | activity  |
      | Sales Bot |