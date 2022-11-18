plugins {
    java
    `java-library`
    `maven-publish`
    signing
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("org.sonarqube") version "3.3"

}

group = "org.kakara.core"
version = org.kakara.core.Version.getCoreVersion()

val artifactName = "server"

java {
    withJavadocJar()
    withSourcesJar()
    targetCompatibility = org.gradle.api.JavaVersion.VERSION_17
    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_17

}
sonarqube {
    properties {
        property("sonar.projectKey", "kakaragame_core_server")
        property("sonar.organization", "kakaragame")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.sources", "src")
    }
}
publishing {
    publications {
        create<MavenPublication>("mavenJava") {

            artifactId = artifactName
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set(artifactName)
            }
        }
    }
    repositories {
        maven {

            val releasesRepoUrl = uri("https://repo.kingtux.me/storages/maven/kakara")
            val snapshotsRepoUrl = uri("https://repo.kingtux.me/storages/maven/kakara")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials(PasswordCredentials::class)

        }
        mavenLocal()
    }
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

repositories {
    maven("https://repo.maven.apache.org/maven2/")
    mavenLocal()
    jcenter()
    maven("https://repo.kingtux.me/storages/maven/kingtux-repo")
    maven("https://repo.kingtux.me/storages/maven/ryandw11")
    maven("https://jitpack.io")
    maven("https://repo.ryandw11.com/repository/maven-releases/")
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.4")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.google.guava:guava:31.0.1-jre")
    implementation("org.jetbrains", "annotations", "20.1.0")
    implementation(project(":common"))
    compileOnly("me.ryandw11:ods:1.0.5")
}

