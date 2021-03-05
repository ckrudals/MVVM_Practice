package com.example.mvvmpr.update

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mvvmpr.R
import com.example.mvvmpr.data.models.Priority
import com.example.mvvmpr.data.models.ToDoData
import com.example.mvvmpr.data.viewmodel.ToDoViewModel
import com.example.mvvmpr.databinding.FragmentUpdateBinding
import com.example.mvvmpr.fragment.SharedViewModel
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
class UpdateFragment : Fragment() {


    //kotlin 은 기본적으로 클래스는 final 이다. 그래서 상속을 받으려면 class 명 앞에 open 을 붙인다.
    //상속을 허용하지 않은 클래스에 새로운 기능을 추가할때 붙이는게 by 이다.
    //by를 붙이면 상속하지 않고 새로운 기능을 추가할 수 있다
    private val args by navArgs<UpdateFragmentArgs>()
    lateinit var binding: FragmentUpdateBinding
    private val mSharedViewModel: SharedViewModel by viewModels()
    private val mToDoViewModel: ToDoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        //set menu
        setHasOptionsMenu(true)

        // --ToDoData 에 있는 값을 저장?--
        binding.currentTitleEt.setText(args.currentItem.title)
        binding.currentDescriptionEt.setText(args.currentItem.description)
        //2번째 포지션으로 이동한다
        binding.currentTitleEtPrioritiesSpinner.setSelection(
            mSharedViewModel.parsePriorityToInt(
                args.currentItem.priority
            )
        )
        binding.currentTitleEtPrioritiesSpinner.onItemSelectedListener = mSharedViewModel.listener

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_save -> updateItem()
            R.id.menu_delete -> confirmItemRemval()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun confirmItemRemval() {

        //Create Dialog
        val builder= AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_->
            //데이터 가져옴
           mToDoViewModel.deleteItem(args.currentItem)
            Toast.makeText(requireContext(),"Successfully Removed : ${args.currentItem.title}",Toast.LENGTH_SHORT).show()
            //back button
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_,_->}
        builder.setTitle("Delete ${args.currentItem.title}?")
        builder.setMessage("Are your sure you want to remove ${args.currentItem.title}?")
        builder.create().show()
    }

    private fun updateItem() {
        val title = binding.currentTitleEt.text.toString()
        val description = binding.currentDescriptionEt.text.toString()
        val getPriority = binding.currentTitleEtPrioritiesSpinner.selectedItem.toString()

        val validation = mSharedViewModel.verifyDtaFromUser(title, description)
        if (validation) {
            // Update Current Item
            val updatedItem = ToDoData(
                args.currentItem.id,
                title,
                mSharedViewModel.parsePriority(getPriority),
                description

            )
            mToDoViewModel.updateData(updatedItem)
            Toast.makeText(requireContext(), "Successfully updated!", Toast.LENGTH_SHORT).show()

            //Navigate back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields. ", Toast.LENGTH_SHORT)
                .show()

        }
    }
}