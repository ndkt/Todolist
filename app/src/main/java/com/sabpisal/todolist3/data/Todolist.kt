package com.sabpisal.todolist3.data

import com.sabpisal.todolist3.model.Todo

class Todolist {
    private val myTodolist: MutableList<Todo> = mutableListOf()

    fun addTodo(newTodo: String) {
        this.myTodolist.add(Todo(newTodo))
    }

    fun getTodoList() = myTodolist
}