package com.sabpisal.todolist3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sabpisal.todolist3.model.Todo
import com.sabpisal.todolist3.R
import com.sabpisal.todolist3.model.Date

class TodoAdapter constructor(private val context: Context, private val todoList: List<Todo>, private val dateList: List<Date>) : RecyclerView.Adapter<TodoAdapter.TodoItemViewHolder>(){
    class TodoItemViewHolder constructor(view: View): RecyclerView.ViewHolder(view) {
        val todoText: TextView = view.findViewById(R.id.todo_title)
        val dateText: TextView = view.findViewById(R.id.date_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return TodoItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val todoItem = todoList.elementAt(position)
        val dateItem = dateList.elementAt(position)
        holder.todoText.text = todoItem.todo
        holder.dateText.text = dateItem.date
    }

    override fun getItemCount() = todoList.size

}