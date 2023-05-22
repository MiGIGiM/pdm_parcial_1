package com.example.music_tracker.ui.instrument

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.music_tracker.R
import com.example.music_tracker.databinding.FragmentInstrumentDetailBinding
import com.example.music_tracker.databinding.FragmentNewInstrumentBinding
import com.example.music_tracker.ui.instrument.viewmodel.InstrumentViewModel


class InstrumentDetail : Fragment() {
    private lateinit var binding: FragmentInstrumentDetailBinding

    private val instrumentVM: InstrumentViewModel by activityViewModels {
        InstrumentViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstrumentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        bindData()
    }

    private fun setViewModel() {
        binding.viewmodel = instrumentVM
    }

    private fun bindData() {
        binding.instrumentNameTextView.text = instrumentVM.name.value
        binding.instrumentCategoryTextView.text = instrumentVM.category.value
    }
}