package com.tamersarioglu.passwordregexchecker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamersarioglu.passwordregexchecker.ui.state.PasswordState

@Composable
fun ScreenTitle() {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        StarbucksLogo(
            modifier = Modifier
                .size(96.dp)
                .padding(vertical = 16.dp)
        )
        
        Text(
            text = "Reset Password",
            style = MaterialTheme.typography.headlineMedium.copy(
                color = Color(0xFFFBFBFD),
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
fun PasswordSection(
    passwordState: PasswordState,
    onPasswordChange: (String) -> Unit,
    onVisibilityChange: (Boolean) -> Unit
) {
    PasswordTextField(
        value = passwordState.password,
        onValueChange = onPasswordChange,
        label = "New Password",
        isVisible = passwordState.isVisible,
        onVisibilityChange = onVisibilityChange,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ConfirmPasswordSection(
    confirmPasswordState: PasswordState,
    onConfirmPasswordChange: (String) -> Unit,
    onVisibilityChange: (Boolean) -> Unit
) {
    PasswordTextField(
        value = confirmPasswordState.password,
        onValueChange = onConfirmPasswordChange,
        label = "Password Again",
        isVisible = confirmPasswordState.isVisible,
        onVisibilityChange = onVisibilityChange,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PasswordRequirements(passwordState: PasswordState) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        PasswordRequirement("8-25 characters", passwordState.hasMinLength)
        PasswordRequirement("At least 1 number", passwordState.hasNumber)
        PasswordRequirement("At least 1 uppercase letter", passwordState.hasUpperCase)
        PasswordRequirement("At least 1 lowercase letter", passwordState.hasLowerCase)
    }
}

@Composable
fun PasswordRequirement(
    text: String,
    isMet: Boolean
) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (isMet) Icons.Default.Check else Icons.Default.Close,
            contentDescription = null,
            tint = if (isMet) Color(0xFF00704A) else Color(0xFFE78587),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFFFBFBFD)
            )
        )
    }
}

@Composable
fun SubmitButton(enabled: Boolean) {
    Button(
        onClick = { /* Handle button click */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF87B892), // Light green
            disabledContainerColor = Color(0xFFE78587).copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(28.dp)
    ) {
        Text(
            "Confirm",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Preview
@Composable
fun PreviewScreenTitle() {
    ScreenTitle()
}

@Preview
@Composable
fun PasswordRequirementsPreview() {
    PasswordRequirements(
        passwordState = PasswordState(
            password = "Password1",
            isVisible = true
        )
    )
}