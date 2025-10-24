plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidx.room)
}

android {
    namespace = "com.zhogin.healtyscore"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.zhogin.healtyscore"
        minSdk = 29
        targetSdk = 36
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
    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.client)
    implementation(libs.ktor.client.auth)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.dagger.hilt.android)
    implementation(libs.hilt.navigation)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.javax.inject)
    implementation(libs.google.code.gson)
    implementation(libs.coil.compose)
    implementation(libs.coil.network)
    implementation(libs.barcode.scanning)
    implementation(libs.androidx.camerax)
    implementation(libs.androidx.camerax.lifecycle)
    implementation(libs.androidx.camerax.view)
    implementation(libs.accompanist.permissions)
    implementation(libs.camera.mlkit.vision)
    implementation(libs.androidx.camera.core)




    ksp(libs.androidx.room.compiler)
    api(libs.androidx.room.ktx)
    kapt(libs.dagger.hilt.compiler)



    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}