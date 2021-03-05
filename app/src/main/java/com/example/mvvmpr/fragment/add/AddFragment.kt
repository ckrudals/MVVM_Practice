package com.example.mvvmpr.fragment.add

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvmpr.R
import com.example.mvvmpr.data.models.ToDoData
import com.example.mvvmpr.data.viewmodel.ToDoViewModel
import com.example.mvvmpr.databinding.FragmentAddBinding
import com.example.mvvmpr.fragment.SharedViewModel
import kotlinx.coroutines.InternalCoroutinesApi


class AddFragment : Fragment() {
    //    binding 서언
    private var _binding: FragmentAddBinding? = null
    private val mSharedViewModel: SharedViewModel by viewModels()
    private val binding get() = _binding!!

    //viewModel 선언
    @InternalCoroutinesApi
    private  val mTodoViewModel: ToDoViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        //set menu
        setHasOptionsMenu(true)

        binding.prioritiesSpinner.onItemSelectedListener=mSharedViewModel.listener
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

        val validation = mSharedViewModel.verifyDtaFromUser(mTitle, mDescription)
        if (validation) {
            // Insert Data
            val newData = ToDoData(
                0,
                mTitle,
                    mSharedViewModel.parsePriority(mPriority),
                mDescription
            )

            Log.e(TAG, "insertDataToDb: ${mTodoViewModel.insertData(newData)}")
           // mTodoViewModel.insertData(newData) //Error
            Toast.makeText(requireContext(), "Successfully added! ", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "빈칸을 채워주세요! ", Toast.LENGTH_SHORT).show()
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}