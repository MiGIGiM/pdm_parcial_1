package com.example.music_tracker

import android.app.Application
import com.example.music_tracker.data.instruments
import com.example.music_tracker.repository.InstrumentRepository

class InstrumentTrackerApplication : Application() {
    val instrumentRepository: InstrumentRepository by lazy {
        InstrumentRepository(instruments)
    }
}