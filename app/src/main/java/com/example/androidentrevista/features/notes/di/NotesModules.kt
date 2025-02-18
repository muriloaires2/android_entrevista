package com.example.androidentrevista.features.notes.di


import com.example.androidentrevista.features.notes.data.repository.NotesRepositoryImpl
import com.example.androidentrevista.features.notes.data.repository.remote.mapper.NotesMapper
import com.example.androidentrevista.features.notes.data.repository.remote.mapper.NotesMapperImpl
import com.example.androidentrevista.features.notes.data.repository.remote.repository.NotesRemoteRepository
import com.example.androidentrevista.features.notes.data.repository.remote.repository.NotesRemoteRepositoryImpl
import com.example.androidentrevista.features.notes.domain.repository.NotesRepository
import com.example.androidentrevista.features.notes.domain.usecase.GetNotesUseCase
import com.example.androidentrevista.features.notes.presentation.list.ListNotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

object NotesModules {

    val notesModule = module {

        singleOf(::NotesRepositoryImpl) { bind<NotesRepository>() }
        singleOf(::NotesRemoteRepositoryImpl) { bind<NotesRemoteRepository>() }
        factoryOf(::GetNotesUseCase)
        factoryOf(::NotesMapperImpl) { bind<NotesMapper>() }
        viewModelOf(::ListNotesViewModel)
    }
}