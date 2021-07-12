package com.sabpisal.todolist3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sabpisal.todolist3.adapter.TodoAdapter
import com.sabpisal.todolist3.data.DateList
import com.sabpisal.todolist3.data.Todolist
import com.sabpisal.todolist3.databinding.FragmentTodolistBinding

class TodolistFragment : Fragment() {
    companion object {
        const val USERNAME = "username"
        lateinit var username: String
        val workTodoList: Todolist = Todolist()
        val dateTodoList: DateList = DateList()

    }
    private var _binding: FragmentTodolistBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // If arguments is Null then the Lambda will not execute
        arguments?.let {
            username = it.getString(USERNAME).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodolistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.rvTodoList
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext(),LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = TodoAdapter(this.requireContext(), workTodoList.getTodoList(), dateTodoList.getDateList())

        binding.floatingActionButton.setOnClickListener {
            // Navigation Action
            val action = TodolistFragmentDirections.actionTodolistToTodoInformation()
            view.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}