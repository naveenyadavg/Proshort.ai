Feature: Dashboard

#  @Library @Admin @Sanity
  Scenario: Ensure that admin should able to create a sales bot by uploading video
    Given login to the application
    Then click on Admin console
    And navigate on library
    And upload a video content & verify the message
    Then verify the uploaded video in the library

#  @SalesBot @Admin @Sanity
  Scenario: Ensure that admin should able to create a sales bot by uploading video
    Given login to the application
    Then click on Admin console
    And click on 'Create' sales bot
    Then upload a video content & verify the message
    And add your question
    Then click on create QA button & verify the message

#  @SalesBot @Admin @Sanity
  Scenario: Ensure that admin should able to create a sales bot by selecting existing video
    Given login to the application
    Then click on Admin console
    And click on 'Create' sales bot
    Then select a video content
    And add your question
    Then click on create QA button & verify the message

#  @SalesBot @Admin @Sanity
  Scenario: Ensure that admin should able to create a sales bot by selecting existing pdf
    Given login to the application
    Then click on Admin console
    And click on 'Create' sales bot
    Then select pdf content
    And add your question
    Then click on create QA button & verify the message

#  @SalesBot @Admin @Sanity
  Scenario: Ensure that admin should able to create a sales bot by selecting existing ppt
    Given login to the application
    Then click on Admin console
    And click on 'Create' sales bot
    Then select ppt content
    And add your question
    Then click on create QA button & verify the message

#  @SalesBot @Admin @Sanity
  Scenario: Ensure that admin should able to create a sales bot by selecting existing document
    Given login to the application
    Then click on Admin console
    And click on 'Create' sales bot
    Then select document content
    And add your question
    Then click on create QA button & verify the message

#  @SalesBot @Admin @Sanity
  Scenario: Ensure that admin should able to view the sales bot
    Given login to the application
    Then click on Admin console
    And click on 'View' sales bot
    Then verify the title & click on done

  @SalesBot @Member @Sanity
  Scenario Outline: Ensure that member can able to ask a question in sales bot
    Given login to the application
    Then click on Participate
    And inside Activities page select "<activity>" option
    Then verify whether the sales bot create a answer
    Examples:
      | activity  |
      | Sales Bot |

#  *** Google driver will not work in headless mode
  @AppIntegration @Admin @Sanity
  Scenario Outline: Ensure that admin should able to integrate the apps
    Given login to the application
    Then click on Admin console
    And select "<app>" & click on install
    Then verify the "<app>" once installed
    Examples:
      | app        |
      | Hubspot    |
      | Salesforce |
      | Slack      |
      | Gong       |
#      | Google Drive |