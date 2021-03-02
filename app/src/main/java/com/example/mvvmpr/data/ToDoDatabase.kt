package com.example.mvvmpr.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvmpr.data.models.ToDoData
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class    ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object {

        @Volatile   //코루틴, 메인쓰레드에 돌아가게함 ?
        // 만약 main thread 에 접근할 때 변수의 값을 cache 를 통해 사용하지 않고,
        // thread 가 직접 main thread 에 접근가능하게 함.
        // thread 에 접근할 때 main thread 로 바로 접근하는게 아니라 catche 에서 변수 값을 읽어감
        // 쓰기 또한 catche 값을 이용, 변경 되면 catche 값이 main thread 에 없데이트 됨
        private var INSTANCE: ToDoDatabase? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context): ToDoDatabase {

            val temInstance = INSTANCE
            if (temInstance != null) {
                return temInstance
            }
            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "todo_database"
                ).build()

                // 다른 쓰레드에 권한을 못줌
                // thread 를 동기화 하기 위해서 제공
                // 스레드는 synchronized 메소드에 들어가기 위해 lock 을 얻고 메소드가 끝이나면 lock 을 반환
                INSTANCE = instance
                return instance

            }

        }
    }
}