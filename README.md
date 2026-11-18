# stayunexposed-startup

Android starter app owned by **stayunexposed**: **Kotlin + Jetpack Compose + Material 3**.

Naming conventions are derived from the company identity throughout:

| Place | Value |
| --- | --- |
| Package / namespace / applicationId | `com.stayunexposed.startup` |
| Gradle root project | `stayunexposed-startup` |
| Compose theme | `StayUnexposedTheme`, `Theme.StayUnexposed` |
| Build config | `BuildConfig.COMPANY_SLUG`, `BuildConfig.COMPANY_DISPLAY_NAME` |
| App name | `StayUnexposed Startup` |

## Why Kotlin

- Google's recommended language for Android; all new APIs and docs are Kotlin-first.
- Jetpack Compose (the modern UI toolkit used here) is a Kotlin compiler plugin — it cannot be
  used ergonomically from Java.
- Coroutines/Flow and sealed classes make async work and state modelling safe and concise.
- Kotlin is fully interoperable with existing Java code, so mixing is always possible.

Java is still supported, but it is a second-class citizen for Compose and modern tooling.

## What is included

| Area | Decision |
| --- | --- |
| UI | Compose, Material 3, edge-to-edge, dynamic color on Android 12+ |
| Architecture | Single activity, stateless composables, `ViewModel` + `StateFlow` |
| Build | Gradle 8.11.1, AGP 8.7.3, version catalog in `gradle/libs.versions.toml` |
| SDK | `compileSdk`/`targetSdk` 35, `minSdk` 24 |
| Tests | JVM unit tests for the ViewModel, Compose UI tests for the screen |
| Release | R8 minify + resource shrinking enabled, `proguard-rules.pro` ready |

## Build

The local toolchain (JDK 17 + Android SDK) lives outside the repo. Point Gradle at it once:

```bat
set JAVA_HOME=C:\AndroidTools\jdk-17.0.21+9
set ANDROID_HOME=C:\AndroidTools\sdk
```

Then:

```bat
gradlew.bat assembleDebug
gradlew.bat testDebugUnitTest
gradlew.bat installDebug
```

`local.properties` already points `sdk.dir` at the same place.

## Where to go next

- Add navigation (`androidx.navigation:navigation-compose`) and a bottom bar.
- Add a repository layer + Retrofit/Room and DI (Hilt) once real data exists.
- Introduce `UiState` sealed interfaces instead of raw values as screens grow.
- Replace `versionCode`/`versionName` release values and set up signing/CI.
- Move the launcher artwork to branded assets (currently a placeholder vector).
