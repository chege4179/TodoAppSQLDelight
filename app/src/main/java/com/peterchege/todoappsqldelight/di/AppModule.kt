package com.peterchege.todoappsqldelight.di

import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.peterchege.todoappsqldelight.TodoDatabase
import com.peterchege.todoappsqldelight.data.TodoDataSource
import com.peterchege.todoappsqldelight.data.TodoDataSourceImpl
import com.peterchege.todoappsqldelight.ui.screens.all_todo.AllTodoScreenViewModel
import com.peterchege.todoappsqldelight.ui.screens.create_todo.CreateTodoScreenViewModel
import com.peterchege.todoappsqldelight.ui.screens.single_todo.SingleTodoScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        TodoDatabase(get())
    }
    single {
        TodoDatabase.Schema
    }
    single {
        AndroidSqliteDriver(
            schema = get(),
            context = androidContext(),
            name = "todo.db"
        )
    }

    single {
        TodoDataSourceImpl(get())
    }

    viewModel {
        AllTodoScreenViewModel(get())
    }

    viewModel {
        CreateTodoScreenViewModel(get())
    }
    viewModel {
        SingleTodoScreenViewModel(get())

    }
}

