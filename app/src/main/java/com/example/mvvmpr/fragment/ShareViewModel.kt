package com.example.mvvmpr.fragment

import android.app.Application
import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.example.mvvmpr.R
import com.example.mvvmpr.data.models.Priority

class ShareViewModel(application: Application) : AndroidViewModel(application) {

    val listener : AdapterView.OnItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("Not yet implemented")
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            when (position){
                0-> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.red)) }
                0-> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.yellow)) }
                0-> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.green)) }
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


}