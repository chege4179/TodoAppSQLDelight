package com.peterchege.todoappsqldelight.ui.screens.all_todo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.peterchege.todoappsqldelight.Todo
import com.peterchege.todoappsqldelight.toExternalModel
import com.peterchege.todoappsqldelight.ui.TodoCard
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

    AllTodoScreenContent(todos = todos)

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AllTodoScreenContent(
    todos: List<Todo>
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(10.dp)
        ) {
            items(items = todos) {
                TodoCard(todo = it,
                    onTodoNavigate = {

                    },
                    onTodoUpdate = {

                    }
                )
            }

        }
    }


}