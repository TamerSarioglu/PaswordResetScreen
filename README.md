# Password Reset Screen 🔐

A modern Android application built with Jetpack Compose that implements a secure password reset screen with real-time password validation and requirements checking. The app features a clean, Material Design 3-based UI with Starbucks-inspired theming.

## ✨ Features

- Real-time password validation with visual feedback
- Password requirements checking:
    - 8-25 characters length
    - At least 1 number
    - At least 1 uppercase letter
    - At least 1 lowercase letter
- Password visibility toggle
- Confirmation password field
- Material Design 3 components
- Dark theme support
- Custom Starbucks-themed styling

## 🛠 Tech Stack

- **Language**: Kotlin
- **Minimum SDK**: 24
- **Target SDK**: 35
- **Architecture Components**:
    - Jetpack Compose
    - Material Design 3
    - AndroidX Core KTX
    - Lifecycle Runtime KTX
    - Activity Compose

## 📁 Project Structure

```
app/
├── build.gradle.kts           # App level build configuration
├── src/
    ├── main/
    │   ├── java/
    │   │   └── com/tamersarioglu/passwordregexchecker/
    │   │       ├── MainActivity.kt
    │   │       └── ui/
    │   │           ├── components/    # Reusable UI components
    │   │           ├── state/         # State management
    │   │           └── theme/         # Theme configuration
    │   └── res/                       # Resources
└── proguard-rules.pro        # ProGuard rules
```

## 🚀 Getting Started

### Prerequisites

- Android Studio Iguana | 2023.2.1 or newer
- JDK 11 or newer
- Android SDK with minimum API level 24

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/PasswordRegexChecker.git
```

2. Open the project in Android Studio

3. Sync Gradle files

4. Run the app on an emulator or physical device

## 🏗️ Building the Project

The project uses Gradle with Kotlin DSL for build configuration. To build the project:

```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease
```

## 🏛️ Architecture

The app follows modern Android development best practices:

- **UI Layer**: Built entirely with Jetpack Compose
- **State Management**: Uses Compose state management with `remember` and `mutableStateOf`
- **Theme**: Custom Material 3 theme with Starbucks-inspired color scheme
- **Component-Based**: Modular UI components for better reusability

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the Apache License 2.0 - see the LICENSE file for details

## 👏 Acknowledgments

- Material Design 3 guidelines
- Jetpack Compose documentation
- Starbucks design system for inspiration

## 📫 Contact

Tamer Sarioglu - [X](https://x.com/tamerthedark)
                 [LinkedIn](https://www.linkedin.com/in/tamer-sarıoğlu-119742a4/)