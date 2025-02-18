package com.example.androidentrevista

import android.app.Application
import com.example.androidentrevista.features.notes.di.NotesModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NotesApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@NotesApp)
            // Load modules
            modules(NotesModules.notesModule)
        }
    }
}