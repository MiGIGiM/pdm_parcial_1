package com.example.music_tracker.ui.instrument.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.music_tracker.data.model.InstrumentModel
import com.example.music_tracker.repository.InstrumentRepository
import com.example.music_tracker.InstrumentTrackerApplication

class InstrumentViewModel(private val instrumentRepository: InstrumentRepository) : ViewModel() {
    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var status = MutableLiveData("")

    fun getInstruments() = instrumentRepository.getInstruments()

    fun addInstrument(instrument: InstrumentModel) = instrumentRepository.addInstrument(instrument)

    fun createInstrument() {
        if (!validateData()) {
            status.value = WRONG_INFO
            return
        }

        val instrument = InstrumentModel(
            name.value!!,
            category.value!!,
        )


        addInstrument(instrument)

        clearData()

        status.value = INSTRUMENT_CREATED
    }

    fun clearData() {
        name.value = ""
        category.value = ""
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun setSelectedInstrument(instrument: InstrumentModel) {
        name.value = instrument.name
        category.value = instrument.category
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as InstrumentTrackerApplication
                InstrumentViewModel(app.instrumentRepository)
            }
        }

        const val INSTRUMENT_CREATED = "Instrument created"
        const val WRONG_INFO = "Wrong information"
        const val INACTIVE = ""
    }
}