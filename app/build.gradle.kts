plugins {
    id("com.android.application")
}

android {
    namespace = "ru.fonzo.virusphone"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.fonzo.virusphone"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0-decompiled"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // .DAT/.bin/.mid не должны сжиматься aapt (читаем как есть из assets)
    androidResources {
        noCompress += listOf("DAT", "bin", "mid", "png")
    }
}
