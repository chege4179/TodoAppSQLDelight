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

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun CreateTodoScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<CreateTodoScreenViewModel>()
    val formState = viewModel.formState.collectAsStateWithLifecycle()

    CreateTodoScreenContent(
        formState = formState.value,
        saveTodo = { viewModel.saveTodo() },
        onChangeTodoName = { viewModel.updateTodoName(it) },
        onChangeTodoDescription = { viewModel.updateTodoDescription(it) }
    )

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateTodoScreenContent(
    formState: TodoFormState,
    saveTodo: () -> Unit,
    onChangeTodoName: (String) -> Unit,
    onChangeTodoDescription: (String) -> Unit,

    ) {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            TextField(
                value = formState.name,
                onValueChange = {
                    onChangeTodoName(it)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Name"
                    )
                },
                textStyle = TextStyle(
                    color = MaterialTheme.colors.primary
                )

            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = formState.description,
                onValueChange = {
                    onChangeTodoDescription(it)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Description"
                    )
                },
                textStyle = TextStyle(
                    color = MaterialTheme.colors.primary
                )

            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { saveTodo() }
            ) {
                Text(text = "Save Todo")
            }
        }

    }

}