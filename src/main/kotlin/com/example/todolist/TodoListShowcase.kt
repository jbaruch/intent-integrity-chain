package com.example.todolist

/**
 * A showcase script that demonstrates the functionality of the TodoList application.
 * This script shows how to use the TodoList interface to manage tasks.
 */
fun main() {
    println("=== To-Do List Application Showcase ===")
    println()

    // Create a new TodoList instance
    val todoList = TodoListImpl()
    println("Created a new empty to-do list.")
    println()

    // Demonstrate adding tasks
    println("=== Adding Tasks ===")
    
    try {
        println("Adding task: 'Buy groceries'")
        todoList.addTask("Buy groceries")
        println("Task added successfully!")
        
        println("Adding task: 'Clean the house'")
        todoList.addTask("Clean the house")
        println("Task added successfully!")
        
        println("Adding task: 'Pay bills'")
        todoList.addTask("Pay bills")
        println("Task added successfully!")
        
        println("Current tasks: ${todoList.getTasks()}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    println()

    // Demonstrate listing tasks
    println("=== Listing Tasks ===")
    val tasks = todoList.getTasks()
    if (tasks.isEmpty()) {
        println("The to-do list is empty.")
    } else {
        println("Tasks in the to-do list:")
        tasks.forEachIndexed { index, task ->
            println("${index + 1}. $task")
        }
    }
    println()

    // Demonstrate error handling - empty task
    println("=== Error Handling: Empty Task ===")
    try {
        println("Attempting to add an empty task...")
        todoList.addTask("")
        println("Task added successfully!") // This line should not be reached
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    println()

    // Demonstrate error handling - blank task
    println("=== Error Handling: Blank Task ===")
    try {
        println("Attempting to add a blank task (whitespace only)...")
        todoList.addTask("   ")
        println("Task added successfully!") // This line should not be reached
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    println()

    // Demonstrate error handling - duplicate task
    println("=== Error Handling: Duplicate Task ===")
    try {
        println("Attempting to add a duplicate task: 'Buy groceries'...")
        todoList.addTask("Buy groceries")
        println("Task added successfully!") // This line should not be reached
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    println()

    // Demonstrate removing tasks
    println("=== Removing Tasks ===")
    try {
        println("Removing task: 'Buy groceries'")
        todoList.removeTask("Buy groceries")
        println("Task removed successfully!")
        
        println("Current tasks: ${todoList.getTasks()}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    println()

    // Demonstrate error handling - non-existent task removal
    println("=== Error Handling: Non-existent Task Removal ===")
    try {
        println("Attempting to remove a non-existent task: 'Do laundry'...")
        todoList.removeTask("Do laundry")
        println("Task removed successfully!") // This line should not be reached
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    println()

    // Demonstrate complete workflow
    println("=== Complete Workflow ===")
    println("1. Starting with current tasks: ${todoList.getTasks()}")
    
    println("2. Adding a new task: 'Read a book'")
    todoList.addTask("Read a book")
    println("   Current tasks: ${todoList.getTasks()}")
    
    println("3. Removing a task: 'Pay bills'")
    todoList.removeTask("Pay bills")
    println("   Current tasks: ${todoList.getTasks()}")
    
    println("4. Adding another task: 'Exercise'")
    todoList.addTask("Exercise")
    println("   Current tasks: ${todoList.getTasks()}")
    
    println("5. Listing all tasks:")
    todoList.getTasks().forEachIndexed { index, task ->
        println("   ${index + 1}. $task")
    }
    
    println()
    println("=== Showcase Complete ===")
    println("The TodoList application successfully demonstrated:")
    println("- Adding tasks")
    println("- Removing tasks")
    println("- Listing tasks")
    println("- Error handling for invalid operations")
}