plugins {
    java
}

group = "org.kakara.core"
version = "1.0-RC-SNAPSHOT"

dependencies {
    implementation("org.jetbrains:annotations:19.0.0")
    testImplementation("junit", "junit", "4.12")
    implementation(project(":common"))
    implementation("org.apache.commons", "commons-lang3", "3.11")
}
