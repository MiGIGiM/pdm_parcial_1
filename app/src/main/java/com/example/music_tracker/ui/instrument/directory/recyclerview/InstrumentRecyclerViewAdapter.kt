package com.example.music_tracker.ui.instrument.directory.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music_tracker.data.model.InstrumentModel
import com.example.music_tracker.databinding.InstrumentItemBinding

class InstrumentRecyclerViewAdapter(
    private val clickListener: (InstrumentModel) -> Unit
) : RecyclerView.Adapter<InstrumentRecyclerViewHolder>() {
    private val instruments = ArrayList<InstrumentModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstrumentRecyclerViewHolder {
        val binding = InstrumentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InstrumentRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InstrumentRecyclerViewHolder, position: Int) {
        val movie = instruments[position]
        holder.bind(movie, clickListener)
    }

    override fun getItemCount(): Int = instruments.size

    fun setData(moviesList: List<InstrumentModel>) {
        instruments.clear()
        instruments.addAll(moviesList)
    }
}