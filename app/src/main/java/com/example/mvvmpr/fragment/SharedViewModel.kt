package com.example.mvvmpr.fragment

import android.app.Application
import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvmpr.R
import com.example.mvvmpr.data.models.Priority
import com.example.mvvmpr.data.models.ToDoData

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    //MutableLiveData 이란 무엇인가?
    val emptyDatabase: MutableLiveData<Boolean> = MutableLiveData(true)

    fun checkIfDatabaseEmpty(toDoData:List<ToDoData>){
        emptyDatabase.value=toDoData.isEmpty() //데이터 있음
    }
    //Spinner Listener
    val listener: AdapterView.OnItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        //클릭 안됌
        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        //클릭됌
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            when (position) {
                0 -> {
                    (parent?.getChildAt(0) as TextView).setTextColor(
                        ContextCompat.getColor(
                            application,
                            R.color.red
                        )
                    )
                }
                1 -> {
                    (parent?.getChildAt(0) as TextView).setTextColor(
                        ContextCompat.getColor(
                            application,
                            R.color.yellow
                        )
                    )
                }
                2 -> {
                    (parent?.getChildAt(0) as TextView).setTextColor(
                        ContextCompat.getColor(
                            application,
                            R.color.green
                        )
                    )
                }
            }


        }

    }

    fun verifyDtaFromUser(title: String, description: String): Boolean {
        // TextUtils 이란, Android 에서 제공하는 TextView null 체크 방식이다.
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            false
        } else
            !(title.isEmpty() || description.isEmpty())
    }

    fun parsePriority(priority: String): Priority {
        return when (priority) {
            "High Priority" -> (Priority.HIGH)

            "Medium Priority" -> (Priority.MEDIUM)

            "Low Priority" -> (Priority.LOW)

            else -> Priority.LOW
        }
    }

    //Priority  에 있는 데이터를 매개변수로 받고,
    fun parsePriorityToInt(priority: Priority): Int {
        return when (priority) {
            Priority.HIGH -> 0
            Priority.MEDIUM -> 1
            Priority.LOW -> 2
        }
    }


}