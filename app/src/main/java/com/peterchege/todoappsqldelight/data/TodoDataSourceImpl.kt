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

    override suspend fun deletePersonById(id: Long) {
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
}

