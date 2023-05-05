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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.peterchege.todoappsqldelight.Todo
import org.koin.androidx.compose.getViewModel

@Composable
fun SingleTodoScreen(
    navController: NavController
) {
    val viewModel = getViewModel<SingleTodoScreenViewModel>()
    val todo = viewModel.todo.collectAsStateWithLifecycle()


    SingleTodoScreenContent(todo = todo.value)

}
@Composable
fun SingleTodoScreenContent(
    todo: Todo?
){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { it ->
        Column(
            modifier = Modifier.fillMaxSize().padding(it)
        ) {
            if (todo != null){
                Text(text = "Todo ID: " + todo.todoId)
                Text(text = "Todo Name: " + todo.todoName)
                Text(text = "Todo Description: " + todo.todoDescription)
                Text(text = "Is Complete: " + todo.isDone)
            }else{
                Text(text = "No todo found")
            }
        }
    }

}