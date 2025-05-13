Feature: Task Management
  As a user of the to-do list application
  I want to manage my tasks
  So that I can keep track of things I need to do

  Background:
    Given I have a to-do list

  Scenario: Add a task to an empty list
    When I add a task "Buy groceries"
    Then the task "Buy groceries" should be in the list
    And the list should contain 1 task

  Scenario: Add multiple tasks
    When I add a task "Buy groceries"
    And I add a task "Clean the house"
    And I add a task "Pay bills"
    Then the list should contain 3 tasks
    And the tasks should be in the order they were added

  Scenario: Attempt to add an empty task
    When I try to add an empty task
    Then the operation should fail with an error
    And the list should be empty

  Scenario: Attempt to add a blank task
    When I try to add a task with only whitespace
    Then the operation should fail with an error
    And the list should be empty

  Scenario: Attempt to add a duplicate task
    Given I have added a task "Buy groceries"
    When I try to add a task "Buy groceries" again
    Then the operation should fail with an error
    And the list should contain 1 task

  Scenario: Remove a task
    Given I have added a task "Buy groceries"
    When I remove the task "Buy groceries"
    Then the task "Buy groceries" should not be in the list
    And the list should be empty

  Scenario: Attempt to remove a non-existent task
    When I try to remove a task "Buy groceries"
    Then the operation should fail with an error
    And the list should be empty

  Scenario: Remove multiple tasks
    Given I have added the following tasks:
      | Buy groceries  |
      | Clean the house |
      | Pay bills      |
    When I remove the task "Buy groceries"
    And I remove the task "Pay bills"
    Then the list should contain 1 task
    And the task "Clean the house" should be in the list

  Scenario: Attempt to remove a task from an empty list
    When I try to remove a task "Buy groceries"
    Then the operation should fail with an error
    And the list should be empty

  Scenario: Get tasks from an empty list
    When I get all tasks
    Then I should receive an empty list

  Scenario: Get tasks from a populated list
    Given I have added the following tasks:
      | Buy groceries  |
      | Clean the house |
      | Pay bills      |
    When I get all tasks
    Then I should receive a list with 3 tasks
    And the tasks should be in the order they were added

  Scenario: Verify list immutability
    Given I have added the following tasks:
      | Buy groceries  |
      | Clean the house |
    When I get all tasks and try to modify the returned list
    Then the original list should remain unchanged
    And the list should contain 2 tasks

  Scenario: Add a task with very long content
    When I add a task with 1000 characters
    Then the task should be added successfully
    And the task content should be preserved

  Scenario: Add a task with special characters
    When I add a task "Buy milk @ $3.99 & eggs!"
    Then the task "Buy milk @ $3.99 & eggs!" should be in the list
    And the task content should be preserved