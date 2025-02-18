package com.example.androidentrevista.features.notes.domain.usecase

import com.example.androidentrevista.features.notes.data.repository.NotesRepositoryImpl
import com.example.androidentrevista.features.notes.data.repository.remote.NotesAPI
import com.example.androidentrevista.features.notes.data.repository.remote.mapper.NotesMapperImpl
import com.example.androidentrevista.features.notes.data.repository.remote.repository.NotesRemoteRepositoryImpl
import com.example.androidentrevista.features.notes.domain.model.Note
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class AddNotesUseCase {
    private val notesRepository = NotesRepositoryImpl(
        notesMapper = NotesMapperImpl(),
        remoteRepository = NotesRemoteRepositoryImpl(
            Retrofit.Builder().build().create(NotesAPI::class.java)
        )
    )

    suspend fun addNote(note: Note): Result<Note> {
        return notesRepository.addNote(note).onFailure {
            HttpLoggingInterceptor.Logger.DEFAULT.log("Erro ao adicionar nota: $it")
        }
    }
}