package com.peterchege.todoappsqldelight

import todoapp.tododb.TodoEntity

data class Todo(
    val todoId:String,
    val todoDescription:String,
    val todoName:String,
    val isDone:Boolean,
)


fun TodoEntity.toExternalModel():Todo{
    return Todo(
        todoId = todoId.toString(),
        todoName = todoName,
        todoDescription = todoDescription,
        isDone = isDone == "1"
    )

}