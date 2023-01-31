package com.example.myfirstapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.myfirstapplication.databinding.Fragment1Binding
import com.example.myfirstapplication.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    private var _binding : Fragment2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGoToFragment1.setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_fragment1)
        }

        binding.buttonGoToListActivity.setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_list_activity)
        }


        binding.editTextGoToListActivity.doOnTextChanged { text, start, before, count ->
            if(binding.editTextGoToListActivity.text.trim().contentEquals("Y",true)){
                binding.buttonGoToListActivity.isEnabled = true
            }else if(binding.editTextGoToListActivity.text.trim().contentEquals("N",true)){
                Toast.makeText(requireContext(), R.string.toast_edit_text, Toast.LENGTH_SHORT).show()
                binding.buttonGoToListActivity.isEnabled = false
            }else{
                binding.buttonGoToListActivity.isEnabled = false
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}