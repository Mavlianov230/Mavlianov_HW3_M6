plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.homework_jc"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.homework_jc"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Jetpack Compose libraries
    implementation(platform(libs.androidx.compose.bom)) // Centralized Compose BOM
    implementation(libs.androidx.compose.ui)           // UI
    implementation(libs.androidx.compose.material3)   // Material3
    implementation(libs.androidx.navigation.compose)  // Navigation
    implementation(libs.accompanist.navigation.animation) // Animations

    // Paging for Compose
    implementation(libs.androidx.paging.compose)      // Paging Compose

    // Dependency Injection
    implementation(libs.androidx.hilt.navigation.compose) // Hilt Navigation Compose
    implementation(libs.koin.android)                    // Koin for DI
    implementation(libs.koin.androidx.compose)          // Koin for Compose

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)    // Coroutines for Android

    // Retrofit and Gson
    implementation(libs.retrofit)                       // Retrofit
    implementation(libs.converter.gson)                 // Gson Converter

    // Room for local database
    implementation(libs.androidx.room.runtime)         // Room Runtime
    kapt(libs.androidx.room.compiler)                  // Room Compiler
    implementation(libs.androidx.room.ktx)             // Room KTX

    // Coil for image loading
    implementation(libs.coil.compose)                   // Coil for Compose

    // AndroidX Libraries
    implementation(libs.androidx.core.ktx)             // Core KTX
    implementation(libs.androidx.activity.compose)     // Activity Compose
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle Runtime KTX

    // Testing
    testImplementation(libs.junit)                     // JUnit
    androidTestImplementation(libs.androidx.junit)     // JUnit for Android
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI tests
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose BOM for tests
    androidTestImplementation(libs.androidx.ui.test.junit4) // Compose UI testing
    debugImplementation(libs.androidx.ui.tooling)     // Compose Tooling for debugging
    debugImplementation(libs.androidx.ui.test.manifest) // Compose UI test manifest
}