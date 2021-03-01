package com.example.mvvmpr.fragment.add

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.mvvmpr.R
import com.example.mvvmpr.databinding.FragmentAddBinding
import com.example.mvvmpr.databinding.FragmentListBinding


class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        //set menu
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}