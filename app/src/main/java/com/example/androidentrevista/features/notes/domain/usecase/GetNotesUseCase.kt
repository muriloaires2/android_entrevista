package com.example.androidentrevista.features.notes.domain.usecase

import com.example.androidentrevista.features.notes.domain.model.Note
import com.example.androidentrevista.features.notes.domain.repository.NotesRepository

class GetNotesUseCase(
    private val notesRepository: NotesRepository
) {

    suspend operator fun invoke(): Result<List<Note>> {
        return notesRepository.getNotes()
    }

}

