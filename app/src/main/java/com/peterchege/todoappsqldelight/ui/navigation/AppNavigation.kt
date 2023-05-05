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
package com.peterchege.todoappsqldelight.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.peterchege.todoappsqldelight.ui.screens.all_todo.AllTodoScreen
import com.peterchege.todoappsqldelight.ui.screens.create_todo.CreateTodoScreen
import com.peterchege.todoappsqldelight.ui.screens.single_todo.SingleTodoScreen
import com.peterchege.todoappsqldelight.util.Screens

@Composable
fun AppNavigation(
    navHostController: NavHostController
) {
    NavHost(
        navController =navHostController,
        startDestination = Screens.ALL_TODO_SCREEN,
    ){
        composable(route = Screens.ALL_TODO_SCREEN){
            AllTodoScreen(navController = navHostController)
        }
        composable(route = Screens.CREATE_TODO_SCREEN){
            CreateTodoScreen(navController = navHostController)
        }
        composable(route = Screens.SINGLE_TODO_SCREEN + "/{id}"){
            SingleTodoScreen(navController = navHostController)
        }

    }

}