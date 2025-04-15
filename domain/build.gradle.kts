plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.serialization)
}
java {
    sourceCompatibility = JavaVersion.VERSION_22
    targetCompatibility = JavaVersion.VERSION_22
}
dependencies {
    implementation(libs.javax.inject)
    implementation(libs.serialization)
    implementation(libs.kotlinx.coroutines.core)
}