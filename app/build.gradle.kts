plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services") // This is correct for Firebase integration
}

android {
    namespace = "com.example.auth"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.auth"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Firebase BOM (Bill of Materials) to manage versions
    implementation(platform("com.google.firebase:firebase-bom:33.1.0")) // Use 33.1.0, not 33.10.0 (typo?)

    // Firebase libraries (no version needed due to BOM)
    implementation("com.google.firebase:firebase-analytics") // Already included
    implementation("com.google.firebase:firebase-auth")     // Add this for Firebase Authentication

    // Existing dependencies
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Test dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}