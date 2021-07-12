package com.sabpisal.todolist3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.sabpisal.todolist3.databinding.FragmentTodoInformationBinding

class TodoInformation : Fragment() {
    private var _binding: FragmentTodoInformationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoInformationBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.sendDataButton.setOnClickListener {
//            // Navigation Action
//            val action = TodoInformationDirections.actionTodoInformationToTodolist(username =  TodolistFragment.username, binding.dataFromTodoInfo.text.toString())
//            view.findNavController().navigate(action)
//        }

        binding.addTodoButton.setOnClickListener {
            if (binding.newtodoEdittext.text.toString().isEmpty()) {
                Toast.makeText(this.requireContext(), "Todo Cannot be Empty!", Toast.LENGTH_SHORT).show()
            } else {
                val workTodolist = TodolistFragment.workTodoList
                val dateList = TodolistFragment.dateTodoList
                val datePicker = binding.insertNewDate
                val todaysDate = "${datePicker.dayOfMonth}/${datePicker.month+1}/${datePicker.year}"
                workTodolist.addTodo(binding.newtodoEdittext.text.toString())
                dateList.addDate(todaysDate)
                // Navigation Action
                val action = TodoInformationDirections.actionTodoInformationToTodolist(username = TodolistFragment.username)
                view.findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}