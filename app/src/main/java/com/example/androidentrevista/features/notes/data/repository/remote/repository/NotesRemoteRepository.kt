package com.example.androidentrevista.features.notes.data.repository.remote.repository

import com.example.androidentrevista.features.notes.data.repository.remote.model.NoteDTO
import retrofit2.Response

interface NotesRemoteRepository {

    suspend fun getNotes(): Response<List<NoteDTO>>

    suspend fun addNote(note: NoteDTO): Response<NoteDTO>

    suspend fun deleteNote(noteId: Int): Response<Unit>

}