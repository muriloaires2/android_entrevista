package com.example.androidentrevista.features.notes.data.repository.remote.mapper

import com.example.androidentrevista.features.notes.data.repository.remote.model.NoteDTO
import com.example.androidentrevista.features.notes.domain.model.Note

interface NotesMapper {

    fun mapListToDomain(remoteNotes: List<NoteDTO>): List<Note>

    fun mapToDomain(remoteNotes: NoteDTO): Note

    fun toDTO(note: Note): NoteDTO
}