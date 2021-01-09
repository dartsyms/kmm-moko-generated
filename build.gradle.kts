buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven("https://dl.bintray.com/icerockdev/plugins")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("dev.icerock.moko:network-generator:0.8.0")
    }
}

group = "me.sanchez"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://dl.bintray.com/icerockdev/moko")
    }
}