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