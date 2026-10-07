package com.example.proyectofinal.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectofinal.ui.auth.LoginScreen
import com.example.proyectofinal.ui.reportes.ListadoReportesScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    // Por ahora, navegamos a la lista de reportes simulando un ingreso exitoso
                    navController.navigate("lista_ciudadano") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        
        composable("lista_ciudadano") {
            ListadoReportesScreen(
                onNavigateToCaptura = { navController.navigate("captura") }
            )
        }
        
        composable("captura") {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Pantalla: Captura de Reporte")
            }
        }
        
        composable("admin") {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Pantalla: Bandeja Admin")
            }
        }
    }
}
