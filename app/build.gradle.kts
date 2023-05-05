plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("app.cash.sqldelight") version "2.0.0-alpha05"
}

android {
    namespace = "com.peterchege.todoappsqldelight"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.peterchege.todoappsqldelight"
        minSdk = 24
        targetSdk = 33
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
        kotlinCompilerExtensionVersion = "1.4.5"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
sqldelight {
    databases {
        create(name = "TodoDatabase") {
            packageName.set("com.peterchege.todoappsqldelight")
        }
    }
}
dependencies {

    implementation ("androidx.core:core-ktx:1.10.0")
    implementation ("androidx.compose.ui:ui:1.5.0-alpha03")
    implementation ("androidx.compose.material:material:1.5.0-alpha03")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.0-alpha03")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.5.0-alpha03")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.5.0-alpha03")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.5.0-alpha03")


    implementation("androidx.compose.foundation:foundation:1.4.2")
    implementation("androidx.compose.foundation:foundation-layout:1.4.2")
    implementation ("androidx.navigation:navigation-compose:2.5.3")


    // view model
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    //koin
    implementation ("io.insert-koin:koin-android:3.4.0")
    implementation ("io.insert-koin:koin-core:3.4.0")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.3")


    implementation("app.cash.sqldelight:android-driver:2.0.0-alpha05")
    implementation("app.cash.sqldelight:primitive-adapters:2.0.0-alpha05")
    implementation("app.cash.sqldelight:coroutines-extensions:2.0.0-alpha05")

}