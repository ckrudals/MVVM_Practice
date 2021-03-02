package com.example.mvvmpr.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmpr.data.models.Priority

@Entity(tableName="todo_table")
data class ToDoData(
        @PrimaryKey(autoGenerate=true) //자동 생성
        var id: Int,
        var title: String,
        var priority: Priority,
        var description: String
)