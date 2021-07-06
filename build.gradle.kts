import org.springframework.boot.gradle.tasks.bundling.BootWar

plugins {
	war
	id("org.springframework.boot") version "2.5.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id ("org.jmailen.kotlinter") version "3.4.5"
	kotlin("jvm") version "1.5.20"
	kotlin("plugin.serialization") version "1.5.20"
	kotlin("plugin.spring") version "1.5.20"
}

group = "com"
version = "0.0.1-SNAPSHOT"


allprojects {
	repositories {
		mavenCentral()
	}
}

subprojects {

	apply {
		plugin("org.jetbrains.kotlin.jvm")
		plugin ("org.jmailen.kotlinter")
		plugin ("org.jetbrains.kotlin.plugin.serialization")
	}

	java.sourceCompatibility = JavaVersion.VERSION_1_8

	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
	}
}

tasks.withType<BootWar> {
	mainClass.set("com.greeting.GreetingAppKt")
}

dependencies {
	implementation(project(":greeting-app"))
	implementation(project(":greeting-model"))
}