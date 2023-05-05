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
            }catch (e:Exception){

            }
        }
    }

}