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
    implementation(project(":common"))
}
