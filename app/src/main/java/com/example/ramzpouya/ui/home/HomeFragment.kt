package com.example.ramzpouya.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ramzpouya.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnGenerate.setOnClickListener{
            homeViewModel.generateRand()
        }

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        homeViewModel.counter.observe(viewLifecycleOwner){
            binding.counterChars.setNumber(it.charNumbers)
            binding.counterNumbers.setNumber(it.numberNumbers)
            binding.counterSpecials.setNumber(it.specialNumbers)
            binding.txtSum.text = (it.charNumbers + it.numberNumbers + it.specialNumbers).toString()
        }

        //homeViewModel.updateCounter(CountModel(5,5,5))
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}