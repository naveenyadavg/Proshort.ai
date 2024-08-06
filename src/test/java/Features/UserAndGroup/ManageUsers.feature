Feature: ManageUser

  @User @Sanity @Admin
  Scenario Outline: Verify admin should able to send a invite
    Given login to the application
    Then click on Admin console
    And inside user & groups menu select "<manageType>" option
    Then click on 'Invite member' button
    And enter "<emailId>" and click done button
    Then verify the email in the 'Pending' section
    Examples:
      | manageType | emailId    |
      | user       | @gmail.com |

  @User @Sanity @Admin
  Scenario Outline: Verify admin should able to send a bulk invite
    Given login to the application
    Then click on Admin console
    And inside user & groups menu select "<manageType>" option
    Then click on 'Bulk invite' button
    And upload a excel file which as multiple "<emailId>"
    Then click on invite
    And verify the sent emails in the invite page
    Then verify the success message & click on 'Done'
    Then verify the sent emails in the 'Pending' section
    Examples:
      | manageType | emailId    |
      | user       | @gmail.com |

  @User @Sanity @Admin
  Scenario Outline: Verify admin should able to edit member details
    Given login to the application
    Then click on Admin console
    And inside user & groups menu select "<manageType>" option
    And edit the "<manageType>" details for existing member
    Then verify the "<manageType>" details after editing
    Examples:
      | manageType |
      | user       |