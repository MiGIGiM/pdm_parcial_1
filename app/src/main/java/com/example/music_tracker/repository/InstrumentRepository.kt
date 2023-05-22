package com.example.music_tracker.repository

import com.example.music_tracker.data.model.InstrumentModel

class InstrumentRepository(private val instruments: MutableList<InstrumentModel>)  {

    fun getInstruments() = instruments

    fun addInstrument(instrument: InstrumentModel) {
        instruments.add(instrument)
    }
}