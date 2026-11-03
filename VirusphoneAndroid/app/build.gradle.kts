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

    // Фиксированный ключ подписи: иначе каждая сборка на GitHub подписывается новым случайным
    // debug-ключом, и Android не ставит новую версию поверх старой (сохранения пропадают).
    signingConfigs {
        create("fixed") {
            storeFile = file("virusphone.keystore")
            storePassword = "virusphone"
            keyAlias = "virusphone"
            keyPassword = "virusphone"
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("fixed")
        }
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("fixed")
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
