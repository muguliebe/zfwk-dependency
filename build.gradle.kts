plugins {
    `java-platform`
    `maven-publish`
    id("io.spring.dependency-management")
}

javaPlatform {
    allowDependencies()
}

group = "com.egstep"
version = "0.1.0"
val zfwkVersion = "0.1.0"
val zutilsVersion = "0.1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://nexus.egstep.com/repository/maven-public/")
    }
}

dependencies {
    //Properties from project gradle.properties to variable mapping
    val jacksonModuleVersion: String by project

    //Maven BOM <dependencyManagement> block
    constraints {
    }

    //Maven BOM <dependencies> block
    api("com.egstep:zutils-kt:${zutilsVersion}")
    api("com.egstep:zfwk-core:${zfwkVersion}")
    api("ch.qos.logback:logback-classic:1.4.11")
    api("org.slf4j:slf4j-api:2.0.9")
    api("org.apache.commons:commons-lang3:3.13.0")
    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.3")

}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["javaPlatform"])
            groupId = group.toString()
            artifactId = project.name
            version = version
        }
    }
    repositories {
        maven {
            url = uri("https://jitpack.io")
        }
    }
}
