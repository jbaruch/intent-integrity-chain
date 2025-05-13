Feature: Application Showcase
  As a developer or user of the to-do list application
  I want to see a demonstration of the application's functionality
  So that I can understand how to use it effectively

  Background:
    Given I have a to-do list application

  Scenario: Demonstrate adding tasks
    When the showcase script adds several tasks
    Then all tasks should be successfully added
    And the output should clearly show the tasks being added

  Scenario: Demonstrate listing tasks
    Given the showcase script has added several tasks
    When the showcase script lists all tasks
    Then all tasks should be displayed in the correct order
    And the output should clearly show the task listing

  Scenario: Demonstrate removing tasks
    Given the showcase script has added several tasks
    When the showcase script removes some tasks
    Then those tasks should be successfully removed
    And the output should clearly show the tasks being removed

  Scenario: Demonstrate error handling for empty tasks
    When the showcase script attempts to add an empty task
    Then the operation should fail with an appropriate error
    And the output should clearly show the error message

  Scenario: Demonstrate error handling for duplicate tasks
    Given the showcase script has added a task "Buy groceries"
    When the showcase script attempts to add the same task again
    Then the operation should fail with an appropriate error
    And the output should clearly show the error message

  Scenario: Demonstrate error handling for non-existent task removal
    When the showcase script attempts to remove a non-existent task
    Then the operation should fail with an appropriate error
    And the output should clearly show the error message

  Scenario: Demonstrate complete application workflow
    When the showcase script runs a complete workflow
    Then it should demonstrate adding, listing, and removing tasks
    And it should demonstrate error handling
    And the output should provide clear explanations of each operation