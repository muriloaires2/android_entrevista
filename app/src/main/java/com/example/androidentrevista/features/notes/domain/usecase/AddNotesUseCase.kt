package com.example.androidentrevista.features.notes.domain.usecase

import com.example.androidentrevista.features.notes.domain.model.Note
import com.example.androidentrevista.features.notes.domain.repository.NotesRepository
import okhttp3.logging.HttpLoggingInterceptor

class AddNotesUseCase(private val notesRepository: NotesRepository) {

    suspend fun addNote(note: Note): Result<Note> {
        return notesRepository.addNote(note).onFailure {
            HttpLoggingInterceptor.Logger.DEFAULT.log("Erro ao adicionar nota: $it")
        }
    }
}