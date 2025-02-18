package com.example.androidentrevista.features.notes.domain.repository

import com.example.androidentrevista.features.notes.domain.model.Note

interface NotesRepository {

    suspend fun getNotes(): Result<List<Note>>

    suspend fun addNote(note: Note): Result<Note>

    suspend fun deleteNote(note: Note): Result<Unit>

}