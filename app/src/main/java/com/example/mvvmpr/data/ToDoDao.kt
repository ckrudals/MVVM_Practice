package com.example.mvvmpr.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmpr.data.models.ToDoData

@Dao
interface ToDoDao {

    @Query("SELECT * FROM  todo_table ORDER BY id ASC") //todo_table 에 있는 id를 오름차순 정렬해라
    fun getAllData(): LiveData<List<ToDoData>>


    // suspend 를 붙이는 이유 < 코루틴을 사용해서 background 에 돌아가는 함수를 만들 수 있다
    // main Thread 에 호출 되고, 아래 에 있는 코드들을 생성하지 않고, 코루틴 block 을 탈출한다.
    //만약 suspend 키워드를 안쓴다면, 루틴을 게속돌아 MainThread 가 손해받는다?
    @Insert(onConflict = OnConflictStrategy.IGNORE) // PrimaryKey 가 겹치면 무시한다.


    suspend fun insertData(todoData: ToDoData)
}