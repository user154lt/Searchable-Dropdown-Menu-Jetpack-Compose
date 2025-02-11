import com.android.utils.TraceUtils.simpleId
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.vanniktech.maven.publish)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
        publishLibraryVariants("release")
    }
    jvm("desktop")
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.material3)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.core)
            }
        }
        val androidInstrumentedTest by getting {
            dependencies {
                implementation(libs.androidx.test.ext)
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
    namespace = "com.kanyidev.searchable_dropdown"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        //noinspection OldTargetApi
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

mavenPublishing {
    coordinates(
        groupId = "io.github.user154lt",
        artifactId = "searchable-dropdown",
        version = "1.1.0"
    )

    pom {
        name.set("Compose multiplatform searchable dropdown library")
        description.set(
            "A Jetpack Compose Multiplatform Library to create a dropdown menu that is " +
                    "searchable, can be used for Android, desktop and iOS targets"
        )
        inceptionYear.set("2025")
        url.set("https://github.com/user154lt/Searchable-Dropdown-Menu-Jetpack-Compose")
        licenses {
            license {
                name.set("Apache")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
            }
        }
        developers {
            developer {
                id.set("User154lt")
                name.set("User154")
                url = "https://github.com/user154lt/"
            }
            developer {
                id.set("Breens-Mbaka")
                name.set("Breens Robert")
                url = "https://github.com/Breens-Mbaka"
            }
        }
        scm{
            url.set("https://github.com/user154lt/Searchable-Dropdown-Menu-Jetpack-Compose")
        }
    }
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}
