package ru.maxtere.sdk.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : BaseViewState, Event : BaseEvent> : ViewModel() {
    private val _state = MutableStateFlow(this.initialState())
    private val _events = Channel<Event>()

    val state = _state.asStateFlow()
    val events = _events.receiveAsFlow()

    abstract fun initialState(): State

    fun updateState(block: State.() -> State) {
        _state.value = block(_state.value)
    }

    fun pushEvent(event: Event) {
        viewModelScope.launch { _events.send(event) }
    }
}