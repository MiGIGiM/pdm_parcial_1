package com.example.music_tracker.ui.instrument.directory.recyclerview

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.music_tracker.data.model.InstrumentModel
import com.example.music_tracker.databinding.InstrumentItemBinding

class InstrumentRecyclerViewHolder(private val binding: InstrumentItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(instrument: InstrumentModel, clickListener: (InstrumentModel) -> Unit) {
        binding.instrumentNameCardTextView.text = instrument.name

        binding.instrumentCardView.setOnClickListener {
            clickListener(instrument)
        }
    }
}