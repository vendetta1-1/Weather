plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.serialization)
}
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
dependencies {
    implementation(libs.javax.inject)
    implementation(libs.serialization)
    implementation(libs.kotlinx.coroutines.core)
}