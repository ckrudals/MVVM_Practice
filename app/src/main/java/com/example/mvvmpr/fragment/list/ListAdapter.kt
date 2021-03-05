package com.example.mvvmpr.fragment.list

import android.content.Context
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpr.R
import com.example.mvvmpr.data.models.Priority
import com.example.mvvmpr.data.models.ToDoData
import com.example.mvvmpr.databinding.FragmentListBinding
import com.example.mvvmpr.databinding.RowLayoutBinding
import com.example.mvvmpr.list.ListFragment
import com.example.mvvmpr.list.ListFragmentDirections
import kotlinx.coroutines.InternalCoroutinesApi
import kotlin.coroutines.coroutineContext

@InternalCoroutinesApi
class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var dataList = emptyList<ToDoData>()  // emptyList Immutable(불변) List
    // 반환값 Object


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = RowLayoutBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        with(holder) {
            //여기서 왜 ToDoData class 가 상속받지 ??
            // 자답 : dataList 의 뷰모델이 ToDoData 다이다
            binding.titleTxt.text = dataList[position].title
            binding.descriptionTxt.text = dataList[position].description
            binding.rowBackground.setOnClickListener {
                //대상 이동방법, Navigation 에 있는 argument 를 가져와 이동 시켜준다!
           val action=ListFragmentDirections.actionListFragmentToUpdateFragment(dataList[position])
                holder.itemView.findNavController().navigate(action)
            }
            when (dataList[position].priority) {

                Priority.HIGH -> binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.red))
                Priority.MEDIUM -> binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.yellow))
                Priority.LOW -> binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.green))
            }

        }

    }

    override fun getItemCount(): Int {
        return dataList.size

    }

    fun setData(todoData: List<ToDoData>) {
        this.dataList = todoData
        notifyDataSetChanged()
    }
}

