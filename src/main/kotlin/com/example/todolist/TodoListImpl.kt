package com.example.todolist

/**
 * Implementation of the TodoList interface.
 * This class provides an in-memory storage for tasks and implements
 * methods for adding, removing, and listing tasks.
 */
class TodoListImpl : TodoList {
    // Using a mutable list to store tasks in memory
    private val tasks = mutableListOf<String>()

    /**
     * Adds a new task to the to-do list.
     *
     * @param task The task to add, represented as a string.
     * @return true if the task was successfully added, false otherwise.
     * @throws IllegalArgumentException if the task is empty, blank, or already exists in the list.
     */
    override fun addTask(task: String): Boolean {
        when {
            task.isEmpty() -> throw IllegalArgumentException("Task cannot be empty")
            task.isBlank() -> throw IllegalArgumentException("Task cannot be blank")
            tasks.contains(task) -> throw IllegalArgumentException("Task already exists in the list")
            else -> {
                tasks.add(task)
                return true
            }
        }
    }

    /**
     * Removes a task from the to-do list.
     *
     * @param task The task to remove, represented as a string.
     * @return true if the task was successfully removed, false otherwise.
     * @throws IllegalArgumentException if the task does not exist in the list or if the list is empty.
     */
    override fun removeTask(task: String): Boolean {
        when {
            tasks.isEmpty() -> throw IllegalArgumentException("The list is empty")
            !tasks.contains(task) -> throw IllegalArgumentException("Task does not exist in the list")
            else -> {
                tasks.remove(task)
                return true
            }
        }
    }

    /**
     * Returns an immutable list of all tasks in the to-do list.
     * The tasks are returned in the order they were added.
     *
     * @return An immutable list of tasks.
     */
    override fun getTasks(): List<String> {
        // Return an immutable copy of the tasks list
        return tasks.toList().toMutableList().apply { 
            // This is a trick to ensure the list is truly immutable
            // by wrapping it with Collections.unmodifiableList()
        }.let { java.util.Collections.unmodifiableList(it) }
    }
}
