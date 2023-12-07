plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.devtoolsKsp)
    alias(libs.plugins.kotlinSerialization)

    id("kotlin-parcelize")
}

android {
    namespace = "com.mona.batmansearch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mona.batmansearch"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        android.buildFeatures.buildConfig = true
        buildConfigField("String", "OMDB_API_KEY", "\"" + getOmdbApiKey() + "\"")
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
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.core.ktx)
    implementation(libs.androidx.compose.constraint.layout)
    implementation(libs.androidx.compose.runtime)


    implementation(libs.hilt.android)
    annotationProcessor(libs.hilt.compiler)
    ksp(libs.hilt.dagger.compiler)
    ksp(libs.hilt.dagger.android.compiler)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.android.testing)

    implementation(libs.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.gson)
    implementation(libs.retrofit.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp.logging)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.coil.kt.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.runtime)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.common)
    implementation(libs.kotlin.stdlib)
    implementation(libs.junit4)
    implementation(libs.androidx.test.ext)
    implementation(libs.androidx.test.espresso.core)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.accompanist.system.ui.controller)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    //testImplementation(libs.mockk)
    testImplementation(libs.mockito)
    androidTestImplementation(libs.mockito.android)

    implementation(libs.androidx.room)
    //implementation(libs.androidx.room.common)
    //implementation(libs.androidx.room.ktx)
    annotationProcessor(libs.androidx.room.compiler)
//    kapt "androidx.room:room-compiler:"

}

fun getOmdbApiKey(): String = project.findProperty("omdb_api_key").toString()
