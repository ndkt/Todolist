package com.sabpisal.todolist3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.sabpisal.todolist3.databinding.FragmentLoginBinding
import com.sabpisal.todolist3.databinding.FragmentTodolistBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    /**
     * Fragment is being inflated.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    /**
     * FindViewById can be called in onViewCreated()
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.login.setOnClickListener {
            // Navigation Action
            val action = LoginFragmentDirections.actionLoginFragmentToTodolist(username = binding.usernameEdittext.text.toString())
            view.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}