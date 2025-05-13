package com.example.todolist

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Tests for the TodoListImpl class.
 */
class TodoListImplTest {
    private lateinit var todoList: TodoList

    @BeforeEach
    fun setUp() {
        todoList = TodoListImpl()
    }

    // Tests for addTask method

    @Test
    fun `should add a task to an empty list`() {
        // When
        val result = todoList.addTask("Buy groceries")

        // Then
        assertTrue(result)
        assertEquals(1, todoList.getTasks().size)
        assertTrue(todoList.getTasks().contains("Buy groceries"))
    }

    @Test
    fun `should add multiple tasks`() {
        // When
        todoList.addTask("Buy groceries")
        todoList.addTask("Clean the house")
        todoList.addTask("Pay bills")

        // Then
        assertEquals(3, todoList.getTasks().size)
        assertEquals(listOf("Buy groceries", "Clean the house", "Pay bills"), todoList.getTasks())
    }

    @Test
    fun `should throw exception when adding an empty task`() {
        // When/Then
        val exception = assertThrows<IllegalArgumentException> {
            todoList.addTask("")
        }
        assertEquals("Task cannot be empty", exception.message)
        assertTrue(todoList.getTasks().isEmpty())
    }

    @Test
    fun `should throw exception when adding a blank task`() {
        // When/Then
        val exception = assertThrows<IllegalArgumentException> {
            todoList.addTask("   ")
        }
        assertEquals("Task cannot be blank", exception.message)
        assertTrue(todoList.getTasks().isEmpty())
    }

    @Test
    fun `should throw exception when adding a duplicate task`() {
        // Given
        todoList.addTask("Buy groceries")

        // When/Then
        val exception = assertThrows<IllegalArgumentException> {
            todoList.addTask("Buy groceries")
        }
        assertEquals("Task already exists in the list", exception.message)
        assertEquals(1, todoList.getTasks().size)
    }

    // Tests for removeTask method

    @Test
    fun `should remove a task`() {
        // Given
        todoList.addTask("Buy groceries")

        // When
        val result = todoList.removeTask("Buy groceries")

        // Then
        assertTrue(result)
        assertTrue(todoList.getTasks().isEmpty())
    }

    @Test
    fun `should throw exception when removing a non-existent task`() {
        // When/Then
        val exception = assertThrows<IllegalArgumentException> {
            todoList.removeTask("Buy groceries")
        }
        assertEquals("The list is empty", exception.message)
    }

    @Test
    fun `should throw exception when removing a task from a non-empty list that doesn't contain the task`() {
        // Given
        todoList.addTask("Clean the house")

        // When/Then
        val exception = assertThrows<IllegalArgumentException> {
            todoList.removeTask("Buy groceries")
        }
        assertEquals("Task does not exist in the list", exception.message)
        assertEquals(1, todoList.getTasks().size)
    }

    @Test
    fun `should remove multiple tasks`() {
        // Given
        todoList.addTask("Buy groceries")
        todoList.addTask("Clean the house")
        todoList.addTask("Pay bills")

        // When
        todoList.removeTask("Buy groceries")
        todoList.removeTask("Pay bills")

        // Then
        assertEquals(1, todoList.getTasks().size)
        assertEquals("Clean the house", todoList.getTasks()[0])
    }

    // Tests for getTasks method

    @Test
    fun `should return an empty list when no tasks exist`() {
        // When
        val tasks = todoList.getTasks()

        // Then
        assertTrue(tasks.isEmpty())
    }

    @Test
    fun `should return all tasks in the order they were added`() {
        // Given
        todoList.addTask("Buy groceries")
        todoList.addTask("Clean the house")
        todoList.addTask("Pay bills")

        // When
        val tasks = todoList.getTasks()

        // Then
        assertEquals(3, tasks.size)
        assertEquals(listOf("Buy groceries", "Clean the house", "Pay bills"), tasks)
    }

    @Test
    fun `should return an immutable list`() {
        // Given
        todoList.addTask("Buy groceries")
        todoList.addTask("Clean the house")

        // When
        val tasks = todoList.getTasks()

        // Then
        assertThrows<UnsupportedOperationException> {
            (tasks as MutableList<String>).add("Pay bills")
        }
    }

    // Edge case tests

    @Test
    fun `should handle tasks with special characters`() {
        // When
        todoList.addTask("Buy milk @ $3.99 & eggs!")

        // Then
        assertEquals(1, todoList.getTasks().size)
        assertEquals("Buy milk @ $3.99 & eggs!", todoList.getTasks()[0])
    }

    @Test
    fun `should handle tasks with very long content`() {
        // Given
        val longTask = "a".repeat(1000)

        // When
        todoList.addTask(longTask)

        // Then
        assertEquals(1, todoList.getTasks().size)
        assertEquals(longTask, todoList.getTasks()[0])
    }
}