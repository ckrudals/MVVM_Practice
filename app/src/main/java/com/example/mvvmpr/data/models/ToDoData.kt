package com.example.mvvmpr.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmpr.data.models.Priority
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Entity(tableName="todo_table")
@Parcelize
data class ToDoData(
        @PrimaryKey(autoGenerate=true) //자동 생성
        var id: Int,
        var title: String,
        var priority: Priority,
        var description: String
) : Parcelable