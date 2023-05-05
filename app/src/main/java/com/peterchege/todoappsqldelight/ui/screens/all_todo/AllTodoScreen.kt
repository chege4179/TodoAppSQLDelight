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

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.peterchege.todoappsqldelight.Todo
import com.peterchege.todoappsqldelight.toExternalModel
import com.peterchege.todoappsqldelight.ui.components.TodoCard
import com.peterchege.todoappsqldelight.util.Screens
import org.koin.androidx.compose.getViewModel

@Composable
fun AllTodoScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<AllTodoScreenViewModel>()
    val todos = viewModel.todos.collectAsStateWithLifecycle()
        .value
        .map {
            it.toExternalModel()
        }

    AllTodoScreenContent(
        todos = todos,
        navController = navController,
        updateTodo = { id,isDone ->
            viewModel.updateTodoStatus(
                todoId = id,
                isDone = if (isDone) "1" else "0"
            )
        },
        deleteTodo = {
            viewModel.deleteTodo(it)
        },
        onTodoNavigate = {
            navController.navigate(Screens.SINGLE_TODO_SCREEN + "/${it}")

        }
    )

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AllTodoScreenContent(
    todos: List<Todo>,
    navController: NavController,
    updateTodo: (String,Boolean) -> Unit,
    deleteTodo: (String) -> Unit,
    onTodoNavigate: (String) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("My Todo App")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(route = Screens.CREATE_TODO_SCREEN)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Create Todo",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            items(items = todos) {
                TodoCard(
                    todo = it,
                    onTodoNavigate = {
                        onTodoNavigate(it)

                    },
                    onTodoUpdate = { id,isDone ->
                        updateTodo(id,isDone)
                    },
                    onTodoDelete = {
                        deleteTodo(it)
                    }
                )
            }

        }
    }


}