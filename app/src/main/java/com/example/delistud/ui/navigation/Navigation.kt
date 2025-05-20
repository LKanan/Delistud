package com.example.delistud.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delistud.ui.screens.LoginScreen
import com.example.delistud.ui.screens.SignUpScreen
import com.example.delistud.ui.screens.UserTypeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {
    val navController = rememberNavController() // Utilisation de rememberNavController pour créer un NavController

    NavHost(navController, startDestination = "signup"){
        composable("login") { LoginScreen(navController)} // Appel de la fonction LoginScreen avec le navController }
        composable("usertype") { UserTypeScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
    }
//    val tenantScreen = TenantScreen() // Création d'une instance de TenantScreen

//    NavHost(navController = navController, startDestination = "tenantScreen") {
//        composable("homeScreen") {
//            homeScreen(navController)
//        }
//        composable("loginScreen") {
//            LoginScreen(navController)
//        }
//        composable("signUpScreen") {
//            signUpScreen(navController)
//        }
//        composable("mainScreen") {
//            mainScreen(navController)
//        }
//        composable("tenantScreen") {
//            tenantScreen.TenantScreenUI(navController) // Appel correct de TenantScreenUI avec navController
//        }
    }
//}