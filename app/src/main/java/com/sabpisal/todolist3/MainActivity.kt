package com.sabpisal.todolist3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.sabpisal.todolist3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val workTodolist = TodolistFragment.workTodoList
        val dateList = TodolistFragment.dateTodoList
        workTodolist.addTodo("Walk the Alpacas")
        dateList.addDate("16/05/2021")
        workTodolist.addTodo("Visit Lenina at the Park")
        dateList.addDate("24/05/2021")
        workTodolist.addTodo("Check out the Museum Downtown")
        dateList.addDate("02/05/2021")
        workTodolist.addTodo("Americano @ Starbucks for George")
        dateList.addDate("01/07/2021")
        workTodolist.addTodo("Make reservations for a flight to Boise, Idaho")
        dateList.addDate("31/06/2021")
        workTodolist.addTodo("Buy a Croissant at a bakery shop on Washington St.")
        dateList.addDate("31/06/2021")
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}