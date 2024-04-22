package com.example.alkusi.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.alkusi.presentation.tab.TabScreen

@Composable
fun SetupNavGraph(navController:NavHostController)
{
    NavHost(navController = navController, startDestination = Route.TabScreen.route ) {
        composable(route = Route.TabScreen.route)
        {
         TabScreen()
        }

    }
}