Feature: Content

  @Upload @Content @Sanity @Admin
  Scenario Outline: Ensure that admin can able to review the reported videos
    Given login to the application
    Then click on Admin console
    And inside Manage videos menu select "<videoType>" option
    Then verify the "<videoType>" title
    And select "<type>" folder
    Then 'Add File' in to the folder
    Then verify the success Message after uploading the video
    Examples:
      | videoType   | type   |
      | All Content | Upload |

  @ProshortPlatform @Content @Sanity @Admin
  Scenario Outline: Ensure that admin can able to review the reported videos
    Given login to the application
    Then click on Admin console
    And inside Manage videos menu select "<videoType>" option
    Then verify the "<videoType>" title
    And select "<type>" folder
    Then 'Add File' in to the folder
    Then verify the success Message after uploading the video
    Examples:
      | videoType   | type              |
      | All Content | Proshort Platform |

  @Snippets @Content @Sanity @Admin
  Scenario Outline: Ensure that admin can able to review the reported videos
    Given login to the application
    Then click on Admin console
    And inside Manage videos menu select "<videoType>" option
    Then verify the "<videoType>" title
    And select "<type>" folder
    Then 'Add File' in to the folder
    Then verify the success Message after uploading the video
    Examples:
      | videoType   | type     |
      | All Content | Snippets |