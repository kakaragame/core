plugins {
    java
}

group = "org.kakara.core"
version = "1.0-RC-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit", "junit", "4.12")
    implementation("com.google.code.gson", "gson", "2.8.6")
    implementation("org.slf4j", "slf4j-api", "1.7.30")
    implementation("org.jetbrains", "annotations", "16.0.1")
    implementation("org.apache.commons", "commons-lang3", "3.11")
}
