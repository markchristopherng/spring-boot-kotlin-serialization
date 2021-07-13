import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("io.spring.dependency-management")
    id("org.springframework.boot")
    kotlin("plugin.spring")
}

val kotinSerializationVersion: String by project

tasks.jar {
    enabled = true
}

tasks.withType<BootJar> {
    archiveClassifier.set("application")
}

dependencies {
    implementation(project(":greeting-model"))

   	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotinSerializationVersion")
}