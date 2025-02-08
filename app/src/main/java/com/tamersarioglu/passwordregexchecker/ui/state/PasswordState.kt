package com.tamersarioglu.passwordregexchecker.ui.state

data class PasswordState(
    val password: String = "",
    val isVisible: Boolean = false,
) {
    val hasMinLength = password.length in 8..25
    val hasNumber = password.any { it.isDigit() }
    val hasUpperCase = password.any { it.isUpperCase() }
    val hasLowerCase = password.any { it.isLowerCase() }
    val isValid = hasMinLength && hasNumber && hasUpperCase && hasLowerCase
}
