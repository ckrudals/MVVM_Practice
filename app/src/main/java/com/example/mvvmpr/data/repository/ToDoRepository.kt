package com.example.mvvmpr.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmpr.data.ToDoDao
import com.example.mvvmpr.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {
    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData) {
       toDoDao.insertData(toDoData)


    }
}




