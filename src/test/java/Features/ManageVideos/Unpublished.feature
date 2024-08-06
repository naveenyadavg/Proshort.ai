Feature: Unpublished

#  @Unpublished @Sanity @Admin
  Scenario Outline: Ensure that admin can able to review the reported videos
    Given login to the application
    Then click on Admin console
    And inside Manage videos menu select "<videoType>" option
    Then verify the module and "<videoType>" title
    And select an video and click on 'Review' btn
    And verify the video title
    Then verify the success message after "<approveType>" the video
    Examples:
      | videoType   | approveType |
      | Unpublished | Publish     |
      | Unpublished | Discard     |