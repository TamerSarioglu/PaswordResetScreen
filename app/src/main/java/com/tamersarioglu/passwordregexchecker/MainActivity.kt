package com.tamersarioglu.passwordregexchecker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamersarioglu.passwordregexchecker.ui.components.ConfirmPasswordSection
import com.tamersarioglu.passwordregexchecker.ui.components.PasswordRequirements
import com.tamersarioglu.passwordregexchecker.ui.components.PasswordSection
import com.tamersarioglu.passwordregexchecker.ui.components.ScreenTitle
import com.tamersarioglu.passwordregexchecker.ui.components.SubmitButton
import com.tamersarioglu.passwordregexchecker.ui.state.PasswordState
import com.tamersarioglu.passwordregexchecker.ui.theme.PasswordRegexCheckerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasswordRegexCheckerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        contentWindowInsets = WindowInsets.safeDrawing
                    ) { paddingValues ->
                        PasswordCheckerScreen(
                            modifier = Modifier.padding(paddingValues)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PasswordCheckerScreen(modifier: Modifier = Modifier) {
    var passwordState by remember { mutableStateOf(PasswordState()) }
    var confirmPasswordState by remember { mutableStateOf(PasswordState()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 24.dp)
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        ScreenTitle()
        Spacer(modifier = Modifier.height(8.dp))
        PasswordSection(
            passwordState = passwordState,
            onPasswordChange = { newPassword ->
                passwordState = passwordState.copy(
                    password = newPassword,
                )
            },
            onVisibilityChange = { isVisible ->
                passwordState = passwordState.copy(isVisible = isVisible)
            }
        )
        PasswordRequirements(passwordState)
        Spacer(modifier = Modifier.height(24.dp))
        ConfirmPasswordSection(
            confirmPasswordState = confirmPasswordState,
            onConfirmPasswordChange = { newConfirmPassword ->
                confirmPasswordState = confirmPasswordState.copy(
                    password = newConfirmPassword,
                )
            },
            onVisibilityChange = { isVisible ->
                confirmPasswordState = confirmPasswordState.copy(isVisible = isVisible)
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        SubmitButton(
            enabled = passwordState.isValid && 
                     confirmPasswordState.password == passwordState.password &&
                     confirmPasswordState.password.isNotEmpty()
        )
        
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview
@Composable
fun PreviewPasswordCheckerScreen() {
    PasswordRegexCheckerTheme {
        PasswordCheckerScreen()
    }
}