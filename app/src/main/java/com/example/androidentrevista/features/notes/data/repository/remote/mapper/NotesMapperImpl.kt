package com.example.androidentrevista.features.notes.data.repository.remote.mapper

import com.example.androidentrevista.features.notes.data.repository.remote.model.NoteDTO
import com.example.androidentrevista.features.notes.domain.model.Note

class NotesMapperImpl: NotesMapper {
    override fun mapListToDomain(remoteNotes: List<NoteDTO>): List<Note> {
        return remoteNotes.map { noteDTO -> Note(noteDTO.id, noteDTO.title, noteDTO.content) }
    }

    override fun mapToDomain(remoteNotes: NoteDTO): Note {
        return Note(remoteNotes.id, remoteNotes.title, remoteNotes.content)
    }

    override fun toDTO(note: Note): NoteDTO {
        return NoteDTO(note.id, note.title, note.content)
    }
}