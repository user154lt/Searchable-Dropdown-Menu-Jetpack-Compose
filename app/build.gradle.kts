plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.plugin.compose)
}

kotlin{
    androidTarget{
        compilations.all{
            kotlinOptions{
                jvmTarget = "17"
            }
        }
    }
    jvm("desktop")
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets{
        val commonMain by getting{
            dependencies{
                implementation(compose.ui)
                implementation(compose.material3)
                implementation(project(":searchable-dropdown"))
            }
        }
        val androidMain by getting {
            dependencies{
                implementation(libs.androidx.core)
                implementation(libs.androidx.activity)
            }
        }
        val androidInstrumentedTest by getting {
            dependencies {
                implementation(libs.androidx.test.ext)
                implementation(libs.androidx.test.espresso)
                implementation(libs.compose.ui.junit)
            }
        }

        val androidUnitTest by getting {
            dependencies {
                implementation(libs.junit)
            }
        }
    }
}

android {
    namespace = "com.breens.searchableexposeddropdownmenujetpackcompose"
    compileSdk =  35

    defaultConfig {
        applicationId = "com.breens.searchableexposeddropdownmenujetpackcompose"
        minSdk = 21
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
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
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}