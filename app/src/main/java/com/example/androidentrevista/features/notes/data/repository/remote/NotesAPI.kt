package com.example.androidentrevista.features.notes.data.repository.remote

import com.example.androidentrevista.features.notes.data.repository.remote.model.NoteDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NotesAPI {

    @GET("/notes")
    suspend fun getNotes(): Response<List<NoteDTO>>

    @POST("/notes")
    suspend fun addNote(@Body note: NoteDTO): Response<NoteDTO>

    @DELETE("/notes/{id}")
    suspend fun deleteNote(@Path("id") id: Int): Response<Unit>


}