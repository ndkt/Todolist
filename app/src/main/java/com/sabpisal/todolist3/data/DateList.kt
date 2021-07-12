package com.sabpisal.todolist3.data

import com.sabpisal.todolist3.model.Date

class DateList {
    private val myDateList: MutableList<Date> = mutableListOf()

    fun addDate(newDate: String) {
        this.myDateList.add(Date(newDate))
    }

    fun getDateList() = myDateList

}