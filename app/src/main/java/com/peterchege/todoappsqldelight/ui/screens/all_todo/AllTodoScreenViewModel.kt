package com.peterchege.todoappsqldelight.ui.screens.all_todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peterchege.todoappsqldelight.data.TodoDataSource
import com.peterchege.todoappsqldelight.toExternalModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class AllTodoScreenViewModel(
    todoDataSource: TodoDataSource,
) : ViewModel() {

    val todos = todoDataSource.getAllTodos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )


}