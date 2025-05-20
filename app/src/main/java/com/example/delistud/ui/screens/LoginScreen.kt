package com.example.delistud.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.util.PatternsCompat
import android.widget.Toast
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.delistud.R

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val isEmailValid = PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    val isPasswordValid = password.length >= 6
    val isFormValid = isEmailValid && isPasswordValid

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
//                .background(color = MaterialTheme.colorScheme.onSecondaryContainer, shape = RoundedCornerShape(30.dp))
                .padding(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logo_no_bg),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Delistud",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Connectez-vous pour continuer",
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Email Field
//            OutlinedTextField(
//                value = email,
//                onValueChange = { email = it },
//                label = { Text("Adresse e-mail") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp),
//                shape = RoundedCornerShape(10.dp), // Définit des coins arrondis de 10.dp
//                singleLine = true
//            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Votre adresse e-mail") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                isError = email.isNotEmpty() && !isEmailValid,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp), // Définit des coins arrondis de 8.dp
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Votre mot de passe") },
//                placeholder = { Text("••••••••") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) R.drawable.eye_off else R.drawable.eye
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                        )
                    }
                },
                isError = password.isNotEmpty() && !isPasswordValid,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Sign In Button
            Button(
                onClick = {
                    Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
                },
                enabled = isFormValid,
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Se connecter")
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Forgot Password
            Text(
                "Mot de passe oublié?",
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Register
            Text(
                "Je n'ai pas de compte",
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Register clicked", Toast.LENGTH_SHORT).show()
                }
            )

        }
    }
}