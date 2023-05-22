package com.example.music_tracker.ui.instrument

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.music_tracker.data.model.InstrumentModel
import com.example.music_tracker.repository.InstrumentRepository
import com.example.music_tracker.InstrumentTrackerApplication

class InstrumentViewModel(private val instrumentRepository: InstrumentRepository) : ViewModel() {

    fun getInstruments() = instrumentRepository.getInstruments()

    fun addInstrument(instrument: InstrumentModel) = instrumentRepository.addInstrument(instrument)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as InstrumentTrackerApplication
                InstrumentViewModel(app.instrumentRepository)
            }
        }
    }
}