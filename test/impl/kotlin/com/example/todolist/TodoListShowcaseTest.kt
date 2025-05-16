package com.example.todolist

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**
 * Tests for the TodoListShowcase script.
 * These tests verify that the showcase script demonstrates all the functionality
 * of the to-do list application as specified in the application_showcase.feature file.
 */
class TodoListShowcaseTest {
    
    /**
     * Captures the standard output of the showcase script and returns it as a string.
     */
    private fun captureShowcaseOutput(): String {
        val originalOut = System.out
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        
        try {
            main() // Run the showcase script
            return outputStream.toString()
        } finally {
            System.setOut(originalOut)
        }
    }
    
    @Test
    fun `should demonstrate adding tasks`() {
        // When
        val output = captureShowcaseOutput()
        
        // Then
        assertTrue(output.contains("=== Adding Tasks ==="))
        assertTrue(output.contains("Adding task: 'Buy groceries'"))
        assertTrue(output.contains("Adding task: 'Clean the house'"))
        assertTrue(output.contains("Adding task: 'Pay bills'"))
        assertTrue(output.contains("Task added successfully!"))
        assertTrue(output.contains("Current tasks: [Buy groceries, Clean the house, Pay bills]"))
    }
    
    @Test
    fun `should demonstrate listing tasks`() {
        // When
        val output = captureShowcaseOutput()
        
        // Then
        assertTrue(output.contains("=== Listing Tasks ==="))
        assertTrue(output.contains("Tasks in the to-do list:"))
        assertTrue(output.contains("1. Buy groceries"))
        assertTrue(output.contains("2. Clean the house"))
        assertTrue(output.contains("3. Pay bills"))
    }
    
    @Test
    fun `should demonstrate removing tasks`() {
        // When
        val output = captureShowcaseOutput()
        
        // Then
        assertTrue(output.contains("=== Removing Tasks ==="))
        assertTrue(output.contains("Removing task: 'Buy groceries'"))
        assertTrue(output.contains("Task removed successfully!"))
        assertTrue(output.contains("Current tasks: [Clean the house, Pay bills]"))
    }
    
    @Test
    fun `should demonstrate error handling for empty tasks`() {
        // When
        val output = captureShowcaseOutput()
        
        // Then
        assertTrue(output.contains("=== Error Handling: Empty Task ==="))
        assertTrue(output.contains("Attempting to add an empty task..."))
        assertTrue(output.contains("Error: Task cannot be empty"))
    }
    
    @Test
    fun `should demonstrate error handling for blank tasks`() {
        // When
        val output = captureShowcaseOutput()
        
        // Then
        assertTrue(output.contains("=== Error Handling: Blank Task ==="))
        assertTrue(output.contains("Attempting to add a blank task (whitespace only)..."))
        assertTrue(output.contains("Error: Task cannot be blank"))
    }
    
    @Test
    fun `should demonstrate error handling for duplicate tasks`() {
        // When
        val output = captureShowcaseOutput()
        
        // Then
        assertTrue(output.contains("=== Error Handling: Duplicate Task ==="))
        assertTrue(output.contains("Attempting to add a duplicate task: 'Buy groceries'..."))
        assertTrue(output.contains("Error: Task already exists in the list"))
    }
    
    @Test
    fun `should demonstrate error handling for non-existent task removal`() {
        // When
        val output = captureShowcaseOutput()
        
        // Then
        assertTrue(output.contains("=== Error Handling: Non-existent Task Removal ==="))
        assertTrue(output.contains("Attempting to remove a non-existent task: 'Do laundry'..."))
        assertTrue(output.contains("Error: Task does not exist in the list"))
    }
    
    @Test
    fun `should demonstrate complete workflow`() {
        // When
        val output = captureShowcaseOutput()
        
        // Then
        assertTrue(output.contains("=== Complete Workflow ==="))
        assertTrue(output.contains("1. Starting with current tasks:"))
        assertTrue(output.contains("2. Adding a new task: 'Read a book'"))
        assertTrue(output.contains("3. Removing a task: 'Pay bills'"))
        assertTrue(output.contains("4. Adding another task: 'Exercise'"))
        assertTrue(output.contains("5. Listing all tasks:"))
    }
    
    @Test
    fun `should provide clear explanations of each operation`() {
        // When
        val output = captureShowcaseOutput()
        
        // Then
        assertTrue(output.contains("=== Showcase Complete ==="))
        assertTrue(output.contains("The TodoList application successfully demonstrated:"))
        assertTrue(output.contains("- Adding tasks"))
        assertTrue(output.contains("- Removing tasks"))
        assertTrue(output.contains("- Listing tasks"))
        assertTrue(output.contains("- Error handling for invalid operations"))
    }
}