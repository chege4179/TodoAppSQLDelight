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
package com.peterchege.todoappsqldelight.data

import kotlinx.coroutines.flow.Flow
import todoapp.tododb.TodoEntity

interface TodoDataSource {

    fun getAllTodos(): Flow<List<TodoEntity>>

    suspend fun getTodoById(id:Long):TodoEntity?

    suspend fun deleteTodoById(id:Long)

    suspend fun insertTodo(todoName:String, todoDescription:String,isDone:String)


    suspend fun updateTodo(todoId:String,isDone: String)

}