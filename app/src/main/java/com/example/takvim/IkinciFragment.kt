package com.example.takvim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.takvim.databinding.FragmentIkinciBinding

class IkinciFragment : Fragment() {

    private lateinit var binding: FragmentIkinciBinding
    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Activity'ye bağlı ViewModel kullanıyoruz
        myViewModel = ViewModelProvider(requireActivity())[MyViewModel::class.java]

        binding = FragmentIkinciBinding.inflate(inflater, container, false)

        // Sayaç değişikliklerini gözlemliyoruz
        myViewModel.counter.observe(viewLifecycleOwner) { counter ->
            binding.counterDeger.text = counter.toString()
        }

        return binding.root
    }
}
