import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "dev.smolyakoff.fimls"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.smolyakoff.fimls"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    composeCompiler {
        featureFlags = setOf(
            ComposeFeatureFlag.StrongSkipping
        )
    }

}

dependencies {

    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.runtime)
    implementation(libs.compose.activity)
    implementation(libs.compose.graphics)
    implementation(libs.compose.preview)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}