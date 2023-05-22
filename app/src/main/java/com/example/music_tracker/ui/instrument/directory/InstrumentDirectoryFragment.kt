package com.example.music_tracker.ui.instrument.directory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music_tracker.R
import com.example.music_tracker.data.model.InstrumentModel
import com.example.music_tracker.databinding.FragmentInstrumentDirectoryBinding
import com.example.music_tracker.ui.instrument.directory.recyclerview.InstrumentRecyclerViewAdapter
import com.example.music_tracker.ui.instrument.viewmodel.InstrumentViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InstrumentDirectoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstrumentDirectoryFragment : Fragment() {
    private lateinit var btnCreateNewInstrument: FloatingActionButton
    private lateinit var binding: FragmentInstrumentDirectoryBinding
    private lateinit var adapter: InstrumentRecyclerViewAdapter

    private val instrumentVM: InstrumentViewModel by activityViewModels {
        InstrumentViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstrumentDirectoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCreateNewInstrument = view.findViewById(R.id.btnNavCreateNewInstrument)

        setRecyclerView(view)

        btnCreateNewInstrument.setOnClickListener {
            instrumentVM.clearData()
        }

    }

    private fun showSelectedItem(ins: InstrumentModel) {
        instrumentVM.setSelectedInstrument(ins)
    }

    private fun display() {
        adapter.setData(instrumentVM.getInstruments())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.instrumentRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = InstrumentRecyclerViewAdapter{selected ->
            showSelectedItem(selected)
        }

        binding.instrumentRecyclerView.adapter = adapter
        display()
    }
}