package com.example.mvvmpr.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmpr.R
import com.example.mvvmpr.data.viewmodel.ToDoViewModel
import com.example.mvvmpr.databinding.FragmentListBinding
import com.example.mvvmpr.fragment.list.ListAdapter
import kotlinx.coroutines.InternalCoroutinesApi
import java.util.*

@InternalCoroutinesApi
class ListFragment : Fragment() {


    private val mToDoViewModel: ToDoViewModel by viewModels()
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
            adapter.setData(data)
        })

        //Flaoting Button Listener
        binding.floatingActionButton.setOnClickListener() {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)

        }

        binding.listLayout.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_updateFragment)
        }

        //set Menu
        setHasOptionsMenu(true)
        // binding return
        return binding.root


    }

    //menu Setting
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}