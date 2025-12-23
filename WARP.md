# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Project Overview
NanoChat (formerly Aiyo) is an Android AI chat application built with Kotlin and Jetpack Compose. It follows **Clean Architecture** principles and uses **Material Design 3**.

## Common Development Tasks

### Build & Run
- **Build App**: `./gradlew :app:assembleDebug`
- **Install & Run**: `./gradlew :app:installDebug`
- **Build All Modules**: `./gradlew build`

### Testing
- **Unit Tests**: `./gradlew test` (Runs tests in all modules)
- **Instrumented Tests**: `./gradlew connectedAndroidTest` (Requires connected device/emulator)

### Code Quality & Formatting
- **Check Linting**: `./gradlew ktlintCheck`
- **Fix Linting Errors**: `./gradlew ktlintFormat`
- **Pre-commit Hook**: The project includes a pre-commit hook that can be installed via the `:installPreCommitHook` task (automatically depended on by `preBuild`).

## Architecture & Structure

The project is modularized by layer (Clean Architecture):

### Modules
- **`:domain`**: The core business logic. Pure Kotlin module with no Android dependencies.
  - Contains: Entities (`model`), Repository Interfaces (`repository`), Use Cases (if any).
  - **Rule**: This module should not depend on `:data`, `:ui`, or `:app`.
- **`:data`**: Implementation of data persistence and networking.
  - Contains:
    - **Local**: Room Database (`local/db`), Key-Value Store (`local/kv`).
    - **Remote**: API Clients (`remote`).
    - **Repository Implementations**: (`repository`).
- **`:ui`**: The Design System and UI components.
  - Contains:
    - **Basics**: Reusable components (`basics/components`), Theme (`Theme.kt`), Color (`Color.kt`), Typography (`Typography.kt`).
    - **Screens**: Feature screens (e.g., Chat, Settings).
  - **Note**: The project has recently migrated to **Material Design 3**. Ensure all new UI components use Material 3 APIs.
- **`:app`**: The application entry point and wiring.
  - Contains: Dependency Injection (`di` with Hilt), Navigation (`nav/AiyoNavHost.kt`), `MainActivity`.

### Key Libraries
- **UI**: Jetpack Compose (Material 3)
- **DI**: Hilt
- **Async**: Coroutines & Flow
- **Database**: Room
- **Network**: Retrofit / Ktor (implied)

## Configuration Files
- `build.gradle.kts`: Root build configuration and plugin aliases.
- `libs.versions.toml`: Dependency version catalog (implied usage).
- `lumo.properties`: Configuration for the Lumo UI Plugin (manages UI component generation).
- `MATERIAL_DESIGN_3_MIGRATION.md`: Reference for the recent migration to MD3.

## Development Guidelines
- **Clean Architecture**: adhere strictly to the dependency rule: `app` -> `ui` -> `domain` <- `data` <- `app`.
- **Material Design 3**: Use the definition in `ui/src/main/java/com/beradeep/aiyo/ui/Theme.kt` and `Color.kt`. Avoid hardcoded colors/dimensions; use the theme system.
- **Code Style**: Follow the Kotlin Coding Conventions enforced by `ktlint`.
