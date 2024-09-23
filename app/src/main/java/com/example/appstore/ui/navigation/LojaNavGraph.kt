package com.example.appstore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appstore.data.LojaRepository
import com.example.appstore.ui.HomeScreen
import com.example.appstore.ui.LojaScreen
import com.example.appstore.ui.LojaViewModel
import com.example.appstore.ui.LojaViewModelFactory

@Composable
fun LojaNavGraph(navController: NavHostController, lojaRepository: LojaRepository) {
    val viewModel: LojaViewModel = viewModel(factory = LojaViewModelFactory(lojaRepository))

    NavHost(navController, startDestination = "homeScreen") {
        composable("lojaScreen") { LojaScreen(viewModel) }
        composable("homeScreen") { HomeScreen(navController) }
    }
}
