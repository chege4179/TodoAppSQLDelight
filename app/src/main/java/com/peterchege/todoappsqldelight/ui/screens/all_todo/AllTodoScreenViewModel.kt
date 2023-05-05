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
package com.peterchege.todoappsqldelight.ui.screens.all_todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peterchege.todoappsqldelight.data.TodoDataSource
import com.peterchege.todoappsqldelight.toExternalModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AllTodoScreenViewModel(
    private val todoDataSource: TodoDataSource,
) : ViewModel() {

    val todos = todoDataSource.getAllTodos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )


    fun updateTodoStatus(todoId:String,isDone:String){
        viewModelScope.launch {
            try {
                todoDataSource.updateTodo(todoId = todoId, isDone = isDone)
            }catch (e:Exception){

            }
        }
    }

    fun deleteTodo(todoId:String){
        viewModelScope.launch {
            try {
                todoDataSource.deleteTodoById(id = todoId.toLong())
            }catch (e:Exception){

            }
        }
    }


}