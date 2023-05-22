package com.example.music_tracker.ui.instrument.newinstrument

import android.os.Bundle
import android.text.Spannable.Factory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.music_tracker.R
import com.example.music_tracker.databinding.FragmentNewInstrumentBinding
import com.example.music_tracker.ui.instrument.viewmodel.InstrumentViewModel

class NewInstrumentFragment : Fragment() {
    private lateinit var binding: FragmentNewInstrumentBinding

    private val instrumentVM: InstrumentViewModel by activityViewModels {
        InstrumentViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewInstrumentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = instrumentVM
    }

    private fun observeStatus() {
        instrumentVM.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(InstrumentViewModel.INSTRUMENT_CREATED) -> {
                    instrumentVM.clearStatus()
                    findNavController().popBackStack()
                }

                status.equals(InstrumentViewModel.WRONG_INFO) -> {
                    instrumentVM.clearStatus()
                }
            }
        }
    }
}