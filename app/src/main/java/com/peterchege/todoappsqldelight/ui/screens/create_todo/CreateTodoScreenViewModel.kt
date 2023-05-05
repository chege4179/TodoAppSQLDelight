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
package com.peterchege.todoappsqldelight.ui.screens.create_todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peterchege.todoappsqldelight.data.TodoDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID


data class TodoFormState(
    val name:String = "",
    val description:String = "",
    val isDone:String = "0",
    val todoId:String = UUID.randomUUID().toString(),
)
class CreateTodoScreenViewModel (
    private val todoDataSource: TodoDataSource,
): ViewModel() {


    private val _formState = MutableStateFlow(TodoFormState())
    val formState = _formState.asStateFlow()

    fun updateTodoName(text:String){
        _formState.value = _formState.value.copy(name = text)
    }

    fun updateTodoDescription(text:String){
        _formState.value = _formState.value.copy(description = text)
    }

    fun saveTodo(){
        viewModelScope.launch {
            try {
                todoDataSource.insertTodo(
                    todoName = _formState.value.name,
                    todoDescription = _formState.value.description,
                    isDone = _formState.value.isDone
                )
                _formState.value = TodoFormState(
                    todoId = UUID.randomUUID().toString(),
                    name = "",
                    description = "",
                    isDone = "0"
                )
            }catch (e:Exception){

            }
        }
    }

}