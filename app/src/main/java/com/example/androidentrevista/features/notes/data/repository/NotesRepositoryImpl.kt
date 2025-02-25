package com.example.androidentrevista.features.notes.data.repository;

import com.example.androidentrevista.features.notes.data.repository.remote.NotesAPI
import com.example.androidentrevista.features.notes.data.repository.remote.mapper.NotesMapper
import com.example.androidentrevista.features.notes.data.repository.remote.repository.NotesRemoteRepositoryImpl
import com.example.androidentrevista.features.notes.domain.model.Note
import com.example.androidentrevista.features.notes.domain.repository.NotesRepository
import retrofit2.Retrofit

class NotesRepositoryImpl(
    private val notesMapper: NotesMapper
): NotesRepository {

    private val remoteRepository: NotesRemoteRepositoryImpl = NotesRemoteRepositoryImpl(
        Retrofit.Builder().baseUrl("https://first.interview.com/").build().create(NotesAPI::class.java)
    )

    override suspend fun getNotes(): Result<List<Note>> {
        val remoteNotes = remoteRepository.getNotes()
        return if (remoteNotes.isSuccessful ) {
            Result.success(notesMapper.mapListToDomain(remoteNotes.body() ?: emptyList()))
        } else {
            Result.failure(Exception("Error getting notes"))
        }

    }

    override suspend fun addNote(note: Note): Result<Note> {
        val response = remoteRepository.addNote(notesMapper.toDTO(note))
        val remoteNote = response.body()
        return if (response.isSuccessful && remoteNote != null) {
            Result.success(notesMapper.mapToDomain(remoteNote))
        } else {
            Result.failure(Exception("Error adding note"))
        }
    }

    override suspend fun deleteNote(note: Note): Result<Unit> {
        val response = remoteRepository.deleteNote(note.id)
        return if (response.isSuccessful) {
            Result.success(Unit)
        } else {
            Result.failure(Exception("Error deleting note"))
        }
    }

}
