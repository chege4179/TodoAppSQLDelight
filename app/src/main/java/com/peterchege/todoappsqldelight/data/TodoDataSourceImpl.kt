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

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.peterchege.todoappsqldelight.TodoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import todoapp.tododb.TodoEntity

class TodoDataSourceImpl (
    db:TodoDatabase
) :TodoDataSource{
    private val queries = db.todoEntityQueries
    override fun getAllTodos(): Flow<List<TodoEntity>> {
        return queries.getAllTodos().asFlow().mapToList(context = Dispatchers.IO)
    }

    override suspend fun getTodoById(id: Long): TodoEntity? = withContext(Dispatchers.IO) {
        return@withContext queries.getTodoById(todoId = id).executeAsOneOrNull()
    }

    override suspend fun deleteTodoById(id: Long) {
        withContext(Dispatchers.IO){
            queries.deleteTodoById(todoId = id)
        }
    }

    override suspend fun insertTodo(todoName: String, todoDescription: String, isDone: String) {
       withContext(Dispatchers.IO){
           queries.insertTodo(
               todoId = null,todoName = todoName,todoDescription = todoDescription, isDone = isDone)
       }
    }

    override suspend fun updateTodo(todoId: String, isDone: String) {
        withContext(Dispatchers.IO){
            queries.updateTodoStatus(isDone = isDone,todoId = todoId.toLong())
        }
    }
}

