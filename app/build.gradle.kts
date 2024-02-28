plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.weatherapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.weatherapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Bunlara şimdilik gerek yoktu
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    implementation ("androidx.lifecycle:lifecycle-extensions:2.1.0")

    // RETROFIT - İnternetten veri çekmeyi ve yayınlamaya yarayan kütüphaneler
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    // RXJAVA - Retrofit için ek/yardımcı kütüphaneler
    implementation ("io.reactivex.rxjava2:rxjava:2.2.6")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")

    // GLIDE - Görsellerde kullanılacak olan kütüphane
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation ("androidx.compose.ui:ui:1.0.5") // veya başka bir sürüm


    /*
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.5")
    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //Gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation("androidx.room:room-runtime:2.6.0")
    implementation("androidx.room:room-ktx:2.6.0") // Coroutine desteği için bu satırı ekleyin
    annotationProcessor("androidx.room:room-compiler:2.6.0")
    // To use Kotlin annotation processing tool (kapt)
    //kapt("androidx.room:room-compiler:2.6.0")
    // To use Kotlin Symbol Processing (KSP)
    //ksp("androidx.room:room-compiler:2.5.0")
    //Add the SwipeRefreshLayout Widget
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")
    //RxJava
    implementation ("io.reactivex.rxjava3:rxjava:3.0.6")
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.0")
     */

    /*
    //def composeBom = platform("androidx.compose:compose-bom:2023.10.01")
    //implementation composeBom
    //androidTestImplementation composeBom

    // Choose one of the following:
    // Material Design 3
    implementation ("androidx.compose.material3:material3")
    // or Material Design 2
    implementation ("androidx.compose.material:material")
    // or skip Material Design and build directly on top of foundational components
    implementation ("androidx.compose.foundation:foundation")
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation ("androidx.compose.ui:ui")

    // Android Studio Preview support
    implementation ("androidx.compose.ui:ui-tooling-preview")
    debugImplementation ("androidx.compose.ui:ui-tooling")

    // UI Tests
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4")
    debugImplementation ("androidx.compose.ui:ui-test-manifest")

    // Optional - Included automatically by material, only add when you need
    // the icons but not the material library (e.g. when using Material3 or a
    // custom design system based on Foundation)
    implementation ("androidx.compose.material:material-icons-core")
    // Optional - Add full set of material icons
    implementation ("androidx.compose.material:material-icons-extended")
    // Optional - Add window size utils
    implementation ("androidx.compose.material3:material3-window-size-class")

    // Optional - Integration with activities
    implementation ("androidx.activity:activity-compose:1.8.1")
    // Optional - Integration with ViewModels
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    // Optional - Integration with LiveData
    implementation ("androidx.compose.runtime:runtime-livedata")
    // Optional - Integration with RxJava
    implementation ("androidx.compose.runtime:runtime-rxjava2")
     */

}