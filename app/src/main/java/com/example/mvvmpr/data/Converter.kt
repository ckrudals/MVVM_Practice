package com.example.mvvmpr.data

import androidx.room.TypeConverter
import com.example.mvvmpr.data.models.Priority

class Converter {

    //Priority.HIGH 를 toString() 으로 가능하게 해준다.
    @TypeConverter
    fun fromPriority(priority: Priority): String{
        return priority.name
    }
    @TypeConverter
    fun  toPriority(priority:String): Priority {
        return Priority.valueOf(priority)
    }
}