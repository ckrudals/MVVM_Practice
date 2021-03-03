package com.example.mvvmpr.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmpr.data.ToDoDao
import com.example.mvvmpr.data.models.ToDoData

// repository 를 쓰는 이유
// 모듈화가 잘되 분담하기가 쉽다
// 현업에서 MVVM 패턴을 쓰는 이유기도 하다, 하지만 단점으로는
// 너무 많은 Class 를 생성해야 하기 때문에 보기 불편 하다.
class ToDoRepository(private val toDoDao: ToDoDao) {
    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData) {
       toDoDao.insertData(toDoData)

    }
}




