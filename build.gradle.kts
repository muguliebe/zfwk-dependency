plugins {
    `java-platform`
    `maven-publish`
    id("io.spring.dependency-management")
}

javaPlatform {
    allowDependencies()
}

group = "com.github.muguliebe"
version = "0.4.3"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    val jacksonModuleVersion: String by project

    constraints {
        api("com.github.muguliebe:zfwk-utils:0.3.0")
        api("com.github.muguliebe:zfwk-core:0.2.0")
        api("ch.qos.logback:logback-classic:1.4.12")
        api("org.slf4j:slf4j-api:2.0.9")
        api("org.apache.commons:commons-lang3:3.13.0")
        api("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.3")
    }

}

publishing {
    publications {
        create<MavenPublication>("zfwk-dependency") {
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
