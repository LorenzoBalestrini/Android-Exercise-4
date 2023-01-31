package com.example.myfirstapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myfirstapplication.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    private var _binding : Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonInFragment1.setOnClickListener {
            Toast.makeText(requireContext(), R.string.toast_string, Toast.LENGTH_LONG).show() }

        binding.buttonGoToFragment2.setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment2)

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}