package com.example.androidentrevista.features.notes.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidentrevista.features.notes.domain.model.Note
import com.example.androidentrevista.features.notes.domain.usecase.GetNotesUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListNotesViewModel(
    private val getNotesUseCase: GetNotesUseCase,
) : ViewModel() {

    private val _failure = MutableSharedFlow<String>()
    val failure: SharedFlow<String> = _failure

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    fun handleAction(action: ListNotesScreenAction) {
        when (action) {
            ListNotesScreenAction.Initialized -> executeInitialized()
        }
    }

    private fun executeInitialized() = viewModelScope.launch {

        val result = getNotesUseCase()
        result.onSuccess { notes ->
            _notes.value = notes
        }.onFailure {
            _failure.emit("Erro ao carregar notas")
        }

    }

}