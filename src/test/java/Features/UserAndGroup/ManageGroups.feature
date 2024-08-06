Feature: ManageGroups

  @Group @Sanity @Admin
  Scenario Outline: Ensure that admin can able to create a group
    Given login to the application
    Then click on Admin console
    And inside user & groups menu select "<manageType>" option
    And click on create "<manageType>" btn
    Then enter the "<manageType>" name & click on next
    And add the members
    And verify the members details & there count
    Then verify the create "<manageType>" is displayed in the table
    Examples:
      | manageType |
      | Group      |

  @Group @Sanity @Admin
  Scenario Outline: Ensure that admin should able to edit the group name which is already created
    Given login to the application
    Then click on Admin console
    And inside user & groups menu select "<manageType>" option
    And select on existing "<manageType>" & 'Edit details' btn
    Then verify the details in the table after editing "<manageType>" name
    Examples:
      | manageType |
      | Group      |

  @Group @Sanity @Admin
  Scenario Outline: Ensure that admin should able to add members to an existing group
    Given login to the application
    Then click on Admin console
    And inside user & groups menu select "<manageType>" option
    Then select on existing "<manageType>" & 'Members' btn
    And click on 'AddBtn' to add members
    Then verify the add members in the 'Add people' page
    Examples:
      | manageType |
      | Group      |

  @Group @Sanity @Admin
  Scenario Outline: Ensure that admin should able to deactivate the existing group
    Given login to the application
    Then click on Admin console
    And inside user & groups menu select "<manageType>" option
    And select on existing "<manageType>" & 'Deactivate' btn
    Then verify the success message & the "<manageType>" details in table
    Examples:
      | manageType |
      | Group      |

  @Group @Sanity @Member
  Scenario Outline: Ensure that member should able to create a group
    Given login to the application
    When click on ' Add Groups'
    And select an create group
    And verify create "<manageType>" title
    Then enter the "<manageType>" name & click on next
    And add the members into the group and verify the success msg
    Then verify the created "<manageType>"
    Examples:
      | manageType |
      | Group      |

  @Group @Sanity @Member
  Scenario Outline: Ensure that member should able to browse a group
    Given login to the application
    When click on ' Add Groups'
    And select an browse group
    And verify create "<manageType>" title
    Then browse the group and verify the details
    Examples:
      | manageType |
      | Browse     |