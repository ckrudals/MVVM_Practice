package com.example.mvvmpr.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmpr.R
import com.example.mvvmpr.data.viewmodel.ToDoViewModel
import com.example.mvvmpr.databinding.FragmentListBinding
import com.example.mvvmpr.fragment.SharedViewModel
import com.example.mvvmpr.fragment.list.ListAdapter
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class ListFragment : Fragment() {


    private val mToDoViewModel: ToDoViewModel by viewModels()
    private val mSharedViewModel: SharedViewModel by viewModels()
    private val adapter: ListAdapter by lazy { ListAdapter() } //선언과 동시에 초기화
    lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)

        val recyclerView = binding.recyclerView //adapter
        recyclerView.adapter = adapter //adapter 연결
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mToDoViewModel.getAllData.observe(viewLifecycleOwner, androidx.lifecycle.Observer { data ->
            mSharedViewModel.checkIfDatabaseEmpty(data)
            adapter.setData(data)
        })

        mSharedViewModel.emptyDatabase.observe(viewLifecycleOwner, Observer {
            showEmptyDatabaseView(it)
        })

        //Flaoting Button Listener
        binding.floatingActionButton.setOnClickListener() {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)

        }


        //set Menu
        setHasOptionsMenu(true)
        // binding return
        return binding.root


    }

    // list 가 없으면 ImageView 와 TextView show
    private fun showEmptyDatabaseView(emptyDatabase: Boolean) {
        if (emptyDatabase) {
            binding.noDataImageView.visibility = View.VISIBLE
            binding.noDataTextView.visibility=View.VISIBLE
        }else{
            binding.noDataImageView.visibility = View.INVISIBLE
            binding.noDataTextView.visibility=View.INVISIBLE
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete_all) {
            confiremRemoval()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun confiremRemoval() {
        //Create Dialog
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            //데이터 가져옴
            mToDoViewModel.deleteAll()
            Toast.makeText(
                requireContext(), "Successfully Removed EveryThing",
                Toast.LENGTH_SHORT
            ).show()

        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete EveryThing?")
        builder.setMessage("Are your sure you want to remove Everything")
        builder.create().show()
    }

    //menu Setting
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}