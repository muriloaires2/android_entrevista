package com.example.androidentrevista.features.notes.domain.usecase

import com.example.androidentrevista.features.notes.domain.model.Note
import com.example.androidentrevista.features.notes.domain.repository.NotesRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetNotesUseCaseTest {
    private val notesRepository = mockk<NotesRepository>()
    private val getNotesUseCase = GetNotesUseCase(notesRepository)

    @Test
    fun `invoke should return a list of notes`() {
        runBlocking {
            val expectedNote = Note(id = 1, title = "test", content = "test")

            coEvery {
                getNotesUseCase()
            } returns Result.success(
                listOf(
                    expectedNote
                )
            )

            getNotesUseCase()

            coVerify { getNotesUseCase() }

            assert(getNotesUseCase().getOrNull() == listOf(expectedNote))

        }
    }
}