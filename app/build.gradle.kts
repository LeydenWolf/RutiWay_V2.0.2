plugins {
    alias(libs.plugins.android.application)
}

android {
    // CAMBIO: namespace alineado con tu app (recomendado que coincida con applicationId)
    namespace = "com.leyden.rutiway"
    compileSdk = 36

    defaultConfig {
        // CAMBIO: applicationId definitivo para RutiWay (identidad de la app)
        applicationId = "com.leyden.rutiway"

        minSdk = 24
        targetSdk = 35

        // CAMBIO: versión para RutiWay 2.0.2
        // Recomendación: versionCode entero creciente; ejemplo 110 para 1.1.0
        versionCode = 202
        versionName = "2.0.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            // Temporal: se configurará después con tu keystore
            // storeFile = file("../keystore/rutiway-release.jks")
            // storePassword = "TU_PASSWORD"
            // keyAlias = "rutiway"
            // keyPassword = "TU_PASSWORD"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // signingConfig = signingConfigs.getByName("release")
        }
        debug {
            isMinifyEnabled = false
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
