package com.example.mvvmpr.update

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.mvvmpr.R
import com.example.mvvmpr.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment() {
    lateinit var binding: FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        //set menu
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}