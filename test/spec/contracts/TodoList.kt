package com.example.todolist

/**
 * Interface defining the contract for a simple in-memory to-do list.
 * This interface provides methods for adding, removing, and listing tasks.
 */
interface TodoList {
    /**
     * Adds a new task to the to-do list.
     *
     * @param task The task to add, represented as a string.
     * @return true if the task was successfully added, false otherwise.
     * @throws IllegalArgumentException if the task is empty, blank, or already exists in the list.
     */
    fun addTask(task: String): Boolean

    /**
     * Removes a task from the to-do list.
     *
     * @param task The task to remove, represented as a string.
     * @return true if the task was successfully removed, false otherwise.
     * @throws IllegalArgumentException if the task does not exist in the list or if the list is empty.
     */
    fun removeTask(task: String): Boolean

    /**
     * Returns an immutable list of all tasks in the to-do list.
     * The tasks are returned in the order they were added.
     *
     * @return An immutable list of tasks.
     */
    fun getTasks(): List<String>
}