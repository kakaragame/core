plugins {
    java
    maven
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "org.kakara.core"
version = "1.0-SNAPSHOT"

configurations {
    shadow
}

repositories {
    maven("https://repo.maven.apache.org/maven2/")
    mavenLocal()
    jcenter()
    maven("https://repo.kingtux.me/storages/maven/kingtux-repo")
    maven("https://repo.kingtux.me/storages/maven/ryandw11")
    maven("https://jitpack.io")
    maven("https://repo.ryandw11.com/repository/maven-snapshots/")
}

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("org.apache.commons:commons-lang3:3.11")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.google.guava:guava:30.0-jre")
    implementation("org.jetbrains", "annotations", "20.1.0")
    implementation(project(":common"))
    compileOnly("me.ryandw11:ods:1.0-MEM-SNAPSHOT")
}

tasks {
    compileJava {
        targetCompatibility = JavaVersion.VERSION_11.toString()
        sourceCompatibility = JavaVersion.VERSION_11.toString()
        options.encoding = "UTF-8"
    }

    jar {
        from(
                *configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }.toTypedArray()
        )
    }

    "uploadArchives"(Upload::class) {
        repositories {
            withConvention(MavenRepositoryHandlerConvention::class) {
                mavenDeployer {
                    withGroovyBuilder {
                        "repository"("url" to "https://repo.kingtux.me/storages/maven/kakara") {
                            "authentication"(
                                    "userName" to System.getProperty("credentials.username"),
                                    "password" to System.getProperty("credentials.password")
                            )
                        }
                    }
                }
            }
        }
    }

    val sourcesJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    val javadocJar by creating(Jar::class) {
        dependsOn.add(javadoc)
        archiveClassifier.set("javadoc")
        from(javadoc)
    }

    artifacts {
        archives(sourcesJar)
        archives(javadocJar)
        archives(shadowJar)
    }
}