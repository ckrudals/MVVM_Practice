package com.example.mvvmpr.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mvvmpr.R
import com.example.mvvmpr.databinding.FragmentListBinding

class ListFragment : Fragment() {


    lateinit var binding: FragmentListBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)
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