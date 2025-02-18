package com.example.androidentrevista.features.notes.data.repository.remote.repository


import com.example.androidentrevista.features.notes.data.repository.remote.NotesAPI
import com.example.androidentrevista.features.notes.data.repository.remote.model.NoteDTO
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response

class NotesRemoteRepositoryImpl(
    private val notesAPI: NotesAPI
) : NotesRemoteRepository {

    override suspend fun getNotes(): Response<List<NoteDTO>> {
        return notesAPI.getNotes()
    }

    override suspend fun addNote(note: NoteDTO): Response<NoteDTO> {
        return notesAPI.addNote(note)
    }

    override suspend fun deleteNote(noteId: Int): Response<Unit> {
        return notesAPI.deleteNote(noteId)
    }

    override suspend fun logEvent(event: String) {
        HttpLoggingInterceptor.Logger.DEFAULT.log(event)
    }
}