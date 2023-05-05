/*
 * Copyright 2023 Todo App By Peter Chege
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.peterchege.todoappsqldelight.ui.screens.single_todo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peterchege.todoappsqldelight.Todo
import com.peterchege.todoappsqldelight.data.TodoDataSource
import com.peterchege.todoappsqldelight.toExternalModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SingleTodoScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val todoDataSource: TodoDataSource,
) : ViewModel() {

    private val _todo = MutableStateFlow<Todo?>(null)
    val todo = _todo.asStateFlow()

    init {
        savedStateHandle.get<String>("id").let {
            if (it != null) {
                getTodoById(it)
            }
        }
    }


    private fun getTodoById(id: String) {
        viewModelScope.launch {
            try {
                val todo = todoDataSource.getTodoById(id = id.toLong())
                if (todo != null) {
                    _todo.value = todo.toExternalModel()
                }
            } catch (e: Exception) {

            }
        }
    }

}