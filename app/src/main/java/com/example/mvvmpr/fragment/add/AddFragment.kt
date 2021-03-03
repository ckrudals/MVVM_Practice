package com.example.mvvmpr.fragment.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvmpr.R
import com.example.mvvmpr.data.models.Priority
import com.example.mvvmpr.data.models.ToDoData
import com.example.mvvmpr.data.viewmodel.ToDoViewModel
import com.example.mvvmpr.databinding.FragmentAddBinding
import kotlinx.coroutines.InternalCoroutinesApi


class AddFragment : Fragment() {
    //    binding 서언
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    //viewModel 선언
    @InternalCoroutinesApi
    private val mToDoViewModel:
            ToDoViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        //set menu
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @InternalCoroutinesApi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            insertDataToDb()
        }
        return super.onOptionsItemSelected(item)
    }

    @InternalCoroutinesApi
    private fun insertDataToDb() {
        val mTitle = binding.titleEt.text.toString()
        val mPriority = binding.prioritiesSpinner.selectedItem.toString()
        val mDescription = binding.descriptionEt.text.toString()

        val validation = verifyDtaFromUser(mTitle, mDescription)
        if (validation) {
            // Insert Data
            val newData = ToDoData(
                0,
                mTitle,
                parsePriority(mPriority),
                mDescription
            )
            mToDoViewModel.insertData(newData) //오류 왜 나지?? 선언을 잘못햇나??
            Toast.makeText(requireContext(), "Successfully added! ", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "빈칸을 채워주세요! ", Toast.LENGTH_SHORT).show()
        }

    }

    private fun verifyDtaFromUser(title: String, description: String): Boolean {
        // TextUtils 이란, Android 에서 제공하는 TextView null 체크 방식이다.
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            false
        } else
            !(title.isEmpty() || description.isEmpty())
    }

    private fun parsePriority(priority: String): Priority {
        return when (priority) {
            "High Priority" -> (Priority.HIGH)

            "Medium Priority" -> (Priority.MEDIUM)

            "Low Priority" -> (Priority.LOW)

            else -> Priority.LOW
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}