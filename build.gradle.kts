plugins {
    java
    id("maven-publish")
}

group = "org.kakara"
version = org.kakara.core.Version.getCoreVersion()


subprojects {


    repositories {
        mavenLocal()
        maven("https://repo.maven.apache.org/maven2")
        maven("https://repo.kingtux.me/storages/maven/kakara")
    }
}
tasks.register<Javadoc>("aggregatedJavadocs") {
    setDestinationDir(file("$buildDir/docs/javadoc"))
    title = "$project.name $version API"
    options.withGroovyBuilder {
        "author"(true)
        "addStringOption"("Xdoclint:none", "-quiet")
        "addStringOption"("sourcepath", "")
    }
    subprojects.forEach { proj ->
        proj.tasks.filterIsInstance<Javadoc>().forEach {
            source += it.source
            classpath += it.classpath
            excludes += it.excludes
            includes += it.includes
        }
    }
}