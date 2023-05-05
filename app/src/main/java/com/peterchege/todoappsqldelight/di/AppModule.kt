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
package com.peterchege.todoappsqldelight.di

import app.cash.sqldelight.db.SqlSchema
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

    viewModel {
        AllTodoScreenViewModel(TodoDataSourceImpl(
            TodoDatabase(
                AndroidSqliteDriver(
                    schema =TodoDatabase.Schema,
                    context = androidContext(),
                    name = "todo.db"
                )
            )
        ))
    }

    viewModel {
        CreateTodoScreenViewModel(TodoDataSourceImpl(
            TodoDatabase(
                AndroidSqliteDriver(
                    schema =TodoDatabase.Schema,
                    context = androidContext(),
                    name = "todo.db"
                )
            )
        ))
    }
    viewModel {
        SingleTodoScreenViewModel(todoDataSource = TodoDataSourceImpl(
            TodoDatabase(
                AndroidSqliteDriver(
                    schema =TodoDatabase.Schema,
                    context = androidContext(),
                    name = "todo.db"
                )
            )
        ), savedStateHandle = get())

    }
}

