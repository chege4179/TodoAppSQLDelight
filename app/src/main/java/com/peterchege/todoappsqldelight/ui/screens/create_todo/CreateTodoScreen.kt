package com.peterchege.todoappsqldelight.ui.screens.create_todo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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

            Button(
                onClick = { saveTodo() }
            ) {
                Text(text = "Save Todo")
            }
        }

    }

}