# zutils-kt

[![](https://jitpack.io/v/muguliebe/zfwk-utils.svg)](https://jitpack.io/#muguliebe/zfwk-utils)


To use this project in your build, add the following to your build.gradle.kts file:

```kotlin
repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly(platform("com.github.muguliebe:zfwk-dependency:$version"))
}
