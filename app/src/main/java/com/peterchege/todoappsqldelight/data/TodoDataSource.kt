package com.peterchege.todoappsqldelight.data

import kotlinx.coroutines.flow.Flow
import todoapp.tododb.TodoEntity

interface TodoDataSource {

    fun getAllTodos(): Flow<List<TodoEntity>>

    suspend fun getTodoById(id:Long):TodoEntity?

    suspend fun deletePersonById(id:Long)

    suspend fun insertTodo(todoName:String, todoDescription:String,isDone:String)



}